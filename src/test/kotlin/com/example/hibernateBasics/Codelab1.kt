package com.example.hibernateBasics

import com.example.hibernateBasics.oneToOne.entity.Book
import com.example.hibernateBasics.oneToOne.entity.Review
import com.example.hibernateBasics.oneToOne.repository.BookRepository
import com.example.hibernateBasics.oneToOne.repository.ReviewRepository
import jakarta.persistence.EntityManager
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class Codelab1(
    @Autowired
    private val bookRepository: BookRepository,
    @Autowired
    private val reviewRepository: ReviewRepository,
    @Autowired
    private val entityManager: EntityManager
) {

    @BeforeEach
    fun initConfig() {
        bookRepository.deleteAll()
        reviewRepository.deleteAll()
    }

    @Test
    fun `should demonstrate eager fetching in bidirectional oneToOne relationship`() {
        val book = Book(id = "id", review = null)
        val review = Review(book = book)
        book.review = review

        println("-------Save entity-------")
        bookRepository.save(book)

        entityManager.clear()
        println("-------Select parent entity-------")
        bookRepository.findById(book.id)
    }
}
