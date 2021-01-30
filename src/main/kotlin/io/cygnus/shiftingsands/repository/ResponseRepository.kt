package io.cygnus.shiftingsands.repository

import io.cygnus.shiftingsands.entity.Response
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.awt.print.Pageable
import java.util.*

@Repository
interface ResponseRepository: CrudRepository<Response, UUID>
{
    fun findFirstByWriteIdOrderByTime(writeId: String): Response?
}
