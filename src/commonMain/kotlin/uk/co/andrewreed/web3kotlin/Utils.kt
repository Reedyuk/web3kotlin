package uk.co.andrewreed.web3kotlin

import com.ionspin.kotlin.bignum.BigNumber
import com.ionspin.kotlin.bignum.integer.BigInteger
import io.ktor.utils.io.core.*
import kotlin.text.String

class Utils {

    fun randomHex(size: Int): String {
        TODO()
    }

    fun sha3(item: String): String {
        TODO()
    }

    fun isHex(item: String): Boolean {
        TODO()
    }

    fun BigNumber<BigInteger>.toHex(): String {
        TODO()
    }

    fun isAddress(address: String): Boolean {
        TODO()
    }
}

internal fun String.toHex(): String =
    encodeToByteArray()
        .asUByteArray()
        .joinToString("") {
            it.toString(radix = 16).padStart(2, '0')
        }

internal fun String.decodeHex(): String {
    require(length % 2 == 0) {"Must have an even length"}
    return String(
        chunked(2)
            .map { it.toInt(16).toByte() }
            .toByteArray()
    )
}
