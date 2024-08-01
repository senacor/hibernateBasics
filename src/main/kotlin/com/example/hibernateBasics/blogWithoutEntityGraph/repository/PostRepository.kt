package com.example.hibernateBasics.blogWithoutEntityGraph.repository

import com.example.hibernateBasics.blogWithoutEntityGraph.entity.Post
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : CrudRepository<Post, Long>
