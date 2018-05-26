package Part1;

import java.util.*;

public class Appointment {

	private Key id_num;
	private Date appointment_date_time;
	private String topic;
	
	public Appointment(Key id, Date d, String t)
	{
		id_num = id;
		appointment_date_time = d;
		topic = t;
	}
	
	public Key getKey() {return id_num;}
	
	public void setDate(Date d) {appointment_date_time = d;}
	
	public Date getDate() {return appointment_date_time;}
	
	public String getTopic() {return topic;}
}
