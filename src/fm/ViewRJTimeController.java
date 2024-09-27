/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ViewRJTimeController implements Initializable {

    @FXML
    private TextArea workTimeTextField;
    @FXML
    private Button ViewButton;
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
    private void ViewButtonClickOnAction(ActionEvent event) throws FileNotFoundException {
        workTimeTextField.clear();
        File f = null;
        Scanner sc; 
        String str; 
        String[] tokens;
        
        f = new File("RjWorkTime.txt");
            sc = new Scanner(f);
            
            if(f.exists()){
                workTimeTextField.appendText("Working Time of RJ: \n");
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split(",");
                    workTimeTextField.appendText(
                            "RJ Name= "+tokens[0]
                            +", Program Name= "+tokens[1]
                            +", Start Time= "+tokens[2]
                            +", End Time= "+tokens[3]
                            +", Date= "+tokens[4]+"\n"                    
                    );
                }
            }else{
                workTimeTextField.setText("oops! meetingTime.txt does not exist...");
            }
    }

    
    @FXML
    private void backButtonClickOnAction(ActionEvent event) throws IOException {
        Stage stagem = (Stage)backButton.getScene().getWindow();
            stagem.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RJ.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
    }
    
}
