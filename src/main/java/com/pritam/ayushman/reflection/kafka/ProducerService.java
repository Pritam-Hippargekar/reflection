package com.pritam.ayushman.reflection.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class ProducerService<T> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${spring.kafka.superhero-topic: normal-topic}")
    private String superHeroTopic;

    @Autowired
    private KafkaTemplate<String, T> kafkaTemplate;

    public void sendSuperHeroMessage(T message) {
        ListenableFuture<SendResult<String, T>> future = this.kafkaTemplate.send(superHeroTopic, message);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, T> result) {
                logger.info("Sent message=[ {} ] with offset=[ {} ]", message, result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                logger.info("Unable to send message=[ {} ] due to : {}", message, ex.getMessage());
            }
        });
    }

//    private <T> void send(String key ,T value){
//        this.kafkaTemplate.send(key, value);
//    }
}
