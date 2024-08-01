package com.example.hibernateBasics.blogWithEntityGraph.entity

import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class CommentEG(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "post_id")
    var post: PostEG,

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    var user: UserEG
)
