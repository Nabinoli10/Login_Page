package com.example.login_page;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    public TextField User;
    public TextField password;

    @FXML
    private Label welcomeText;

    private static final String STATIC_User = "NABIN";
    private static final String STATIC_password = "8695";
    private int failedAttempts = 0;
    private boolean isLocked = false;

    public void onClick(ActionEvent actionEvent) {
        if (isLocked) {
            welcomeText.setText("Sorry, Your Account is Locked!!!");
            return;
        }

        String x = User.getText();
        String y = password.getText();

        if (x.isEmpty() || y.isEmpty()) {
            welcomeText.setText("Please Provide Username or Password.");
        } else if (!x.matches("^[a-zA-Z\\s]+$")) {
            welcomeText.setText("Invalid username. Please use only letters and spaces.");
        } else {
            if (x.equals(STATIC_User) && y.equals(STATIC_password)) {
                welcomeText.setText("Success!!!");
                failedAttempts = 0; // Reset the counter on successful login
                isLocked = false; // Reset account lock status
            } else {
                failedAttempts++;
                if (failedAttempts >= 5) {
                    isLocked = true;
                    welcomeText.setText("Sorry, Your Account is Locked!!!");
                } else {
                    welcomeText.setText("Sorry, Invalid Username or Password. Attempt " + failedAttempts + " of 5.");
                }
            }
        }
    }
}
