package com.example.hibernateBasics.blogWithEntityGraph.repository

import com.example.hibernateBasics.blogWithEntityGraph.entity.PostEG
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PostEGRepository : CrudRepository<PostEG, Long> {

    @EntityGraph(value = "post-user-graph", type = EntityGraph.EntityGraphType.LOAD)
    override fun findById(id: Long): Optional<PostEG>

    @EntityGraph(value = "post-with-comments", type = EntityGraph.EntityGraphType.LOAD)
    fun findPostWithCommentsById(id: Long): PostEG?
}
