/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */


///////////////
public class LoginController implements Initializable {

    @FXML
    private TextField loginIdTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private ComboBox selectUser;
    @FXML
    private Button signInbutton;

    /**
     * Initializes the controller class.
     */
    @Override 
    public void initialize(URL url, ResourceBundle rb) {
        selectUser.getItems().addAll("CEO", "Program Manager", "RJ", "Content Writer", "Guest");
        // TODO
    }    

    @FXML
    private void SignInOnAction(ActionEvent event) throws IOException {
        String userID = loginIdTextField.getText();
        String password = passwordTextField.getText();
        String user = selectUser.getValue().toString();
        
        if ("CEO".equals(user)) {
            if (matchUserIdPassword(userID, password, user)) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CEO.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
                Stage stagem = (Stage) signInbutton.getScene().getWindow();
                stagem.close();
            }else {
                JOptionPane.showMessageDialog(null, "Not valid");
            }
        }
        if ("Program Manager".equals(user)) {
            if (matchUserIdPassword(userID, password, user)) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProgramManager.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
                Stage stagem = (Stage) signInbutton.getScene().getWindow();
                stagem.close();
            }else {
                JOptionPane.showMessageDialog(null, "Not valid");
            }
        }
        if ("RJ".equals(user)) {
            if (matchUserIdPassword(userID, password, user)) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RJ.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
                Stage stagem = (Stage) signInbutton.getScene().getWindow();
                stagem.close();
            }else {
                JOptionPane.showMessageDialog(null, "Not valid");
            }
        }
        if ("Content Writer".equals(user)) {
            if (matchUserIdPassword(userID, password, user)) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Content Writer.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
                Stage stagem = (Stage) signInbutton.getScene().getWindow();
                stagem.close();
            }else {
                JOptionPane.showMessageDialog(null, "Not valid");
            }
        }
        if ("Guest".equals(user)) {
            if (matchUserIdPassword(userID, password, user)) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
                Stage stagem = (Stage) signInbutton.getScene().getWindow();
                stagem.close();
            }else {
                JOptionPane.showMessageDialog(null, "Not valid");
            }
        }
    }    
    
    
    public boolean matchUserIdPassword(String userID, String password, String user){
        String idf = null;
        String passf = null;
        String userf = null;
        File f = new File("login.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(f);
        } catch (FileNotFoundException ex) {
          //  Logger.getLogger(LoginHScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br = new BufferedReader(fr);
        String s = null;

        if (f.exists()) {

            try {
                while ((s = br.readLine()) != null) {
                    if (s.contains(user)) {
                        String n = s;
                        String fm[] = n.split(",");
                        idf = fm[1];
                        passf = fm[2];
                        userf = fm[3];

                    }
                     
                }
            } catch (Exception ex) {

            }

            if (idf.equals(userID) && passf.equals(password) && userf.equals(user)) {
                return true;
            } else {
                return false;

            }

        } else {
            return false;

        }
    }
}