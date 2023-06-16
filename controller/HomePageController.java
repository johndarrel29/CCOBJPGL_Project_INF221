package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import alert.AlertMaker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomePageController {

  @FXML
  Parent root;

  @FXML
  FXMLLoader loader;

  @FXML
  Button cart, logo, products;

  @FXML
  CartController CartController = null;
  

    
  public void account(ActionEvent event) throws IOException {

    AlertMaker.showSimpleAlert("Notification", "Your message have been sent!");
    
  }

  public void cart(ActionEvent event) throws IOException {

    AlertMaker.showSimpleAlert("Notification", "You have no items yet");

  }

  public void logo(ActionEvent event) throws IOException {

    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HomePage.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    }

  public void product(ActionEvent event) throws IOException {

    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Products.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();

  }

  public void contact(ActionEvent event) throws IOException {

    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Contact.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();

  }

  
}
