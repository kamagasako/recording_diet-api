package com.wazeka_inc.recording_diet.models

import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate
import java.util.*

interface AccountRepository: JpaRepository<Account, Long> {
    fun findByUsername(username: String): Optional<Account>
}

interface BodyRecordRepository: JpaRepository<BodyRecord, Long> {
    fun findByAccountAndDate(account: Account, date: LocalDate): List<BodyRecord>
}

interface MealRecordRepository: JpaRepository<MealRecord, Long> {
    fun findByAccountAndDate(account: Account, date: LocalDate): List<MealRecord>
}

interface ExerciseRecordRepository: JpaRepository<ExerciseRecord, Long> {
    fun findByAccountAndDate(account: Account, date: LocalDate): List<ExerciseRecord>
}
