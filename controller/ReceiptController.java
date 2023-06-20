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
import javafx.scene.control.Label;
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
    private Stage stage;
            
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //====================================== paints ====================================================

        if (LoginController.watercolor.getProductStatus()) {
            product1.setText(LoginController.watercolor.getProductName());
            qty1.setText(Double.toString(LoginController.watercolor.getProductQuantity()));
            amount1.setText(Double.toString(LoginController.watercolor.getProductPrice() * LoginController.watercolor.getProductQuantity()));
            
            product1.setVisible(true);
            qty1.setVisible(true);
            amount1.setVisible(true);

            item1Amount = LoginController.watercolor.getProductPrice() * LoginController.watercolor.getProductQuantity();

        }

         if (LoginController.gouache.getProductStatus()) {
            product2.setText(LoginController.gouache.getProductName());
            qty2.setText(Double.toString(LoginController.gouache.getProductQuantity()));
            amount2.setText(Double.toString(LoginController.gouache.getProductPrice() * LoginController.gouache.getProductQuantity()));
            
            product2.setVisible(true);
            qty2.setVisible(true);
            amount2.setVisible(true);

            item2Amount = LoginController.gouache.getProductPrice() * LoginController.gouache.getProductQuantity();

        }

           if (LoginController.acrylicPaint.getProductStatus()) {
            product3.setText(LoginController.acrylicPaint.getProductName());
            qty3.setText(Double.toString(LoginController.acrylicPaint.getProductQuantity()));
            amount3.setText(Double.toString(LoginController.acrylicPaint.getProductPrice() * LoginController.acrylicPaint.getProductQuantity()));
            
            product3.setVisible(true);
            qty3.setVisible(true);
            amount3.setVisible(true);

            item3Amount = LoginController.acrylicPaint.getProductPrice() * LoginController.acrylicPaint.getProductQuantity();

        }

        //====================================== artpapers ====================================================
           
            if (LoginController.sketchingpaper.getProductStatus()) {
            product4.setText(LoginController.sketchingpaper.getProductName());
            qty4.setText(Double.toString(LoginController.sketchingpaper.getProductQuantity()));
            amount4.setText(Double.toString(LoginController.sketchingpaper.getProductPrice() * LoginController.sketchingpaper.getProductQuantity()));
            
            product4.setVisible(true);
            qty4.setVisible(true);
            amount4.setVisible(true);

            item4Amount = LoginController.sketchingpaper.getProductPrice() * LoginController.sketchingpaper.getProductQuantity();

        }

            if (LoginController.canvasPaper.getProductStatus()) {
            product5.setText(LoginController.canvasPaper.getProductName());
            qty5.setText(Double.toString(LoginController.canvasPaper.getProductQuantity()));
            amount5.setText(Double.toString(LoginController.canvasPaper.getProductPrice() * LoginController.canvasPaper.getProductQuantity()));
            
            product5.setVisible(true);
            qty5.setVisible(true);
            amount5.setVisible(true);

            item5Amount = LoginController.canvasPaper.getProductPrice() * LoginController.canvasPaper.getProductQuantity();

        }

          if (LoginController.watercolorpaper.getProductStatus()) {
            product6.setText(LoginController.watercolorpaper.getProductName());
            qty6.setText(Double.toString(LoginController.watercolorpaper.getProductQuantity()));
            amount6.setText(Double.toString(LoginController.watercolorpaper.getProductPrice() * LoginController.watercolorpaper.getProductQuantity()));
            
            product6.setVisible(true);
            qty6.setVisible(true);
            amount6.setVisible(true);

            item6Amount = LoginController.watercolorpaper.getProductPrice() * LoginController.watercolorpaper.getProductQuantity();

        }

        //====================================== brushes ====================================================
        
            if (LoginController.angularbrush.getProductStatus()) {
            product7.setText(LoginController.angularbrush.getProductName());
            qty7.setText(Double.toString(LoginController.angularbrush.getProductQuantity()));
            amount7.setText(Double.toString(LoginController.angularbrush.getProductPrice() * LoginController.angularbrush.getProductQuantity()));
            
            product7.setVisible(true);
            qty7.setVisible(true);
            amount7.setVisible(true);

            item7Amount = LoginController.angularbrush.getProductPrice() * LoginController.angularbrush.getProductQuantity();

        }

            if (LoginController.flatbrush.getProductStatus()) {
            product8.setText(LoginController.flatbrush.getProductName());
            qty8.setText(Double.toString(LoginController.flatbrush.getProductQuantity()));
            amount8.setText(Double.toString(LoginController.flatbrush.getProductPrice() * LoginController.flatbrush.getProductQuantity()));
            
            product8.setVisible(true);
            qty8.setVisible(true);
            amount8.setVisible(true);

            item8Amount = LoginController.flatbrush.getProductPrice() * LoginController.flatbrush.getProductQuantity();

        }

            if (LoginController.roundbrush.getProductStatus()) {
            product9.setText(LoginController.roundbrush.getProductName());
            qty9.setText(Double.toString(LoginController.roundbrush.getProductQuantity()));
            amount9.setText(Double.toString(LoginController.roundbrush.getProductPrice() * LoginController.roundbrush.getProductQuantity()));
            
            product9.setVisible(true);
            qty9.setVisible(true);
            amount9.setVisible(true);

            item9Amount = LoginController.roundbrush.getProductPrice() * LoginController.roundbrush.getProductQuantity();

        }

        double final_amount = item1Amount + item2Amount + item3Amount + item4Amount + item5Amount + item6Amount + item7Amount + item8Amount + item4Amount;
        total.setText(Double.toString(final_amount));
        total.setVisible(true);

        
    }

    public void logo(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/HomePage.fxml"));
        Scene scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
