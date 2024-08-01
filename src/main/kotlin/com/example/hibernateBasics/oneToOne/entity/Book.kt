package com.example.hibernateBasics.oneToOne.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import java.util.UUID.randomUUID

@Entity
class Book(

    @Id
    var id: String = randomUUID().toString(),

    @OneToOne(
        mappedBy = "book",
        fetch = LAZY,
        orphanRemoval = true,
        optional = false,
        cascade = [CascadeType.ALL]
    )
    var review: Review?,
)
