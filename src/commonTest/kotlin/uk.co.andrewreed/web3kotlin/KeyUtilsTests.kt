package uk.co.andrewreed.web3kotlin

import uk.co.andrewreed.web3kotlin.utils.KeyUtils
import kotlin.test.Test
import kotlin.test.assertEquals

class KeyUtilsTests {

    @Test
    fun testAddress() = runTest {
        val publicKey = "0x719561fee351F7aC6560D0302aE415FfBEEc0B51fdsfsdfdsfdsfdsfdsfs"
        val privateKey = "0xef4e182ae2cf32192d2a62c1159c8c4f7f2d658c303d0dfca5791a205456a132"
        val publicAddress = "0x719561fee351F7aC6560D0302aE415FfBEEc0B51"

        val address = KeyUtils.generateAddress(publicKey)
        assertEquals(publicAddress, address)

        val publicKeyFromPrivate = KeyUtils.generatePublicKey(privateKey)
        assertEquals(publicAddress, publicKeyFromPrivate)
        val publicAddressFromPrivate = KeyUtils.generateAddress(publicKeyFromPrivate)
        assertEquals(publicAddress, publicAddressFromPrivate)
    }
}
