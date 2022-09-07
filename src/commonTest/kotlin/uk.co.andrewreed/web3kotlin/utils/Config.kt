package uk.co.andrewreed.web3kotlin.utils

data class Config(
    val url: String
)

val goerli = Config(
    "https://eth-goerli.g.alchemy.com/v2/ri0TxzkaKF-VwB95D1Np8EmmQ1qcG8tH"
)

val local = Config(
    "http://127.0.0.1:8545"
)

val ethMainnet = Config(
    "https://mainnet.infura.io/v3/9aa3d95b3bc440fa88ea12eaa4456161"
)

val config = goerli
