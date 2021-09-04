package uk.co.andrewreed.web3kotlin

import kotlinx.coroutines.runBlocking

actual fun runTest(test: suspend () -> Unit) = runBlocking { test() }
