package game.gui;

import javax.swing.*;

public class TodoCard extends Card {
    public TodoCard(String description) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(GuiUtils.makeTitle(description));
    }
}
