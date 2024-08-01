package com.example.hibernateBasics

import com.example.hibernateBasics.oneToOne.correctEntity.CBook
import com.example.hibernateBasics.oneToOne.correctEntity.CReview
import com.example.hibernateBasics.oneToOne.repository.CBookRepository
import com.example.hibernateBasics.oneToOne.repository.CReviewRepository
import jakarta.persistence.EntityManager
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@SpringBootTest
class Codelab1Solution(
    @Autowired
    private val bookRepository: CBookRepository,
    @Autowired
    private val reviewRepository: CReviewRepository,
    @Autowired
    private val entityManager: EntityManager
) {

    @BeforeEach
    fun initConfig() {
        bookRepository.deleteAll()
        reviewRepository.deleteAll()
    }

    @Test
    @Transactional
    fun `should demonstrate eager fetching in bidirectional oneToOne relationship`() {
        val book = CBook()
        println("-------Save entity-------")
        bookRepository.save(book)
        val review = CReview(book = book)
        reviewRepository.save(review)
        entityManager.clear()

        println("-------Select parent entity-------")
        val result = bookRepository.findById(book.id.toString())
        println(result)
    }
}
