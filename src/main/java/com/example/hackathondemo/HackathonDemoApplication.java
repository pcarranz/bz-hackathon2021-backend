package com.example.hackathondemo;

import org.springframework.beans.factory.annotation.Autowired;
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
public class HackathonDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackathonDemoApplication.class, args);
	}

}

@RestController
class ServiceDiscoveryController{

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
