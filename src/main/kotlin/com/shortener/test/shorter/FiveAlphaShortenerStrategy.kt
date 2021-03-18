package com.shortener.test.shorter

import com.shortener.test.ALPHABET_SIZE
import com.shortener.test.DIGITS
import com.shortener.test.DIG_PAIR
import kotlin.math.floor
import kotlin.math.pow

class FiveAlphaShortenerStrategy: ShortenerStrategy {

    override fun convertToLink(id: Int): String {
        val builder = StringBuilder()
        var tmp = id
        do {
            val dig: Int = tmp % ALPHABET_SIZE
            builder.append(DIGITS[dig])
            tmp = floor((tmp / ALPHABET_SIZE).toDouble()).toInt()
        } while (tmp != 0)

        return builder.reverse().toString()
    }

    override fun convertToDigital(link: String): Int {
        var id = 0
        for (i in link.indices) {
            id += ((DIG_PAIR[link[link.length - i - 1]]!!.toDouble()) * ALPHABET_SIZE.toDouble().pow(i.toDouble())).toInt()
        }
        return id
    }
}
