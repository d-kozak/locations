package io.dkozak.locations.controller

import io.dkozak.locations.repository.LocationDataRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class DataController(
        @Autowired
        private val locationDataRepository: LocationDataRepository
) {


    @GetMapping("/biking")
    fun biking() = locationDataRepository.getBikingData()

    @GetMapping("/driving")
    fun driving() = locationDataRepository.getDrivingData()

    @GetMapping("/running")
    fun running() = locationDataRepository.getRunningData()

    @GetMapping("/walking")
    fun walking() = locationDataRepository.getWalkingData()


}

