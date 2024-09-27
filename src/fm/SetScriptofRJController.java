/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm;

import java.io.File;
import java.io.FileWriter;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class SetScriptofRJController implements Initializable {

    @FXML
    private TextArea contentTextArea;
    @FXML
    private TextField ProgramNameTextField;
    @FXML
    private TextField RJNameTextField;
    @FXML
    private Button backButton;
    @FXML
    private Button saveButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backButtonOnAction(ActionEvent event) throws IOException {
        Stage stagem = (Stage)backButton.getScene().getWindow();
            stagem.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Content Writer.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
    }

    @FXML
    private void saveButtonOnAction(ActionEvent event) throws IOException {
        File f = null;
        FileWriter fw = null;

        f = new File("ContentOfRJ.txt"); 
        
        if(f.exists()){
                fw = new FileWriter(f,true);
            } 
            else{
                fw = new FileWriter(f);
            } 
        
        fw.write(
                ProgramNameTextField.getText()+", "	
                +RJNameTextField.getText()+", "	
                +contentTextArea.getText()+"\n"
            );
        
        if(fw != null){
            fw.close();
        }
    }
    }
    
