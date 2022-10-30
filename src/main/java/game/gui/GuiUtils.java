package game.gui;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public final class GuiUtils {

    public static JButton makeButton(String title, Color color) {
        JButton button = new JButton(title);
        button.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        button.setBorder(new CompoundBorder(new LineBorder(color), new EmptyBorder(5, 10, 5, 10)));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }

    public static JLabel makeLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    public static JTextField makeTextField(int columns) {
        JTextField textField = new JTextField();
        textField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        textField.setColumns(columns);
        textField.setMaximumSize(textField.getPreferredSize());
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        return textField;
    }

    public static JLabel makeTitle(String title) {
        return makeTitle(title, 18);
    }

    public static JLabel makeTitle(String title, int size) {
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, size));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return titleLabel;
    }
}
