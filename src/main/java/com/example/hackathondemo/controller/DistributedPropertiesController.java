package com.example.hackathondemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
@CrossOrigin(origins = { "http://localhost:3000" })
public class DistributedPropertiesController {

    @Value("${props.test}")
    String value;

    @Value("${props.renderFilesButton}")
    boolean renderFilesButton;

    @GetMapping("/getConfigFromValue")
    public Map<String, Object> getConfigFromValue() {
        Map<String, Object> configMap = new HashMap<>();
        configMap.put("test", value);
        configMap.put("renderFilesButton", renderFilesButton);
        return configMap;
    }

}
