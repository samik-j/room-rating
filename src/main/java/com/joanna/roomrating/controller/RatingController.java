package com.joanna.roomrating.controller;

import com.joanna.roomrating.dto.RatingDto;
import com.joanna.roomrating.service.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
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
