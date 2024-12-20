package com.example.bankaccountprogram

fun main() {
    val parkBankAccount = BankAccount("Sarah", 0.0)
    parkBankAccount.deposit(100.0) // 200달러 입금
    parkBankAccount.withdraw(10.0) // 1200달러 출금
    parkBankAccount.deposit(300.0)

    parkBankAccount.displayTransactionHistory() // 계좌 내역 확인
    parkBankAccount.acctBalance()
}