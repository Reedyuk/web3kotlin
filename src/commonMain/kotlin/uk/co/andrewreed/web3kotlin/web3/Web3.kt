package uk.co.andrewreed.web3kotlin.web3

import uk.co.andrewreed.jsonrpc.Client.RPCClient
import uk.co.andrewreed.jsonrpc.Service.RPCService
import uk.co.andrewreed.web3kotlin.eth.Eth

//https://www.blockmeadow.com/complete-ethereum-rpc-calls-list-with-examples/
//web3

class Web3(provider: String) : RPCService(RPCClient(provider)) {
    val version = "0.0.1" // version of web3kotlin

    val eth = Eth(provider)
    // extend for more?

    // val utils = Utils()
}
