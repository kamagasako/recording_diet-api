package com.wazeka_inc.recording_diet.controllers

import com.wazeka_inc.recording_diet.models.BodyRecord
import com.wazeka_inc.recording_diet.models.ExerciseRecord
import com.wazeka_inc.recording_diet.models.ExerciseRecordRepository
import com.wazeka_inc.recording_diet.models.MealRecord
import com.wazeka_inc.recording_diet.services.AccountService
import com.wazeka_inc.recording_diet.services.RecordService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/api/records")
class RecordController {

    @Autowired
    lateinit var accountService: AccountService

    @Autowired
    lateinit var recordService: RecordService

    @GetMapping("/body")
    fun bodyRecords(): List<BodyRecord> {
        val account = accountService.retrieve()
        return recordService.bodyRecords(account, LocalDate.now())
    }

    @GetMapping("/meal")
    fun mealRecords(): List<MealRecord> {
        val account = accountService.retrieve()
        return recordService.mealRecords(account, LocalDate.now())
    }

    @GetMapping("/exercise")
    fun exerciseRecords(): List<ExerciseRecord> {
        val account = accountService.retrieve()
        return recordService.exerciseRecords(account, LocalDate.now())
    }
}
