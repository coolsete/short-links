package com.shortener.test.services

interface IdGenerator {
    fun generateId(): Int
    fun clear()
}
