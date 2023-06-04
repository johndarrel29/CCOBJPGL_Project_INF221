package controller;

import java.io.IOException;

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

public class PaintsController {

    @FXML
    Button logo;

    public void initialize (){
        ImageView imageView = new ImageView(getClass().getResource("/images/brush.png").toExternalForm());
        logo.setGraphic(imageView);
        imageView.fitWidthProperty().bind(logo.widthProperty().divide(2));
        imageView.setPreserveRatio(true);
        //Important otherwise button will wrap to text + graphic size (no resizing on scaling).
        logo.setMaxWidth(Double.MAX_VALUE);   
        logo.setPadding(Insets.EMPTY);
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
