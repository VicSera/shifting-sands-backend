package io.cygnus.shiftingsands.service

import io.cygnus.shiftingsands.exception.FormNotFound
import io.cygnus.shiftingsands.dto.FormDTO
import io.cygnus.shiftingsands.dto.ResponseDTO
import io.cygnus.shiftingsands.entity.Form
import io.cygnus.shiftingsands.mapper.FormMapper
import io.cygnus.shiftingsands.mapper.ResponseMapper
import io.cygnus.shiftingsands.repository.FormRepository
import io.cygnus.shiftingsands.repository.ResponseRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FormService
(
        @Autowired val formRepository: FormRepository,
        @Autowired val responseRepository: ResponseRepository,
        @Autowired val formMapper: FormMapper,
        @Autowired val responseMapper: ResponseMapper
)
{
    fun createForm(): FormDTO
    {
        return formMapper.toDto(formRepository.save(Form()))
    }

    fun submitResponse(responseDTO: ResponseDTO)
    {
        if (formRepository.existsByWriteId(responseDTO.writeId))
            responseRepository.save(responseMapper.toEntity(responseDTO))
        else
            throw FormNotFound()

    }

    /**
     * Fetch the next response for the form identified by readId
     *
     * It throws a FormNotFound exception if the form is not found
     * It returns a ResponseDTO for containing the response data,
     * or null if the form exists but has no more responses
     */
    fun getNextResponse(readId: String): ResponseDTO?
    {
        val form = formRepository.findByReadId(readId)
                   ?: throw FormNotFound()
        responseRepository.findFirstByWriteIdOrderByTime(form.writeId)
                ?.let {
                    responseRepository.deleteById(it.id)
                    return responseMapper.toDto(it)
                } ?: return null
    }
}
