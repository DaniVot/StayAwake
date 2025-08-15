package com.example;

import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
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

        // Mouse mover / key presser logic
        try {
            Robot robot = new Robot();
            while (true) {
                Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
                int x = mouseLocation.x;
                int y = mouseLocation.y;

                // Move the mouse by 1 pixel
                robot.mouseMove(x + moveAmount, y);

                // Simulate a key press
                robot.keyPress(KeyEvent.VK_SCROLL_LOCK);
                robot.keyRelease(KeyEvent.VK_SCROLL_LOCK);

                // Wait for a random time between 1.5 to 2 minutes
                // Get integer between 90 and 120 seconds
                int waitTime = (int) (Math.random() * 30 + 90);
                TimeUnit.SECONDS.sleep(waitTime);

                // Flip the direction of the mouse movement
                moveAmount = moveAmount * -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
