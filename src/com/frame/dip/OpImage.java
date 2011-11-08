package com.frame.dip;
/** OpImage.java
 *  It consists of methods for image processing purpose

		Read Java API for methods defined in BufferedImage and Graphics.
		A good reference for understanding Java Graphics:
		Java 2D Graphics by Jonathan Knudsen, Publisher O'Reilly
 */

import java.awt.image.*;

class OpImage {
    private	BufferedImage image;

    public OpImage( ) { //an empty constructor is provided

}


    /*
        Static methods could be invoked without creating an instance of
	OpImage.
    */

    /*
	The averageImage() method processes each pixel of an image,
	divide the intensity of a band by 2
    */
    public static BufferedImage averageImage( BufferedImage image ) {
        int value;
        WritableRaster raster =	image.getRaster();

        try {
            for (int y = 0; y < image.getHeight(); ++y ) //row
                for (int x = 0; x < image.getWidth(); ++x ) //column

                    //Make sure it can handles color images
                    for (int b = 0; b < raster.getNumBands(); ++b )
                    {
                        value =raster.getSample(x, y, b) / 2;
                        raster.setSample(x, y, 0, value);
                    }

        }//end of try
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println( "Error performing averaging \n ");
	}//end of catch

	System.out.println( "Perform averaging \n" );
	return image;

    }//end of averageImage() method

}
