package at.htlleonding.health.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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


    @FXML private void initialize() {
        this.patientsLeftLabel.setText("_");
    }
    @FXML
    void handleAddPatientClicked(ActionEvent event) {

    }

    @FXML
    void handleNextPleaseClicked(ActionEvent event) {

    }
}

