package com.example.hibernateBasics

import com.example.hibernateBasics.blogWithoutEntityGraph.repository.PostRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class Codelab2(
    @Autowired
    private val postRepository: PostRepository,
) {

    @Test
    fun `should demonstrate generated sql statements for blog with entity graph`() {
        println("-------Get post by ID-------")
        println("-------Two SELECT statements generated although post->user relationship was defined as LAZY-------")
        val foundPost = postRepository.findById(1)
        val comments = foundPost.get().comments
        val firstComment = comments.first()
    }
}
