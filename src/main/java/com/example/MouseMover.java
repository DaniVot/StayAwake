package com.example;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class MouseMover {
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            while (true) {
                Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
                int x = mouseLocation.x;
                int y = mouseLocation.y;

                // Move the mouse by 1 pixel right and back
                robot.mouseMove(x + 1, y);
                TimeUnit.MILLISECONDS.sleep(500);
                robot.mouseMove(x, y);

                // Wait for 2 minutes
                TimeUnit.MINUTES.sleep(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
