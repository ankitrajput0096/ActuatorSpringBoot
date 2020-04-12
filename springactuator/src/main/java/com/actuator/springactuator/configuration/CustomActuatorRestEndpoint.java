package com.actuator.springactuator.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/* Creating custom actuator endpoint */
@Component
@Endpoint(id="active-users")
public class CustomActuatorRestEndpoint {

    /* NOTE: This is for just showing some implementation
             Using this we can add useful details related to spring 
             boot service and expose it.
    */

    private final Map<String, User> users = new HashMap<>();

    CustomActuatorRestEndpoint() {
        this.users.put("Ankit", new User("Ankit_Rajput"));
        this.users.put("Sudhir", new User("Sudhir_Rajput"));
        this.users.put("Mithlesh", new User("Mithlesh_Rajput"));
    }

    @ReadOperation
    public List<User> getAll() {
        return new ArrayList<User>(this.users.values());
    }

    @ReadOperation
    public User getActiveUser(@Selector String user) {
        return this.users.get(user);
    }

    @WriteOperation
    public void updateActiveUser(@Selector String name,@RequestBody String user) {
        this.users.put(name, new User(user));
    }

    @DeleteOperation
    public void deleteActiveUser(@Selector String name) {
        this.users.remove(name);
    }

    public static class User {
        private String name;

        User(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}