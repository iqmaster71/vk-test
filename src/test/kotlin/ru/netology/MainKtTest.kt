package ru.netology

import org.junit.Test
import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calcCommissionOfTransfer_VkPayZero() {
        val typeOfCard = TYPE_CARD_VK_PAY
        val amountOfPreviousMonthPeriod = 0
        val transferAmount = 14_000_00

        val result = calcCommissionOfTransfer(typeOfCard, amountOfPreviousMonthPeriod, transferAmount)

        // assertEquals(0, result)
    }

    @Test
    fun calcCommissionOfTransfer_VkPayOneTimeLimit() {
        val typeOfCard = TYPE_CARD_VK_PAY
        val amountOfPreviousMonthPeriod = 0
        val transferAmount = 16_000_00

        val result = calcCommissionOfTransfer(typeOfCard, amountOfPreviousMonthPeriod, transferAmount)

        // assertEquals(0, result)
    }

    @Test
    fun calcCommissionOfTransfer_VkPayMonthLimit() {
        val typeOfCard = TYPE_CARD_VK_PAY
        val amountOfPreviousMonthPeriod = 39_000_00
        val transferAmount = 11_000_00

        val result = calcCommissionOfTransfer(typeOfCard, amountOfPreviousMonthPeriod, transferAmount)

        // assertEquals(0, result)
    }

    @Test
    fun calcCommissionOfTransfer_AnyCardMonthLimit() {
        val typeOfCard = TYPE_CARD_MIR
        val amountOfPreviousMonthPeriod = 599_000_00
        val transferAmount = 11_000_00

        val result = calcCommissionOfTransfer(typeOfCard, amountOfPreviousMonthPeriod, transferAmount)

        // assertEquals(0, result)
    }

    @Test
    fun printMassageOfTransfer_Easy() {
        val typeOfCard = TYPE_CARD_VK_PAY
        val transferAmount = 16_000
        val commissionOfTransfer = 0

        printMassageOfTransfer(typeOfCard, transferAmount, commissionOfTransfer)

        //assertEquals(0, result)
    }

    @Test
    fun calcFullCommissionOfTransfer_TestVKPay() {
        val typeOfCard = TYPE_CARD_VK_PAY
        val transferAmount = 14_000

        val result = calcFullCommissionOfTransfer(typeOfCard, transferAmount)

        assertEquals(0, result)
    }

    @Test
    fun calcFullCommissionOfTransfer_TestVisaPay() {
        val typeOfCard = TYPE_CARD_VISA
        val transferAmount = 24_000

        val result = calcFullCommissionOfTransfer(typeOfCard, transferAmount)

        assertEquals(3500, result)
    }

    @Test
    fun calcFullCommissionOfTransfer_TestMirPayBig() {
        val typeOfCard = TYPE_CARD_MIR
        val transferAmount = 560_000

        val result = calcFullCommissionOfTransfer(typeOfCard, transferAmount)

        assertEquals(4200, result)
    }

    @Test
    fun calcFullCommissionOfTransfer_TestMasterPay() {
        val typeOfCard = TYPE_CARD_MASTER
        val transferAmount = 24_000

        val result = calcFullCommissionOfTransfer(typeOfCard, transferAmount)

        assertEquals(2144, result)
    }

    @Test
    fun calcFullCommissionOfTransfer_WrongCard() {
        val typeOfCard = "None"
        val transferAmount = 32_000

        val result = calcFullCommissionOfTransfer(typeOfCard, transferAmount)

        assertEquals(0, result)
    }
}