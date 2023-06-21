package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ReceiptController implements Initializable {

    @FXML
    double item1Amount, item2Amount, item3Amount, item4Amount, item5Amount, item6Amount, item7Amount, item8Amount, item9Amount;

    @FXML
    Label qty1, qty2, qty3, qty4, qty5, qty6, qty7, qty8, qty9, 
    product1, product2, product3, product4, product5, product6, product7, product8, product9, 
    amount1,  amount2,  amount3,  amount4,  amount5,  amount6,  amount7,  amount8,  amount9,
    total;

    @FXML
    VBox myvbox1;

    @FXML
    Pane pane1, pane2, pane3, pane4, pane5, pane6, pane7, pane8, pane9;

    @FXML
    private Stage stage;
            
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //====================================== paints ====================================================
            product1.setText(LoginController.watercolor.getProductName());
            product2.setText(LoginController.gouache.getProductName());
            product3.setText(LoginController.acrylicPaint.getProductName());

        //====================================== artpapers ====================================================
            product4.setText(LoginController.sketchingpaper.getProductName());
            product5.setText(LoginController.canvasPaper.getProductName());
            product6.setText(LoginController.watercolorpaper.getProductName());
        //====================================== brushes ====================================================
            product7.setText(LoginController.angularbrush.getProductName());
            product8.setText(LoginController.flatbrush.getProductName());
            product9.setText(LoginController.roundbrush.getProductName());
    }

    // Show all items in ArrayList
    public void receiptshowItems(ArrayList<Pane> receiptItemList) {
        for (Pane p : receiptItemList) {
            myvbox1.getChildren().add(p);
        }
    }

    public void setValues(){

        // ============================== paints ================================//

        if (LoginController.cartController.cb1.isSelected()) {
            qty1.setText(Double.toString(LoginController.watercolor.getProductQuantity()));
            amount1.setText(Double.toString(LoginController.watercolor.getProductPrice() * LoginController.watercolor.getProductQuantity()));

            item1Amount = LoginController.watercolor.getProductPrice()* LoginController.watercolor.getProductQuantity();

        }

        if (LoginController.cartController.cb2.isSelected()) {
            qty2.setText(Double.toString(LoginController.gouache.getProductQuantity()));
            amount2.setText(Double.toString(LoginController.gouache.getProductPrice() * LoginController.gouache.getProductQuantity()));

            item2Amount = LoginController.gouache.getProductPrice() * LoginController.gouache.getProductQuantity();

        }

        if (LoginController.cartController.cb3.isSelected()) {
            qty3.setText(Double.toString(LoginController.acrylicPaint.getProductQuantity()));
            amount3.setText(Double.toString(LoginController.acrylicPaint.getProductPrice()* LoginController.acrylicPaint.getProductQuantity()));

            item3Amount = LoginController.acrylicPaint.getProductPrice()* LoginController.acrylicPaint.getProductQuantity();

        }

        // ======================== artpapers ===================================//

        if (LoginController.cartController.cb4.isSelected()) {
            qty4.setText(Double.toString(LoginController.sketchingpaper.getProductQuantity()));
            amount4.setText(Double.toString(LoginController.sketchingpaper.getProductPrice()* LoginController.sketchingpaper.getProductQuantity()));

            item4Amount = LoginController.sketchingpaper.getProductPrice()* LoginController.sketchingpaper.getProductQuantity();

        }

        if (LoginController.cartController.cb5.isSelected()) {
            qty5.setText(Double.toString(LoginController.canvasPaper.getProductQuantity()));
            amount5.setText(Double.toString(LoginController.canvasPaper.getProductPrice() * LoginController.canvasPaper.getProductQuantity()));

            item5Amount = LoginController.canvasPaper.getProductPrice()* LoginController.canvasPaper.getProductQuantity();

        }

        if (LoginController.cartController.cb6.isSelected()) {
            qty6.setText(Double.toString(LoginController.watercolorpaper.getProductQuantity()));
            amount6.setText(Double.toString(LoginController.watercolorpaper.getProductPrice()* LoginController.watercolorpaper.getProductQuantity()));

            item6Amount = LoginController.watercolorpaper.getProductPrice()* LoginController.watercolorpaper.getProductQuantity();

        }

        // ==================== brushes ============================================//

        if (LoginController.cartController.cb7.isSelected()) {
            qty7.setText(Double.toString(LoginController.angularbrush.getProductQuantity()));
            amount7.setText(Double.toString(LoginController.angularbrush.getProductPrice()* LoginController.angularbrush.getProductQuantity()));

            item7Amount = LoginController.angularbrush.getProductPrice()* LoginController.angularbrush.getProductQuantity();

        }

        if (LoginController.cartController.cb8.isSelected()) {
            qty8.setText(Double.toString(LoginController.flatbrush.getProductQuantity()));
            amount8.setText(Double.toString(
            LoginController.flatbrush.getProductPrice() * LoginController.flatbrush.getProductQuantity()));

            item8Amount = LoginController.flatbrush.getProductPrice() * LoginController.flatbrush.getProductQuantity();

        }

        if (LoginController.cartController.cb9.isSelected()) {
            qty9.setText(Double.toString(LoginController.roundbrush.getProductQuantity()));
            amount9.setText(Double.toString(
            LoginController.roundbrush.getProductPrice() * LoginController.roundbrush.getProductQuantity()));

            item9Amount = LoginController.roundbrush.getProductPrice()* LoginController.roundbrush.getProductQuantity();

        }

        double final_amount = item1Amount + item2Amount + item3Amount + item4Amount + item5Amount + item6Amount
        + item7Amount + item8Amount + item9Amount;
        total.setText(Double.toString(final_amount));
    }

    // go to logo 
      public void logo(ActionEvent event) throws IOException {

    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HomePage.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
}
