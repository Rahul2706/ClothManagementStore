package screens.userscreen;

import Operations.ErrorHandler;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class MyDesktopPane extends JDesktopPane {

    private Image back_image;

    public MyDesktopPane() {
        try {
            ImageIcon icon;
            icon = new ImageIcon(getClass().getResource("/photos/show.jpg"));
            back_image = icon.getImage();
        } catch (Exception ex) {
            ErrorHandler.showStacktrace(ex);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        if (back_image != null) {
            g.drawImage(back_image, 0, 0, getWidth(), getHeight(), this);
        } else {
            super.paintComponent(g);
        }

    }

}
