package uk.co.andrewreed.web3kotlin

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
