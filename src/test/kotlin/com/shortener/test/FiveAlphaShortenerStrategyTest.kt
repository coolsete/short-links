package com.shortener.test

import com.shortener.test.shorter.FiveAlphaShortenerStrategy
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FiveAlphaShortenerStrategyTest {
    private val shortener = FiveAlphaShortenerStrategy()
    private val id = 123456789
    private val link = "8m0Kx"

    @Test
    fun `FiveAlphaShortener should to return string link to digital id`() {
        Assertions.assertEquals(link, shortener.convertToLink(id))
    }

    @Test
    fun `FiveAlphaShortener should to return digital id by string link`() {
        Assertions.assertEquals(id, shortener.convertToDigital(link))
    }

    @Test
    fun `FiveAlphaShortener should generate 5 alpha-numeric` () {
        Assertions.assertEquals(5, shortener.convertToLink(id).length)
    }

}
