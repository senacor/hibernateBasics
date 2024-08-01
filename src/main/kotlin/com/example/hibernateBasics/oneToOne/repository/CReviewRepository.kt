package com.example.hibernateBasics.oneToOne.repository

import com.example.hibernateBasics.oneToOne.correctEntity.CReview
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CReviewRepository : CrudRepository<CReview, String>
