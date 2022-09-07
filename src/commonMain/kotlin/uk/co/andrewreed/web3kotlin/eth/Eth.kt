package uk.co.andrewreed.web3kotlin.eth

import co.touchlab.kermit.Kermit
import com.ionspin.kotlin.bignum.integer.BigInteger
import kotlinx.serialization.json.*
import uk.co.andrewreed.jsonrpc.Client.RPCClient
import uk.co.andrewreed.jsonrpc.Service.RPCService
import uk.co.andrewreed.web3kotlin.Wallet
import uk.co.andrewreed.web3kotlin.decodeHex
import uk.co.andrewreed.web3kotlin.toHex
import uk.co.andrewreed.web3kotlin.utils.Numeric

//https://www.blockmeadow.com/complete-ethereum-rpc-calls-list-with-examples/
// eth
class Eth(provider: String) : RPCService(RPCClient(provider)) {

    private val log = Kermit()

    val wallet: Wallet = Wallet()

    suspend fun gasPrice(): BigInteger {
        return Numeric.decodeQuantity(invoke("eth_gasPrice").content)
    }

    suspend fun sha3(data: String): String {
        return invoke("web3_sha3", JsonArray(listOf(JsonPrimitive("0x${data.toHex()}")))).content
    }

    suspend fun balance(address: EthereumAddress): BigInteger {
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
        return resp.content.drop(2).decodeHex().mapNotNull {
            if (it != Char.MIN_VALUE && it != '\u0006') {
                it
            } else {
                null
            }
        }.joinToString("").trimStart()
    }

    suspend fun sendRawTransaction(transaction: EthereumTransaction): String {
        log.d("sendRawTransaction $transaction")
        val resp = invoke(
            "eth_sendRawTransaction",
            JsonArray(
                listOf(
                    Json.encodeToJsonElement(EthereumTransaction.serializer(), transaction)
                )
            )
        )
        log.d("sendRawTransaction response $resp")
        // should return a transaction hash
        return resp.content
    }

//    suspend fun getAccounts(): List<EthereumAddress> {
//        return invoke("eth_accounts", null).jsonArray.map { it.jsonPrimitive.content }
//    }

}
