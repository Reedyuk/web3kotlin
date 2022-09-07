package uk.co.andrewreed.web3kotlin.web

import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonPrimitive
import uk.co.andrewreed.jsonrpc.Client.RPCClient
import uk.co.andrewreed.jsonrpc.Service.RPCService
import uk.co.andrewreed.web3kotlin.toHex

// https://www.blockmeadow.com/complete-ethereum-rpc-calls-list-with-examples/
// web3

class Web(provider: String) : RPCService(RPCClient(provider)) {
    val version = "0.0.1" // version of web3kotlin

//    val eth = Eth(provider)
    // extend for more?

    // val utils = Utils()
    //
    suspend fun sha3(data: String): String {
        return invoke("web3_sha3", JsonArray(listOf(JsonPrimitive("0x${data.toHex()}")))).content
    }

    suspend fun clientVersion(): String = invoke("web3_clientVersion").content
}
