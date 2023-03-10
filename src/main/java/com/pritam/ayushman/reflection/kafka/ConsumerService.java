package com.pritam.ayushman.reflection.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

@Service
public class ConsumerService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @KafkaListener(id = AppConstants.CONSUMER_ID,topics = AppConstants.TOPIC, containerFactory = "kafkaListenerJsonFactory", groupId = AppConstants.GROUP_ID)
    public void consumeSuperHero(ConsumerRecord<?, ?> consumerRecord, Acknowledgment ack) {
        logger.info("**** -> Consumed Super Hero :: {}", consumerRecord.value());
        logger.info("Getting consumer record key: '" + consumerRecord.key() + "', value: '" + consumerRecord.value() + "', partition: " + consumerRecord.partition() + " and offset: " + consumerRecord.offset() + " at " + new Date(consumerRecord.timestamp()));
        ack.acknowledge();
    }
}
