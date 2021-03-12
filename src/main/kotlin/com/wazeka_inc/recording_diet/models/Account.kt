package com.wazeka_inc.recording_diet.models

import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Account(
    @Id @GeneratedValue var id: Long? = null,
    @Column(unique = true) var username: String,
    var password: String,
    var roles: String,
    var deleted: Boolean = false
) {

    companion object {
        const val ROLE_USER: String = "ROLE_USER"
    }

    fun toUserDetail(): UserDetails = User(username, password, !deleted, !deleted, !deleted, !deleted, AuthorityUtils.commaSeparatedStringToAuthorityList(roles))
}
