package com.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class MouseMover {
    public static void main(String[] args) {
        if (!SystemTray.isSupported()) {
            System.out.println("System tray not supported!");
            return;
        }

        // Initialize system tray icon
        SystemTray tray = SystemTray.getSystemTray();

        // Get the icon from src/main/resources/images/logoMouse.png
        Image iconImage = new ImageIcon(MouseMover.class.getResource("/images/logoMouse.png")).getImage();

        TrayIcon trayIcon = new TrayIcon(iconImage, "StayAwake Mouse Mover");
        trayIcon.setImageAutoSize(true);

        // Create a popup menu for the tray icon
        PopupMenu popup = new PopupMenu();
        MenuItem exitItem = new MenuItem("Exit");

        // Add an action listener for exit
        exitItem.addActionListener(e -> {
            tray.remove(trayIcon);
            System.exit(0);
        });

        popup.add(exitItem);
        trayIcon.setPopupMenu(popup);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            e.printStackTrace();
            return;
        }

        int moveAmount = 1;

        // Main functionality of the mouse mover
        try {
            Robot robot = new Robot();
            while (true) {
                Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
                int x = mouseLocation.x;
                int y = mouseLocation.y;

                // Move the mouse by 1 pixel
                robot.mouseMove(x + moveAmount, y);

                // Wait for 2 minutes before repeating
                TimeUnit.MINUTES.sleep(2);

                // Flip the direction of the mouse movement
                moveAmount = moveAmount * -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
