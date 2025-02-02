package com.jobapp.service;

import com.jobapp.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReview(Long id);
    boolean addReview(Review review, Long companyId);
    Review getReview(Long companyId,Long reviewId);
    boolean updateReview(Long companyId, Long reviewId, Review review);
    boolean deleteReview(Long companyId, Long reviewId);
}
