/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package find_fast_dash_board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ziyad
 */
public class PaymentController implements Initializable {

    @FXML
    private VBox sidebar;
    @FXML
    private Button dash;
    @FXML
    private Button srch;
    @FXML
    private Button Ulist;
    @FXML
    private ListView<String> paylist = new ListView<String>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String str = "https://khandokeranan.com/projects/findfastai/admin/subslist.php";
        URL url1 = null;
        try {
            url1 = new URL(str);
        } catch (MalformedURLException ex) {
            Logger.getLogger(TotalUserpaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(url1.openStream()));
        } catch (IOException ex) {
            Logger.getLogger(TotalUserpaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        try {
            String check;
            check = in.readLine();
            System.out.println(check);
            String[] res = check.split("@@@@", -2);
            List<User1> users = new ArrayList<User1>();
            for (int i =0; i<res.length; i++) {
                if (res[i].equals("")) continue;
                String[] res1 = res[i].split("@@@");
                String s1 = res1[0];
                String s2 = res1[1];
                String s3 = res1[2];
                String s4 = res1[3];
                User1 us = new User1 (s1, s3, s2,s4);
//                System.out.println(res1[0]);
//                System.out.println(res1[1]);
//                System.out.println(res1[2]);
 
                users.add(us);}
 
            for(int i =0; i<users.size(); i++) {
                //System.out.println(users.get(i).id + " " + users.get(i).name);
                
                paylist.getItems().add(users.get(i).id+"       "+users.get(i).amount+"       "+users.get(i).reason +"     ");
            }
 
        } catch (IOException ex) {
            Logger.getLogger(TotalUserpaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }    

    @FXML
    private void opendash(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void srchsubs(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SearchUser.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void generatelist(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TotalUserpane.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
