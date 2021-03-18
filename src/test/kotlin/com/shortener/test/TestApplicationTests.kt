package com.shortener.test

import com.shortener.test.common.NotShortenerDomainException
import com.shortener.test.services.LinkManager
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [TestApplication::class])
class TestApplicationTests {

	val link = "https://blog.mysite.com/another-article"
	val wrongShortLink = "https://short.en/Pq34r"

	@Autowired
	lateinit var linkManager: LinkManager

	@Test
	fun `Link manager should return short link`() {
		Assertions.assertTrue(linkManager.getShortUrl(link).isNotEmpty())
	}

	@Test
	fun `Link manager should return original link`() {
		val short_link = linkManager.getShortUrl(link)
		Assertions.assertEquals(link, linkManager.getOriginalUrl(short_link))
	}

	@Test
	fun `Link manager should throw NotShortenerDomain in case incorrect domain`() {
		val thrown = Assertions.assertThrows(NotShortenerDomainException::class.java) {
			linkManager.getOriginalUrl(wrongShortLink)
		}
		Assertions.assertEquals(WRONG_DOMAIN, thrown.errorCode)
	}

}
