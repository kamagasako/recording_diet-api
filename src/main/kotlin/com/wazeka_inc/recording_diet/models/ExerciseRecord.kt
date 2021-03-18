package com.wazeka_inc.recording_diet.models

import java.time.LocalDate
import javax.persistence.*

@Entity
class ExerciseRecord(
    @Id @GeneratedValue var id: Long? = null,
    var date: LocalDate,

    var name: String,
    var munites: Int,

    @ManyToOne(optional = false) @JoinColumn(nullable = false) var account: Account,
)
