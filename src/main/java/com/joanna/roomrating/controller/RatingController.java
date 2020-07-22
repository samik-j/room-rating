package com.joanna.roomrating.controller;

import com.joanna.roomrating.dto.RatingDto;
import com.joanna.roomrating.service.RatingService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Value("${test.property}")
    private String test;

    @Value("${CF_INSTANCE_INDEX}")
    private String instanceName;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @ApiOperation(value = "", authorizations = {@Authorization(value = "bearerToken")})
    @PreAuthorize("#oauth2.hasScope('room_rating')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RatingDto> getAllRatings() {
        log.info(test);
        log.info("This is instance " + instanceName);
        return ratingService.getAllRatings();
    }

    @ApiOperation(value = "", authorizations = {@Authorization(value = "bearerToken")})
    @GetMapping(value = "findByRoomId", params = {"roomId"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RatingDto> gerRatingsByRoomId(@RequestParam Long roomId) {
        return ratingService.getRatingsByRoomId(roomId);
    }
}
