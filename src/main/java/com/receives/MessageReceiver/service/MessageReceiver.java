package com.receives.MessageReceiver.service;

import jakarta.jms.Message;
import jakarta.jms.TextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MessageReceiver {
    @JmsListener(destination = "learning")
    public void receiveMessage(Message message){
        try {

            // Simulate processing time with a 5-second delay
            Thread.sleep(5000);
            // Manually acknowledge the message
            message.acknowledge();
            
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                String messageText = textMessage.getText();
                System.out.println("Received message: " + messageText);
            } else {
                System.out.println("Received message of unsupported type: " + message.getClass().getName());
            }
        }
        catch (Exception e) {
            // Handle acknowledgment error
        }


    }
}
