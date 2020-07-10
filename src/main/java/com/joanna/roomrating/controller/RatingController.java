package com.joanna.roomrating.controller;

import com.joanna.roomrating.dto.RatingDto;
import com.joanna.roomrating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping
    public List<RatingDto> getAllRatings() {
        return ratingService.getAllRatings();
    }

    @GetMapping(params = {"roomId"})
    public List<RatingDto> gerRatingsByRoomId(@RequestParam Long roomId) {
        return ratingService.getRatingsByRoomId(roomId);
    }
}
