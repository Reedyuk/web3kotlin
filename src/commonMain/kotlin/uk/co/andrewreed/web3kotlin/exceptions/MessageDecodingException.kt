package uk.co.andrewreed.web3kotlin.exceptions

class MessageDecodingException constructor(message: String, override val cause: Throwable? = null) : Exception(message, cause)
