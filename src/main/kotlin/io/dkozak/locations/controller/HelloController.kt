package io.dkozak.locations.controller

import io.dkozak.locations.repository.LocationDataRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloController(
        @Autowired
        private val locationDataRepository: LocationDataRepository
) {


    @GetMapping("/hello")
    fun sayHello() = "Hello"

    @GetMapping("/bike")
    fun biking() = locationDataRepository.getBikingData()

}

