package com.sourcemancien.kafka.producers;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient(id = "simple-producer")
public interface DeclarativeKafkaProducer {

    @Topic("${kafka.topics.producer}")
    void send(@KafkaKey String key, String message);

}