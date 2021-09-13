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
        val privateKey = SigningKey("67E56582298859DDAE725F972992A07C6C4FB9F62A8FFF58CE3CA926A1063530")
        val wallet = Wallet(privateKey)
        assertEquals("04C591A8FF19AC9C4E4E5793673B83123437E975285E7B442F4EE2654DFFCA5E2D2103ED494718C697AC9AEBCFD19612E224DB46661011863ED2FC54E71861E2A6", wallet.publicKey.toString())
    }

}
