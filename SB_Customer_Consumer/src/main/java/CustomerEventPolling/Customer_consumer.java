package CustomerEventPolling;


import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootApplication
@RestController
public class Customer_consumer {
	private static KafkaConsumer<String, String> consumer;
	@RequestMapping("/")
	@SuppressWarnings("deprecation")
	public static void main1(String[] args) throws JsonMappingException, JsonProcessingException, URISyntaxException {
	    	Properties props = new Properties();
	        props.put("bootstrap.servers", "34.105.107.154:9092");
	        props.put("group.id", "test-consumer-group");
	        props.put("enable.auto.commit", "false");
	        props.put("auto.offset.reset","earliest");
	        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	        consumer = new KafkaConsumer<>(props);
	        consumer.subscribe(Arrays.asList("CustomerEvents"));
	        RestTemplate restTemplate = new RestTemplate();
		    final String baseUrl = "http://notification:7000/microbank/v1/notify/customer";
		    URI uri = new URI(baseUrl);

	        	
	        while (true) {
				ConsumerRecords<String, String> records = consumer.poll(100);
	            for (ConsumerRecord<String, String> record : records)

	            	restTemplate.postForEntity(uri, record.value() , String.class);
	            	
	        }
	        
	}
	 
	    
	public static void main(String[] args) {
		SpringApplication.run(Customer_consumer.class, args);
	}
	
	
	
}
