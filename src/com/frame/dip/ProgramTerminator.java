package com.frame.dip;
/*****************************************************************
    A ProgramTerminator object terminates the program when its
		main window generates a window closing event.
******************************************************************/

import java.awt.event.*;

class ProgramTerminator implements WindowListener {

    // Window Event Handling
    public void windowClosing( WindowEvent event ) {
        System.exit(0);
    }

    public void windowActivated   (WindowEvent event) { }
    public void windowClosed      (WindowEvent event) { }
    public void windowDeactivated (WindowEvent event) { }
    public void windowDeiconified (WindowEvent event) { }
    public void windowIconified   (WindowEvent event) { }
    public void windowOpened      (WindowEvent event) { }

}
