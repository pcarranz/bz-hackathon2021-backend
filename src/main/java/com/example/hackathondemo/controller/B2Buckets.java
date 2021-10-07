package com.example.hackathondemo.controller;

import com.backblaze.b2.client.exceptions.B2Exception;
import com.backblaze.b2.client.structures.B2Bucket;
import com.example.hackathondemo.service.B2BucketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = { "http://localhost:3000" })
public class B2Buckets {

    @Autowired
    private B2BucketService bucketService;

    @GetMapping("/b2/buckets")
    public List<B2Bucket> getB2Buckets() throws B2Exception {
        return  bucketService.listBuckets();
    }

}
