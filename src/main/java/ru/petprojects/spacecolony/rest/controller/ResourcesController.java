package ru.petprojects.spacecolony.rest.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.petprojects.spacecolony.rest.service.ResourcesService;

@RestController
@RequestMapping("/resources")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResourcesController {

    final ResourcesService service;

    @GetMapping("/storage/capacity")
    public ResponseEntity<?> getSize() {
        return new ResponseEntity<>(service.getCount(), HttpStatus.OK);
    }

    @GetMapping("/storage/resources")
    public ResponseEntity<?> getResources() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/storage/clear")
    public ResponseEntity<?> clear() {
        service.clear();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
