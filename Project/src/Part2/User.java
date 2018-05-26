package Part2;

public class User {

	private Key address;
	private String pass;
	private EmailMessage[] sent;
	private EmailMessage[] received;
	private int sent_email_num;
	private int received_email_num;
	
	public User(Key a, String p)
	{
		address = a;
		pass = p;
		sent = new EmailMessage[100];
		received = new EmailMessage[100];
		sent_email_num = 0;
		received_email_num = 0;
	}

	public void send(User u, EmailMessage e)
	{		
		if(sent_email_num + 1 < sent.length)
			{sent[sent_email_num] = e;}
		
		else
		{
			EmailMessage[] temp = new EmailMessage[2 * sent.length];
			for(int i = 0; i < sent.length; i++)
				{temp[i] = sent[i];}
			
			temp[sent.length] = e;
			sent = temp;
		}
		u.receive(e);
		sent_email_num++;
	}
	
	public void receive(EmailMessage e)
	{		
		if(received_email_num + 1 < received.length)
			{received[received_email_num] = e;}
		
		else
		{
			EmailMessage[] temp = new EmailMessage[2 * received.length];
			for(int i = 0; i < received.length; i++)
				{temp[i] = received[i];}
			
			temp[received.length] = e;
			received = temp;
		}		
		received_email_num++;
	}
	
	public Key getKey() {return address;}
	
	public String getAddress() {return address.getString();}
	
	public String getPass() {return pass;}

	public EmailMessage[] getSentMessages() {return sent;}
	
	public EmailMessage[] getReceivedMessages() {return received;}

	public int getSentEmailNum() {return sent_email_num;}
	
	public int getReceivedEmailNum() {return received_email_num;}
}
