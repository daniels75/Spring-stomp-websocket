package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {


    @MessageMapping("/hello") // receive message from JS Script
    @SendTo("/topic/greetings") // send to Topics
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(500); // simulated delay
        System.out.println(">>>> Greeting: " + message.getName());
        return new Greeting("Hello, " + message.getName() + "!");
    }

    
    @MessageMapping("/myhello")
    @SendTo("/mytopic/foo")
    public Greeting myGreetings(HelloMessage message) throws Exception {
        Thread.sleep(500); // simulated delay
        System.out.println(">>>> My Greeting: " + message.getName());
        return new Greeting("My Hello, " + message.getName() + "!");
    }
}
