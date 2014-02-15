package mysql;

import data.MyData;

public class hourObserver implements Observer{
	private int count=0;

	public hourObserver(Subject subject){
		subject.registerObserver(this);
	}

	@Override
	public void update(MyData mydata) {
		// TODO Auto-generated method stub
		count++;
		if(count==3600){
			count=0;
			MyDatabase.writeDatabase(mydata, "hourTable");
		}		
	}
}
