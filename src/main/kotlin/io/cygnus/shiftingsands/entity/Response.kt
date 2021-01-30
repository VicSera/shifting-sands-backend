package io.cygnus.shiftingsands.entity

import io.cygnus.shiftingsands.config.StaticConfig
import org.hibernate.annotations.GenericGenerator
import java.sql.Timestamp
import java.time.Instant
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "response", schema = "shifting_sands_schema")
data class Response
(
        @Column
        val writeId: String,

        @Column
        val goodText: String,

        @Column
        val badText: String
)
{
    @Id
    @Column
    (
            name = "id",
            length = StaticConfig.UUIDLength
    )
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(
            name = "uuid",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    val id: UUID = UUID.randomUUID()

    @Column
    val time: Timestamp = Timestamp.from(Instant.now())
}
