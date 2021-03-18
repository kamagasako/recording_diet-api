package com.wazeka_inc.recording_diet.services

import com.wazeka_inc.recording_diet.models.Account
import com.wazeka_inc.recording_diet.models.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

interface AccountService {
    fun retrieve(): Account
}

@Service
class AccountServiceImpl: AccountService {

    @Autowired
    lateinit var accountRepository: AccountRepository

    /**
     * @todo serviceのメソッドが例外を投げていいかどうか
     * @todo HTTPステータスコードの整理
     */
    override fun retrieve(): Account {
        val principal = SecurityContextHolder.getContext().authentication.principal
        if (principal is User) {
            return accountRepository.findByUsername(principal.username).orElseThrow{ ResponseStatusException(HttpStatus.NOT_FOUND) }
        } else {
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED)
        }
    }
}