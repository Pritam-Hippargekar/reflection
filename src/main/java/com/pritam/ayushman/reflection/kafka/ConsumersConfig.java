package com.pritam.ayushman.reflection.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import java.util.HashMap;
import java.util.Map;
//https://github.com/rahul-ghadge/spring-boot-kafka/blob/master/src/main/java/com/arya/kafka/service/ConsumerService.java
@Configuration
public class ConsumersConfig {

    @Value("${spring.kafka.consumer.bootstrap-servers: localhost:9092}")
    private String bootstrapServers;

    @Value("${spring.kafka.consumer.group-id: normal-topic-group}")
    private String groupId;

    @Bean
    public Map<String, Object> consumersConfigs() {
        Map<String, Object> configProps = new HashMap<>();

        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        configProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        configProps.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return configProps;
    }

    @Bean
    public ConsumerFactory<String, SuperHero> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumersConfigs(), new StringDeserializer(), new JsonDeserializer<>(SuperHero.class));
    }

    @Bean
    public <T> ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerJsonFactory() {
        ConcurrentKafkaListenerContainerFactory<String, SuperHero> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setMessageConverter(new StringJsonMessageConverter());
        factory.setBatchListener(true);
        return factory;
    }

//    @Bean
//    public ConsumerFactory<String, List<FooObject>> consumerFactory(){
//        Map<String,Object> config = new HashMap<>();
//        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
//        config.put(ConsumerConfig.GROUP_ID_CONFIG,"foo");
//        ObjectMapper om = new ObjectMapper();
//        JavaType type = om.getTypeFactory().constructParametricType(List.class, FooObject.class);
//        return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(), new JsonDeserializer<List<FooObject>>(type, om, false));
//    }
}
