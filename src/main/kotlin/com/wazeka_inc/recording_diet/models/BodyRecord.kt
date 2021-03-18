package com.wazeka_inc.recording_diet.models

import java.time.LocalDate
import javax.persistence.*

/**
 * 体調などに関する記録
 */
@Entity
class BodyRecord(
    @Id @GeneratedValue var id: Long? = null,
    var date: LocalDate,

    var weight: Long,
    var bodyFat: Long,

    @ManyToOne(optional = false) @JoinColumn(nullable = false) var account: Account,
)
