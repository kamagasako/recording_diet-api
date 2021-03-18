package com.wazeka_inc.recording_diet.services

import com.wazeka_inc.recording_diet.models.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Service
import java.time.LocalDate

interface RecordService {
    fun bodyRecords(account: Account, date: LocalDate): List<BodyRecord>
    fun mealRecords(account: Account, date: LocalDate): List<MealRecord>
    fun exerciseRecords(account: Account, date: LocalDate): List<ExerciseRecord>
}

@Service
class RecordServiceImpl: RecordService {

    @Autowired
    lateinit var accountRepository: AccountRepository
    @Autowired
    lateinit var bodyRecordRepository: BodyRecordRepository
    @Autowired
    lateinit var mealRecordRepository: MealRecordRepository
    @Autowired
    lateinit var exerciseRecordRepository: ExerciseRecordRepository

    override fun bodyRecords(account: Account, date: LocalDate): List<BodyRecord> {
        return bodyRecordRepository.findByAccountAndDate(account, date)
    }

    override fun mealRecords(account: Account, date: LocalDate): List<MealRecord> {
        return mealRecordRepository.findByAccountAndDate(account, date)
    }

    override fun exerciseRecords(account: Account, date: LocalDate): List<ExerciseRecord> {
        return exerciseRecordRepository.findByAccountAndDate(account, date)
    }
}