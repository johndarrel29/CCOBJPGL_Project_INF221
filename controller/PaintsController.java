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

public class PaintsController implements Initializable {

    @FXML
    Label paint1, paint2, paint3, price1, price2, price3;

    @FXML
    ImageView img1, img2, img3;

    @FXML
    Button button1, button2, button3, cartbutton;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    static Parent root = null;

    FXMLLoader loader;

    @FXML
    static CartController cartController = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // ============== Watercolor Paint ==================//
        paint1.setText(LoginController.watercolor.getProductName());
        price1.setText(Double.toString(LoginController.watercolor.getProductPrice()));
        Image watercolorPic = new Image(LoginController.watercolor.getProductImage());
        img1.setImage(watercolorPic);

        // ============== Gouache Paint ==================//

        paint2.setText(LoginController.gouache.getProductName());
        price2.setText(Double.toString(LoginController.gouache.getProductPrice()));

        Image goauchePic = new Image(LoginController.gouache.getProductImage());
        img2.setImage(goauchePic);

        // ============== Poster Color Paint ==================//

        paint3.setText(LoginController.acrylicPaint.getProductName());
        price3.setText(Double.toString(LoginController.acrylicPaint.getProductPrice()));
        Image acrylicpaintPic = new Image(LoginController.acrylicPaint.getProductImage());
        img3.setImage(acrylicpaintPic);

    }

    public void buy(ActionEvent event) throws IOException {

        AlertMaker.showSimpleAlert("hello", "item added");

        Button sourceButton = (Button) event.getSource();

        // If addtocart button is pressed, set product status to true
        if (sourceButton.equals(button1)) {
            LoginController.watercolor.setProductStatus(true);
            LoginController.watercolor.setProductQuantity(1);
            LoginController.cart.addItem(LoginController.cartController.pane1);
        }

        else if (sourceButton == button2) {
            LoginController.gouache.setProductStatus(true);
            LoginController.gouache.setProductQuantity(1);
            LoginController.cart.addItem(LoginController.cartController.pane2);
        }

        else if (sourceButton == button3) {
            LoginController.acrylicPaint.setProductStatus(true);
            LoginController.acrylicPaint.setProductQuantity(1);
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

        Parent root = FXMLLoader.load(getClass().getResource("/view/HomePage.fxml"));
        Scene scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // goes to art paper page

     public void artpaper(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/artpapers.fxml"));
        Scene scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // go to brush 

    public void brush(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/brush.fxml"));
        Scene scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}