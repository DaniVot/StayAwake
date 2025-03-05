# StayAwake

Keeps a machine from going to sleep


### **Use Windows Task Scheduler**
To make the program run automatically on startup:
1. Press `Win + R`, type `taskschd.msc`, and hit **Enter**.
2. Click **Create Basic Task**.
3. Name the task **Mouse Mover** and click **Next**.
4. Choose **When the computer starts** and click **Next**.
5. Select **Start a program**, then click **Next**.
6. Under **Program/script**, browse to your `javaw.exe` location (usually in `C:\Program Files\Java\jdk-XX\bin\javaw.exe`).
7. In the **Add arguments** field, enter:
   ```sh
   -cp path\to\your\script MouseMover
   ```
8. Click **Finish**.

Now, the mouse mover will start automatically when you log in.

---

## **Stopping the Script**

### **Option 1: Stop Manually**
1. Press `Ctrl + Shift + Esc` to open **Task Manager**.
2. Find **java.exe** or **javaw.exe** in the list.
3. Right-click and select **End Task**.

### **Option 2: Remove from Task Scheduler**
1. Open **Task Scheduler**.
2. Locate **Mouse Mover** under **Task Scheduler Library**.
3. Right-click and select **Disable** or **Delete**.

---


