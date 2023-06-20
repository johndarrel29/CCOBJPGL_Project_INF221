package controller;

import java.io.IOException;

import alert.AlertMaker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

  private Stage stage;

//@FXML
//CartController cartController = null;
  

    
  public void account(ActionEvent event) throws IOException {

    AlertMaker.showSimpleAlert("Notification", "You are already Signed In");
    
  }

  public void cart(ActionEvent event) throws IOException {

    AlertMaker.showSimpleAlert("Notification", "You have no items yet");

  }

  public void logo(ActionEvent event) throws IOException {

    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HomePage.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    }

  public void product(ActionEvent event) throws IOException {

    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/paints.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();

  }

  public void contact(ActionEvent event) throws IOException {

    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Contact.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();

  }

  
}
