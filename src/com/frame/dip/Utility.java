package com.frame.dip;
/** Utility.java
 *  Provides methods to load, save images of different format

		Read Java API for methods defined in BufferedImage and Graphics.
		A good reference for understanding Java Graphics:
		Java 2D Graphics by Jonathan Knudsen, Publisher O'Reilly
 */

import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.*;

import java.awt.image.Raster;

import com.sun.image.codec.jpeg.*;

class Utility {

    private DipFrame dipFrame;
    private JFileChooser chooser;
    private BufferedImage image;

    public Utility(DipFrame dipFrame) { //constructor
        this.dipFrame = dipFrame;
        chooser = new JFileChooser();
    }


    /*
        Use Java FileDialog to open and load an image. People who
	wants to load in images of different format should modify
	the code to use different encoder/decoder.
	Note: the metod so far only recognizes JPG format
    */
    public BufferedImage readImage ( ) {

        int retval = chooser.showOpenDialog(dipFrame);

        if ( retval == JFileChooser.APPROVE_OPTION ) {
            File inFile = chooser.getSelectedFile ( ); //read in file name

            try {
                //Use getPath() instead of getName(), in Forte, the full path to the
                //file is needed.
                FileInputStream in = new FileInputStream( inFile.getPath() ); //create file stream
                JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder ( in ); //Decode JPG
                image = decoder.decodeAsBufferedImage();
                in.close(); //close file stream
            	            }
            catch (Exception e) {
                System.out.println("Error Reading "+ inFile.getName() + " as JPG image\n" );
            }

        }
	else {
            System.out.println( "Error open image to load\n" );
	}//end of if statement

	return image;

    }//end of readImage() method


    /*
        Use Java FileDialog to save an image. People who wants to
	save an images of different format should modify the code
	to use different encoder/decoder.
	Note: the method so far only recognizes JPG format
    */

    public void saveImage( BufferedImage image ) {

    	/*
        if ( image != null ) { //Make sure the image is valid
            int retval = chooser.showSaveDialog(dipFrame);
            if (retval == JFileChooser.APPROVE_OPTION) {
                File outFile = chooser.getSelectedFile();//get a file name

                try {
                    FileOutputStream out = new FileOutputStream( outFile.getPath() );
                    JPEGImageEncoder decoder = JPEGCodec.createJPEGEncoder(out);
                    decoder.encode( image );
                    out.close();
				}
				catch (Exception e) {
                    System.out.println("Error Reading "+ outFile.getName() );
                }
            }
        }
		else {
            System.out.println( "No image has been selected!\n");
		}//end of if statement
		*/

    }// end of saveImage()

}
