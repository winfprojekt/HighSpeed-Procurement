package application;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;



public class Controller {
    @FXML
    private Text actiontarget;
    
    @FXML
    private Text actiontarget2;
    
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameTextbox;
    
    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
    
    
        if (!passwordField.getText().equals("admin") || !usernameTextbox.getText().equals("admin")) {
            actiontarget.setText("Failed to Authenticate");
        } else
            actiontarget2.setText("Success!");
    }
    
    @FXML
    protected void resetSubmitButtonAction(MouseEvent event) {
            actiontarget.setText(" ");
            actiontarget2.setText(" ");
    }
}
    