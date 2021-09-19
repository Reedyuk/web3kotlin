package uk.co.andrewreed.web3kotlin.utils

class KeyUtils {

    companion object {
        fun generateAddress(publicKey: String): String = publicKey.substring(0, 42)
        // 42 with 0x otherwise 40

        fun generatePublicKey(privateKey: String): String {
            val privateKeyPtr = privateKey.encodeToByteArray()

            //https://www.massmux.com/private-and-public-keys-on-ethereum/
            TODO("todo")
            // https://github.com/argentlabs/web3.swift/blob/master/web3swift/src/Utils/KeyUtil.swift

//            multiply the private key by the elliptic curve generator point to get the public key; The public key is a point on the elliptic curve and has x and y coordinates;
//concatenate the x and y coordinates of the public key;
//PUBLIC ADDRESSES
//Hash the result from previous point with keccak-256 hashing function;
//
//Take the last 20 bytes, add “0x” to the front, and you got an Ethereum address; The 0x It’s a prefix used to indicate the number is in hexadecimal rather in other numeral system;
        }

        // static func generatePublicKey(from privateKey: Data) throws -> Data {
        //        guard let ctx = secp256k1_context_create(UInt32(SECP256K1_CONTEXT_SIGN | SECP256K1_CONTEXT_VERIFY)) else {
        //            print("Failed to generate a public key: invalid context.")
        //            throw KeyUtilError.invalidContext
        //        }
        //
        //        defer {
        //            secp256k1_context_destroy(ctx)
        //        }
        //
        //
        //        let privateKeyPtr = (privateKey as NSData).bytes.assumingMemoryBound(to: UInt8.self)
        //        guard secp256k1_ec_seckey_verify(ctx, privateKeyPtr) == 1 else {
        //            print("Failed to generate a public key: private key is not valid.")
        //            throw KeyUtilError.privateKeyInvalid
        //        }
        //
        //        let publicKeyPtr = UnsafeMutablePointer<secp256k1_pubkey>.allocate(capacity: 1)
        //        defer {
        //            publicKeyPtr.deallocate()
        //        }
        //        guard secp256k1_ec_pubkey_create(ctx, publicKeyPtr, privateKeyPtr) == 1 else {
        //            print("Failed to generate a public key: public key could not be created.")
        //            throw KeyUtilError.unknownError
        //        }
        //
        //        var publicKeyLength = 65
        //        let outputPtr = UnsafeMutablePointer<UInt8>.allocate(capacity: publicKeyLength)
        //        defer {
        //            outputPtr.deallocate()
        //        }
        //        secp256k1_ec_pubkey_serialize(ctx, outputPtr, &publicKeyLength, publicKeyPtr, UInt32(SECP256K1_EC_UNCOMPRESSED))
        //
        //        let publicKey = Data(bytes: outputPtr, count: publicKeyLength).subdata(in: 1..<publicKeyLength)
        //
        //        return publicKey
        //    }
    }
}