package com.joanna.roomrating.repository;

import com.joanna.roomrating.model.Rating;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findAllByRoomId(@Param("roomId") Long roomId);

}
