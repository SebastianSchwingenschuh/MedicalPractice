package at.htlleonding.health.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Patient implements Comparable<Patient>{
    private String name;
    private LocalDate appointment;
    private boolean isEmergency;

    public Patient(String johnDoe, LocalDateTime of, boolean b) {
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getAppointment() {
        return appointment.atStartOfDay();
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


    @Override
    public int compareTo(Patient o) {
        return 0;
    }
}
