package com.joanna.roomrating.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(queues = "hotel.room-events")
public class RoomEventListener {

    @RabbitHandler
    public void consumeRoomEvent(String message) {
        log.info("Room event message: " + message);
    }

}
