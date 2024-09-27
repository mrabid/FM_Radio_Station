/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ClientController implements Initializable {

    @FXML
    private Button checkProgramList;
    @FXML
    private Button payBill;
    @FXML
    private Button myReview;
    @FXML
    private Button backButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void checkProgramListClickOnAction(ActionEvent event) throws IOException {
        Stage stagem = (Stage)checkProgramList.getScene().getWindow();
            stagem.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProgramList.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
    }

    @FXML
    private void payBillClickOnAction(ActionEvent event) throws IOException {
        Stage stagem = (Stage)myReview.getScene().getWindow();
            stagem.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PayBill.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
    }

    @FXML
    private void myReviewClickOnAction(ActionEvent event) throws IOException {
        Stage stagem = (Stage)myReview.getScene().getWindow();
            stagem.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Review.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
    }

    @FXML // Back to Login window
    private void backButtonClickOnAction(ActionEvent event) throws IOException {
        Stage stagem = (Stage)backButton.getScene().getWindow();
            stagem.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
    }
    
}
