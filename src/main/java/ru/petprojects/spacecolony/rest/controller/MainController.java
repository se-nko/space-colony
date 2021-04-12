package ru.petprojects.spacecolony.rest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Value("${service.type}")
    private String serviceType;

    @GetMapping(
            value = "/type",
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String getServiceType() {
        return String.format("The type of this service is - %s", serviceType);
    }
}
