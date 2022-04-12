package ru.netology

const val TYPE_CARD_VK_PAY = "VК Pay"
const val TYPE_CARD_MASTER = "Mastercard"
const val TYPE_CARD_MAESTRO = "Maestro"
const val TYPE_CARD_VISA = "Visa"
const val TYPE_CARD_MIR = "МИР"

const val MAX_CARD_TRANSFER_DAY = 15_000_000
const val MAX_CARD_TRANSFER_MONTH = 60_000_000

const val MAX_VK_PAY_TRANSFER_ONE_TIME = 1_500_000
const val MAX_VK_PAY_TRANSFER_MONTH = 4_000_000

fun main() {
    val transferAmount = 1_450_000

    calcCommissionOfTransfer(typeOfCard = TYPE_CARD_VK_PAY, amountOfPreviousMonthPeriod = 0, transferAmount)
}

fun calcCommissionOfTransfer(typeOfCard: String, amountOfPreviousMonthPeriod: Int, transferAmount: Int) {
    if (typeOfCard == TYPE_CARD_VK_PAY) {
        if (transferAmount >= MAX_VK_PAY_TRANSFER_ONE_TIME) {
            println("Превышен лимит суммы перевода за один раз.")
        } else if ((amountOfPreviousMonthPeriod + transferAmount) > MAX_VK_PAY_TRANSFER_MONTH) {
            println("Сумма превышает месячный лимит переводов.")
        } else {
            val commissionOfTransfer = calcFullCommissionOfTransfer(typeOfCard, transferAmount)
            printMassageOfTransfer(typeOfCard, transferAmount, commissionOfTransfer)
        }
    } else if (typeOfCard == TYPE_CARD_MAESTRO ||
        typeOfCard == TYPE_CARD_MIR ||
        typeOfCard == TYPE_CARD_VISA ||
        typeOfCard == TYPE_CARD_MASTER
    ) {
        val amountOfDay = 0
        if ((amountOfPreviousMonthPeriod + transferAmount) > MAX_CARD_TRANSFER_MONTH) {
            println("Сумма превышает месячный лимит переводов.")
        } else if ((amountOfDay + transferAmount) >= MAX_CARD_TRANSFER_DAY) {
            println("Превышен лимит суммы перевода за сутки.")
        } else {
            val commissionOfTransfer = calcFullCommissionOfTransfer(typeOfCard, transferAmount)
            printMassageOfTransfer(typeOfCard, transferAmount, commissionOfTransfer)
        }
    }
}

fun printMassageOfTransfer(typeOfCard: String, transferAmount: Int, commissionOfTransfer: Int) {
    println(
        "Сумма перевода на $typeOfCard: ${transferAmount / 100} руб. ${transferAmount % 100} коп., " +
                "комиссия за перевод $commissionOfTransfer коп."
    )
}

fun calcFullCommissionOfTransfer(typeOfCard: String, transferAmount: Int): Int {
    when (typeOfCard) {
        TYPE_CARD_VK_PAY -> return 0
        TYPE_CARD_MIR, TYPE_CARD_VISA ->
            return if ((transferAmount * 0.0075).toInt() > 3500) {
                (transferAmount * 0.0075).toInt()
            } else {
                3500
            }
        TYPE_CARD_MASTER, TYPE_CARD_MAESTRO -> return ((transferAmount * 0.006).toInt() + 2000)
    }
    return 0
}