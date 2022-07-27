package com.course.rabbitmq.consumer;

import com.course.rabbitmq.entity.DummyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CreateDummyMessageSchema {

  private static final Logger LOGGER = LoggerFactory.getLogger(CreateDummyMessageSchema.class);

  @RabbitListener(
      bindings =
          @QueueBinding(
              value = @Queue(name = "q.code-created-createQueue", durable = "true"),
              exchange =
                  @Exchange(
                      name = "x.code-created-direct-exchange",
                      type = ExchangeTypes.DIRECT,
                      durable = "true"),
              key = "routing-key",
              ignoreDeclarationExceptions = "true"))
  public void readMessage(DummyMessage dummyMessage) {
    LOGGER.info("Dummy Message  : {}", dummyMessage.toString());
  }
}
