/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package find_fast_dash_board;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ziyad
 */
public class LoginpanelController implements Initializable {

    @FXML
    private Button login;
    @FXML
    private TextField u_name;
    @FXML
    private TextField u_pass;
    public static String x= "" ;

    String str1;
    String str2;
    
    

    /**
     * Initializes the controller class.
     *
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void EnterApp(ActionEvent event) throws MalformedURLException, IOException {

        String str3 = "https://khandokeranan.com/projects/findfastai/admin/authAdmin.php?user=" + u_name.getText() + "&pass="+u_pass.getText();
        URL url = new URL(str3);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String check = in.readLine();
        
        String str4 = "https://khandokeranan.com/projects/findfastai/admin/insights.php";
        URL url1 = new URL(str4);
        BufferedReader in1 = new BufferedReader(new InputStreamReader(url1.openStream()));
        x = in1.readLine();
         
        System.out.println(x);
        System.out.println(check);


        if (check.equals("0")) {
           
        } else {
         Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("All.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Stage stage = (Stage)login.getScene().getWindow();
        stage.close();
        }

    }

    @FXML
    private void u_nameread(ActionEvent event) {
        str1 = u_name.getText();
    }

    @FXML
    private void u_passread(ActionEvent event) {
        str2 = u_pass.getText();
    }

}
