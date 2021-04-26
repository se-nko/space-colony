package ru.petprojects.spacecolony.rest.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.petprojects.spacecolony.rest.service.HarvestersService;

@RestController
@RequestMapping("/harvesters")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class HarvesterController {

    final HarvestersService harvestersService;

    @GetMapping("/count")
    public ResponseEntity<Integer> getCount() {
        return new ResponseEntity<>(harvestersService.getActiveCount(), HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<?> create() {
        harvestersService.create();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
