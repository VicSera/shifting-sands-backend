package io.cygnus.shiftingsands.entity

import io.cygnus.shiftingsands.config.StaticConfig
import io.cygnus.shiftingsands.util.Generators
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "form", schema = "shifting_sands_schema")
class Form
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
        var id: UUID = UUID.randomUUID()

        @Column
        var readId: String = Generators.randomAlphaNumericId(StaticConfig.IdLength)

        @Column
        var writeId: String = Generators.randomAlphaNumericId(StaticConfig.IdLength)
}
