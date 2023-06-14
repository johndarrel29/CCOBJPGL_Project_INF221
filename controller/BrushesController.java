package controller;

import model.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import alert.AlertMaker;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;

public class BrushesController implements Initializable{

    @FXML
    Button button7, button8, button9, cartbutton;;

    @FXML
    Label name7, name8, name9, price7, price8, price9;

    @FXML
    ImageView img7, img8, img9;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Parent root = null;

    FXMLLoader loader;
    
    @FXML
    CheckoutController checkoutController = null;
    
    static AngularflatBrush angularflatbrush = new AngularflatBrush();
    static FlatBrush flatbrush = new FlatBrush();
    static RoundBrush roundbrush = new RoundBrush();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // ============== Angular Flat Brush ==================//
        angularflatbrush.setProductName("Angular Flat Brush");
        name7.setText(angularflatbrush.getProductName());

        angularflatbrush.setProductPrice(200.00);
        price7.setText(Double.toString(angularflatbrush.getProductPrice()));

        angularflatbrush.setProductImage("images/angularflatbrushpic.jpg");
        Image angularflatbrushpic = new Image(angularflatbrush.getProductImage());
        img7.setImage(angularflatbrushpic);

        // ============== Flat Brush ==================//

        flatbrush.setProductName("Flat Brush");
        name8.setText(flatbrush.getProductName());

        flatbrush.setProductPrice(100.00);
        price8.setText(Double.toString(flatbrush.getProductPrice()));

        flatbrush.setProductImage("images/flatbrushpic.jpg");
        Image flatbrushpic = new Image(flatbrush.getProductImage());
        img8.setImage(flatbrushpic);

        // ============== Round Brush ==================//
        roundbrush.setProductName("Round Brush");
        name9.setText(roundbrush.getProductName());

        roundbrush.setProductPrice(50.00);
        price9.setText(Double.toString(roundbrush.getProductPrice()));

        roundbrush.setProductImage("images/roundbrushpic.jpg");
        Image roundbrushpic = new Image(roundbrush.getProductImage());
        img9.setImage(roundbrushpic);

        try {
            loader = new FXMLLoader(getClass().getResource("/view/Checkout.fxml"));
            root = loader.load();
        } catch (Exception e) {
            // TODO: handle exception
        }

        // Clears all items in Checkout.fxml
        checkoutController = loader.getController();
        checkoutController.myvbox.getChildren().removeAll(checkoutController.myvbox.getChildren());
    
    }

     public void buy(ActionEvent event) throws IOException {

        AlertMaker.showSimpleAlert("notification", "item added successfully");

        Button sourceButton = (Button) event.getSource();

        // If addtocart button is pressed, set product status to true
        if (sourceButton.equals(button7)) {
            angularflatbrush.setProductStatus(true);
            checkoutController.addItem(checkoutController.pane4);
        }

        else if (sourceButton == button8) {
            flatbrush.setProductStatus(true);
            checkoutController.addItem(checkoutController.pane5);
        }

        else if (sourceButton == button9) {
            roundbrush.setProductStatus(true);
            checkoutController.addItem(checkoutController.pane6);
        }
    }
    

    public void logo(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Home.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Goes to Checkout.fxml
    public void gotocart(ActionEvent event) throws IOException {

        Scene scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
