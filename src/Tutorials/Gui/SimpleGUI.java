package Tutorials.Gui;
import javax.swing.*; //For GUI components like frames and buttons
import java.awt.*;  //for layout and basic graphics
import java.awt.event.*; //for handling user interactions(events)


public class SimpleGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My First GUI");  // Title of the window
        frame.setSize(400, 300);  // Width and height in pixels
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit app when window closes
        JLabel label = new JLabel("Enter your name:");  // A text label
        JTextField textField = new JTextField(20);  // A text input field (20 columns wide)
        JButton button = new JButton("Submit");  // A clickable button


        // Add them to the frame's content pane
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.setLayout(new GridLayout(3, 1));  // 3 rows, 1 column

        contentPane.add(label);
        contentPane.add(textField);
        contentPane.add(button);

        frame.setVisible(true);  // Make the window visible
    }
}

