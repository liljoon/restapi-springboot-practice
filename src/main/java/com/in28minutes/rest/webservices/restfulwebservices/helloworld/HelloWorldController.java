package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path="/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }


    //path variable practice
    @GetMapping(path="/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable("name") String name) {
        return new HelloWorldBean(String.format("Hello World %s", name));
    }

    //path variable practice
    @GetMapping(path="/hello-world-bean/path-param")
    public HelloWorldBean helloWorldBeanPathParam(@PathParam("name") String name) {
        return new HelloWorldBean(String.format("Hello World %s", name));
    }

}
