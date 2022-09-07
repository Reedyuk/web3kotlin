package uk.co.andrewreed.web3kotlin.net

import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonPrimitive
import uk.co.andrewreed.jsonrpc.Client.RPCClient
import uk.co.andrewreed.jsonrpc.Service.RPCService
import uk.co.andrewreed.web3kotlin.toHex

//https://www.blockmeadow.com/complete-ethereum-rpc-calls-list-with-examples/
// net
class Net(provider: String) : RPCService(RPCClient(provider)) {

    suspend fun version(): String = invoke("net_version").content
    suspend fun listening(): Boolean = invoke("net_listening" ).content.toBooleanStrict()
    suspend fun peerCount(): String = invoke("net_peerCount").content
}
