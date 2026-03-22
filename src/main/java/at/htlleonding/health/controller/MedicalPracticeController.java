package at.htlleonding.health.controller;

import at.htlleonding.health.model.Patient;
import at.htlleonding.health.model.WaitingRoom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.converter.LocalDateTimeStringConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class MedicalPracticeController {

    @FXML
    private Button addPatientButton;

    @FXML
    private DatePicker datePicker;

    @FXML
    private CheckBox emergencyCheckBox;

    @FXML
    private Label inPreparationLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    private Button nextPleaseButton;

    @FXML
    private Label patientsLeftLabel;

    @FXML
    private TextField timeTextField;

    @FXML
    private TextArea txtWaitingRoom;

    @FXML
    private Label undergoingTreatmentLabel;

    Patient patient;
    private WaitingRoom waitingRoom;

    @FXML private void initialize() {
        waitingRoom = new WaitingRoom();
        waitingRoom.addObserver(wr -> updateLabels());
    }
    @FXML
    void handleAddPatientClicked(ActionEvent event) {
        String name = nameTextField.getText();
        LocalDate date = datePicker.getValue();
        String timeText = timeTextField.getText();
        boolean isEmergency = emergencyCheckBox.isSelected();

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.parse(timeText, timeFormatter);
        LocalDateTime appointment = LocalDateTime.of(date, time);

        waitingRoom.addPatient(name, appointment, isEmergency);

        nameTextField.clear();
        datePicker.setValue(null);
        timeTextField.clear();
        emergencyCheckBox.setSelected(false);
    }

    @FXML
    void handleNextPleaseClicked(ActionEvent event) {
        waitingRoom.treatNextPatient();
    }

    private void updateLabels(){
        patientsLeftLabel.setText(String.valueOf(waitingRoom.getPatientCount()));

        Patient prep = waitingRoom.getPatientInPreparation();
        inPreparationLabel.setText(prep != null ? prep.toString() : "-");

        Patient treat = waitingRoom.getPatientUndergoingTreatment();
        undergoingTreatmentLabel.setText(treat != null ? treat.toString() : "-");

        StringBuilder sb = new StringBuilder();
        for(Patient p : waitingRoom.getWaitingListSnapshot()){
            sb.append(p.toString()).append("\n");
        }
        txtWaitingRoom.setText(sb.toString());
    }
}

