package com.shortener.test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(AppContext::class)
@ConfigurationPropertiesScan(basePackages = ["com.shortener.test.properties"])
class ShorterApplication
fun main(args: Array<String>) {
	runApplication<ShorterApplication>(*args)
}
