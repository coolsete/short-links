package com.shortener.test

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(AppContext::class)
@ConfigurationPropertiesScan(basePackages = ["com.shortener.test.properties"])
class TestApplication: CommandLineRunner {
	val logger: Logger = LoggerFactory.getLogger(TestApplication::class.java)

	override fun run(vararg args: String?) {
		for (i in args.indices) {
			logger.info("args[{}]: {}", i, args[i])
		}
	}
}

fun main(args: Array<String>) {
	runApplication<TestApplication>(*args)
}
