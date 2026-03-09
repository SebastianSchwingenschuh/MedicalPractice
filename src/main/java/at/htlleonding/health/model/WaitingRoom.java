package at.htlleonding.health.model;

import at.htlleonding.observer.ChangeObserver;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.PriorityBlockingQueue;

public class WaitingRoom {
    private PriorityBlockingQueue<Patient> waitingRoomQueue = new PriorityBlockingQueue<>();
    private ArrayList<ChangeObserver> observers = new ArrayList<>();

    public int getPatientCount() {
        return waitingRoomQueue.size();
    }
    public Patient getPatientInPrepatation() {
        return waitingRoomQueue.poll();
    }

    public Patient getPatientUndergoingTreatment() {
        return waitingRoomQueue.poll();
    }

    public void addObserver(ChangeObserver observer) {
        observers.add(observer);
    }

    public void addPatient(String name, LocalDateTime date, boolean success){

    }
    public void removeObserver(ChangeObserver observer) {
        observers.remove(observer);
    }

    public void treatNextPatient() {
        waitingRoomQueue.add(getPatientInPrepatation());
    }

    @Override
    public String toString() {
        return "WaitingRoom{" +
                "waitingRoomQueue=" + waitingRoomQueue +
                ", observers=" + observers +
                '}';
    }
}