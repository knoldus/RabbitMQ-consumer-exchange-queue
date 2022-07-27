package com.course.rabbitmq.consumer;

import com.course.rabbitmq.entity.DummyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//@Service
public class DummyMessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(DummyMessageConsumer.class);

    @RabbitListener(queues = "q.dummy")
    public void readMessage(DummyMessage dummyMessage) {
        LOGGER.info("Dummy Message  : {}", dummyMessage.toString());
    }
}
