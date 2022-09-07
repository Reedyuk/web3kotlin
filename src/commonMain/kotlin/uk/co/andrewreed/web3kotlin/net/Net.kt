package uk.co.andrewreed.web3kotlin.net

import uk.co.andrewreed.jsonrpc.Client.RPCClient
import uk.co.andrewreed.jsonrpc.Service.RPCService

//https://www.blockmeadow.com/complete-ethereum-rpc-calls-list-with-examples/
// net
class Net(provider: String) : RPCService(RPCClient(provider)) {
}