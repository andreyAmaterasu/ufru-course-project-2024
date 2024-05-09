package ru.kostromin.kafkaurfu

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaurfuApplication

fun main(args: Array<String>) {
	runApplication<KafkaurfuApplication>(*args)
}