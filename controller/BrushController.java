package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import alert.AlertMaker;

public class BrushController implements Initializable {

    @FXML
    Label brush1, brush2, brush3, price1, price2, price3;

    @FXML
    ImageView img1, img2, img3;

    @FXML
    Button button1, button2, button3, cartbutton;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    static Parent homeRoot = null;

    FXMLLoader loader;

    @FXML
    // static CheckoutController checkoutController = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // ============== Angularflat Brush ==================//
        brush1.setText(LoginController.angularflatbrush.getProductName());
        price1.setText(Double.toString(LoginController.angularflatbrush.getProductPrice()));
        Image angularflatbrushPic = new Image(LoginController.angularflatbrush.getProductImage());
        img1.setImage(angularflatbrushPic);

        // ============== Flat Brush ==================//

        brush2.setText(LoginController.flatbrush.getProductName());
        price2.setText(Double.toString(LoginController.flatbrush.getProductPrice()));
        Image flatbrushPic = new Image(LoginController.flatbrush.getProductImage());
        img2.setImage(flatbrushPic);

        // ============== Round Brush Paint ==================//

        brush3.setText(LoginController.roundbrush.getProductName());
        price3.setText(Double.toString(LoginController.roundbrush.getProductPrice()));
        Image roundbrushPic = new Image(LoginController.roundbrush.getProductImage());
        img3.setImage(roundbrushPic);

    }

    public void buy(ActionEvent event) throws IOException {

        AlertMaker.showSimpleAlert("hello", "item added");

        Button sourceButton = (Button) event.getSource();

        // If addtocart button is pressed, set product status to true
        if (sourceButton.equals(button1)) {
            LoginController.angularflatbrush.setProductStatus(true);
            LoginController.angularflatbrush.setProductQuantity(1);
            LoginController.cart.addItem(LoginController.cartController.pane1);
        }

        else if (sourceButton == button2) {
            LoginController.flatbrush.setProductStatus(true);
            LoginController.flatbrush.setProductQuantity(1);
            LoginController.cart.addItem(LoginController.cartController.pane2);
        }

        else if (sourceButton == button3) {
            LoginController.roundbrush.setProductStatus(true);
            LoginController.roundbrush.setProductQuantity(1);
            LoginController.cart.addItem(LoginController.cartController.pane3);
        }

        LoginController.cart.showItems();
    }

    // Goes to Checkout.fxml
    public void gotocart(ActionEvent event) throws IOException {

        // Load items to cart before switching to checkout page
        LoginController.cartController.showItems(LoginController.cart.getItemList());

        // Set initial total amount in checkout page
        LoginController.cartController.getInitialAmount();

        Scene scene = new Scene(LoginController.root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Goes to Checkout.fxml
    public void logo(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/Products.fxml"));
        Scene scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}