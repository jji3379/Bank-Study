package com.example.bank.account

import com.example.bank.user.UserEntity
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class AccountEntity (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val accountNumber: String,

    @Column(nullable = false)
    var balance: BigDecimal = BigDecimal.ZERO,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: UserEntity
)
