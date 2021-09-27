package uk.co.andrewreed.web3kotlin

import uk.co.andrewreed.web3kotlin.eth.Eth

class Web3(provider: String) {
    val version = "0.0.1" // version of web3kotlin

    val eth = Eth(provider)
    // extend for more?

    // val utils = Utils()
}
