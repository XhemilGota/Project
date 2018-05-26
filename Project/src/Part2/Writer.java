package Part2;

import javax.swing.*;
import java.awt.*;

public class Writer extends JPanel {

	JFrame loginFrame, userFrame, sendFrame;
	JPanel panel;
	JTextField User, fromText, toText, subjectText;
	JPasswordField Pass;
	JButton Login, Register, sendEmail, receivedEmails, send, signOut, back, delete;
	Controller h;
	JLabel label1,label2, sentEmailsLabel, receivedEmailsLabel;
	JTextArea area;
	
	public Writer(Controller handler) 
	{		
		h = handler;
		loginFrame = new JFrame();
		userFrame = new JFrame();
		sendFrame = new JFrame();
		loginView();
	}
	
	public void loginView()
	{
		   loginFrame = new JFrame();
		   loginFrame.setSize(400, 120);
		   loginFrame.setTitle("Login");
		   loginFrame.setLayout(new BorderLayout());
		   
		   label1 = new JLabel();
		   label1.setText("Username:");
		   
		   User = new JTextField(15);
		 
		   label2 = new JLabel();
		   label2.setText("Password:");
		   
		   Pass = new JPasswordField(15);
		  
		   Login = new JButton("Login");
		   Login.addActionListener(h);
		   
		   Register = new JButton("Register");
		   Register.addActionListener(h);
		   
		   Panel northPanel = new Panel(new BorderLayout());
		   Panel northWest = new Panel(new GridLayout(2,1));
		   Panel northEast = new Panel(new GridLayout(2,1));
		   Panel southPanel = new Panel(new GridLayout(1,2));
		   
		   northWest.add(label1);
		   northWest.add(label2);
		   
		   northEast.add(User);
		   northEast.add(Pass);
		   
		   northPanel.add(northWest, BorderLayout.WEST);
		   northPanel.add(northEast, BorderLayout.CENTER);
		   
		   southPanel.add(Login);
		   southPanel.add(Register);
		   
		   loginFrame.add(northPanel, BorderLayout.CENTER);
		   loginFrame.add(southPanel, BorderLayout.SOUTH);
		   
		   userFrame.setVisible(false);
		   sendFrame.setVisible(false);
		   loginFrame.setLocationRelativeTo(null);
		   loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   loginFrame.setVisible(true);
	}
	
	public void userView(User u)
	{
		userFrame = new JFrame();
		userFrame.setSize(800,700);
		
		userFrame.setLayout(new BorderLayout());
		
		EmailMessage[] e = u.getSentMessages();
		String s = "Sent Emails \n";
		
		for(int i = 0; i < u.getSentEmailNum(); i++)
		{
			s += "\nReceiver: " + e[i].getReceiverAddress() + "\nSubject: " + e[i].getSubject() + "\n" + e[i].getText() + "\n \n";
		}
		
		JTextArea area1 = new JTextArea(s);
		JScrollPane scrollPane = new JScrollPane(area1); 
		area1.setEditable(false);
		
		EmailMessage[] e2 = u.getReceivedMessages();
		s = "Received Emails \n";
		
		for(int i = 0; i < u.getReceivedEmailNum(); i++)
		{
			s += "\nSender: " + e2[i].getSenderAddress() + "\nSubject: " + e2[i].getSubject() + "\n" + e2[i].getText() + "\n \n";
		}
		
		JTextArea area2 = new JTextArea(s);
		JScrollPane scrollPane2 = new JScrollPane(area2); 
		area2.setEditable(false);
		
		
		panel = new JPanel(new GridLayout(1,2, 10, 0));
		panel.add(scrollPane);
		panel.add(scrollPane2);
		
		JPanel southPanel = new JPanel(new GridLayout(1,2));
		
		sendEmail = new JButton("Send Email");
		sendEmail.addActionListener(h);
		
		signOut = new JButton("Sign out");
		signOut.addActionListener(h);
		
		delete = new JButton("Delete Account");
		delete.addActionListener(h);
		
		southPanel.add(sendEmail);
		southPanel.add(signOut);
		southPanel.add(delete);
		
		loginFrame.setVisible(false);
		sendFrame.setVisible(false);
		JLabel label3 = new JLabel("Welcome " + u.getAddress());
		label3.setBounds(10, 10, 100, 50);
		userFrame.add(label3, BorderLayout.NORTH);
		userFrame.add(panel, BorderLayout.CENTER);
		userFrame.add(southPanel, BorderLayout.SOUTH);
		userFrame.setLocationRelativeTo(null);
		userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userFrame.setVisible(true);
	}
	
	public void sendView(User u) 
	{
		loginFrame.setVisible(false);
		userFrame.setVisible(false);
		
		sendFrame = new JFrame();
		sendFrame.setSize(400,400);
		
		sendFrame.setTitle("Send Message");
		sendFrame.setLayout(new BorderLayout());
		
		JPanel northWest = new JPanel(new GridLayout(3, 1));
		northWest.add(new JLabel("From: "));
		northWest.add(new JLabel("To: "));
		northWest.add(new JLabel("Subject: "));
		
		JPanel northCenter = new JPanel(new GridLayout(3, 1));
		fromText = new JTextField();
		northCenter.add(fromText);
		toText = new JTextField();
		northCenter.add(toText);
		subjectText = new JTextField();
		northCenter.add(subjectText);
		
		JPanel north = new JPanel(new BorderLayout());
		north.add(northWest, BorderLayout.WEST);
		north.add(northCenter, BorderLayout.CENTER);
		
		JPanel south = new JPanel(new FlowLayout());
		
		send = new JButton("Send");
		send.addActionListener(h);
		south.add(send);
		
		back = new JButton("Back");
		back.addActionListener(h);
		south.add(back);
		
		area = new JTextArea(); 
		
		sendFrame.add(north, BorderLayout.NORTH);
		sendFrame.add(area, BorderLayout.CENTER);
		sendFrame.add(south, BorderLayout.SOUTH);
		sendFrame.setLocationRelativeTo(null);
		sendFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sendFrame.setVisible(true);
	}	
	
	public JButton getLoginButton() {return Login;}
	
	public JButton getRegisterButton() {return Register;}
	
	public JButton getSendEmailButton() {return sendEmail;}
	
	public JButton getSignOutButton() {return signOut;}
	
	public JButton getSendButton() {return send;}
	
	public JButton getBackButton() {return back;}
	
	public JButton getDeleteButton() {return delete;}
	
	public JTextField getUsernameTextfield() {return User;}
	
	public JTextField getPasswordTextfield() {return Pass;}
	
	public JTextField getToTextfield() {return toText;}
	
	public JTextField getFromTextfield() {return fromText;}
	
	public JTextField getSubjectTextfield() {return subjectText;}
	
	public JTextArea getTextArea() {return area;}
	
	
	
}
