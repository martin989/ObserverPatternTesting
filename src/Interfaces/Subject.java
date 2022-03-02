package Interfaces;

public interface Subject {
    public void registerObserver(IObserver o);
    public void unregisterObserver(IObserver o);
    public void notifyObservers();
}
