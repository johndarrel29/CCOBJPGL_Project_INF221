package controller;

import java.io.IOException;

import alert.AlertMaker;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomePageController {

    Button cart, logo, products;
    
    public void account(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

     public void cart(ActionEvent event) throws IOException {

      AlertMaker.showSimpleAlert("Notification", "You have to Log In your Account first!");

    }

    public void logo(ActionEvent event) throws IOException {

      AlertMaker.showSimpleAlert("Notification", "You have to Log In your Account first!");

    }

    public void product(ActionEvent event) throws IOException {

      AlertMaker.showSimpleAlert("Notification", "You have to Log In your Account first!");

    }
}
