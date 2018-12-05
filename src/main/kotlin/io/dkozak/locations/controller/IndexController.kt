package io.dkozak.locations.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {

    @GetMapping("/")
    fun root() = "index"

    @GetMapping("/new")
    fun new() = "new"

    @GetMapping("/availability")
    fun availability() = "availability"
}