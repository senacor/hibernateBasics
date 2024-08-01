package com.example.hibernateBasics.oneToOne.repository

import com.example.hibernateBasics.oneToOne.entity.Review
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository : CrudRepository<Review, String>
