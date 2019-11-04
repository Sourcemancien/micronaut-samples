package com.sourcemancien.kafka.consumers;

import com.sourcemancien.kafka.producers.DeclarativeKafkaProducer;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import org.apache.avro.generic.GenericRecord;

import javax.inject.Inject;

@KafkaListener(groupId = "avro-consumer")
public class AvroListener {

    @Inject
    private DeclarativeKafkaProducer producer;

    @Topic("products")
    void receive(@KafkaKey String key, GenericRecord record){
        producer.send(key, record.toString());
    }
}
