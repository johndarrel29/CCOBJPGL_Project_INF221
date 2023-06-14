package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.Node;

public class CheckoutController implements Initializable {

    @FXML
    Pane pane1, pane2, pane3, pane4, pane5, pane6;

    @FXML
    VBox myvbox, myvbox1;

    @FXML
    Label name1, name2, name3, name4, name5, name6, price1, price2, price3, price4, price5, price6, total;

    @FXML
    ImageView img1, img2, img3, img4, img5, img6;

    // @FXML
    // private ChoiceBox<String> choicebox1, choicebox2, choicebox3;

    @FXML
    Button Checkout;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Parent root = null;

    // private String[] quantity = { "1", "2", "3" };

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        name1.setText(PaintsController.watercolor.getProductName());
        price1.setText(Double.toString(PaintsController.watercolor.getProductPrice()));
        Image watercolorImage = new Image(PaintsController.watercolor.getProductImage());
        img1.setImage(watercolorImage);

        name2.setText(PaintsController.gouache.getProductName());
        price2.setText(Double.toString(PaintsController.gouache.getProductPrice()));
        Image guacheImage = new Image(PaintsController.gouache.getProductImage());
        img2.setImage(guacheImage);

        name3.setText(PaintsController.postercolor.getProductName());
        price3.setText(Double.toString(PaintsController.postercolor.getProductPrice()));
        Image postercolorImage = new Image(PaintsController.postercolor.getProductImage());
        img3.setImage(postercolorImage);

        // name4.setText(BrushesController.angularflatbrush.getProductName());
        // price4.setText(Double.toString(BrushesController.angularflatbrush.getProductPrice()));
        // Image angularflatbrushImage = new Image(BrushesController.angularflatbrush.getProductImage());
        // img4.setImage(angularflatbrushImage);

        // name5.setText(BrushesController.flatbrush.getProductName());
        // price5.setText(Double.toString(BrushesController.flatbrush.getProductPrice()));
        // Image flatbrushImage = new Image(BrushesController.flatbrush.getProductImage());
        // img5.setImage(flatbrushImage);

        // name6.setText(BrushesController.roundbrush.getProductName());
        // price6.setText(Double.toString(BrushesController.roundbrush.getProductPrice()));
        // Image roundbrushImage = new Image(BrushesController.roundbrush.getProductImage());
        // img6.setImage(roundbrushImage);


        // // Set default quantities in choicebox to 1
        // choicebox1.setValue("1");
        // choicebox2.setValue("1");
        // choicebox3.setValue("1");

        // // Insert quantity array to choicebox
        // choicebox1.getItems().addAll(quantity);
        // choicebox2.getItems().addAll(quantity);
        // choicebox3.getItems().addAll(quantity);

        // // Add event handler on all choiceboxes
        // choicebox1.setOnAction(this::computeTotal);
        // choicebox2.setOnAction(this::computeTotal);
        // choicebox3.setOnAction(this::computeTotal);

        // // Set total initial amount
        // double totalInitialAmount = 0.00;
        // if (HomeController.clamp.getProductStatus() || HomeController.blamp.getProductStatus() || HomeController.wlamp.getProductStatus()) {
        //     totalInitialAmount = Double.parseDouble(choicebox1.getValue()) * HomeController.blamp.getProductPrice() +
        //     +Double.parseDouble(choicebox2.getValue()) * HomeController.clamp.getProductPrice()
        //     + Double.parseDouble(choicebox3.getValue()) * HomeController.wlamp.getProductPrice();
        // }
     
        // // Display total initial amount in total label
        // total.setText(Double.toString(totalInitialAmount));
    }


    public void addItem(Pane pane) {
        myvbox.getChildren().add(pane);
    }


    // public void computeTotal(ActionEvent event) {

    //     double totalAmount = 0;
    //     double item1Amount = 0;
    //     double item2Amount = 0;
    //     double item3Amount = 0;

    //     ChoiceBox source = (ChoiceBox) event.getSource();

        // If product is chosen, compute item amount
        // if (HomeController.blamp.getProductStatus()) {

        //     double qty = Double.parseDouble(choicebox1.getValue());
        //     HomeController.blamp.setProductQuantity(qty);

        //     item1Amount = HomeController.blamp.getProductPrice() * qty;

        //     if (source == choicebox1) {
        //         item1Amount = HomeController.blamp.getProductPrice() * qty;
        //     }
        // }

        // if (HomeController.clamp.getProductStatus()) {

        //     double qty = Double.parseDouble(choicebox2.getValue());
        //     HomeController.clamp.setProductQuantity(qty);
        //     item2Amount = HomeController.clamp.getProductPrice() * qty;

        //     if (source == choicebox2) {
        //         item2Amount = HomeController.clamp.getProductPrice() * qty;
        //     }
        // }

        // if (HomeController.wlamp.getProductStatus()) {

        //     double qty = Double.parseDouble(choicebox3.getValue());
        //     HomeController.wlamp.setProductQuantity(qty);
        //     item3Amount = HomeController.wlamp.getProductPrice() * qty;

        //     if (source == choicebox3) {
        //         item3Amount = HomeController.wlamp.getProductPrice() * qty;
        //     }
        // }

        // // Compute total amount for all items chosen
        // totalAmount = item1Amount + item2Amount + item3Amount;
        
        // // Display total amount in total label
        // total.setText(Double.toString(totalAmount));
    // }

    public void checkout(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Order.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
