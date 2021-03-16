package com.example.weatherapplication

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Test
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    //from kelvin to fahrenheit
    @Test
    fun tempFromKToF_isCorrect() {
        assertThat(((100 - 273.15) * 9 / 5 + 32),(equalTo(-279.66999999999996)))
    }
    //from kelvin to celcius
    @Test
    fun tempFromKToC_isCorrect() {
        assertThat((100 - 273.15),(equalTo(-173.14999999999998)))
    }
}