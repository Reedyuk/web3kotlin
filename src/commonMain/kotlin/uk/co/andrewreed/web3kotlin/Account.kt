package uk.co.andrewreed.web3kotlin

import uk.co.andrewreed.web3kotlin.utils.KeyUtils

class Account(private val privateKey: String) {

    val publicKey = KeyUtils.generatePublicKey(privateKey)
    val address: String = KeyUtils.generateAddress(publicKey)

    companion object {
        fun create(): Account {
            // generate account?
            TODO("create account")
        }

        fun privateKeyToAccount(privateKey: String, ignoreLength: Boolean = true): Account {
            TODO("Creates an account object from a private key.")
        }
    }

    fun signTransaction() {
    }

    fun sign() {
    }
}
