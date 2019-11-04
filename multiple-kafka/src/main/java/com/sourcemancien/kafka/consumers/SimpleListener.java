package com.sourcemancien.kafka.consumers;

import com.sourcemancien.kafka.producers.DeclarativeKafkaProducer;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;

import javax.inject.Inject;

@KafkaListener(groupId = "simple-consumer")
public class SimpleListener {

    @Inject
    private DeclarativeKafkaProducer producer;

    @Topic(patterns = "products-*")
    void receiveAll(@KafkaKey String key, String message){
        producer.send(key, message);
    }

    @Topic({"products-fr", "products-en"})
    void receiveSpecific(@KafkaKey String key, String message){
        producer.send(key, message.toUpperCase());
    }
}
