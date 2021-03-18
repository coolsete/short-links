package com.shortener.test.services

import com.shortener.test.WRONG_DOMAIN
import com.shortener.test.common.NotShortenerDomainException
import com.shortener.test.datamodel.Link
import com.shortener.test.properties.ShortenerProperties
import com.shortener.test.repositories.LinkRepository
import com.shortener.test.shorter.ShortenerStrategy
import javassist.NotFoundException

class LinkManager(private val shortener: ShortenerStrategy,
                  private val repository: LinkRepository,
                  private val idGenerator: IdGenerator,
                  private val shortenerProperties: ShortenerProperties) {

    fun getShortUrl(url: String): String {
        val id = idGenerator.generateId()
        return shortenerProperties.domainName + repository.save(Link(id, url, shortener.convertToLink(id))).short_url
    }

    fun getOriginalUrl(short_url: String): String {
        if(!short_url.contains(shortenerProperties.domainName)) {
            throw NotShortenerDomainException("Link format incorrect. It is not "
                    + shortenerProperties.domainName + " link", WRONG_DOMAIN)
        }
        val hash = short_url.substringAfter(shortenerProperties.domainName)
        val id = shortener.convertToDigital(hash)
        val link = repository.findById(id)
        if (link.isPresent) {
            return link.get().url
        } else {
            throw NotFoundException("Link isn't found")
        }
    }
}
