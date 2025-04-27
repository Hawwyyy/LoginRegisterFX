package org.finalproject.loginregisterfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherAdminController implements Initializable {

    @FXML
    private Label titleLabel;

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Button registerButton;

    @FXML
    private Button backButton;

    @FXML
    private Hyperlink loginLink;

    private String role;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Any initialization code here
    }

    public void setRole(String role) {
        this.role = role;
        // Update the title according to the role
        if (role != null) {
            titleLabel.setText(role + " Registration");
        }
    }

    @FXML
    protected void onRegisterButtonClick() {
        // Validate form
        if (validateForm()) {
            // Process registration
            registerUser();
        }
    }

    @FXML
    protected void onBackButtonClick() {
        try {
            // Navigate back to main registration form
            Parent registrationView = FXMLLoader.load(getClass().getResource("RegisterForm.fxml"));
            Scene registrationScene = new Scene(registrationView);

            Stage currentStage = (Stage) backButton.getScene().getWindow();
            currentStage.setScene(registrationScene);
            currentStage.show();
        } catch (IOException e) {
            showAlert("Navigation Error", "Could not navigate back to main registration form.");
            e.printStackTrace();
        }
    }

    @FXML
    protected void onLoginLinkClick(ActionEvent event) {
        try {
            // Navigate to login screen
            Parent loginView = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
            Scene loginScene = new Scene(loginView);

            Stage currentStage = (Stage) loginLink.getScene().getWindow();
            currentStage.setScene(loginScene);
            currentStage.show();
        } catch (IOException e) {
            showAlert("Navigation Error", "Could not navigate to login page.");
            e.printStackTrace();
        }
    }

    private boolean validateForm() {
        // Basic validation
        if (fullNameField.getText().isEmpty()) {
            showAlert("Validation Error", "Please enter your full name.");
            return false;
        }

        if (emailField.getText().isEmpty() || !emailField.getText().contains("@")) {
            showAlert("Validation Error", "Please enter a valid email address.");
            return false;
        }

        if (phoneField.getText().isEmpty()) {
            showAlert("Validation Error", "Please enter your phone number.");
            return false;
        }

        if (passwordField.getText().isEmpty()) {
            showAlert("Validation Error", "Please enter a password.");
            return false;
        }

        if (!passwordField.getText().equals(confirmPasswordField.getText())) {
            showAlert("Validation Error", "Passwords do not match.");
            return false;
        }

        return true;
    }

    private void registerUser() {
        // Implementation for user registration
        // This would typically involve saving to a database

        showAlert("Success", "Registration successful! You can now login.");

        // Navigate to login screen after successful registration
        onLoginLinkClick(new ActionEvent());
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}