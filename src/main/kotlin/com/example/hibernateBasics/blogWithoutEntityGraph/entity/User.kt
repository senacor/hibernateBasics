package com.example.hibernateBasics.blogWithoutEntityGraph.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class User(

    @Id @GeneratedValue(strategy =	GenerationType.IDENTITY)
    val id: Long? = null,

    val email: String?
)
