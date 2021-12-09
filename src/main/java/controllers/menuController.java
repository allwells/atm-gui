package main.java.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import main.java.modules.SceneController;

/**
 * FXML menuController class
 *
 * @author Allwell Onen
 * @since Wed 8 Dec 2021, 01:37 PM
 */
public class menuController implements Initializable {

    /**
     *
     * String
     */
    private final String FXML = "/main/resources/views/";
    // Login scene
    private final String login = "login.fxml";

    /**
     *
     * SceneController class
     */
    private SceneController sceneController;
    @FXML
    private AnchorPane menuScreen;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void cancel(MouseEvent event) throws IOException {
        sceneController = new SceneController(event, (FXML + login));
        sceneController.changeScene();

    }

    @FXML
    private void getTransferScene(MouseEvent event) {
    }

    @FXML
    private void getEnquiryScene(MouseEvent event) {
    }

    @FXML
    private void getWithdrawScene(MouseEvent event) {
    }

    @FXML
    private void getQuickTellerScene(MouseEvent event) {
    }

    @FXML
    private void getTopUpScene(MouseEvent event) {
    }

    @FXML
    private void getChangePinScene(MouseEvent event) {
    }

}
