package co.edu.uptc.views;

import javax.swing.*;

public class IoManager {
    private static final String ERROR_MESSAGE = "Error";

    public static void showGraphicMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE);
    }
}
