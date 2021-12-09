package main.java.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import main.java.modules.Animation;
import main.java.modules.SceneController;

/**
 *
 * @author Allwell Onen
 * @since Tue 7 Dec 2021, 12:38 PM
 */
public class loginController implements Initializable {

    /**
     *
     * Double
     */
    private final double durationInSeconds = 0.2;

    /**
     *
     * String
     */
    private final String FXML = "/main/resources/views/";
    // Menu scene
    private final String menu = "menu.fxml";

    /**
     *
     * FXML Button
     */
    @FXML
    private Button num1;
    @FXML
    private Button num2;
    @FXML
    private Button num3;
    @FXML
    private Button num4;
    @FXML
    private Button num5;
    @FXML
    private Button num6;
    @FXML
    private Button num7;
    @FXML
    private Button num8;
    @FXML
    private Button num9;
    @FXML
    private Button num0;
    @FXML
    private Button proceedToPinBtn;
    @FXML
    private Button backToNumberBtn;
    @FXML
    private Button proceedToMenuBtn;

    /**
     *
     * FXML Label
     */
    @FXML
    private Label invalidPin;
    @FXML
    private Label invalidNumber;
    @FXML
    private Label accountPinField;
    @FXML
    private Label accountNumberField;

    /**
     * FXML AnchorPane a.k.a the ATM login screens
     */
    @FXML
    private AnchorPane pinScreen;
    @FXML
    private AnchorPane numberScreen;
    /**
     *
     * SceneController class
     */
    private SceneController sceneController;

    public loginController() {
        this.sceneController = new SceneController(invalidNumber, accountNumberField);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pinScreen.setOpacity(0);
        invalidPin.setOpacity(0);
        invalidNumber.setOpacity(0);
    }

    @FXML
    private void clear(MouseEvent event) {
        if (numberScreen.getOpacity() == 1) {
            accountNumberField.setText("");
            sceneController.setAccountNumber("");
        } else {
            accountPinField.setText("");
            sceneController.setAccountPin("");
        }
    }

    @FXML
    private void cancel(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void displayOne(MouseEvent event) {
        sceneController.display(numberScreen, accountNumberField, accountPinField, num1);
    }

    @FXML
    private void displayTwo(MouseEvent event) {
        sceneController.display(numberScreen, accountNumberField, accountPinField, num2);
    }

    @FXML
    private void displayThree(MouseEvent event) {
        sceneController.display(numberScreen, accountNumberField, accountPinField, num3);
    }

    @FXML
    private void displayFour(MouseEvent event) {
        sceneController.display(numberScreen, accountNumberField, accountPinField, num4);
    }

    @FXML
    private void displayFive(MouseEvent event) {
        sceneController.display(numberScreen, accountNumberField, accountPinField, num5);
    }

    @FXML
    private void displaySix(MouseEvent event) {
        sceneController.display(numberScreen, accountNumberField, accountPinField, num6);
    }

    @FXML
    private void displaySeven(MouseEvent event) {
        sceneController.display(numberScreen, accountNumberField, accountPinField, num7);
    }

    @FXML
    private void displayEight(MouseEvent event) {
        sceneController.display(numberScreen, accountNumberField, accountPinField, num8);
    }

    @FXML
    private void displayNine(MouseEvent event) {
        sceneController.display(numberScreen, accountNumberField, accountPinField, num9);
    }

    @FXML
    private void displayZero(MouseEvent event) {
        sceneController.display(numberScreen, accountNumberField, accountPinField, num0);
    }

    @FXML
    private void proceedToMenu(MouseEvent event) {
        try {

            if (accountPinField.getText().length() <= 4) {

                sceneController = new SceneController(event, (FXML + menu));
                sceneController.changeScene();

                invalidPin.setText("");
                invalidPin.setOpacity(0);

//                if (accountNumberField.getText().equals("0499162228") && accountPinField.getText().equals("0000")) {
//                    sceneController = new SceneController(event, (FXML + menu));
//                    sceneController.changeScene();
//
//                    invalidPin.setText("");
//                    invalidPin.setOpacity(0);
//                } else {
//                    invalidPin.setOpacity(1);
//                    invalidPin.setText("Invalid PIN!");
//                }
            } else {
                invalidPin.setOpacity(1);
                invalidPin.setText("4-digit PIN required!");
            }

        } catch (IOException ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void proceedToPin(MouseEvent event) {
        if (accountNumberField.getText().length() == 10) {
            invalidNumber.setOpacity(0);
            Animation animation = new Animation(pinScreen);
            animation.fadeOut(numberScreen, durationInSeconds);

            Animation animation2 = new Animation(numberScreen);
            animation2.fadeIn(pinScreen, durationInSeconds);
        } else {
            invalidNumber.setOpacity(1);
            invalidNumber.setText("10-digit account number required!");
        }

    }

    @FXML
    private void backToNumber(MouseEvent event) {

        invalidNumber.setText("");
        invalidNumber.setOpacity(0);
        invalidPin.setText("");
        invalidPin.setOpacity(0);

        Animation animation = new Animation(numberScreen);
        animation.fadeOut(pinScreen, durationInSeconds);

        Animation animation2 = new Animation(pinScreen);
        animation2.fadeIn(numberScreen, durationInSeconds);
    }
}
