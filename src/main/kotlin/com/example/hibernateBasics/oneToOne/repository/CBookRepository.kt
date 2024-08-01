package com.example.hibernateBasics.oneToOne.repository

import com.example.hibernateBasics.oneToOne.correctEntity.CBook
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CBookRepository : CrudRepository<CBook, String>
