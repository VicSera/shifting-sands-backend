package io.cygnus.shiftingsands.mapper

import io.cygnus.shiftingsands.dto.ResponseDTO
import io.cygnus.shiftingsands.entity.Response
import org.springframework.stereotype.Service

@Service
class ResponseMapper
{
    fun toDto(response: Response): ResponseDTO {
        return ResponseDTO(response.writeId, response.goodText, response.badText)
    }

    fun toEntity(responseDTO: ResponseDTO): Response {
        return Response(responseDTO.writeId, responseDTO.goodText, responseDTO.badText)
    }
}
