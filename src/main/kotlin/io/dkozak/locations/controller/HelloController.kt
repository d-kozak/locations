package io.dkozak.locations.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloController {


    @GetMapping("/hello")
    fun sayHello() = "Hello"
}

