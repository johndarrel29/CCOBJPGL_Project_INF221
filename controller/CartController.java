package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
    Label paint1, paint2, paint3, brush1, brush2, brush3, paper1, paper2, paper3, 
    price1, price2, price3, price4, price5, price6, price7, price8, price9, total;

    @FXML
    ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;

    @FXML
    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9;
    
    @FXML
    private ChoiceBox<String> choicebox1, choicebox2, choicebox3, choicebox4, choicebox5, 
    choicebox6, choicebox7, choicebox8, choicebox9;

    private String[] quantity = { "1", "2", "3" };

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


        //===================================ART PAPERS===================================//

        paper1.setText(LoginController.sketchingpaper.getProductName());
        price4.setText(Double.toString(LoginController.sketchingpaper.getProductPrice()));
        Image sketchpic = new Image(LoginController.sketchingpaper.getProductImage());
        img4.setImage(sketchpic);

        paper2.setText(LoginController.canvasPaper.getProductName());
        price5.setText(Double.toString(LoginController.canvasPaper.getProductPrice()));
        Image tonedpic = new Image(LoginController.canvasPaper.getProductImage());
        img5.setImage(tonedpic);

        paper3.setText(LoginController.watercolorpaper.getProductName());
        price6.setText(Double.toString(LoginController.watercolorpaper.getProductPrice()));
        Image waterpaperpic = new Image(LoginController.watercolorpaper.getProductImage());
        img6.setImage(waterpaperpic);

      //=================================BRUSHES======================================//

        brush1.setText(LoginController.angularbrush.getProductName());
        price7.setText(Double.toString(LoginController.angularbrush.getProductPrice()));
        Image angpic = new Image(LoginController.angularbrush.getProductImage());
        img7.setImage(angpic);

        brush2.setText(LoginController.flatbrush.getProductName());
        price8.setText(Double.toString(LoginController.flatbrush.getProductPrice()));
        Image flatpic = new Image(LoginController.flatbrush.getProductImage());
        img8.setImage(flatpic);

        brush3.setText(LoginController.roundbrush.getProductName());
        price9.setText(Double.toString(LoginController.roundbrush.getProductPrice()));
        Image roundpic = new Image(LoginController.roundbrush.getProductImage());
        img9.setImage(roundpic);


        // Set default quantities in choicebox to 1
        choicebox1.setValue("1");
        choicebox2.setValue("1");
        choicebox3.setValue("1");
        choicebox4.setValue("1");
        choicebox5.setValue("1");
        choicebox6.setValue("1");
        choicebox7.setValue("1");
        choicebox8.setValue("1");
        choicebox9.setValue("1");

        // Insert quantity array to choicebox
        choicebox1.getItems().addAll(quantity);
        choicebox2.getItems().addAll(quantity);
        choicebox3.getItems().addAll(quantity);
        choicebox4.getItems().addAll(quantity);
        choicebox5.getItems().addAll(quantity);
        choicebox6.getItems().addAll(quantity);
        choicebox7.getItems().addAll(quantity);
        choicebox8.getItems().addAll(quantity);
        choicebox9.getItems().addAll(quantity);

        // Add event handler on all choiceboxes
        choicebox1.setOnAction(this::computeTotal);
        choicebox2.setOnAction(this::computeTotal);
        choicebox3.setOnAction(this::computeTotal);
        choicebox4.setOnAction(this::computeTotal);
        choicebox5.setOnAction(this::computeTotal);
        choicebox6.setOnAction(this::computeTotal);
        choicebox7.setOnAction(this::computeTotal);
        choicebox8.setOnAction(this::computeTotal);
        choicebox9.setOnAction(this::computeTotal);
    }

    public void computeTotal(ActionEvent event) {

        double totalAmount = 0;
        double item1Amount = 0;
        double item2Amount = 0;
        double item3Amount = 0;
        double item4Amount = 0;
        double item5Amount = 0;
        double item6Amount = 0;
        double item7Amount = 0;
        double item8Amount = 0;
        double item9Amount = 0;

        ChoiceBox source = (ChoiceBox) event.getSource();

        // If product is chosen, compute item amount
        if (cb1.isSelected() && LoginController.watercolor.getProductStatus()) {

            double qty = Double.parseDouble(choicebox1.getValue());
            LoginController.watercolor.setProductQuantity(qty);
            item1Amount = LoginController.watercolor.getProductPrice() * qty;
            
            if (source == choicebox1) {
                item1Amount = LoginController.watercolor.getProductPrice() * qty;
            }

        }

        if (cb2.isSelected() && LoginController.gouache.getProductStatus()) {

            double qty = Double.parseDouble(choicebox2.getValue());
            LoginController.gouache.setProductQuantity(qty);
            item2Amount = LoginController.gouache.getProductPrice() * qty;

            if (source == choicebox2) {
                item2Amount = LoginController.gouache.getProductPrice() * qty;
            }
        }

        if (cb3.isSelected() && LoginController.acrylicPaint.getProductStatus()) {

            double qty = Double.parseDouble(choicebox3.getValue());
            LoginController.acrylicPaint.setProductQuantity(qty);
            item3Amount = LoginController.acrylicPaint.getProductPrice() * qty;

            if (source == choicebox3) {
                item3Amount = LoginController.acrylicPaint.getProductPrice() * qty;
            }

        }

        if (cb4.isSelected() && LoginController.sketchingpaper.getProductStatus()) {

            double qty = Double.parseDouble(choicebox4.getValue());
            LoginController.sketchingpaper.setProductQuantity(qty);
            item4Amount = LoginController.sketchingpaper.getProductPrice() * qty;

            if (source == choicebox4) {
                item4Amount = LoginController.sketchingpaper.getProductPrice() * qty;
            }

        }

        if (cb5.isSelected() && LoginController.canvasPaper.getProductStatus()) {

            double qty = Double.parseDouble(choicebox5.getValue());
            LoginController.canvasPaper.setProductQuantity(qty);
            item5Amount = LoginController.canvasPaper.getProductPrice() * qty;

            if (source == choicebox5) {
                item5Amount = LoginController.canvasPaper.getProductPrice() * qty;
            }

        }

        if (cb6.isSelected() && LoginController.watercolorpaper.getProductStatus()) {

            double qty = Double.parseDouble(choicebox6.getValue());
            LoginController.watercolorpaper.setProductQuantity(qty);
            item6Amount = LoginController.watercolorpaper.getProductPrice() * qty;

            if (source == choicebox6) {
                item6Amount = LoginController.watercolorpaper.getProductPrice() * qty;
            }

        }

        if (cb7.isSelected() && LoginController.angularbrush.getProductStatus()) {

            double qty = Double.parseDouble(choicebox7.getValue());
            LoginController.angularbrush.setProductQuantity(qty);
            item7Amount = LoginController.angularbrush.getProductPrice() * qty;

            if (source == choicebox7) {
                item7Amount = LoginController.angularbrush.getProductPrice() * qty;
            }

        }

        if (cb8.isSelected() && LoginController.flatbrush.getProductStatus()) {

            double qty = Double.parseDouble(choicebox8.getValue());
            LoginController.flatbrush.setProductQuantity(qty);
            item8Amount = LoginController.flatbrush.getProductPrice() * qty;

            if (source == choicebox8) {
                item8Amount = LoginController.flatbrush.getProductPrice() * qty;
            }

        }

        if (cb9.isSelected() && LoginController.roundbrush.getProductStatus()) {

            double qty = Double.parseDouble(choicebox9.getValue());
            LoginController.roundbrush.setProductQuantity(qty);
            item9Amount = LoginController.roundbrush.getProductPrice() * qty;

            if (source == choicebox9) {
                item9Amount = LoginController.roundbrush.getProductPrice() * qty;
            }

        }

        // Compute total amount for all items chosen
        totalAmount = item1Amount + item2Amount + item3Amount + item4Amount + item5Amount +
        item6Amount + item7Amount + item8Amount + item9Amount;

        // Display total amount in total label
        total.setText(Double.toString(totalAmount));
    }


    
    public void getInitialAmount() {

        double totalamount = 0.00;

        // If product is chosen, compute item amount
       
        if (LoginController.watercolor.getProductStatus()) {
            if (LoginController.watercolor.getItemReceiptStatus()){
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

        if (LoginController.sketchingpaper.getProductStatus()) {
            if (cb4.isSelected()){
                totalamount += LoginController.sketchingpaper.getProductPrice();
            }
        }

        if (LoginController.canvasPaper.getProductStatus()) {
            if (cb5.isSelected()){
                totalamount += LoginController.canvasPaper.getProductPrice();
            }
        }

        if (LoginController.watercolorpaper.getProductStatus()) {
            if (cb6.isSelected()){
                totalamount += LoginController.watercolorpaper.getProductPrice();
            }
        }

        if (LoginController.angularbrush.getProductStatus()) {
            if (cb7.isSelected()){
                totalamount += LoginController.angularbrush.getProductPrice();
            }
        }

        if (LoginController.flatbrush.getProductStatus()) {
            if (cb8.isSelected()){
                totalamount += LoginController.flatbrush.getProductPrice();
            }
        }

        if (LoginController.roundbrush.getProductStatus()) {
            if (cb9.isSelected()){
                totalamount += LoginController.roundbrush.getProductPrice();
            }
        }

        total.setText(Double.toString(totalamount));

    }

    public void getItemReceiptStatus(){

        if (LoginController.watercolor.getItemReceiptStatus()) {
            LoginController.receipt.addtoReceipt(LoginController.receiptController.pane1);
        }
        if (LoginController.gouache.getItemReceiptStatus()) {
            LoginController.receipt.addtoReceipt(LoginController.receiptController.pane2);
        }
        if (LoginController.acrylicPaint.getItemReceiptStatus()) {
            LoginController.receipt.addtoReceipt(LoginController.receiptController.pane3);
        }
        if (LoginController.sketchingpaper.getItemReceiptStatus()) {
            LoginController.receipt.addtoReceipt(LoginController.receiptController.pane4);
        }
        if (LoginController.canvasPaper.getItemReceiptStatus()) {
            LoginController.receipt.addtoReceipt(LoginController.receiptController.pane5);
        }
        if (LoginController.watercolorpaper.getItemReceiptStatus()) {
            LoginController.receipt.addtoReceipt(LoginController.receiptController.pane6);
        }
        if (LoginController.angularbrush.getItemReceiptStatus()) {
            LoginController.receipt.addtoReceipt(LoginController.receiptController.pane7);
        }
        if (LoginController.flatbrush.getItemReceiptStatus()) {
            LoginController.receipt.addtoReceipt(LoginController.receiptController.pane8);
        }
        if (LoginController.roundbrush.getItemReceiptStatus()) {
            LoginController.receipt.addtoReceipt(LoginController.receiptController.pane9);
        }

    }

    public void setItemReceiptStatus(ActionEvent event){

        CheckBox checkbox = (CheckBox) event.getSource();

        if(checkbox.equals(cb1)){

            if (LoginController.watercolor.getItemReceiptStatus() == false) {
                LoginController.watercolor.setItemReceiptStatus(true);
            } else {
                LoginController.watercolor.setItemReceiptStatus(false);
            }

            getInitialAmount();
        }
        if(checkbox.equals(cb2)){

            if (LoginController.gouache.getItemReceiptStatus() == false) {
                LoginController.gouache.setItemReceiptStatus(true);
            } else {
                LoginController.gouache.setItemReceiptStatus(false);
            }

            getInitialAmount();
        }
        if(checkbox.equals(cb3)){

            if (LoginController.acrylicPaint.getItemReceiptStatus() == false) {
                LoginController.acrylicPaint.setItemReceiptStatus(true);
            } else {
                LoginController.acrylicPaint.setItemReceiptStatus(false);
            }

            getInitialAmount();
        }
        if(checkbox.equals(cb4)){

            if (LoginController.sketchingpaper.getItemReceiptStatus() == false) {
                LoginController.sketchingpaper.setItemReceiptStatus(true);
            } else {
                LoginController.sketchingpaper.setItemReceiptStatus(false);
            }

            getInitialAmount();
        }
        if(checkbox.equals(cb5)){

            if (LoginController.canvasPaper.getItemReceiptStatus() == false) {
                LoginController.canvasPaper.setItemReceiptStatus(true);
            } else {
                LoginController.canvasPaper.setItemReceiptStatus(false);
            }

            getInitialAmount();
        }
        if(checkbox.equals(cb6)){

            if (LoginController.watercolorpaper.getItemReceiptStatus() == false) {
                LoginController.watercolorpaper.setItemReceiptStatus(true);
            } else {
                LoginController.watercolorpaper.setItemReceiptStatus(false);
            }

            getInitialAmount();
        }
        if(checkbox.equals(cb7)){

            if (LoginController.angularbrush.getItemReceiptStatus() == false) {
                LoginController.angularbrush.setItemReceiptStatus(true);
            } else {
                LoginController.angularbrush.setItemReceiptStatus(false);
            }

            getInitialAmount();
        }
        if(checkbox.equals(cb8)){

            if (LoginController.flatbrush.getItemReceiptStatus() == false) {
                LoginController.flatbrush.setItemReceiptStatus(true);
            } else {
                LoginController.flatbrush.setItemReceiptStatus(false);
            }

            getInitialAmount();
        }
        if(checkbox.equals(cb9)){

            if (LoginController.roundbrush.getItemReceiptStatus() == false) {
                LoginController.roundbrush.setItemReceiptStatus(true);
            } else {
                LoginController.roundbrush.setItemReceiptStatus(false);
            }

            getInitialAmount();
        }
    }

    // Go to Receipt Page
    public void checkout(ActionEvent event) throws IOException {

        getItemReceiptStatus();

        LoginController.receiptController.receiptshowItems(LoginController.receipt.receiptgetItemList());

        LoginController.receiptController.setValues();

        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(LoginController.receiptRoot);
        stage.setScene(scene);
        stage.show();

    }


    // Show all items in ArrayList
    public void showItems(ArrayList<Pane> itemList) {
        for (Pane p : itemList) {
            myvbox.getChildren().add(p);
        }
    }

    

}