package hello;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	@Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        System.out.println("Ready to send a message.");
        rabbitTemplate.convertAndSend(Application.queueName, "Hello World");
    }
}