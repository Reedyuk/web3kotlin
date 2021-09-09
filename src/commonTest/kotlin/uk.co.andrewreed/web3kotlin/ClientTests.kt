package uk.co.andrewreed.web3kotlin

import com.ionspin.kotlin.bignum.integer.BigInteger
import uk.co.andrewreed.web3kotlin.eth.CallObject
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
        val gas = client.gasPrice()
        assertEquals(BigInteger.fromLong(20000000000), gas)
    }

    @Test
    fun testSha3Price() = runTest {
        val sha3Response = client.sha3("0x68656c6c6f20776f726c64")
        assertEquals("0xdbf426f3c534816dd14e5e2f888d77bfa2ad01d17a538d4fce73d3267c5a15ef", sha3Response)
    }

    @Test
    fun testBalance() = runTest {
        val balance = client.balance("0xFa5fDa418364C2CA452EBD467644d23EE0d8bd80")
        assertEquals(BigInteger.fromLong(1), balance)
    }

    @Test
    fun testCall() = runTest {
        val response = client.call(
            CallObject(
                to = "0xF7e4B57862EC47A9B059b8D2D051bBd3A8A64A14",
                data = "0xfe50cc72"
            )
        )
        assertEquals("0x0000000000000000000000000000000000000000000000000000000000000020000000000000000000000000000000000000000000000000000000000000000b48656c6c6f20576f726c64000000000000000000000000000000000000000000", response)
    }
}
