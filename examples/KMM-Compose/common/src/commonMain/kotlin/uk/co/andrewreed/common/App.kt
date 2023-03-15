package uk.co.andrewreed.common

import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uk.co.andrewreed.web3kotlin.Web3

@Composable
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    val platformName = getPlatformName()

    Button(onClick = {
        text = "Hello, ${platformName}"
        println("Hi")

        Web3("https://eth-goerli.g.alchemy.com/v2/ri0TxzkaKF-VwB95D1Np8EmmQ1qcG8tH").let {
            println("Hi3")
            CoroutineScope(Dispatchers.IO).launch {
                println("Hi 2")
                println(it.web.clientVersion())
            }
        }
//        Web?
    }) {
        Text(text)
    }
}
