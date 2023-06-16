package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.AngularflatBrush;
import model.FlatBrush;
import model.Gouache;
import model.PosterColors;
import model.RoundBrush;
import model.SketchingPaper;
import model.TonedPaper;
import model.Watercolor;
import model.WatercolorPaper;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LoginController implements Initializable {

    @FXML
    TextField mytextfield;

    @FXML
    PasswordField mypasswordfield;

    @FXML
    Button loginbutton;

    @FXML
    Label mywarninglabel;

    // @FXML
    // HomePageController homepageController = null;

    static Watercolor watercolor = new Watercolor();
    static Gouache gouache = new Gouache();
    static PosterColors postercolor = new PosterColors();
    static AngularflatBrush angularflatbrush = new AngularflatBrush();
    static FlatBrush flatbrush = new FlatBrush();
    static RoundBrush roundbrush = new RoundBrush();
    static SketchingPaper sketchingpaper = new SketchingPaper();
    static TonedPaper tonedpaper = new TonedPaper();
    static WatercolorPaper watercolorpaper = new WatercolorPaper();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //============================Paints==================================//
        
        watercolor.setProductName("Watercolor");
        watercolor.setProductPrice(120);
        watercolor.setProductImage("images/watercolorpic.jpg");

        gouache.setProductName("Gouache");
        gouache.setProductPrice(150);
        gouache.setProductImage("images/gouachepic.jpg");

        postercolor.setProductName("Poster Color");
        postercolor.setProductPrice(70);
        postercolor.setProductImage("images/postercolorpic.jpg");

        //============================Brushes======================================//

        angularflatbrush.setProductName("Angular Flat Brush");
        angularflatbrush.setProductPrice(70);
        angularflatbrush.setProductImage("images/angularflatbrushpic.jpg");

        flatbrush.setProductName("Flat Brush");
        flatbrush.setProductPrice(80);
        flatbrush.setProductImage("images/flatbrushpic.jpg");

        roundbrush.setProductName("Round Brush");
        roundbrush.setProductPrice(60);
        roundbrush.setProductImage("images/roundbrushpic.jpg");

        //===========================Art Papers==============================//

        sketchingpaper.setProductName("Sketching Paper");
        sketchingpaper.setProductPrice(150);
        sketchingpaper.setProductImage("images/sketchingpaperpic.jpg");

        tonedpaper.setProductName("Toned Paper");
        tonedpaper.setProductPrice(90);
        tonedpaper.setProductImage("images/tonedpaperpic.jpg");

        watercolorpaper.setProductName("Watercolor Paper");
        watercolorpaper.setProductPrice(90);
        watercolorpaper.setProductImage("images/watercolorpaperpic.jpg");

        

    }


    public void login(ActionEvent event) throws IOException {

        String username = mytextfield.getText();
        String password = mypasswordfield.getText();

        if (username.equals("a") && password.equals("a")) {

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HomePage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else {
            mywarninglabel.setVisible(true);
        }
    }

   

}