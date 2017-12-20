package frogger;

import javax.swing.*;

public class NameInputWindow
{
    private String name;

    public NameInputWindow()
    {
        JFrame frame = new JFrame("Name Input Window");
        name = JOptionPane.showInputDialog(
                frame,
                "Type your name: ",
                "Name Input Window",
                JOptionPane.PLAIN_MESSAGE
        );
    }

    public String get_name() {
        return name;
    }
}