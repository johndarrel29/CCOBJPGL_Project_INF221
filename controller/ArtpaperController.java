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

public class ArtpaperController implements Initializable{

@FXML
    Button button4, button5, button6, cartbutton;;

    @FXML
    Label name4, name5, name6, price4, price5, price6;

    @FXML
    ImageView img4, img5, img6;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Parent root = null;

    FXMLLoader loader;

    @FXML
    CheckoutController checkoutController = null;
    
    static SketchingPaper sketchingpaper = new SketchingPaper();
    static TonedPaper tonedpaper = new TonedPaper();
    static WatercolorPaper watercolorpaper = new WatercolorPaper();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // ============== Sketching Paper ==================//
        sketchingpaper.setProductName("Sketching Paper");
        name4.setText(sketchingpaper.getProductName());

        sketchingpaper.setProductPrice(500.00);
        price4.setText(Double.toString(sketchingpaper.getProductPrice()));

        sketchingpaper.setProductImage("images/sketchingpaperpic.jpg");
        Image sketchingpaperpic = new Image(sketchingpaper.getProductImage());
        img4.setImage(sketchingpaperpic);

        // ============== Toned Paper ==================//

        tonedpaper.setProductName("Toned Paper");
        name5.setText(tonedpaper.getProductName());

        tonedpaper.setProductPrice(1800.00);
        price5.setText(Double.toString(tonedpaper.getProductPrice()));

        tonedpaper.setProductImage("images/tonedpaper.jpg");
        Image tonedpaperpic = new Image(tonedpaper.getProductImage());
        img5.setImage(tonedpaperpic);

        // ============== Watercolor Paper ==================//
        watercolorpaper.setProductName("Watercolor Paper");
        name6.setText(watercolorpaper.getProductName());

        watercolorpaper.setProductPrice(500.00);
        price6.setText(Double.toString(watercolorpaper.getProductPrice()));

        watercolorpaper.setProductImage("images/watercolorpaperpic.jpg");
        Image watercolorpaperpic = new Image(watercolorpaper.getProductImage());
        img6.setImage(watercolorpaperpic);

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
        if (sourceButton.equals(button4)) {
            sketchingpaper.setProductStatus(true);
            //checkoutController.addItem(checkoutController.pane1);
        }

        else if (sourceButton == button5) {
            tonedpaper.setProductStatus(true);
            //checkoutController.addItem(checkoutController.pane2);
        }

        else if (sourceButton == button6) {
            watercolorpaper.setProductStatus(true);
           // checkoutController.addItem(checkoutController.pane3);
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
