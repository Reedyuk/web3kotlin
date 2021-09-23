package uk.co.andrewreed.web3kotlin.eth

typealias EthereumAddress = String

val EthereumAddress.zero: EthereumAddress
    get() = "0x0000000000000000000000000000000000000000"
