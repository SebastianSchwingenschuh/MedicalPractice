package at.htlleonding.health.model;

import java.time.LocalDate;

public class Patient{
    private String name;
    private LocalDate appointment;
    private boolean isEmergency;

    public String getName() {
        return name;
    }

    public LocalDate getAppointment() {
        return appointment;
    }

    public boolean isEmergency() {
        return isEmergency;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", appointment=" + appointment +
                ", isEmergency=" + isEmergency +
                '}';
    }
}
