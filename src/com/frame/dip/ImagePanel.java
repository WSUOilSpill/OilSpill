package com.frame.dip;
/** ImagePanel.java
 *  ImagePanel will create an area for displaying an image

		Read Java API for methods defined in BufferedImage and Graphics
 */

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class ImagePanel extends JPanel {

    final int DRAWAREA = 400;
    private BufferedImage image;
    private Graphics2D page2;

    public ImagePanel ( ) {
        setBackground (Color.white);
        setMinimumSize (new Dimension(DRAWAREA, DRAWAREA));
        setPreferredSize (new Dimension(DRAWAREA, DRAWAREA));
    }

    public void paint (Graphics page) {
        page2 = (Graphics2D)page;
        if (image != null) //assure a valid image
            //drawImage(Image img, int x, int y, ImageObserver observer)
            page2.drawImage ( image, 0, 0, null );
    }

    public void setImage (BufferedImage image) {
        this.image = image;
        int width = image.getWidth();
        int height = image.getHeight();
        repaint();
    }

}
