
package controller;

import java.io.IOException;
import java.util.ResourceBundle;

import alert.AlertMaker;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.DataStored;
import model.Database;
import model.UserTask;

public class HomePageController implements Initializable {


    @FXML
    Button logoutButton, taskButton, refreshTable;

    @FXML
    Label displayUsername;

    @FXML
    TextArea task_Input;

    @FXML
    TableView<UserTask> displayTaskTable;

    @FXML
    TableColumn<UserTask, String> userTaskList;



    ObservableList<UserTask> TaskList;

    

    Statement statement;
    Connection connect;

  
   //-------------------------------REFRESH---------------------------------------------
    @FXML
    private Button refreshButton;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            displayUser();

            try {
            showTaskList();
        }       catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showTaskList() throws SQLException {
            TaskList = dataTaskList();

            userTaskList.setCellValueFactory(new PropertyValueFactory<UserTask, String>("Task"));
            displayTaskTable.setItems(TaskList);
    }
    
    public void displayUser(){
        //display user
        String user = DataStored.username;
        displayUsername.setText(user.substring(0, 1).toUpperCase() + user.substring(1));
        
    }

    public void refreshTable(ActionEvent event) {
            try {
                showTaskList(); 
        }       catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //-------------------------------DELETE---------------------------------------------

    public void deletetask(ActionEvent event) throws SQLException {
    UserTask selectedTask = displayTaskTable.getSelectionModel().getSelectedItem();
    
    if (selectedTask != null) {
        connect = Database.DBConnect();
        statement = connect.createStatement();
        
        String deleteQuery = "DELETE FROM usertask WHERE Task = '" + selectedTask.getTask() + "'";
        
        try {
            statement.executeUpdate(deleteQuery);
            showTaskList(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } else {
        AlertMaker.showSimpleAlert("Ooops!", "Select a task to delete.");
    }
}

    
    //---------------------------------------------------------------------------------------


    //gumana na..pwede na ulit mag input si user paulit ulit
    public void insertTask()throws SQLException{

        connect = Database.DBConnect();
        statement = connect.createStatement();

        String task = "SELECT Task FROM usertask WHERE Task = '" + task_Input.getText() + "'";
        
        ResultSet result = statement.executeQuery(task);
        
        if (result.next()) {
            AlertMaker.showSimpleAlert("Notifications", "Task is already existing");
        } else {
            String insertTask = "INSERT INTO usertask (Task, Admin) VALUES ('" + task_Input.getText() + "', '" +  DataStored.username + "')";
            statement.executeUpdate(insertTask);
        
        }

    }

    //Retrieval of data from xampp
    public ObservableList<UserTask> dataTaskList() throws SQLException{
        ObservableList<UserTask> DataList = FXCollections.observableArrayList();
    
        String retrieveData = "SELECT * FROM usertask WHERE Admin = '" + DataStored.username + "'";
        connect = Database.DBConnect();
        statement = connect.createStatement();

        try {
            ResultSet result = statement.executeQuery(retrieveData);

            UserTask UT;

            while (result.next()) {
                UT = new UserTask(result.getString("Task"));

                DataList.add(UT);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return DataList;

    }



    //----------------------------Methods for buttons------------------------------------

    public void logout(ActionEvent event)throws IOException{

        System.out.println("Logout method called");

        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SignIn.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        DataStored.clearUsername();

        stage.show();

    }


    


}