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
    fun biking() = locationDataRepository.getBikingData().asArrays()

    @GetMapping("/driving")
    fun driving() = locationDataRepository.getDrivingData().asArrays()

    @GetMapping("/running")
    fun running() = locationDataRepository.getRunningData().asArrays()

    @GetMapping("/walking")
    fun walking() = locationDataRepository.getWalkingData().asArrays()
}

fun List<Pair<Double, Double>>.asArrays() = map {
    arrayOf(it.first, it.second)
}
