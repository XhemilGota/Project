package Part2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{
	
	Writer writer;
	Database db;
	
	public Controller()
	{
		db = new Database();
		writer = new Writer(this);		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		Key k = new Key(writer.getUsernameTextfield().getText());
		
		User u = new User(k, writer.getPasswordTextfield().getText());
		
		if(event.getSource() == writer.getLoginButton())
		{			
			if(db.find(k) != null && !(writer.getUsernameTextfield().getText().equals("")) && !(writer.getPasswordTextfield().getText().equals("")) 
					&& db.find(k).getPass().equals(writer.getPasswordTextfield().getText()))
			{
				writer.userView(db.find(k));
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Username or Password incorrect!");
			}			
		}
		
		else if(event.getSource() == writer.getRegisterButton())
		{			
			
			if((writer.getUsernameTextfield().getText().equals("")) && (writer.getPasswordTextfield().getText().equals("")))
			{
				JOptionPane.showMessageDialog(null, "Username or Password field should not be left blank!");
			}
			
			else if(db.find(k) == null)
			{
				db.insert(u);
				writer.userView(db.find(k));
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "User already exists!");
			}
		}
		
		else if(event.getSource() == writer.getSendButton())
		{
			String from = writer.getFromTextfield().getText();
			String to = writer.getToTextfield().getText();
			String subject = writer.getSubjectTextfield().getText();
			String text = writer.getTextArea().getText();
			
			Key k2 = new Key(to);
			
			EmailMessage email = new EmailMessage(from, to, subject, text);
			
			if(!(u.getAddress().equals(from)))
					JOptionPane.showMessageDialog(null, "Sender address incorrect!");
			
			else if(db.find(k2) == null)
					JOptionPane.showMessageDialog(null, "Receiver address incorrect");
			
			else
			{
				db.find(new Key(from)).send(db.find(k2), email);
				
				writer.userView(db.find(new Key(from)));
			}
		}
		
		else if(event.getSource() == writer.getSendEmailButton())
		{
			writer.sendView(u);
		}
		
		else if(event.getSource() == writer.getSignOutButton())
		{
			writer.loginView();
		}
		
		else if(event.getSource() == writer.getBackButton())
		{
			writer.userView(db.find(k));
		}
		
		else if(event.getSource() == writer.getDeleteButton())
		{
			writer.loginView();
			db.delete(k);
		}
	}
	
	

}
