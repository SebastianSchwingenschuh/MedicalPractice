package at.htlleonding.health.model;

import at.htlleonding.observer.ChangeObserver;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.PriorityBlockingQueue;

public class WaitingRoom {
    private PriorityBlockingQueue<Patient> waitingRoomQueue = new PriorityBlockingQueue<>();
    private ArrayList<ChangeObserver> observers = new ArrayList<>();
    private Patient currentPatient;

    public int getPatientCount() {
        return waitingRoomQueue.size();
    }
    public Patient getPatientInPreparation() {
        return waitingRoomQueue.peek();
    }

    public Patient getPatientUndergoingTreatment() {
        return this.currentPatient;
    }

    public void addObserver(ChangeObserver observer) {
        observers.add(observer);
    }

    public void addPatient(String name, LocalDateTime date, boolean isEmergency){
        Patient newPatient = new Patient(name, date, isEmergency);
        this.waitingRoomQueue.add(newPatient);
        for (ChangeObserver observer : observers) {
            observer.update(this);
        }
    }
    public void removeObserver(ChangeObserver observer) {
        observers.remove(observer);
    }

    public void treatNextPatient() {
        this.currentPatient = waitingRoomQueue.poll();
        for (ChangeObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        return "WaitingRoom{" +
                "waitingRoomQueue=" + waitingRoomQueue +
                ", observers=" + observers +
                ", currentPatient=" + currentPatient +
                '}';
    }
}