# Assignment IT212: The Simple Click Counter

## Project Overview

The **Simple Click Counter** is a Java Swing desktop application that displays a window with a button and a label. Each time the user clicks the button, the application increases a counter and updates the label to show the new number of clicks.

This project demonstrates basic GUI programming using Java Swing.

---

## Features

* Simple graphical user interface (GUI)
* Button click detection
* Dynamic label updates
* Uses Java Swing components:

  * `JFrame`
  * `JLabel`
  * `JButton`
  * `ActionListener`
* Uses `FlowLayout` for automatic component positioning

---

## How It Works

1. The program creates a window using `JFrame`.
2. A `JLabel` displays the number of clicks (starting at 0).
3. A `JButton` allows the user to click.
4. An `ActionListener` listens for button clicks.
5. Each time the button is clicked:

   * The counter variable increases by 1
   * The label updates to show the new count

---

## File Structure

```text
SimpleClickCounter/
└── ClickCounter.java
```

---

## How to Run the Program

### Using VS Code

1. Open the `SimpleClickCounter` folder in VS Code
2. Open the file `ClickCounter.java`
3. Click the **Run** button near the `main` method
4. The window will appear

### Using Terminal

1. Navigate to the project folder:

   ```bash
   cd SimpleClickCounter
   ```

2. Compile the program:

   ```bash
   javac ClickCounter.java
   ```

3. Run the program:

   ```bash
   java ClickCounter
   ```

---

## Example Output

* Window title: **My Click Counter**
* Label: **Number of clicks: 0**
* Button: **Click Me!**

Each click updates the label:

```
Number of clicks: 1
Number of clicks: 2
Number of clicks: 3
```

---

## Demo Videos

Replace the links below with your own YouTube videos.

| Demo Type           | Description                                           | Link                     |
| ------------------- | ----------------------------------------------------- | ------------------------ |
| Full Demo           | Shows the application running and clicking the button | https://youtu.be/LL6-csTU7iU |
