package Part2;

public class EmailMessage {

	private String sender_address;
	private String receiver_address;
	private String subject;
	private String text;
	
	public EmailMessage(String s, String r, String sub, String t)
	{
		sender_address = s;
		receiver_address = r;
		subject = sub;
		text = t;
	}
	
	public String getSenderAddress() {return sender_address;}
	
	public String getReceiverAddress() {return receiver_address;}
	
	public String getSubject() {return subject;}
	
	public String getText() {return text;}
}
