package uk.co.andrewreed.web3kotlin

import com.ionspin.kotlin.bignum.integer.BigInteger
import uk.co.andrewreed.web3kotlin.eth.CallObject
import uk.co.andrewreed.web3kotlin.eth.Eth
import uk.co.andrewreed.web3kotlin.eth.EthereumTransaction
import kotlin.test.Test
import kotlin.test.assertEquals

expect fun runTest(test: suspend () -> Unit)

private val goerli = "https://eth-goerli.g.alchemy.com/v2/ri0TxzkaKF-VwB95D1Np8EmmQ1qcG8tH"
private val ethMainnet = "https://mainnet.infura.io/v3/9aa3d95b3bc440fa88ea12eaa4456161"
private val local = "http://127.0.0.1:8545"

class EthTests {
    private val clientUrl = goerli

    private val client = Eth(clientUrl)

    // Changes too often.
//    @Test
//    fun testFetchGasPrice() = runTest {
//        val gas = client.gasPrice()
//        assertEquals(BigInteger.fromLong(100028815), gas)
//    }

    @Test
    fun testSha3Price() = runTest {
        val sha3Response = client.sha3("0x68656c6c6f20776f726c64")
        assertEquals("0x5b2c76da96136d193336fad3fbc049867b8ca157da22f69ae0e4923648250acc", sha3Response)
    }

    @Test
    fun testSha3FunctionCall() = runTest {
        val sha3Response = client.sha3("apply()")
        assertEquals("0xdb595b3b148fad58781ca9b18e71eeea7804b39e9b88afe8263ff62f5b5e9d3d", sha3Response)
    }

    @Test
    fun testBalance() = runTest {
        val balance = client.balance("0xF0C66B225FDA2fe9e0C54ce9B345F8A103c1Dca0")
        assertEquals(BigInteger.fromLong(248625822453342784), balance)
    }

    @Test
    fun testCall() = runTest {
        val sha3Method = client.sha3("greet()")
        val response = client.call(
            CallObject(
                to = "0x26a712c1227A66eb9AE54a3b7c3Ad00Ba329CF40",
                data = sha3Method
            )
        )
        assertEquals("Andrew", response)
    }

//    @Test
//    fun testTransaction() = runTest {
        // sending raw transaction is just with data: 0x0000
        // look into account_signTransaction to sign a transaction first.
//{
//  "id": 2,
//  "jsonrpc": "2.0",
//  "method": "account_signTransaction",
//  "params": [
//    {
//      "from": "0x1923f626bb8dc025849e00f99c25fe2b2f7fb0db",
//      "gas": "0x55555",
//      "maxFeePerGas": "0x1234",
//      "maxPriorityFeePerGas": "0x1234",
//      "input": "0xabcd",
//      "nonce": "0x0",
//      "to": "0x07a565b7ed7d7a678680a4c162885bedbb695fe0",
//      "value": "0x1234"
//    }
//  ]
//}
//        val sha3Method = client.sha3("greet()")
//        val response = client.sendRawTransaction(
//            EthereumTransaction(
//                to = "0x26a712c1227A66eb9AE54a3b7c3Ad00Ba329CF40",
//                from = "0xF0C66B225FDA2fe9e0C54ce9B345F8A103c1Dca0",
//                data = sha3Method,
//                gas = "0x55555",
//                maxPriorityFeePerGas = "0x1234",
//                maxFeePerGas = "0x1234",
//                value = "0x1234",
//                nonce = 0x00
//            )
//        )
//{
//  "id": 2,
//  "jsonrpc": "2.0",
//  "method": "account_signTransaction",
//  "params": [
//    {
//      "from": "0x1923f626bb8dc025849e00f99c25fe2b2f7fb0db",
//      "gas": "0x55555",
//      "maxFeePerGas": "0x1234",
//      "maxPriorityFeePerGas": "0x1234",
//      "input": "0xabcd",
//      "nonce": "0x0",
//      "to": "0x07a565b7ed7d7a678680a4c162885bedbb695fe0",
//      "value": "0x1234"
//    }
//  ]
//}
//        { id = 2, method = eth_sendRawTransaction, params = [{"to":"0x26a712c1227A66eb9AE54a3b7c3Ad00Ba329CF40","from":"0xF0C66B225FDA2fe9e0C54ce9B345F8A103c1Dca0","value":"0x1234","data":"0xcfae3217c5b262aa4fd3346d6d110ec3c0361903298087be8626cb438090d274","nonce":0,"gas":"0x55555","gasPrice":"0x1234","gasLimit":"0x1234"}] }
//        assertEquals("Andrew", response)
//    }

//    @Test
//    fun testAccounts() = runTest {
//        val response = client.getAccounts()
//        assertEquals(5, response.count())
//    }
}
