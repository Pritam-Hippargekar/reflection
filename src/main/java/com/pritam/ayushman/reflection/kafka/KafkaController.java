package com.pritam.ayushman.reflection.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    @Autowired
    private ProducerService<SuperHero> producerService;

    @PostMapping(value = "/publish")
    public Map<String, Object> sendObjectToKafkaTopic(@RequestBody SuperHero superHero) {
        producerService.sendSuperHeroMessage(superHero);
        Map<String, Object> map = new HashMap<>();
        map.put("message", "Successfully publisher Super Hero..!");
        map.put("payload", superHero);
        return map;
    }
}
