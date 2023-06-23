package com.springboot.cloud.kafka.producer.service.controller;

import com.springboot.cloud.kafka.producer.service.model.KafkaMessageDto;
import com.springboot.cloud.kafka.producer.service.service.KafkaMessageProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class KafkaMessageController {

    private final KafkaMessageProducerService kafkaMessageProducerService;

    @RequestMapping(method = RequestMethod.POST, path = "/v1/kafka-producer/message")
    public ResponseEntity<Void> getCustomerMessage(@RequestBody KafkaMessageDto kafkaMessageDto) {
        this.kafkaMessageProducerService.sendMessageToKafka(kafkaMessageDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
