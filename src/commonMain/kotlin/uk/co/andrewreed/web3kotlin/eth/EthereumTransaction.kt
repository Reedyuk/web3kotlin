package uk.co.andrewreed.web3kotlin.eth

import kotlinx.serialization.Serializable

@Serializable
data class EthereumTransaction(
    val to: EthereumAddress? = null,
    val value: String? = null,
    val data: String? = null,
    val nonce: Int? = null,
    val gas: String? = null,
    val gasPrice: String? = null,
    val gasLimit: String? = null,
    val blockNumber: String? = null,
    val hash: String? = null
)
/*
public let from: EthereumAddress?
    public let to: EthereumAddress
    public let value: BigUInt?
    public let data: Data?
    public var nonce: Int?
    public let gasPrice: BigUInt?
    public let gasLimit: BigUInt?
    public let gas: BigUInt?
    public let blockNumber: EthereumBlock?
    public private(set) var hash: Data?
 */
