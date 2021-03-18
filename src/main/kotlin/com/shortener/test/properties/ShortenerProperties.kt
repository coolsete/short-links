package com.shortener.test.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "shorter")
data class ShortenerProperties(val domainName: String = "http://tst.com/")
