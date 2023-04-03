package com.example.proctoring

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.every
import io.mockk.spyk
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun choseActivityIsCorrect() {
        val exampleActivity = spyk(CheckQrActivity())
        every { exampleActivity.startActivity(any()) } returns Unit
        exampleActivity.choseActivity(true)
    }

    @Test
    fun QrReadingIsCorrectTrueCase() {
        val qrText = "url:http://localhost;ident:10;name:Матросов Денис Валерьевич;stud_nomer:930430;proc: rpdmp"
        val exampleActivity = spyk(CheckQrActivity())
        every { exampleActivity.startActivity(any()) } returns Unit
        assert( exampleActivity.checkQrContent(qrText))
    }

    @Test
    fun QrReadingIsCorrectFalseCase() {
        val qrText =
            "url:http://localhost;ident:10;name:Боблаков Дмитрий Сергеевич;stud_nomer:930424;proc:abcd"
        val exampleActivity = spyk(CheckQrActivity())
        every { exampleActivity.startActivity(any()) } returns Unit
        assertTrue(exampleActivity.checkQrContent(qrText))
    }
}