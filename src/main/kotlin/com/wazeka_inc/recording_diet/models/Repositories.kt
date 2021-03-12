package com.wazeka_inc.recording_diet.models

import org.springframework.data.repository.CrudRepository
import java.util.*

interface AccountRepository: CrudRepository<Account, Long> {
    fun findByUsername(username: String): Optional<Account>
}
