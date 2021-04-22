package com.shortener.test.rest

import com.shortener.test.URL
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api"])
interface LinkRestService {

    @RequestMapping(method = [RequestMethod.GET], value = ["/original"])
    fun getOriginalUlr(@RequestParam(name = URL)url: String) : String

    @RequestMapping(method = [RequestMethod.GET], value = ["/short"])
    fun getShortUrl(@RequestParam(name = URL)url: String): String
}
