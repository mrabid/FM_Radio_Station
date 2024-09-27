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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ProgramListController implements Initializable {

    @FXML
    private TextArea programList;
    @FXML
    private TextField programName;
    @FXML
    private Button ConfirmButton;
    @FXML
    private Button backButton;
    @FXML
    private Button viewButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ConfirmButtonOnAction(ActionEvent event) {
    }

    @FXML
    private void backButtonOnAction(ActionEvent event) throws IOException {
        Stage stagem = (Stage)backButton.getScene().getWindow();
            stagem.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
    }

    @FXML
    private void viewButtonOnAction(ActionEvent event) throws FileNotFoundException {
        programList.clear();
        File f = null;
        Scanner sc; 
        String str; 
        String[] tokens;
        
        f = new File("ProgramList.txt");
            sc = new Scanner(f);
            
            if(f.exists()){
                programList.appendText("All Program List: \n");
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split(",");
                    programList.appendText(
                            "Program Name= "+tokens[0]
                            +", RJ Name= "+tokens[1]
                            +", Date= "+tokens[2]
                            +", Start Time= "+tokens[3]
                            +", Duration= "+tokens[4]        
                            +", Cost= "+tokens[5]+"\n\n"                    
                    );
                }
            }else{
                programList.setText("oops! Program List.txt does not exist...");
            }
    }
    
}
