package com.example.hibernateBasics.blogWithoutEntityGraph.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany

@Entity
class Post(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @OneToMany(mappedBy = "post", cascade = [CascadeType.ALL], fetch = LAZY)
    val comments: MutableList<Comment> = mutableListOf(),

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    var user: User
)
