package hello;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class MyWebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	// this doesnt work only one Simle Broker is alowed
//	@Override
//	public void configureMessageBroker(MessageBrokerRegistry config) {
//		config.enableSimpleBroker("/mytopic");
//		config.setApplicationDestinationPrefixes("/app");
//	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/myhello", "/foo").withSockJS();
	}

}