package com.joanna.roomrating.repository;

import com.joanna.roomrating.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
