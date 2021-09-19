package uk.co.andrewreed.web3kotlin

import uk.co.andrewreed.web3kotlin.utils.KeyUtils

typealias Mnemonic = String

// wallet contains multiple accounts.

class Wallet() {

    companion object {
        fun create(numberOfAccounts: Int = 0, entropy: String? = null): Wallet {
            TODO("To implement")
        }
    }

    fun add(account: Account): Account {
        TODO("Add account")
    }

    fun remove(account: Account): Boolean {
        return false
    }

    fun clear() {
        TODO("Need to clear.")
    }
}

// class Account(key: SigningKey) {
//
//    companion object {
//        fun createRandom(): Wallet {
//            // Returns a new Wallet with a random private key, generated from cryptographically secure entropy sources. If the current environment does not have a secure entropy source, an error is thrown.
//            // Wallets created using this method will have a mnemonic.
//            TODO("Address should be of a special type")
//        }
//
//        fun Mnemonic.fromMnemonic(): Wallet {
//            // Create an instance from a mnemonic phrase.
//            // If path is not specified, the Ethereum default path is used (i.e. m/44'/60'/0'/0/0).
//            // If wordlist is not specified, the English Wordlist is used.
//            TODO("Need to generate wallet from the mnemonics")
//        }
//    }
//
//    val address: String = ""
//    val privateKey = key.privateKey
//    val publicKey = key.publicKey
//
//    fun computeAddress(publicKey: ByteArray): String {
//        return ""
//    }
// }

class Account(private val privateKey: String) {

    val publicKey = KeyUtils.generatePublicKey(privateKey)
    val address: String = KeyUtils.generateAddress(publicKey)

    companion object {
        fun create(): Account {
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

class SigningKey(key: String) {

    // val privateKey = Hex.decode(key.lowercase())
    val privateKey = ""
    val publicKey = ""
//    val publicKey = Secp256k1.pubkeyCreate(privateKey)
}

// readonly curve: string;
//    readonly privateKey: string;
//    readonly publicKey: string;
//    readonly compressedPublicKey: string;
//    readonly _isSigningKey: boolean;
//    constructor(privateKey: BytesLike);
//    _addPoint(other: BytesLike): string;
//    signDigest(digest: BytesLike): Signature;
//    computeSharedSecret(otherKey: BytesLike): string;
//    static isSigningKey(value: any): value is SigningKey;

/*
// Create a wallet instance from a mnemonic...
mnemonic =
  "announce room limb pattern dry unit scale effort smooth jazz weasel alcohol"
walletMnemonic = Wallet.fromMnemonic(mnemonic)

// ...or from a private key
walletPrivateKey = new Wallet(walletMnemonic.privateKey)

walletMnemonic.address === walletPrivateKey.address
// true

// The address as a Promise per the Signer API
walletMnemonic.getAddress()
// { Promise: '0x71CB05EE1b1F506fF321Da3dac38f25c0c9ce6E1' }

// A Wallet address is also available synchronously
walletMnemonic.address
// '0x71CB05EE1b1F506fF321Da3dac38f25c0c9ce6E1'

// The internal cryptographic components
walletMnemonic.privateKey
// '0x1da6847600b0ee25e9ad9a52abbd786dd2502fa4005dd5af9310b7cc7a3b25db'
walletMnemonic.publicKey
// '0x04b9e72dfd423bcf95b3801ac93f4392be5ff22143f9980eb78b3a860c4843bfd04829ae61cdba4b3b1978ac5fc64f5cc2f4350e35a108a9c9a92a81200a60cd64'

// The wallet mnemonic
walletMnemonic.mnemonic
// {
//   locale: 'en',
//   path: 'm/44\'/60\'/0\'/0/0',
//   phrase: 'announce room limb pattern dry unit scale effort smooth jazz weasel alcohol'
// }

// Note: A wallet created with a private key does not
//       have a mnemonic (the derivation prevents it)
walletPrivateKey.mnemonic
// null

// Signing a message
walletMnemonic.signMessage("Hello World")
// { Promise: '0x14280e5885a19f60e536de50097e96e3738c7acae4e9e62d67272d794b8127d31c03d9cd59781d4ee31fb4e1b893bd9b020ec67dfa65cfb51e2bdadbb1de26d91c' }

tx = {
  to: "0x8ba1f109551bD432803012645Ac136ddd64DBA72",
  value: utils.parseEther("1.0"),
}

// Signing a transaction
walletMnemonic.signTransaction(tx)
// { Promise: '0xf865808080948ba1f109551bd432803012645ac136ddd64dba72880de0b6b3a7640000801ca0918e294306d177ab7bd664f5e141436563854ebe0a3e523b9690b4922bbb52b8a01181612cec9c431c4257a79b8c9f0c980a2c49bb5a0e6ac52949163eeb565dfc' }

// The connect method returns a new instance of the
// Wallet connected to a provider
wallet = walletMnemonic.connect(provider)

// Querying the network
wallet.getBalance()
// { Promise: { BigNumber: "42" } }
wallet.getTransactionCount()
// { Promise: 0 }

// Sending ether
wallet.sendTransaction(tx)

 */
