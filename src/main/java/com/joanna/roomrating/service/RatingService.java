package com.joanna.roomrating.service;

import com.joanna.roomrating.dto.RatingDto;
import com.joanna.roomrating.model.Rating;
import com.joanna.roomrating.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<RatingDto> getAllRatings() {
        return ratingRepository.findAll()
                               .stream()
                               .map(rating -> new RatingDto(rating.getRoomId(), rating.getRating()))
                               .collect(Collectors.toList());
    }

    public List<RatingDto> getRatingsByRoomId(Long roomId) {
        return ratingRepository.findAllByRoomId(roomId)
                               .stream()
                               .map(rating -> new RatingDto(rating.getRoomId(), rating.getRating()))
                               .collect(Collectors.toList());
    }

    public void save(Rating rating) {
        ratingRepository.save(rating);
    }
}
