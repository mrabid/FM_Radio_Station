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
public class CheckReviewController implements Initializable {

    @FXML
    private TextArea reviewTextArea;
    @FXML
    private Button viewButton;
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
    private void viewButtonOnAction(ActionEvent event) throws FileNotFoundException {
        reviewTextArea.clear();
        File f = null;
        Scanner sc; 
        String str; 
        String[] tokens;
        
        f = new File("RevewComment.txt");
            sc = new Scanner(f);
            
            if(f.exists()){
                reviewTextArea.appendText("Program Review: \n");
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split(",");
                    reviewTextArea.appendText(
                            "Program Name= "+tokens[0]+"\n"
                            +"Comment= "+tokens[1]+"\n\n"                    
                    );
                }
            }else{
                reviewTextArea.setText("oops! Review.txt does not exist...");
            }
    }

    @FXML
    private void backButtonOnAction(ActionEvent event) throws IOException {
        Stage stagem = (Stage)backButton.getScene().getWindow();
            stagem.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CEO.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        
    }
    
}
