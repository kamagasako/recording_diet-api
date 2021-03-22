package com.wazeka_inc.recording_diet.models

import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate
import java.util.*

interface AccountRepository: JpaRepository<Account, Long> {
    fun findByUsername(username: String): Optional<Account>
}

interface DietRecordRepository: JpaRepository<DietRecord, Long> {
    fun findByAccountAndLocalDate(account: Account, localDate: LocalDate): Optional<DietRecord>
}
