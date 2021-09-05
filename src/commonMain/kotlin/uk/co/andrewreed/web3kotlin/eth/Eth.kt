package uk.co.andrewreed.web3kotlin.eth

import co.touchlab.kermit.Kermit
import com.ionspin.kotlin.bignum.integer.BigInteger
import uk.co.andrewreed.jsonrpc.Client.RPCClient
import uk.co.andrewreed.jsonrpc.Service.RPCService
import uk.co.andrewreed.web3kotlin.utils.Numeric

class Eth(provider: String) : RPCService(RPCClient(provider)) {

    private val log = Kermit()

    suspend fun gasPrice(): BigInteger {
        return Numeric.decodeQuantity(invoke("eth_gasPrice").content)
    }

    suspend fun sha3(data: String): String {
        return invoke("web3_sha3", arrayOf(data)).content
    }

    suspend fun balance(address: String): BigInteger {
        return Numeric.decodeQuantity(invoke("eth_getBalance", arrayOf(address)).content)
    }

    suspend fun call(callObject: CallObject) {
        val resp = invoke("eth_call", arrayOf(callObject.toString()))
        log.d("call response $resp")
    }
}

data class CallObject(
    val from: String? = null, // address obj
    val to: String? = null,
    val gas: BigInteger? = null,
    val gasLimit: BigInteger? = null,
    val value: String? = null,
    val data: String? = null
) {
    override fun toString(): String {
        return "{\n" +
                (from?.let { "\"from\": \"$it\",\n" } ?: "") +
                (to?.let { "\"to\": \"$it\",\n" } ?: "") +
                (gas?.let { "\"gas\": \"${it.stringRepresentation}\",\n" } ?: "") +
                (gasLimit?.let { "\"gasPrice\": \"${it.stringRepresentation}\",\n" } ?: "") +
                (value?.let { "\"value\": \"$it\",\n" } ?: "") +
                (data?.let { "\"data\": \"$it\"\n" } ?: "") +
            "\t}"
    }
}
