package com.example.hackathondemo;

import com.example.hackathondemo.entity.Switches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class DistributedPropertiesController {

    @Value("${props.test}")
    String value;

    @Autowired
    private Switches properties;

    @GetMapping("/getConfigFromValue")
    public String getConfigFromValue() {
        return value;
    }

    @GetMapping("/getConfigFromProperty")
    public String getConfigFromProperty() {
        return properties.getTest();
    }
}
