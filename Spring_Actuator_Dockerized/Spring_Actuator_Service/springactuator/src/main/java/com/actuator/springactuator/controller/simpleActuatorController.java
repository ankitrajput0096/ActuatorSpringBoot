package com.actuator.springactuator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/* Normal Rest Controller */
@RestController
public class simpleActuatorController {

    @RequestMapping(
            value = "/helloactuator",
            method=RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity<?> helloActuator() {
        return ResponseEntity.ok().body("This is hello actuator endpoint");
    }
    
}