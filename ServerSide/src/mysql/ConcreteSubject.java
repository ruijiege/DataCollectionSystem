package mysql;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import data.MyData;
import dataGenerator.Generator;

public class ConcreteSubject implements Subject {
	
    private List<Observer> observers = new ArrayList<Observer>();

	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.remove(o);
	}

	@Override
	public void notifyObservers(MyData mydata) {
		// TODO Auto-generated method stub
		for(Observer observer:observers){
	           observer.update(mydata);
	    }
	}
	
    public void dataChanged(){	    
		Runnable intervalRunnable = new Runnable() {
		    public void run() {
		    	try {
					MyData mydata=Generator.randomData(1,10);
					notifyObservers(mydata);
				} catch (Exception e) {
					e.printStackTrace();
				}
		    }
		};
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(intervalRunnable, 0, 1, TimeUnit.SECONDS);
    }

}
