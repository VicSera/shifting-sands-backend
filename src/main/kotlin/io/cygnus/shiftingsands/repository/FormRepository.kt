package io.cygnus.shiftingsands.repository

import io.cygnus.shiftingsands.entity.Form
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FormRepository: CrudRepository<Form, UUID>
{
    fun findByReadId(readId: String): Form?

    fun existsByWriteId(writeId: String): Boolean
}
