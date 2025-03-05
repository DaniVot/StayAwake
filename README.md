# StayAwake

Keeps a machine from going to sleep

## **Running the Program in the Background**

### **Run Without a Console Window**
Instead of `java`, use `javaw` to run the script without a visible console:
```sh
javaw MouseMover
```
This will keep the program running in the background without an open Command Prompt window.

### **Run at Startup Without Admin Privileges**
If you don’t have permission to use Task Scheduler, you can use a simple batch file to start the script automatically:

1. **Create a Batch File**
   - Open **Notepad** and paste this:
     ```sh
     @echo off
     cd /d C:\path\to\your\compiled\file
     start /min javaw MouseMover
     ```
   - Replace `C:\path\to\your\compiled\file` with the actual directory where `MouseMover.class` is located.
   - Save it as `mouse_mover.bat`.

2. **Place the Batch File in the Startup Folder**
   - Press `Win + R`, type `shell:startup`, and hit **Enter**.
   - Copy `mouse_mover.bat` into this folder.

Now, the script will run automatically on startup without requiring administrator privileges.

---

## **Stopping the Script**

### **Option 1: Stop Manually**
1. Press `Ctrl + Shift + Esc` to open **Task Manager**.
2. Find **java.exe** or **javaw.exe** in the list.
3. Right-click and select **End Task**.

### **Option 2: Remove from Startup Folder**
1. Press `Win + R`, type `shell:startup`, and hit **Enter**.
2. Delete `mouse_mover.bat` from the folder.

---

