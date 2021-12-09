package main.java.modules;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Allwell Onen
 * @since Wed 8 Dec 2021, 11:16 AM
 */
public class SceneController {

    private String fxml = null;
    private MouseEvent event = null;
    private String accountPin = "";
    private String accountNumber = "";
    private Label invalidNumber = null;
    private Label accountNumberField = null;

    public SceneController() {
    }

    public SceneController(Label invalidNumber, Label accountNumberField) {
        this.invalidNumber = invalidNumber;
        this.accountNumberField = accountNumberField;
    }

    /**
     *
     * @param event is the mouse event handler variable
     * @param FXML the FXML scene location
     */
    public SceneController(MouseEvent event, String FXML) {
        this.event = event;
        this.fxml = FXML;
    }

    /**
     *
     * changeScene() method is responsible for changing the scene.
     *
     * @throws IOException
     */
    public void changeScene() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(fxml));

        Scene scene = new Scene(parent);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @return the accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     *
     * @return the accountPin
     */
    public String getAccountPin() {
        return accountPin;
    }

    /**
     *
     * @param accountPin the accountPin to set
     */
    public void setAccountPin(String accountPin) {
        this.accountPin = accountPin;
    }

    /**
     *
     * @param accountNumber
     * @return
     */
    private String updateAccntNum(String number) {
        return accountNumber += number;
    }

    /**
     *
     * @param pin
     * @return
     */
    private String updateAccntPin(String pin) {
        return accountPin += pin;
    }

    /**
     *
     * @param screen
     * @param accntNumField
     * @param accntPinField
     * @param num
     */
    public void show(AnchorPane screen, Label accntNumField, Label accntPinField, Button num) {
        if (screen.getOpacity() == 1) {
            if (accntNumField.getText().length() <= 9) {
                accntNumField.setText(updateAccntNum(num.getText()));
            } else {
            }
        } else {
            if (accntPinField.getText().length() <= 3) {
                accntPinField.setText(updateAccntPin(num.getText()));
            } else {
            }
        }

    }

    public void display(AnchorPane screen, Label textField1, Label textField2, Button button) {
        if (screen.getOpacity() == 1) {
            show(screen, textField1, textField2, button);
        } else {
            show(screen, textField2, textField2, button);
        }
    }

}
