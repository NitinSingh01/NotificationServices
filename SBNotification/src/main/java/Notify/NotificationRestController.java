package Notify;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import Notify.Transaction;


@RestController
public class NotificationRestController {
	@Autowired 
	NotificationRepository notificationRepo;
	@RequestMapping(method=RequestMethod.POST, value="/microbank/v1/notify/customer")
	public void notify_msg1(@RequestBody String data) throws JsonMappingException, JsonProcessingException{	
		Object mapper = new ObjectMapper();
		Customer c = ((ObjectMapper) mapper).readValue(data, Customer.class);
		System.out.println(c.getEmail());
		notificationRepo.sendSuccessfulRegistraionEmail(c);
		
	}
	@RequestMapping(method=RequestMethod.POST, value="/microbank/v1/notify/customer/account/transaction")
	public void notify_msg2(@RequestBody String user)throws JsonMappingException, JsonProcessingException, MailException, URISyntaxException{	
		Object mapper = new ObjectMapper();
		Transaction c = ((ObjectMapper) mapper).readValue(user, Transaction.class);
		notificationRepo.sendTransactionEmail(c);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/microbank/v1/notify/customer/account")
	public void notify_msg3(@RequestBody String data) throws JsonMappingException, JsonProcessingException, MailException, URISyntaxException{	
		Object mapper = new ObjectMapper();
		Account c = ((ObjectMapper) mapper).readValue(data, Account.class);
		notificationRepo.sendAccountCreatedEmail(c);
		
	}
	
	
}
