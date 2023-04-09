package controllers;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

import java.util.Scanner;
import java.io.File;


public class LoginController {

    @FXML
    protected PasswordField PasswordField;
    
    @FXML
    protected Label incorrectLabel;
    
    @FXML
    protected Button loginBtn;
    

	private Stage stage;
	private Scene scene;
	
	/**
	 * Checks if the default password is submitted
	 * @param event
	 * @throws IOException
	 */
    @FXML
    public void Login(ActionEvent event) throws IOException{
        String FilePath = "src/resources/password.txt";
        File file = new File(FilePath);
        
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        
        if(line.equals("p") && PasswordField.getText().equals("p"))
        {
    		Parent root = FXMLLoader.load(getClass().getResource("/controllers/fxml/ChangePassword.fxml"));
    		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();
        }
        
        else if(PasswordField.getText().equals(line))
    	{
    		Parent root = FXMLLoader.load(getClass().getResource("/controllers/fxml/Scene1.fxml"));
    		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();
    	}
        else
        {
        	incorrectLabel.setOpacity(1);
        }
        scanner.close();
    }
}
