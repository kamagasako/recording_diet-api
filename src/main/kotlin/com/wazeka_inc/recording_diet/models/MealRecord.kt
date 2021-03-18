package com.wazeka_inc.recording_diet.models

import java.time.LocalDate
import javax.persistence.*

@Entity
class MealRecord(
    @Id @GeneratedValue var id: Long? = null,
    var timing: Int,
    var date: LocalDate,

    var name: String,
    var quantity: Long,
    var unit: String,

    @ManyToOne(optional = false) @JoinColumn(nullable = false) var account: Account,
)
