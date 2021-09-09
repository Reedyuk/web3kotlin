package uk.co.andrewreed.web3kotlin.eth

import co.touchlab.kermit.Kermit
import com.ionspin.kotlin.bignum.integer.BigInteger
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
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
        log.d("callObject ${callObject}")
        val resp = invoke("eth_call", JsonArray(listOf(callObject.toJsonObject())))
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
) {
    fun toJsonObject(): JsonObject {
        val map = mutableMapOf<String, JsonPrimitive>()
        from?.let { map.put("from", JsonPrimitive(it)) }
        to?.let { map.put("to", JsonPrimitive(it)) }
        gas?.let { map.put("gas", JsonPrimitive(it)) }
        gasLimit?.let { map.put("gasLimit", JsonPrimitive(it)) }
        value?.let { map.put("value", JsonPrimitive(it)) }
        data?.let { map.put("data", JsonPrimitive(it)) }
        return JsonObject(map)
    }
}
