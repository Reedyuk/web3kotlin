package uk.co.andrewreed.web3kotlin.utils

import kotlinx.coroutines.runBlocking

actual fun runTest(test: suspend () -> Unit) = runBlocking { test() }
