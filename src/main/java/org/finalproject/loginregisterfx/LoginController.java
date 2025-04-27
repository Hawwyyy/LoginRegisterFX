package org.finalproject.loginregisterfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private CheckBox rememberMeBox;

    @FXML
    private Hyperlink forgotPasswordLink;

    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink registerLink;

    @FXML
    void initialize() {

        loginButton.setCursor(Cursor.HAND); // In LoginController

        // Set styling for focus effect with updated styling
        usernameField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                usernameField.setStyle("-fx-background-radius: 8; -fx-border-radius: 8; -fx-border-color: #1976D2; -fx-border-width: 2px; -fx-padding: 0 15;");
            } else {
                usernameField.setStyle("-fx-background-radius: 8; -fx-border-radius: 8; -fx-border-color: #dcdcdc; -fx-border-width: 1px; -fx-padding: 0 15;");
            }
        });

        passwordField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                passwordField.setStyle("-fx-background-radius: 8; -fx-border-radius: 8; -fx-border-color: #1976D2; -fx-border-width: 2px; -fx-padding: 0 15;");
            } else {
                passwordField.setStyle("-fx-background-radius: 8; -fx-border-radius: 8; -fx-border-color: #dcdcdc; -fx-border-width: 1px; -fx-padding: 0 15;");
            }
        });

        // Button hover effect with updated styling
        loginButton.setOnMouseEntered(e -> loginButton.setStyle("-fx-background-color: #1565C0; -fx-background-radius: 8; -fx-text-fill: white;"));
        loginButton.setOnMouseExited(e -> loginButton.setStyle("-fx-background-color: #1976D2; -fx-background-radius: 8; -fx-text-fill: white;"));
    }

    @FXML
    protected void onLoginButtonClick() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Basic validation
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Username and password must not be empty");
            return;
        }

        // Add your authentication logic here
        System.out.println("Login attempt with username: " + username);

        // For testing purposes - normally you would check credentials in a database
        boolean loginSuccessful = true;

        if (loginSuccessful) {
            // Here you would navigate to your main application screen
            System.out.println("Login successful");
        }
    }

    @FXML
    protected void onRegisterLinkClick(ActionEvent event) {
        try {
            // Close current window
            Stage currentStage = (Stage) registerLink.getScene().getWindow();
            currentStage.close();

            // Open registration form
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("RegisterForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 720, 650);
            Stage registerStage = new Stage();
            registerStage.setTitle("Registration Form");
            registerStage.setScene(scene);
            registerStage.setResizable(false);
            registerStage.show();
            registerStage.centerOnScreen();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onForgotPasswordClick(ActionEvent event) {
        // Implement forgot password functionality
        System.out.println("Forgot password clicked");
        // You could open a dialog or navigate to a password reset screen
    }
}