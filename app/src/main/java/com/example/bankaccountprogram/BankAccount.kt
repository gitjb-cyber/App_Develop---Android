package com.example.bankaccountprogram

// 계좌 주인 이름과 계좌 금액을 프로퍼티로 설정
class BankAccount(var accountHolder : String, var balance : Double) {

    // 문자열로 된 변할 수 있는 리스트
    // 리스트에 추가할 목록의 데이터 종류를 정의하지 않아도 되지만,
    // Kotlin은 타입 종류가 어떤 것인지 모르기에 수동으로 정의(String)
    // BankAccount 클래스 외부에서 접근 불가(보안성)
    // BankMain 클래스에서는 데이터를 표시할 수는 있지만,
    // 직접 데이터를 수정하거나 접근할 수는 없음
    // 매 거래마다 transactionHistory에 저장
    private val transactionHistory = mutableListOf<String>()

    fun deposit(amount : Double) { // 입금 금액
        balance += amount
        // 거래 내역에 계좌주가 얼마 입금했는지 기록
        transactionHistory.add("$accountHolder deposited $$amount" +
                "($accountHolder 님이 $$amount 를 입금했습니다)")
    }

    fun withdraw(amount: Double) { // 출금 금액
        if (amount <= balance) {
            // 출금 가능할 때(계좌 잔액이 원하는 출금액보다 많을 때)
            balance -= amount
            transactionHistory.add("$accountHolder withdraw $$amount" +
                    "($accountHolder 님이 $$amount 를 출금했습니다)")
        } else {
            // 출금 불가능(계좌 잔액이 원하는 출금액보다 적을 때)
            println("You don't have the funds to withdraw $$amount" +
                    "(잔액이 부족하여 $$amount 를 출금할 수 없습니다.)")
        }
    }

    fun displayTransactionHistory() { // 거래 내역 표시
        println("Transaction history for $accountHolder" +
                "($accountHolder 님의 거래 내역입니다.)")
        for (transaction in transactionHistory) {
            println(transaction)
        }
    }

    fun acctBalance() : Double { // 계좌 잔액 반환
        println("${accountHolder}'s balance is ${balance}" +
                "(${accountHolder} 님의 현재 잔액은 ${balance} 입니다.)")
        return balance
    }

}