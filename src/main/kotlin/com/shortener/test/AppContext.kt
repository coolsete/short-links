package com.shortener.test

import com.shortener.test.properties.ShortenerProperties
import com.shortener.test.repositories.LinkRepository
import com.shortener.test.services.IdGeneratorImpl
import com.shortener.test.services.LinkManager
import com.shortener.test.shorter.FiveAlphaShortenerStrategy
import com.shortener.test.shorter.ShortenerStrategy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["com.shortener.test"])
class AppContext() {

    @Autowired
    lateinit var repository: LinkRepository

    @Autowired
    lateinit var shortenerProperties: ShortenerProperties

    @Bean
    fun getShortener(): ShortenerStrategy {
        return FiveAlphaShortenerStrategy()
    }

    @Bean
    fun getIdGenerator() = IdGeneratorImpl()

    @Bean
    fun getLinkManager(): LinkManager {
        return LinkManager(getShortener(), repository, getIdGenerator(), shortenerProperties)
    }
}
