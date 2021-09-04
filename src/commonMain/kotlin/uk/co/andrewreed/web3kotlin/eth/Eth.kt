package uk.co.andrewreed.web3kotlin.eth

import com.ionspin.kotlin.bignum.integer.BigInteger
import uk.co.andrewreed.jsonrpc.Client.RPCClient
import uk.co.andrewreed.jsonrpc.Service.RPCService
import uk.co.andrewreed.web3kotlin.utils.Numeric

class Eth(provider: String) : RPCService(RPCClient(provider)) {

    suspend fun getGasPrice(): BigInteger {
        return Numeric.decodeQuantity(invoke("eth_gasPrice").content)
    }

    suspend fun sha3(data: String): String {
        return invoke("web3_sha3", arrayOf(data)).content
    }
}
