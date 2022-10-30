package game.gui;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class CenteredCard extends JPanel {

    public CenteredCard(Card child) {
        JPanel centeredPanel = new JPanel();
        centeredPanel.setLayout(new BoxLayout(centeredPanel, BoxLayout.Y_AXIS));
        centeredPanel.add(Box.createVerticalGlue());
        centeredPanel.add(child);
        centeredPanel.add(Box.createVerticalGlue());

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(Box.createHorizontalGlue());
        add(centeredPanel);
        add(Box.createHorizontalGlue());

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                child.notifyCardShown();
            }
        });
    }

}
