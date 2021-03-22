package com.wazeka_inc.recording_diet.services

import com.wazeka_inc.recording_diet.models.Account
import com.wazeka_inc.recording_diet.models.DietRecord
import com.wazeka_inc.recording_diet.models.DietRecordRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.util.*

interface DietRecordService {
    fun findOrNewInstance(account: Account, localDate: LocalDate): DietRecord
}

@Service
class DietRecordServiceImpl : DietRecordService {

    @Autowired
    lateinit var dietRecordRepository: DietRecordRepository

    @Transactional(rollbackFor = [Exception::class])
    override fun findOrNewInstance(account: Account, localDate: LocalDate): DietRecord {
        return find(account, localDate).orElse(newInstance(account, localDate))
    }

    private fun find(account: Account, localDate: LocalDate): Optional<DietRecord> {
        return dietRecordRepository.findByAccountAndLocalDate(account, localDate)
    }

    private fun newInstance(account: Account, localDate: LocalDate): DietRecord {
        val record = DietRecord(null, localDate, "", "", "", account)
        dietRecordRepository.saveAndFlush(record)
        return record
    }
}
