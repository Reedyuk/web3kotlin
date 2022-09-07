package uk.co.andrewreed.web3kotlin

import uk.co.andrewreed.web3kotlin.net.Net
import uk.co.andrewreed.web3kotlin.utils.config
import uk.co.andrewreed.web3kotlin.utils.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class NetTests {
    private val client = Net(config.url)

    @Test
    fun testVersion() = runTest {
        val version = client.version()
        assertEquals("5", version)
    }

    @Test
    fun testListening() = runTest {
        val isListening = client.listening()
        assertTrue(isListening)
    }

//    @Test
//    fun testPeerCount() = runTest {
//        val version = client.peerCount()
//        assertEquals("5", version)
//    }
}