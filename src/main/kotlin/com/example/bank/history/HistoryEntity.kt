package com.example.bank.history

import com.example.bank.account.AccountEntity
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
data class HistoryEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val amount: BigDecimal,

    @Column(nullable = false)
    val historyDateTime: LocalDateTime = LocalDateTime.now(),

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val historyType: HistoryType,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    val account: AccountEntity
) {
    enum class HistoryType {
        DEPOSIT, WITHDRAW
    }
}