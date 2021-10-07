package com.example.hackathondemo.service;

import com.backblaze.b2.client.B2StorageClient;
import com.backblaze.b2.client.B2StorageClientFactory;
import com.backblaze.b2.client.exceptions.B2Exception;
import com.backblaze.b2.client.structures.B2Bucket;
import com.backblaze.b2.util.B2ExecutorUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class B2BucketService {

    private static final String APP_KEY = "<APP_KEY>";
    private static final String APP_KEY_ID = "<APP_KEY_ID>";
    private static final String USER_AGENT = "B2Sample";

//    @Autowired
//    private ApplicationConfig appConfig;

    private final B2StorageClient client;

    public B2BucketService() {
        final ExecutorService executor = Executors.newFixedThreadPool(10, createThreadFactory("B2Sample-executor-%02d"));

        try {
            client = B2StorageClientFactory.createDefaultFactory().create(APP_KEY_ID, APP_KEY, USER_AGENT);
        } finally {
            B2ExecutorUtils.shutdownAndAwaitTermination(executor, 10, 10);
        }
    }

    public List<B2Bucket> listBuckets() throws B2Exception {
        return client.buckets();
    }

    /**
     * @param nameFormat the format for the thread names, should contain a single %d.
     * @return a new ThreadFactory that takes a string format to help name threads
     */
    public static ThreadFactory createThreadFactory(String nameFormat) {
        final AtomicInteger count = new AtomicInteger(0);

        return (runnable) -> {
            final Thread thread = Executors.defaultThreadFactory().newThread(runnable);
            thread.setName(String.format(nameFormat, count.getAndIncrement()));
            return thread;
        };
    }

}
