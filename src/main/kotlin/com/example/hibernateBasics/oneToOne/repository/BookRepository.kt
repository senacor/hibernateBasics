package com.example.hibernateBasics.oneToOne.repository

import com.example.hibernateBasics.oneToOne.entity.Book
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : CrudRepository<Book, String>
