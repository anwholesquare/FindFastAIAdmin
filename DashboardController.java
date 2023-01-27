package find_fast_dash_board;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
import find_fast_dash_board.FXMain;
import static find_fast_dash_board.LoginpanelController.x;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.in;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.Scanner;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User 1
 */
public class DashboardController implements Initializable {

    @FXML
    private VBox sidebar;

    /**
     * Initializes the controller class.
     */
    String input = x;
    Scanner sc = new Scanner(input).useDelimiter("@");
    String firstString = sc.next();
    String secondString = sc.next();
    String thirdString = sc.next();
    String fourthString = sc.next();
    static String Ul = "";

    DecimalFormat df = new DecimalFormat("#.##");
    double number = Double.parseDouble(fourthString);
    private Scene scene;
    private Stage stage;
    private Parent root;
    @FXML
    private Label a1;
    @FXML
    private Label a2;
    @FXML
    private Label a3;
    @FXML
    private Label a4;
    @FXML
    private Button Ulist;
    @FXML
    private Button srch;
    @FXML
    private Button pay;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        a2.setText(firstString);
        a1.setText(secondString);
        a4.setText(thirdString);
        a3.setText("$" + df.format(number));

    }

    @FXML
    private void generatelist(ActionEvent event) throws MalformedURLException, IOException {
       
      
        
        
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

}
