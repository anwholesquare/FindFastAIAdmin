/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package find_fast_dash_board;

import java.awt.event.MouseEvent;
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
import javafx.event.EventHandler;
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
    static String za="";
    String s1,s2,s3,s4,s5,s6;
    
    @FXML
    private ListView<String> paylist;
    List<User1> users = new ArrayList<User1>();
    @FXML
    private Button logo;
    @FXML
    private Button ms;

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
            String[] res = check.split("@@@@", -3);
            
            for (int i = 0; i < res.length; i++) {
                if (res[i].equals("")) {
                    continue;
                }
                String[] res1 = res[i].split("@@@");
                 s1 = res1[0];
                 s2 = res1[1];
                 s3 = res1[2];
                 s4 = res1[3];
                 s5 = res1[4];
                 s6 = res1[5];
                
                User1 us = new User1(s1, s2, s3, s4, s5, s6);
//                System.out.println(res1[0]);
//                System.out.println(res1[1]);
//                System.out.println(res1[2]);

                users.add(us);
            }
            paylist.getItems().add("id" + "             " + "user_id" + "              " + "status" + "              " + "Expire Date" + "                  " + "payment_id" + "            " + "Created Date");
            for (int i = 0; i < users.size(); i++) {
                //System.out.println(users.get(i).id+"       "+users.get(i).amount+"       "+users.get(i).reason +"     ");

                paylist.getItems().add(users.get(i).id + "                         " + users.get(i).user_id + "                            " + users.get(i).status + "                          " + users.get(i).expdate + "                    " + users.get(i).pay_id + "                      " + users.get(i).create);
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

    @FXML
    private void user_detail(javafx.scene.input.MouseEvent event) throws IOException {
        
        String str = "https://khandokeranan.com/projects/findfastai/admin/verifysub.php?id=membership_id";
        URL url0 = null;
        try {
            url0 = new URL(str);
        } catch (MalformedURLException ex) {
            Logger.getLogger(TotalUserpaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        za = s2;
        Parent root = FXMLLoader.load(getClass().getResource("Paymentdetails.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("loginpanel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void msp(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("temp.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
