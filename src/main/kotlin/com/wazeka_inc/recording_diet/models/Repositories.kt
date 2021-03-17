package com.wazeka_inc.recording_diet.models

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AccountRepository: JpaRepository<Account, Long> {
    fun findByUsername(username: String): Optional<Account>
}
