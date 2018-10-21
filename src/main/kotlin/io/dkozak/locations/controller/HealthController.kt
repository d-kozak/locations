package io.dkozak.locations.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthController {

    /**
     * Ping echo health check
     */
    @GetMapping("/health")
    fun health() = "ok"
}