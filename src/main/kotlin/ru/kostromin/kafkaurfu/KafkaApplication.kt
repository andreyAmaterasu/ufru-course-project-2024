package ru.kostromin.kafkaurfu

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.core.KafkaTemplate
import ru.kostromin.kafkaurfu.config.AppConstants
import ru.kostromin.kafkaurfu.service.KafkaProducer

@SpringBootApplication
class KafkaApplication(val kafkaProducer: KafkaProducer): CommandLineRunner {

	override fun run(vararg args: String?) {

		while (true) {
			println("Please type your message:")
			val commands = readlnOrNull()?.split(" ", limit = 2)
			if (commands != null && commands.size == 2) {
				when (commands[0]) {
					"send" -> kafkaProducer.sendEvent(commands[1])
					else -> println("Incorrect command!")
				}
				Thread.sleep(1000)
			}
		}
	}
}

fun main(args: Array<String>) {
	runApplication<KafkaApplication>(*args)
}