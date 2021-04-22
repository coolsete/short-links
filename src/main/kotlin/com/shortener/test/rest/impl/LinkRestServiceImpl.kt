package com.shortener.test.rest.impl

import com.shortener.test.rest.LinkRestService
import com.shortener.test.services.LinkManager
import org.springframework.web.bind.annotation.RestController

@RestController
class LinkRestServiceImpl(private val manager: LinkManager): LinkRestService {

    override fun getOriginalUlr(url: String) = manager.getOriginalUrl(url)

    override fun getShortUrl(url: String) = manager.getShortUrl(url)
}
