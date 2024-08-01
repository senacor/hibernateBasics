package com.example.hibernateBasics.blogWithEntityGraph.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.NamedAttributeNode
import jakarta.persistence.NamedEntityGraph
import jakarta.persistence.NamedSubgraph
import jakarta.persistence.OneToMany

@NamedEntityGraph(
    name = "post-user-graph",
    attributeNodes = [ NamedAttributeNode(value = "user") ]
)
@NamedEntityGraph(
    name = "post-with-comments",
    attributeNodes = [
        NamedAttributeNode(value = "comments", subgraph = "comments-subgraph")
    ],
    subgraphs = [
        NamedSubgraph(
            name = "comments-subgraph",
            attributeNodes = [ NamedAttributeNode(value = "user") ]
        )
    ]
)
@Entity
class PostEG(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @OneToMany(mappedBy = "post", cascade = [CascadeType.ALL])
    val comments: MutableList<CommentEG> = mutableListOf(),

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    var user: UserEG
)
