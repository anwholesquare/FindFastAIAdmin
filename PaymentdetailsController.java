/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package find_fast_dash_board;

import static find_fast_dash_board.PaymentController.za;
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
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ziyad
 */
public class PaymentdetailsController implements Initializable {

    @FXML
    private VBox sidebar;
    @FXML
    private Button dash;
    List<User> users1 = new ArrayList<User>();
    @FXML
    private Label u_id;
    @FXML
    private Label u_name;
    @FXML
    private Label amo;
    @FXML
    private Label met;
    @FXML
    private Button Ul;
    @FXML
    private Button srch;
    @FXML
    private Button pay;
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
       
        String str = "https://khandokeranan.com/projects/findfastai/admin/userlist.php";
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
            //List<User> users = new ArrayList<User>();
            for (int i = 0; i < res.length; i++) {
                if (res[i].equals("")) {
                    continue;
                }
                String[] res1 = res[i].split("@@@");
                String s1 = res1[0];
                String s2 = res1[1];
                String s3 = res1[2];
                User us = new User(s1, s3, s2);
//                System.out.println(res1[0]);
//                System.out.println(res1[1]);
//                System.out.println(res1[2]);

                users1.add(us);
            }

            for (int i = 0; i < users1.size(); i++) {
              if(users1.get(i).id.equals(za))
              {
                  u_id.setText(users1.get(i).id);
                  u_name.setText(users1.get(i).name);
//                  met.setText("COD");
//                  amo.setText("2.99");
              }

            }

        } catch (IOException ex) {
            Logger.getLogger(TotalUserpaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        String str1 = "https://khandokeranan.com/projects/findfastai/admin/paymentinfo.php?id=" + za;
        URL url2 = null;
        System.out.println(str1);
        try {
            url2 = new URL(str1);
        } catch (MalformedURLException ex) {
            Logger.getLogger(PaymentdetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader in1 = null;
        try {
            in1 = new BufferedReader(new InputStreamReader(url2.openStream()));
        } catch (IOException ex) {
            Logger.getLogger(TotalUserpaneController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            String check;
            check = in1.readLine();
            System.out.println(check);
            
            String[] res = check.split("@@@", -2);
            
            
            try {
                amo.setText(res[1]);
                met.setText(res[2]);
            }catch (ArrayIndexOutOfBoundsException e) {
                
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
    private void showlist(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TotalUserpane.fxml"));
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
    private void paytm(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Payment.fxml"));
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
