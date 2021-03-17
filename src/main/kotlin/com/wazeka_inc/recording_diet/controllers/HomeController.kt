package com.wazeka_inc.recording_diet.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {

    @GetMapping("/")
    fun root(): Map<String, String> {
        return mapOf() // 空のJSON
    }
}
