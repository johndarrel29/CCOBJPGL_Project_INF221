package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CartController implements Initializable {

    @FXML
    Pane pane1, pane2, pane3, pane4, pane5, pane6, pane7, pane8, pane9;

    @FXML
    VBox myvbox;

    @FXML
     Label paint1, paint2, paint3, brush1, brush2, brush3, artpaper1, artpaper2, artpaper3, 
    price1, price2, price3, price4, price5, price6, price7, price8, price9, total;

    @FXML
    ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;

     @FXML
    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9;
    
    // @FXML
    // private ChoiceBox<String> choicebox1, choicebox2, choicebox3, choicebox4;

    // private String[] quantity = { "1", "2", "3" };

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //==============PAINTS==================================//

        paint1.setText(LoginController.watercolor.getProductName());
        price1.setText(Double.toString(LoginController.watercolor.getProductPrice()));
        Image watercolorpic = new Image(LoginController.watercolor.getProductImage());
        img1.setImage(watercolorpic);

        paint2.setText(LoginController.gouache.getProductName());
        price2.setText(Double.toString(LoginController.gouache.getProductPrice()));
        Image gouchepic = new Image(LoginController.gouache.getProductImage());
        img2.setImage(gouchepic);

        paint3.setText(LoginController.acrylicPaint.getProductName());
        price3.setText(Double.toString(LoginController.acrylicPaint.getProductPrice()));
        Image postercolorpic = new Image(LoginController.acrylicPaint.getProductImage());
        img3.setImage(postercolorpic);

        //=================================BRUSHES======================================//

        brush1.setText(LoginController.angularflatbrush.getProductName());
        price4.setText(Double.toString(LoginController.angularflatbrush.getProductPrice()));
        Image angpic = new Image(LoginController.angularflatbrush.getProductImage());
        img4.setImage(angpic);

        brush2.setText(LoginController.flatbrush.getProductName());
        price5.setText(Double.toString(LoginController.flatbrush.getProductPrice()));
        Image flatpic = new Image(LoginController.flatbrush.getProductImage());
        img5.setImage(flatpic);

        brush3.setText(LoginController.roundbrush.getProductName());
        price6.setText(Double.toString(LoginController.roundbrush.getProductPrice()));
        Image roundpic = new Image(LoginController.roundbrush.getProductImage());
        img6.setImage(roundpic);

        //===================================ART PAPERS===================================//

        artpaper1.setText(LoginController.sketchingpaper.getProductName());
        price7.setText(Double.toString(LoginController.sketchingpaper.getProductPrice()));
        Image sketchpic = new Image(LoginController.sketchingpaper.getProductImage());
        img7.setImage(sketchpic);

        artpaper2.setText(LoginController.tonedpaper.getProductName());
        price8.setText(Double.toString(LoginController.tonedpaper.getProductPrice()));
        Image tonedpic = new Image(LoginController.tonedpaper.getProductImage());
        img8.setImage(tonedpic);

        artpaper3.setText(LoginController.watercolorpaper.getProductName());
        price9.setText(Double.toString(LoginController.watercolorpaper.getProductPrice()));
        Image waterpaperpic = new Image(LoginController.watercolorpaper.getProductImage());
        img9.setImage(waterpaperpic);

    }


    //     // Set default quantities in choicebox to 1
    //     choicebox1.setValue("1");
    //     choicebox2.setValue("1");
    //     choicebox3.setValue("1");
    //     choicebox4.setValue("1");

    //     // Insert quantity array to choicebox
    //     choicebox1.getItems().addAll(quantity);
    //     choicebox2.getItems().addAll(quantity);
    //     choicebox3.getItems().addAll(quantity);
    //     choicebox4.getItems().addAll(quantity);

    //     // Add event handler on all choiceboxes
    //     choicebox1.setOnAction(this::computeTotal);
    //     choicebox2.setOnAction(this::computeTotal);
    //     choicebox3.setOnAction(this::computeTotal);
    //     choicebox4.setOnAction(this::computeTotal);
    // }

    public void getInitialAmount() {

        double totalamount = 0.00;

        // If product is chosen, compute item amount
       
          if (LoginController.watercolor.getProductStatus()) {
            if (cb1.isSelected()){
                totalamount += LoginController.watercolor.getProductPrice();
            }
        }

        if (LoginController.gouache.getProductStatus()) {
            if (cb2.isSelected()){
                totalamount += LoginController.gouache.getProductPrice();
            }
        }

        if (LoginController.acrylicPaint.getProductStatus()) {
            if (cb3.isSelected()){
                totalamount += LoginController.acrylicPaint.getProductPrice();
            }
        }

        if (LoginController.angularflatbrush.getProductStatus()) {
            if (cb4.isSelected()){
                totalamount += LoginController.angularflatbrush.getProductPrice();
            }
        }

        if (LoginController.flatbrush.getProductStatus()) {
            if (cb5.isSelected()){
                totalamount += LoginController.flatbrush.getProductPrice();
            }
        }

        if (LoginController.roundbrush.getProductStatus()) {
            if (cb6.isSelected()){
                totalamount += LoginController.roundbrush.getProductPrice();
            }
        }

        if (LoginController.sketchingpaper.getProductStatus()) {
            if (cb7.isSelected()){
                totalamount += LoginController.sketchingpaper.getProductPrice();
            }
        }

        if (LoginController.tonedpaper.getProductStatus()) {
            if (cb8.isSelected()){
                totalamount += LoginController.tonedpaper.getProductPrice();
            }
        }

        if (LoginController.watercolorpaper.getProductStatus()) {
            if (cb9.isSelected()){
                totalamount += LoginController.watercolorpaper.getProductPrice();
            }
        }

        total.setText(Double.toString(totalamount));

    }


    // // Go to Receipt Page
    // public void checkout(ActionEvent event) throws IOException {

    //     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    //     FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Receipt.fxml"));
    //     Parent root = loader.load();
    //     Scene scene = new Scene(root);
    //     stage.setScene(scene);
    //     stage.show();

    // }

    // Show all items in ArrayList
    public void showItems(ArrayList<Pane> itemList) {
        for (Pane p : itemList) {
            myvbox.getChildren().add(p);
        }
    }

}