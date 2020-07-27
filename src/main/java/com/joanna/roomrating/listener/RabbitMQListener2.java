package com.joanna.roomrating.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joanna.roomrating.event.RatingEvent;
import com.joanna.roomrating.model.Rating;
import com.joanna.roomrating.service.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(queues = "hotel.room-rating")
public class RabbitMQListener2 {

    private final ObjectMapper objectMapper;
    private final RatingService ratingService;

    @Autowired
    public RabbitMQListener2(ObjectMapper objectMapper, RatingService ratingService) {
        this.objectMapper = objectMapper;
        this.ratingService = ratingService;
    }

    @RabbitHandler
    public void consumeRoomRatingEvent2(String message) throws JsonProcessingException {
        log.info("String Room rating message 1123: " + message);
        RatingEvent ratingEvent = objectMapper.readValue(message, RatingEvent.class);
        Rating rating = new Rating();
        rating.setRating(ratingEvent.getRating());
        rating.setRoomId(ratingEvent.getRoomId());
        ratingService.save(rating);
    }
}

