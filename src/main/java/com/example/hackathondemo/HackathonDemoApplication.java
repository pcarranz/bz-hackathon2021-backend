package com.example.hackathondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;

@EnableDiscoveryClient
@SpringBootApplication
public class HackathonDemoApplication implements CommandLineRunner {

	@Autowired
	private ApplicationConfig appConfig;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(HackathonDemoApplication.class);
		app.run();
	}

	public void run(String... args) throws Exception {
		System.out.println("B2 App Key: " + appConfig.getAppKey());
		System.out.println("B2 App Id: " + appConfig.getAppKeyId());
	}

}

@RestController
class ServiceDiscoveryController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping("/services")
	public Optional<URI> serviceURL() {
		return discoveryClient.getInstances("hackathon-demo")
				.stream()
				.map(ServiceInstance::getUri)
				.findFirst();
	}

}
