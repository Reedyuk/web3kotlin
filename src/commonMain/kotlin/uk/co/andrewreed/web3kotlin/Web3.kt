package uk.co.andrewreed.web3kotlin

import uk.co.andrewreed.web3kotlin.eth.Eth
import uk.co.andrewreed.web3kotlin.net.Net
import uk.co.andrewreed.web3kotlin.web.Web

class Web3(provider: String) {
    val eth: Eth = Eth(provider)
    val net: Net = Net(provider)
    val web: Web = Web(provider)

    val utils: Utils = Utils()


}