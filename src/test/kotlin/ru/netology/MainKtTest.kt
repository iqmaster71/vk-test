package ru.netology

import org.junit.Assert.assertEquals
import org.junit.Test

class MainKtTest {

    @Test
    fun calcFullCommissionOfTransfer_TestVKPay() {
        val typeOfCard = TYPE_CARD_VK_PAY
        val transferAmount = 14_000

        val result = calcFullCommissionOfTransfer(typeOfCard, transferAmount)

        assertEquals(12, result)
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