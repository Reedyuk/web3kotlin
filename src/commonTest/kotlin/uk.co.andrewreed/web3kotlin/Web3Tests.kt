package uk.co.andrewreed.web3kotlin

import uk.co.andrewreed.web3kotlin.utils.config
import uk.co.andrewreed.web3kotlin.utils.runTest
import uk.co.andrewreed.web3kotlin.web3.Web3
import kotlin.test.Test
import kotlin.test.assertEquals

class Web3Tests {
    private val client = Web3(config.url)

    @Test
    fun testSha3Price() = runTest {
        val sha3Response = client.sha3("0x68656c6c6f20776f726c64")
        assertEquals("0x5b2c76da96136d193336fad3fbc049867b8ca157da22f69ae0e4923648250acc", sha3Response)
    }

    @Test
    fun testSha3FunctionCall() = runTest {
        val sha3Response = client.sha3("apply()")
        assertEquals("0xdb595b3b148fad58781ca9b18e71eeea7804b39e9b88afe8263ff62f5b5e9d3d", sha3Response)
    }

    @Test
    fun testClientVersion() = runTest {
        val response = client.clientVersion()
        assertEquals("Geth/v1.10.23-stable-d901d853/linux-amd64/go1.18.5", response)
    }
}