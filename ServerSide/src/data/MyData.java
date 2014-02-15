package data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyData {
	private int data;
	private Date date;
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public MyData(){
		data=0;
		date=new Date();
	}
	
	public MyData(int data,Date date){
		this.data=data;
		this.date=date;
	}

	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//get current date time with Date()
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		System.out.println(dateFormat.format(new java.sql.Date(date.getTime())));
	}

}
