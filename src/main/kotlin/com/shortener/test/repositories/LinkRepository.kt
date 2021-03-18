package com.shortener.test.repositories

import com.shortener.test.datamodel.Link
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LinkRepository: CrudRepository<Link, Int> {
}
