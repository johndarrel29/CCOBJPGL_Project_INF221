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

public class PaperController implements Initializable {

    @FXML
    Label paper1, paper2, paper3, price1, price2, price3;

    @FXML
    ImageView img1, img2, img3;

    @FXML
    Button button4, button5, button6, cartbutton;

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

        // ============== Sketching Paper ==================//
        paper1.setText(LoginController.sketchingpaper.getProductName());
        price1.setText(Double.toString(LoginController.sketchingpaper.getProductPrice()));
        Image sketchingpaperPic = new Image(LoginController.sketchingpaper.getProductImage());
        img1.setImage(sketchingpaperPic);

        // ============== Toned Paper ==================//

        paper2.setText(LoginController.canvasPaper.getProductName());
        price2.setText(Double.toString(LoginController.canvasPaper.getProductPrice()));
        Image tonedpaperPic = new Image(LoginController.canvasPaper.getProductImage());
        img2.setImage(tonedpaperPic);

        // ============== Water Color Paper ==================//

        paper3.setText(LoginController.watercolorpaper.getProductName());
        price3.setText(Double.toString(LoginController.watercolorpaper.getProductPrice()));
        Image watercolorpaperPic = new Image(LoginController.watercolorpaper.getProductImage());
        img3.setImage(watercolorpaperPic);

    }

    public void buy(ActionEvent event) throws IOException {

        AlertMaker.showSimpleAlert("hello", "item added");

        Button sourceButton = (Button) event.getSource();

        // If addtocart button is pressed, set product status to true
        if (sourceButton.equals(button4)) {
            LoginController.sketchingpaper.setProductStatus(true);
            LoginController.sketchingpaper.setProductQuantity(1);
            LoginController.cart.addItem(LoginController.cartController.pane4);
        }

        else if (sourceButton == button5) {
            LoginController.canvasPaper.setProductStatus(true);
            LoginController.canvasPaper.setProductQuantity(1);
            LoginController.cart.addItem(LoginController.cartController.pane5);
        }

        else if (sourceButton == button6) {
            LoginController.watercolorpaper.setProductStatus(true);
            LoginController.watercolorpaper.setProductQuantity(1);
            LoginController.cart.addItem(LoginController.cartController.pane6);
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
     // goes to paints page

     public void paints(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/paints.fxml"));
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