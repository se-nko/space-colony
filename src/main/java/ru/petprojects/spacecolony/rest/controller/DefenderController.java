package ru.petprojects.spacecolony.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/defenders")
public class DefenderController {

    @GetMapping("/count")
    public ResponseEntity<Integer> getCount() {
        return new ResponseEntity<>(2, HttpStatus.OK);
    }

}
