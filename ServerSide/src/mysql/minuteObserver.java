package mysql;

import data.MyData;

public class minuteObserver implements Observer{
	private int count=0;

	public minuteObserver(Subject subject){
		subject.registerObserver(this);
	}

	@Override
	public void update(MyData mydata) {
		// TODO Auto-generated method stub
		count++;
		if(count==60){
			count=0;
			MyDatabase.writeDatabase(mydata, "minuteTable");
		}		
	}

}
