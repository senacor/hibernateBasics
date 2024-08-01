package com.example.hibernateBasics

import com.example.hibernateBasics.blogWithEntityGraph.repository.PostEGRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class Codelab2Solution(
    @Autowired
    private val postEGRepository: PostEGRepository,
) {

    @Test
    fun `should demonstrate generated sql statements for blog without entity graph`() {
        println("-------Get post by ID with users-------")
        val foundPost = postEGRepository.findById(1)
        println("-------Get post by ID with comments and users-------")
        val foundPostWithComments = postEGRepository.findPostWithCommentsById(1)
    }
}
