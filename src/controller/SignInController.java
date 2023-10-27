package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import alert.AlertMaker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.DataStored;
import model.Database;


public class SignInController implements Initializable{
    
    @FXML
    TextField loginUsername, InsertUsername;

    @FXML
    PasswordField loginPassword, InsertPassword;

    @FXML
    Pane loginPane, signUpPane;

    @FXML
    Button createAccountButton, loginButton = new Button();

    @FXML
    Hyperlink goToSignup, goToLogin;

    @FXML
    FXMLLoader loader;

    Statement statement;
    Connection connect;



    public void signup(ActionEvent event)throws IOException, SQLException{
        insertDB();
    }


  

    //Insert username and password to database, basically signup feature
    public void insertDB() throws SQLException{
        String insertAccount = "INSERT INTO `account` (`Username`, `Password`) VALUES ('"+ InsertUsername.getText() +"', '"+ InsertPassword.getText()+"')";
        
        connect = Database.DBConnect();
        statement = connect.createStatement();

        try {
            if (InsertUsername.getText().isEmpty() || InsertPassword.getText().isEmpty()) {
                AlertMaker.showErrorAlert("Error", "Account cannot be blanked!");
                
            } else {

                String checkUsername = "select Username from account where Username = '" + InsertUsername.getText() + "'";
                ResultSet result = statement.executeQuery(checkUsername);

                if (result.next()) {
                    AlertMaker.showErrorAlert("Notification!", "Username taken");
                } else {
                    statement.executeUpdate(insertAccount);
                    AlertMaker.showSuccessfulAlert("Successfully Added!", "Account Insert, Successful!");
                    System.out.println("Inserted Account");
                    signUpPane.setVisible(false);
                    loginPane.setVisible(true);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            AlertMaker.showSimpleAlert("Notification!", "Error");
            
        }

    }



    //Login Feature..chinecheck muna kung yung account is existing na
    public void CheckLogin(ActionEvent event) throws SQLException, IOException{
        
        String selectAccount = "SELECT Username, Password from `account` where Username = '" + loginUsername.getText() + "' and password = '" + loginPassword.getText() + "'";
        
        connect = Database.DBConnect();
        statement = connect.createStatement();

        try {
            ResultSet result = statement.executeQuery(selectAccount);

            if (loginUsername.getText().isEmpty() || loginPassword.getText().isEmpty()) {
                AlertMaker.showErrorAlert("Notification!", "Cannot be blanked");
            } else {

                if (result.next()) {
                    String logUsername = result.getString(1);
                    String logPassword = result.getString(2);

                    DataStored.username = loginUsername.getText();

                    if (logUsername.equals(loginUsername.getText()) && logPassword.equals(loginPassword.getText())) {

                        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HomePage.fxml"));
                        Parent root = loader.load();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }
                } else {
                    AlertMaker.showErrorAlert("Notification!", "Wrong password or username");
                }

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    //switch pane of login and signup
    public void switchPane(ActionEvent event){
    
        if (event.getSource() == goToSignup) {
            signUpPane.setVisible(true);
            loginPane.setVisible(false);
        } else if (event.getSource() == goToLogin) {
            signUpPane.setVisible(false);
            loginPane.setVisible(true);
        }
    }

    //ready for designing
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        

    }



}