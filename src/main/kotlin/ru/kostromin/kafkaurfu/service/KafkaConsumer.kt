package ru.kostromin.kafkaurfu.service

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import ru.kostromin.kafkaurfu.config.AppConstants

@Service
class KafkaConsumer {

    @KafkaListener(topics = [AppConstants.TOPIC_NAME], groupId = AppConstants.GROUP_ID)
    fun firstListener(message: String) {
        println("Message received: $message")
    }
}