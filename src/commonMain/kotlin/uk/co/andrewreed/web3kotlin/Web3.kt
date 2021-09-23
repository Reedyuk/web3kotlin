package uk.co.andrewreed.web3kotlin

import uk.co.andrewreed.web3kotlin.eth.Eth

class Web3(provider: String) {
    val eth = Eth(provider)
}
