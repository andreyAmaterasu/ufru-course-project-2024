package ru.kostromin.kafkaurfu.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.kostromin.kafkaurfu.service.KafkaProducer

@RestController
class KafkaController(val kafkaProducer: KafkaProducer) {

    @GetMapping("/send")
    fun sendKafkaEvent(@RequestParam("msg") msg: String): ResponseEntity<String> {

        kafkaProducer.sendEvent(msg)
        return ResponseEntity("Message sent by kafka", HttpStatus.OK)
    }
}