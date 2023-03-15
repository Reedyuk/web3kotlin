package uk.co.andrewreed.web3kotlin.utils

import com.ionspin.kotlin.bignum.integer.BigInteger
import uk.co.andrewreed.web3kotlin.exceptions.MessageDecodingException

class Numeric {

    companion object {
        fun decodeQuantity(value: String): BigInteger {
            if (isLongValue(value)) {
                return BigInteger.parseString(value)
            }
            if (!isValidHexQuantity(value)) {
                throw MessageDecodingException("Value must be in format 0x[1-9]+[0-9]* or 0x0")
            }
            try {
                return BigInteger.parseString(value.substring(2), 16)
            } catch (e: NumberFormatException) {
                throw MessageDecodingException("Negative ", e)
            }
        }

        private const val hexPrefix = "0x"

        private fun isLongValue(value: String): Boolean =
            try {
                value.toLong()
                true
            } catch (exception: NumberFormatException) {
                false
            }

        private fun isValidHexQuantity(value: String): Boolean {
            if (value.length < 3) return false
            return value.startsWith(hexPrefix)
        }
    }
}
