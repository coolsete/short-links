package com.shortener.test.datamodel

import javax.persistence.*

@Entity
data class Link(@Id @Column(name = "id")val id: Int = -1,
                @Column(name = "url") val url: String = "",
                @Column(name = "short_url") val short_url: String = "")
