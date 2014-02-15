package mysql;

import data.MyData;

public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers(MyData mydata);
}
