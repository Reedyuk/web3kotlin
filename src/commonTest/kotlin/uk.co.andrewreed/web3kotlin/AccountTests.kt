package uk.co.andrewreed.web3kotlin

import uk.co.andrewreed.web3kotlin.utils.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class AccountTests {

    @Test
    fun testSimplePrivateKey() = runTest {
        val account = Account.privateKeyToAccount("fa982e3142ff4bec6fa35c1c3bf90e2843be5ce43f3e2bd71d2e5957b358a3f0")
        assertEquals("0x7DcdB62d6162A5eD4aD035b8cbCB04444ce445DC", account.address)
        assertEquals("7DcdB62d6162A5eD4aD035b8cbCB04444ce445DC", account.publicKey)
    }

}
