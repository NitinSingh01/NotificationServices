package Notify;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Repository
public class NotificationRepository {
	@Autowired
	JavaMailSender javaMailSender;


	public void sendAccountCreatedEmail(Account user) throws MailException, URISyntaxException {
		Customer c = new Customer();
		Customer d = new Customer();
		c.setFields("First_Name,Last_Name,Email");
		
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://customer:9009/microbank/v1/customers/"+Integer.toString(user.getCust_ID())+"/fields";
	    URI uri1 = new URI(baseUrl);
	    d = restTemplate.postForObject(uri1, c, Customer.class);
	    
	    
	    final String baseUrl1 = "http://account:9000/microbank/v1/customers/accounts/"+Integer.toString(user.getAcc_ID());
	    URI uri2 = new URI(baseUrl1);
	    Account g = restTemplate.getForObject(uri2, Account.class);
	    System.out.println(g.getCust_ID());
		SimpleMailMessage mail = new SimpleMailMessage();
		String h="";
		h = d.getFirst_Name()+d.getLast_Name();
		mail.setTo(d.getEmail());
		mail.setSubject("Congratulations Account Created");
		mail.setText("Hurray! "+h+", your account is created. You Account Number is "+user.getAcc_ID()+". To login, you can use customer ID and Password mailed to you before."
				+"\n"+"Customer User ID:"+g.getCust_ID());

		
		javaMailSender.send(mail);
	}
	public void sendTransactionEmail(Transaction user) throws MailException, URISyntaxException {RestTemplate restTemplate = new RestTemplate();
		Customer c = new Customer();
		Customer d = new Customer();
		c.setFields("First_Name,Last_Name,Email");
		final String baseUrl1 = "http://account:9000/microbank/v1/customers/accounts/"+Integer.toString(user.getAcc_ID());
	    URI uri2 = new URI(baseUrl1);
	    Account g = restTemplate.getForObject(uri2, Account.class);
		
		final String baseUrl = "http://customer:9009/microbank/v1/customers/"+Integer.toString(g.getCust_ID())+"/fields";
	    URI uri1 = new URI(baseUrl);
	    d = restTemplate.postForObject(uri1, c, Customer.class);
		
		String h="";
		h = d.getFirst_Name()+d.getLast_Name();
		

		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(d.getEmail());
		mail.setSubject("Transaction Alert");
		if(user.getTransaction_Type().toUpperCase().equals("DEBIT")) {
		mail.setText("Hi "+h+"!"+"\n"+"You account "+user.getAcc_ID()+"is "+user.getTransaction_Type().toLowerCase()+"ed by Rs."+user.getAmount());
		}
		else
			mail.setText("Hi "+h+"!"+"\n"+"Rs. "+user.getAmount()+" is "+user.getTransaction_Type().toLowerCase()+"ed to your account "+user.getAcc_ID());
	
		
		javaMailSender.send(mail);
	}
	public void sendSuccessfulRegistraionEmail(Customer user) throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(user.getEmail());
		mail.setSubject("Successful Registration");
		mail.setText("Hi! "+user.getFirst_Name()+", you have successfully Registered. To login use below mentioned credentials:"
				+"\n"+"Customer ID:"+user.getCust_ID()+"\n"+"Password :"+user.getPassword());

		
		javaMailSender.send(mail);
	}
	
	
	
}
