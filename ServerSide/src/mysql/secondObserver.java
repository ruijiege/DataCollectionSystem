package mysql;

import data.MyData;

public class secondObserver implements Observer{

	public secondObserver(Subject subject){
		subject.registerObserver(this);
	}

	@Override
	public void update(MyData mydata) {
		// TODO Auto-generated method stub
		MyDatabase.writeDatabase(mydata, "secondTable");
	}

}
