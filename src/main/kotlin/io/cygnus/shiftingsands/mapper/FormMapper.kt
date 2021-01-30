package io.cygnus.shiftingsands.mapper

import io.cygnus.shiftingsands.dto.FormDTO
import io.cygnus.shiftingsands.entity.Form
import org.springframework.stereotype.Service

@Service
class FormMapper
{
    fun toDto(formEntity: Form): FormDTO {
        return FormDTO(formEntity.readId, formEntity.writeId)
    }

    fun toEntity(formDTO: FormDTO): Form {
        val formEntity = Form()
        formEntity.readId = formDTO.readId
        formEntity.writeId = formDTO.writeId
        return formEntity
    }
}
