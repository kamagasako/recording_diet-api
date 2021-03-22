package com.wazeka_inc.recording_diet.models

import java.time.LocalDate
import javax.persistence.*

@Entity
class DietRecord(
    @Id @GeneratedValue var id: Long? = null,
    var localDate: LocalDate,
    var body: String,
    var meals: String,
    var exercises: String,

    @ManyToOne(optional = false) @JoinColumn(nullable = false) var account: Account,
)
