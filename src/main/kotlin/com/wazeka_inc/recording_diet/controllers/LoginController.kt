package com.wazeka_inc.recording_diet.controllers

import com.wazeka_inc.recording_diet.models.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpStatusCodeException
import org.springframework.web.server.ResponseStatusException

/**
 * @todo LoginServiceを導入?
 */
@RestController
class LoginController {

    @GetMapping("/unauthorized")
    fun loginPage() {
        throw ResponseStatusException(HttpStatus.UNAUTHORIZED)
    }

    @Autowired
    lateinit var accountRepository: AccountRepository

    /**
     * @todo ログイン名ではなく表示名を返す?
     */
    @GetMapping("/logged_in")
    fun loggedIn(): Map<String, String> {
        val context = SecurityContextHolder.getContext()
        val authentication = context.authentication
        val principal = authentication.principal

        val result = mutableMapOf("action" to "login", "result" to "success")
        if (principal is User) {
            accountRepository.findByUsername(principal.username).map {
                result.putAll(mapOf("name" to it.username, "role" to it.roles))
            }
        }
        return result
    }

    @GetMapping("/login_failure")
    fun loginFailure(): Map<String, String> {
        return mapOf("action" to "login", "result" to "failure")
    }

    @GetMapping("/logged_out")
    fun loggedOut(): Map<String, String> {
        return mapOf("action" to "logout", "result" to "success")
    }
}
