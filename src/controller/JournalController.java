package controller;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Stack;

import alert.AlertMaker;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
// import javafx.fxml.FXMLLoader;
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
import model.UserJournal;
import model.UserJournalMemento;



public class JournalController implements Initializable {


    @FXML
    Button journalButton, delJournalButton, UndoButton1, RedoButton1, toTask;

    @FXML
    Label displayUsername1;

    @FXML
    TextArea journal_Input;

    @FXML
    TableView<UserJournal> displayJournalTable;

    @FXML
    TableColumn<UserJournal, String> userJournalList;

    ObservableList<UserJournal> JournalList;

    Stack<UserJournalMemento> undoStack = new Stack<>();
    Stack<UserJournalMemento> redoStack = new Stack<>();
    

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;


    //ready for designing
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        displayUser();
        myJournalShowData();
        
        try {
            showJournalList();
        } catch (Exception e) {
            e.printStackTrace();
        }


        UndoButton1.setDisable(true);
        RedoButton1.setDisable(true);
    }

    //----------------------------METHODS for display------------------------------------------
    
    public void displayUser(){
        //display user
        String user = DataStored.username;
        displayUsername1.setText(user.substring(0, 1).toUpperCase() + user.substring(1));
        
    }

    
    public void showJournalList() throws SQLException{
        JournalList = dataJournalList();

        userJournalList.setCellValueFactory(new PropertyValueFactory<UserJournal, String>("JournalText"));
        displayJournalTable.setItems(JournalList);
    }


    //---------------------------------------------------------------------------------------


    //gumana na..pwede na ulit mag input si user paulit ulit
    public void insertJournal()throws SQLException{
        connect = Database.DBConnect();
        // statement = connect.createStatement();
        String JournalText = journal_Input.getText();
        String username = DataStored.username;

        if (isDuplicateJournal(JournalText, username)) {
            // Display an alert if duplication is found
            AlertMaker.showSimpleAlert("Duplicate Entry", "This journal entry already exists.");
        } else { 
        String insertJournal = "INSERT INTO journal ( JournalText, Username) VALUES (?,?)";
        try(PreparedStatement preparedStatement = connect.prepareStatement(insertJournal)){
            // preparedStatement.setString(1, "YourTaskValue");
            preparedStatement.setString(1, JournalText);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        
            showJournalList();
            myJournalShowData();

            //save the current state for possible undo action
            undoStack.push(new UserJournalMemento(JournalText));

            //clear the redo stack, as a new action is performed
            redoStack.clear();

            

            // Enable the "Undo" button when a new task is inserted
            UndoButton1.setDisable(false);
            // Disable the "Redo" button when a new action is performed
            RedoButton1.setDisable(true);
            

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }

    private boolean isDuplicateJournal(String journalText, String username) throws SQLException {
        String query = "SELECT COUNT(*) FROM journal WHERE JournalText = ? AND Username = ?";
        try (PreparedStatement preparedStatement = connect.prepareStatement(query)) {
            preparedStatement.setString(1, journalText);
            preparedStatement.setString(2, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;
        }
    }

    public void deleteJournal(ActionEvent event) throws SQLException {
        UserJournal selectedJournal = displayJournalTable.getSelectionModel().getSelectedItem();
        
        if (selectedJournal != null) {
            connect = Database.DBConnect();
            statement = connect.createStatement();
            
            String deleteQuery = "DELETE FROM journal WHERE JournalText = '" + selectedJournal.getJournalText() + "'";
            
            try {
                statement.executeUpdate(deleteQuery);
                showJournalList(); 
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            AlertMaker.showSimpleAlert("Ooops!", "Select a text to delete.");
        }

        myJournalShowData();
    }

    //undo for task
    public void undo1() throws SQLException {
        if (!undoStack.isEmpty()) {
            UserJournalMemento memento = undoStack.pop();
            redoStack.push(memento);
    
            //Delete the task from the database
            connect = Database.DBConnect();
            statement = connect.createStatement();
            String deleteQuery = "DELETE FROM journal WHERE JournalText = '" + memento.getJournal() + "'";
            statement.executeUpdate(deleteQuery);

            // Remove the task from TaskList.
            JournalList.removeIf(journal -> journal.getJournalText().equals(memento.getJournal()));

            // Refresh the table view.
            displayJournalTable.refresh();

            // Disable the "Undo" button when the undoStack is empty
            UndoButton1.setDisable(undoStack.isEmpty());

            // Enable the "Redo" button when an undo is performed
            RedoButton1.setDisable(false);

            myJournalShowData();
        }
    }

    //redo for task
    public void redo1()throws SQLException {
        if (!redoStack.isEmpty()) {
            UserJournalMemento memento = redoStack.pop();
            undoStack.push(memento);
            
            // Insert the task into the database.
            connect = Database.DBConnect();
            statement = connect.createStatement();
            String insertQuery = "INSERT INTO journal (journalText, Username) VALUES ('" + memento.getJournal() + "', '" + DataStored.username + "')";
            statement.executeUpdate(insertQuery);
    
            // Update the TaskList.
            JournalList.add(new UserJournal(memento.getJournal()));
    
            // Refresh the table view.
            displayJournalTable.refresh();

            // Enable the "Undo" button when a redo is performed
            UndoButton1.setDisable(false);

            // Disable the "Redo" button when the redoStack is empty
            RedoButton1.setDisable(redoStack.isEmpty());
            
            myJournalShowData();
        }
    }


    //Retrieval of data from xampp
    public ObservableList<UserJournal> dataJournalList() {
        ObservableList<UserJournal> dataList = FXCollections.observableArrayList();
        
        String retrieveData = "SELECT * FROM journal WHERE Username = '" + DataStored.username + "'";
        
        connect = Database.DBConnect();
        
        try {
            prepare = connect.prepareStatement(retrieveData);
            result = prepare.executeQuery();
        
            UserJournal UJ;
        
            while (result.next()) {
                UJ = new UserJournal(result.getString("JournalText")); // Use "JournalText" here
        
                dataList.add(UJ);
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return dataList;
    }

    public void ToTask(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HomePage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    

    private ObservableList<UserJournal> myJournalData;

    public void myJournalShowData() {
        myJournalData = dataJournalList();
    
        userJournalList.setCellValueFactory(new PropertyValueFactory<>("journalText"));
    
        displayJournalTable.setItems(myJournalData);
    }
    

    
    


    

}