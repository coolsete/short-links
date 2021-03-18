package com.shortener.test.shorter

interface ShortenerStrategy {
    fun convertToLink(id: Int): String
    fun convertToDigital(link: String): Int
}
