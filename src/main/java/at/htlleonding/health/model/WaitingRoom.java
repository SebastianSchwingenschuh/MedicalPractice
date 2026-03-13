package at.htlleonding.health.model;

import at.htlleonding.observer.ChangeObserver;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.PriorityBlockingQueue;

public class WaitingRoom {
    private PriorityBlockingQueue<Patient> patients = new PriorityBlockingQueue<>();
    private ArrayList<ChangeObserver> observers = new ArrayList<>();
    private Patient currentPatient;

    public int getPatientCount() {
        return patients.size();
    }

    public Patient getPatientInPreparation() {
        return patients.peek();
    }

    public Patient getPatientUndergoingTreatment() {
        return this.currentPatient;
    }

    public void addObserver(ChangeObserver observer) {
        observers.add(observer);
        observer.update(this);
    }

    public void addPatient(String name, LocalDateTime date, boolean isEmergency) {
        this.patients.add(new Patient(name, date, isEmergency));
        notifyObservers();
    }

    private void notifyObservers() {
        for (ChangeObserver<WaitingRoom> observer : observers) {
            observer.update(this);
        }
    }

    public void removeObserver(ChangeObserver observer) {
        observers.remove(observer);
    }

    public void treatNextPatient() {
        this.currentPatient = patients.poll();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "WaitingRoom{" +
                "waitingRoomQueue=" + patients +
                ", observers=" + observers +
                ", currentPatient=" + currentPatient +
                '}';
    }
}