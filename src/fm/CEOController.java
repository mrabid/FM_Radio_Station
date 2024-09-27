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
public class CEOController implements Initializable {

    @FXML
    private Button checkReviewbutton;
    @FXML
    private Button RevenueButton;
    @FXML
    private Button meetingButton;
    @FXML
    private Button backbutton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ReviewClick(ActionEvent event) throws IOException {
        //Stage stagem = (Stage)checkReviewbutton.getScene().getWindow();
            //stagem.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CheckReview.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
    }

    @FXML
    private void RevenueClick(ActionEvent event) {
    }

    @FXML // Set meeting window Open
    private void MeetingClick(ActionEvent event) throws IOException{
        Stage stagem = (Stage)meetingButton.getScene().getWindow();
            stagem.close();
            FXMLLoader fxmlLoader;
        fxmlLoader = new FXMLLoader(getClass().getResource("Set Meeting.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
    }

    @FXML // Back to Login window
    private void backClick(ActionEvent event) throws IOException {
        Stage stagem = (Stage)backbutton.getScene().getWindow();
            stagem.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
    }
    
}
