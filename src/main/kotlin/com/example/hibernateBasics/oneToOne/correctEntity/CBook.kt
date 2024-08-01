package com.example.hibernateBasics.oneToOne.correctEntity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne

@Entity
class CBook(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @OneToOne(mappedBy = "book", cascade = [CascadeType.ALL], orphanRemoval = true)
    val review: CReview? = null
)
