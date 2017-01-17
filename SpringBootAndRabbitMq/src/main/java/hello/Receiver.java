package hello;

import org.springframework.stereotype.Component;

/**
 * Technically speaking, the sender and the receiver are completely decoupled.
 * Instead of communicating with each other via the current project, they taken care of by rabbit-mq.
 * Which makes it feasible to pull the entire receiver out of this project and put it into another one, and you will still receive the message from the sender. 
 */
@Component
public class Receiver {
    public void receiveMessage(String message) {
        System.out.println("Received '" + message + "'.");
    }
}