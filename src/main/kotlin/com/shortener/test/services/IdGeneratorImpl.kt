package com.shortener.test.services

import com.shortener.test.START_ID

class IdGeneratorImpl: IdGenerator {
    //5 symbols in short link (item 2 in task)
    private var currentId = START_ID
    override fun generateId(): Int {
        return ++currentId
    }

    override fun clear() {
        currentId = START_ID
    }
}
