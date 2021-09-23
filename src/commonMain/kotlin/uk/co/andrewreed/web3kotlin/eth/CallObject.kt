package uk.co.andrewreed.web3kotlin.eth

import kotlinx.serialization.Serializable

@Serializable
data class CallObject(
    val from: EthereumAddress? = null, // address obj
    val to: EthereumAddress? = null,
    val gas: String? = null,
    val gasLimit: String? = null,
    val value: String? = null,
    val data: String? = null // Either a ABI byte string containing the data of the function call on a contract, or in the case of a contract-creation transaction the initialisation code.
)
