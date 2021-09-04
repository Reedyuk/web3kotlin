package uk.co.andrewreed.web3kotlin

import co.touchlab.kermit.Kermit
import com.ionspin.kotlin.bignum.integer.BigInteger
import uk.co.andrewreed.web3kotlin.eth.Eth
import kotlin.test.Test
import kotlin.test.assertEquals

expect fun runTest(test: suspend () -> Unit)

private val ropsten = "https://ropsten.infura.io/v3/9aa3d95b3bc440fa88ea12eaa4456161"
private val ethMainnet = "https://mainnet.infura.io/v3/9aa3d95b3bc440fa88ea12eaa4456161"
private val local = "http://127.0.0.1:7545"

class ClientTests {
    private val clientUrl = local

    private val client = Eth(clientUrl)

    @Test
    fun testFetchGasPrice() = runTest {
        val gas = client.getGasPrice()
        assertEquals(BigInteger.fromLong(20000000000), gas)
    }

    @Test
    fun testSha3Price() = runTest {
        val sha3Response = client.sha3("0x68656c6c6f20776f726c64")
        assertEquals("0xdbf426f3c534816dd14e5e2f888d77bfa2ad01d17a538d4fce73d3267c5a15ef", sha3Response)
    }
}
