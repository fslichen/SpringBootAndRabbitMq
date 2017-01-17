package hello;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Sender implements CommandLineRunner {
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	@Autowired
    private Receiver receiver;
	
	@Autowired
    private ConfigurableApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Ready to send a message.");
        rabbitTemplate.convertAndSend(Application.queueName, "Hello World");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        context.close();
    }
}