
package bemyguest.entities;

/**
 *
 * @author LENOVO
 */



import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author rania
 */
public class Mail {
   
             
 
                final String username = "dalhoumidorra1996@gmail.com";
		final String password = "esprit2014";
                Properties props = new Properties();
                
    public void send(String email){
                
                props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
                props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
                
                Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
                        @Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
                
                Message message = new MimeMessage(session);
                
    try {
        message.setFrom(new InternetAddress("dalhoumidorra1996@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
        
        
        message.setSubject("une Reclamation ajouté");
        
        message.setText("une reclamation ajoutée vous dever la traiter " );

			Transport.send(message);

			System.out.println("Done");
        
        
        
    } catch (MessagingException ex) {
        Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
    }
                
                
                }
}
    
