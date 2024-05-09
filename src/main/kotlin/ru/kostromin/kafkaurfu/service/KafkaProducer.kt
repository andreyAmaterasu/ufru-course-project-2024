package ru.kostromin.kafkaurfu.service

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import ru.kostromin.kafkaurfu.config.AppConstants

@Service
class KafkaProducer(val kafkaTemplate: KafkaTemplate<String, String>) {

    fun sendEvent(message: String) {
        kafkaTemplate.send(AppConstants.TOPIC_NAME,message)
    }
}