package com.frame.dip;
/** DipFrame is a framework coded in Java for image processing class
 *  taught at Winona State University.
 *  @author Mingrui Zhang

 Copyright (C) 2002  Mingrui Zhang

 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public License
 as published by the Free Software Foundation.

 This program is provided to students who are taking image processing
 class as a GUI framework. The framework is provide in a hope that a
 student can customize it for their project.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;


public class DipFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private ImagePanel imagePanel;
    private BufferedImage image;
    private Utility utility;
    private JPanel appPanel;

    /*
        Set up the layout of primary GUI window
    */
    public DipFrame() {
        super ("Image Processing Frame"); //Set title, size and location, etc.
        setSize	(900, 600);
        //setLocation (150, 250);
        setResizable (true);

        utility = new Utility( this ); //Utility may be used to read, save image, etc.
        imagePanel = new ImagePanel ( ); //ImagePanel used for display.

        appPanel = new JPanel ( );
        appPanel.setLayout ( new BorderLayout() );
        appPanel.add ( createMenuBar(), BorderLayout.NORTH );
        appPanel.add ( imagePanel, BorderLayout.SOUTH );

        setContentPane ( appPanel );
        addWindowListener( new ProgramTerminator() );
        setVisible(true);
    } // end of DipFrame() constructor


    /*
	Method to create items on the menu bar.
    */
    private JMenuBar createMenuBar ( ) {
        JMenuItem item;
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
            item = new JMenuItem("Open JPG");    //Open...
            item.addActionListener( new MenuListener() );
            fileMenu.add( item );
            item = new JMenuItem("Save JPG"); //Save As...
            item.addActionListener( new MenuListener() );
            fileMenu.add( item );
            item = new JMenuItem("Quit");       //Quit
            item.addActionListener( new MenuListener() );
            fileMenu.add( item );
        menuBar.add(fileMenu);

        JMenu OperationMenu = new JMenu("Operation");
            item = new JMenuItem("Average");    //Average intensity
            item.addActionListener( new OperationListener() );
            OperationMenu.add( item );
        menuBar.add(OperationMenu);

        return menuBar;
    } //end of createMenuBar()


    /*
 	The following are nested classes to handle event of MenuBar
    */
    class MenuListener implements ActionListener {

	public void actionPerformed(ActionEvent event) {
            String menuName = event.getActionCommand();

            if ( menuName.equals("Quit") ) {
                System.exit(0);
            }
            else if ( menuName.equals("Open JPG") ) {
                //Note: this program can only read, save JPG image so far.
                image = utility.readImage ( );
                imagePanel.setImage ( image );
            }
            else if ( menuName.equals("Save JPG") ) {
		//Note: this program can only read, save JPG image so far.
		utility.saveImage( image );
            }
            else {
		System.out.println("Menu selected\n");
            }

            repaint();
	}//end of actionPerformed()

    }//end of class MenuListener



    class OperationListener implements ActionListener {

       	/*
         * EDIT: This sets the image variable, which makes
         * the save function save the changes. Previously,
         * the image before the changes was saved anyway,
         * and would not have had further transformations
         * applied to it.
         */
        public void actionPerformed(ActionEvent event) {
            String menuName = event.getActionCommand();

            if ( menuName.equals( "Average" ) ) {
                //averageImage is a static method
                image = OpImage.averageImage( image );
            }
            else {
		System.out.println("Menu selected\n");
            }

            imagePanel.setImage( image );
            repaint();
	}//end of actionPerformed()

    }//end of class OperationListenner


    /*
	The main() method of DipFrame
    */
    public static void main (String[] argv) {
	DipFrame dipFrame = new DipFrame( );
	//dipFrame.pack();
	//dipFrame.show();
    }//end of main()

}

