package uk.co.andrewreed.web3kotlin

import com.ionspin.kotlin.bignum.integer.BigInteger
import uk.co.andrewreed.web3kotlin.eth.CallObject
import uk.co.andrewreed.web3kotlin.eth.Eth
import uk.co.andrewreed.web3kotlin.eth.EthereumAddress
import kotlin.test.Test
import kotlin.test.assertEquals

expect fun runTest(test: suspend () -> Unit)

private val goerli = "https://eth-goerli.g.alchemy.com/v2/ri0TxzkaKF-VwB95D1Np8EmmQ1qcG8tH"
private val ethMainnet = "https://mainnet.infura.io/v3/9aa3d95b3bc440fa88ea12eaa4456161"
private val local = "http://127.0.0.1:8545"

class EthTests {
    private val clientUrl = goerli

    private val client = Eth(clientUrl)

    @Test
    fun testFetchGasPrice() = runTest {
        val gas = client.gasPrice()
        assertEquals(BigInteger.fromLong(129784325), gas)
    }

    @Test
    fun testSha3Price() = runTest {
        val sha3Response = client.sha3("0x68656c6c6f20776f726c64")
        assertEquals("0x47173285a8d7341e5e972fc677286384f802f8ef42a5ec5f03bbfa254cb01fad", sha3Response)
    }

    @Test
    fun testSha3FunctionCall() = runTest {
        val sha3Response = client.sha3("apply()")
        assertEquals("0xdbf426f3c534816dd14e5e2f888d77bfa2ad01d17a538d4fce73d3267c5a15ef", sha3Response)
    }

    @Test
    fun testBalance() = runTest {
        val balance = client.balance("0xF0C66B225FDA2fe9e0C54ce9B345F8A103c1Dca0")
        assertEquals(BigInteger.fromLong(250000000000000000), balance)
    }

    @Test
    fun testCall() = runTest {
        val response = client.call(
            CallObject(
                to = "0x533ac4d8ac369b5be0389762614ca07494c3ccd2",
                data = "0x8da5cb5b"
            )
        )
        assertEquals("0x000000000000000000000000923f57ab9e1a2443ac729301ebaa6e8135fff79f", response)
    }

//    @Test
//    fun testAccounts() = runTest {
//        val response = client.getAccounts()
//        assertEquals(5, response.count())
//    }
}
