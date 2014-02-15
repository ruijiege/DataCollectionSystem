package dataGenerator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import data.MyData;

public class Generator {

	/**
	 * Generate random number form min to max
	 * @param min minimum number
	 * @param max maximum number
	 * @return random number between min and max
	 */
	public static MyData randomData(int min, int max) throws Exception{
		if(min>max){
			throw new Exception("data range error");
		}
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    Date date = new Date();
//	    java.sql.Date sqlDate=new java.sql.Date(new Date().getTime());
	    MyData myData=new MyData(randomNum, date);
	    
	    return myData;
	}
	
	public static void main(String[] args){
		//test randomData function
		Runnable helloRunnable = new Runnable() {
		    public void run() {
		    	try {
					MyData mydata=randomData(1,10);
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					System.out.println(mydata.getData()+" "+dateFormat.format(mydata.getDate()));
				} catch (Exception e) {
					e.printStackTrace();
				}
		    }
		};

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(helloRunnable, 0, 1, TimeUnit.SECONDS);
	}
}
