package com.wazeka_inc.recording_diet.models

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.time.LocalDate
import javax.persistence.EntityManager

@DataJpaTest
class RepositoriesTests @Autowired constructor(
    val entityManager: EntityManager,
    val dietRecordRepository: DietRecordRepository
) {

    @Test
    fun `diet record not found`() {
        val account = Account(null, "test_username", "{noop}password", "ROLE_USER", false)
        entityManager.persist(account)
        entityManager.flush()

        val now = LocalDate.now()
        val notFound = dietRecordRepository.findByAccountAndLocalDate(account, now)
        assert(notFound.isEmpty)
    }

    @Test
    fun `find diet record by account and localdate`() {
        val account = Account(null, "test_username", "{noop}password", "ROLE_USER", false)
        entityManager.persist(account)
        val now = LocalDate.now()
        val record = DietRecord(null, now, "body", "meals", "exercises", account)
        entityManager.persist(record)
        entityManager.flush()
        entityManager.clear()

        val found = dietRecordRepository.findByAccountAndLocalDate(account, now)
        assert(found.isPresent)
        found.map {
            assert(it.id == record.id)
        }
    }
}
