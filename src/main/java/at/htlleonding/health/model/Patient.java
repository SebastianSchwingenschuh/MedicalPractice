package at.htlleonding.health.model;

import com.sun.jdi.connect.Connector;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Patient implements Comparable<Patient>{
    private String name;
    private LocalDateTime appointment;
    private boolean isEmergency;

    public Patient(String name, LocalDateTime appointment, boolean isEmergency) {
        this.name = name;
        this.appointment = appointment;
        this.isEmergency = isEmergency;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getAppointment() {
        return appointment;
    }

    public boolean isEmergency() {
        return isEmergency;
    }

    @Override
    public String toString() {
        //14.3.22 12:30 John Doe
        if(isEmergency) {
            return String.format("EMERGENCY %s", name);
        }
        return String.format("%s %s", appointment.format(DateTimeFormatter.ofPattern("dd.M.yy H:mm")), name);
    }


    @Override
    public int compareTo(Patient o) {
        int compareIsEmergency = -Boolean.compare(isEmergency, o.isEmergency);
        if(compareIsEmergency != 0){
            return compareIsEmergency;
        }
        return this.getAppointment().compareTo(o.getAppointment());
    }

}
