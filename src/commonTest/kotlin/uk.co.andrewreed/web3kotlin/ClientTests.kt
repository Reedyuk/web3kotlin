package uk.co.andrewreed.web3kotlin

import co.touchlab.kermit.Kermit
import uk.co.andrewreed.jsonrpc.Client.RPCClient
import uk.co.andrewreed.jsonrpc.Service.RPCService
import kotlin.test.Test
import kotlin.test.assertEquals

expect fun runTest(test: suspend () -> Unit)

private val ropsten = "https://ropsten.infura.io/v3/9aa3d95b3bc440fa88ea12eaa4456161"
private val local = "http://127.0.0.1:7545"

class ClientTests {
    private val kermit = Kermit()
    private val clientUrl = local

    @Test
    fun testPost() = runTest {
        val client = RPCClient(clientUrl)
        val service = object : RPCService(client) {
            suspend fun gasPrice(): String {
                val gasPrice = invoke("eth_gasPrice")
                kermit.v("$gasPrice")
                return gasPrice.content
            }
        }
        val price = service.gasPrice()
        assertEquals("0x4a817c800", price)
    }
}
