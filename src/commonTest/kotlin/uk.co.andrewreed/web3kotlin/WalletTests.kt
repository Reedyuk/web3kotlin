package uk.co.andrewreed.web3kotlin

import uk.co.andrewreed.web3kotlin.Wallet.Companion.fromMnemonic
import kotlin.test.Test
import kotlin.test.assertEquals

class WalletTests {

    @Test
    fun testMnemonic() = runTest {
        // "announce room limb pattern dry unit scale effort smooth jazz weasel alcohol"
        val mnemonic = ""
        val wallet = mnemonic.fromMnemonic()
        assertEquals("", wallet.address)
    }

    @Test
    fun testPrivateKey() = runTest {
        // "announce room limb pattern dry unit scale effort smooth jazz weasel alcohol"
        val privateKey = ""
        val wallet = Wallet(privateKey)
        assertEquals("", wallet.address)
    }

}
