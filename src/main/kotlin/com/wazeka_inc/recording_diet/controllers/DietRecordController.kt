package com.wazeka_inc.recording_diet.controllers

import com.wazeka_inc.recording_diet.models.DietRecord
import com.wazeka_inc.recording_diet.services.AccountService
import com.wazeka_inc.recording_diet.services.DietRecordService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/api/record")
class DietRecordController {

    @Autowired
    lateinit var accountService: AccountService
    @Autowired
    lateinit var dietRecordService: DietRecordService

    @GetMapping("")
    fun today(): DietRecord {
        val account = accountService.retrieve()
        val now = LocalDate.now()
        return dietRecordService.findOrNewInstance(account, now)
    }
}
