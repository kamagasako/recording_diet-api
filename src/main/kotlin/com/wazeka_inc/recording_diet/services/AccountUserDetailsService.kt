package com.wazeka_inc.recording_diet.services

import com.wazeka_inc.recording_diet.models.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.util.*

@Service
class AccountUserDetailsService: UserDetailsService {

    @Autowired
    lateinit var accountRepository: AccountRepository

    override fun loadUserByUsername(username: String?): UserDetails {
        println("username: $username")
        return Optional.ofNullable(username).flatMap {
            accountRepository.findByUsername(it)
        }.map {
            println(it)
            it.toUserDetail()
        }.orElseThrow {
            throw UsernameNotFoundException("username: $username")
        }
    }
}
