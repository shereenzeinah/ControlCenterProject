package com.assignment.ControlCenter.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public void createIncident(String message, String topic) {

        kafkaTemplate.send(topic, message);
    }

    public void updateIncident(String message, String topic) {

        kafkaTemplate.send(topic, message);
    }
}