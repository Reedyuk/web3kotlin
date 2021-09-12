package uk.co.andrewreed.web3kotlin.eth

import co.touchlab.kermit.Kermit
import com.ionspin.kotlin.bignum.integer.BigInteger
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonPrimitive
import uk.co.andrewreed.jsonrpc.Client.RPCClient
import uk.co.andrewreed.jsonrpc.Service.RPCService
import uk.co.andrewreed.web3kotlin.utils.Numeric

class Eth(provider: String) : RPCService(RPCClient(provider)) {

    private val log = Kermit()

    suspend fun gasPrice(): BigInteger {
        return Numeric.decodeQuantity(invoke("eth_gasPrice").content)
    }

    suspend fun sha3(data: String): String {
        return invoke("web3_sha3", JsonArray(listOf(JsonPrimitive(data)))).content
    }

    suspend fun balance(address: String): BigInteger {
        return Numeric.decodeQuantity(invoke("eth_getBalance", JsonArray(listOf(JsonPrimitive(address)))).content)
    }

    suspend fun call(callObject: CallObject): String {
        log.d("callObject $callObject")
        val resp = invoke(
            "eth_call",
            JsonArray(
                listOf(
                    Json.encodeToJsonElement(CallObject.serializer(), callObject)
                )
            )
        )
        log.d("call response $resp")
        return resp.content
    }
}

@Serializable
data class CallObject(
    val from: String? = null, // address obj
    val to: String? = null,
    val gas: String? = null,
    val gasLimit: String? = null,
    val value: String? = null,
    val data: String? = null
)