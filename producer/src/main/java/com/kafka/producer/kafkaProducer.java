package com.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class kafkaProducer {

    private final KafkaTemplate<String, RiderLocation> kafkaTemplate;

    public kafkaProducer(KafkaTemplate<String, RiderLocation> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    @PostMapping("/send")
    public String sendMessage(@RequestParam RiderLocation location) {

        RiderLocation riderLocation = new RiderLocation("riderVarun",98.69,69.69);

        kafkaTemplate.send("my-topic", riderLocation);
        return "Message sent :" +riderLocation.getRiderId();
    }
}
