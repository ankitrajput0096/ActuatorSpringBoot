package com.actuator.springactuator.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/* Creating custom actuator Rest Controller */
@Component
@RestControllerEndpoint(id = "custom-actuator-rest-endpoint")
public class CustomActuatorRestController {

    /* NOTE: This is for just showing some implementation
             Using this we can add useful details related to spring 
             boot service and expose it.
    */

    private final ArrayList<String> theList = new ArrayList<>();

    CustomActuatorRestController() {
        theList.add("Ankit");
        theList.add("Sudhir");
        theList.add("Papa");
    }

    @GetMapping
    public ResponseEntity<List<String>> getMethod() {
        return new ResponseEntity<List<String>>(theList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postMethod(@RequestBody Request request) {
        theList.add(request.getValue());
        return ResponseEntity.ok().body("This was post method");
    }

    @DeleteMapping
    public ResponseEntity<?> deleteMethod(@RequestParam String request) {
        theList.remove(request);
        return ResponseEntity.ok().body("This was delete method");
    }

    public static class Request {
        public String value;

        public String getValue() {
            return this.value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}