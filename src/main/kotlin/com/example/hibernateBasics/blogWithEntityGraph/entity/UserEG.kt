package com.example.hibernateBasics.blogWithEntityGraph.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class UserEG(

    @Id @GeneratedValue(strategy =	GenerationType.IDENTITY)
    val id: Long? = null,

    val email: String?
)
