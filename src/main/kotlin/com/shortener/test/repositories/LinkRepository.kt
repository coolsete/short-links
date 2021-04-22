package com.shortener.test.repositories

import com.shortener.test.datamodel.Link
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LinkRepository: CrudRepository<Link, Int> {

    @Query(value = "select * from Links l where l.url = ?1", nativeQuery = true)
    fun findAllByUrl(url: String): Collection<Link>
}
