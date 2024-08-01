package com.example.hibernateBasics.oneToOne.entity

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import java.util.UUID.randomUUID

@Entity
class Review(

    @Id
    var id: String = randomUUID().toString(),

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    val book: Book?,
)
