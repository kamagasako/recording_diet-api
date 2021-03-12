package com.wazeka_inc.recording_diet.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginController {

    @GetMapping("/login-page")
    fun loginPage(): String {
        return "login-page"
    }

    @GetMapping("/logged_in")
    fun loggedIn(): Map<String, String> {
        return mapOf("result" to "logged_in")
    }

    @GetMapping("/logged_out")
    fun loggedOut(): Map<String, String> {
        return mapOf("result" to "logged_out")
    }

    @GetMapping("/login_failure")
    fun loginFailure(): Map<String, String> {
        return mapOf("result" to "login_failure")
    }
}
