package controller;

import model.*;
import java.net.URL;
import java.io.IOException;
import java.util.ResourceBundle;

import alert.AlertMaker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.control.ContentDisplay;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class PaintsController implements Initializable {

    @FXML
    Button logo, button1, button2, button3, button4, cartbutton;;

     @FXML
    Label name1, name2, name3, name4, price1, price2, price3, price4;

      @FXML
    ImageView img1, img2, img3, img4;

      @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Parent root = null;

      FXMLLoader loader;

    //for the home button lng to
//     public void initialize (){
//         ImageView imageView = new ImageView(getClass().getResource("/images/brush.png").toExternalForm());
//         logo.setGraphic(imageView);
//         imageView.fitWidthProperty().bind(logo.widthProperty().divide(2));
//         imageView.setPreserveRatio(true);
//         //Important otherwise button will wrap to text + graphic size (no resizing on scaling).
//         logo.setMaxWidth(Double.MAX_VALUE);   
//         logo.setPadding(Insets.EMPTY);
//     }

     static Watercolor watercolor = new Watercolor();
    static Gouache gouache = new Gouache();
    static PosterColors postercolor = new PosterColors();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // ============== Watercolor ==================//
        watercolor.setProductName("Watercolor");
        name1.setText(watercolor.getProductName());

        watercolor.setProductPrice(1200.00);
        price1.setText(Double.toString(watercolor.getProductPrice()));

        watercolor.setProductImage("images/watercolorpic.jpg");
        Image watercolorpic = new Image(watercolor.getProductImage());
        img1.setImage(watercolorpic);

        // ============== Gouache ==================//

        gouache.setProductName("Goauche");
        name2.setText(gouache.getProductName());

        gouache.setProductPrice(800.00);
        price2.setText(Double.toString(gouache.getProductPrice()));

        gouache.setProductImage("images/gouachepic.jpg");
        Image gouachepic = new Image(gouache.getProductImage());
        img2.setImage(gouachepic);

        // ============== Poster Colors ==================//
        postercolor.setProductName("Poster Color");
        name3.setText(postercolor.getProductName());

        postercolor.setProductPrice(500.00);
        price3.setText(Double.toString(postercolor.getProductPrice()));

        postercolor.setProductImage("images/postercolorpic.jpg");
        Image postercolorpic = new Image(postercolor.getProductImage());
        img3.setImage(postercolorpic);
    }

     public void buy(ActionEvent event) throws IOException {

        AlertMaker.showSimpleAlert("notification", "item added successfully");

        Button sourceButton = (Button) event.getSource();

        // If addtocart button is pressed, set product status to true
        if (sourceButton.equals(button1)) {
            watercolor.setProductStatus(true);
            checkoutController.addItem(checkoutController.pane1);
        }

        else if (sourceButton == button2) {
            gouache.setProductStatus(true);
            checkoutController.addItem(checkoutController.pane2);
        }

        else if (sourceButton == button3) {
            postercolor.setProductStatus(true);
            checkoutController.addItem(checkoutController.pane3);
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


}
