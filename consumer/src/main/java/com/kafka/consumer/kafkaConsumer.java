package com.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class kafkaConsumer {

    @KafkaListener(topics = "my-topics", groupId = "my-group")
    public void listen1(String message) {
        System.out.println("The message is recevied 1: "+message);
    }

    @KafkaListener(topics = "my-topics", groupId = "my-group")
    public void listen2(String message) {
        System.out.println("The message is recevied 2: "+message);
    }

    @KafkaListener(topics = "my-topic", groupId = "my-group-rider")
    public void RiderLocation(RiderLocation location) {
        System.out.println("The location is recevied 2: "+location.getRiderId()+":" +location.getLatitude()+":"+location.getLongitute());
    }

}
