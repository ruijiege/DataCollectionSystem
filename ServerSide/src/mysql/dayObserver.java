package mysql;

import data.MyData;

public class dayObserver implements Observer{
	private int count=0;

	public dayObserver(Subject subject){
		subject.registerObserver(this);
	}

	@Override
	public void update(MyData mydata) {
		// TODO Auto-generated method stub
		count++;
		if(count==86400){
			count=0;
			MyDatabase.writeDatabase(mydata, "hourTable");
		}		
	}
}
