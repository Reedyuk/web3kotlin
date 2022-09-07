package uk.co.andrewreed.web3kotlin

import com.ionspin.kotlin.bignum.integer.BigInteger
import uk.co.andrewreed.web3kotlin.eth.CallObject
import uk.co.andrewreed.web3kotlin.eth.Eth
import uk.co.andrewreed.web3kotlin.utils.config
import uk.co.andrewreed.web3kotlin.utils.runTest
import uk.co.andrewreed.web3kotlin.web3.Web3
import kotlin.test.Test
import kotlin.test.assertEquals

class EthTests {
    private val client = Eth(config.url)

    // Changes too often.
//    @Test
//    fun testFetchGasPrice() = runTest {
//        val gas = client.gasPrice()
//        assertEquals(BigInteger.fromLong(100028815), gas)
//    }

    @Test
    fun testProtocolVersion() = runTest {
        val response = client.protocolVersion()
        assertEquals("0x41", response)
    }

    @Test
    fun testSyncing() = runTest {
        val response = client.syncing()
        assertEquals(false, response)
    }

    @Test
    fun testBalance() = runTest {
        val balance = client.balance("0xF0C66B225FDA2fe9e0C54ce9B345F8A103c1Dca0")
        assertEquals(BigInteger.fromLong(248625822453342784), balance)
    }

    @Test
    fun testCall() = runTest {
        val web3Client = Web3(config.url)
        val sha3Method = web3Client.sha3("greet()")
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
