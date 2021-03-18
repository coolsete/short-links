package com.shortener.test.common

class NotShortenerDomainException: RuntimeException {
    constructor(msg: String): super(msg)
    constructor(cause: Throwable): super(cause)
    constructor(msg: String, cause: Throwable) : super(msg, cause)
    constructor(errorCode: Long): super() {
        this.errorCode = errorCode
    }
    constructor(msg: String, errorCode: Long): this(msg) {
        this.errorCode = errorCode
    }
    constructor(cause: Throwable, errorCode: Long): this(cause) {
        this.errorCode = errorCode
    }
    constructor(msg: String, cause: Throwable, errorCode: Long) : this(msg, cause) {
        this.errorCode = errorCode
    }

    var errorCode: Long = 0
}
