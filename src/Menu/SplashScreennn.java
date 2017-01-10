/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;
import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import darkomj.Midlet;

/**
 *
 * @author maher
 */
public class SplashScreennn extends Canvas implements Runnable{
    private Image mImage;
    private Midlet Midlet;
    /**
     * The constructor attempts to load the named image and begins a timeout
     * thread. The splash screen can be dismissed with a key press,
     * a pointer press, or a timeout
     * @param Midlet instance of MIDlet
     */
    public SplashScreennn(Midlet Midlet){
        this.Midlet = Midlet;
        try{
        mImage = Image.createImage("/Images/splash3.jpg");
        Thread t = new Thread(this);
        t.start();
            System.out.println("maher");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

   

    protected void paint(Graphics g) {
    int width = getWidth();
        int height = getHeight();
        //set background color to overdraw what ever was previously displayed
        g.setColor(0x000000);
        g.fillRect(0,0, width, height);
        g.drawImage(mImage, width / 2, height / 2,
                Graphics.HCENTER | Graphics.VCENTER);    }
    
    public void dismiss() {
        if (isShown())
            Display.getDisplay(Midlet).setCurrent(new SplashScreenn(Midlet));

    }

    public void run() {
    try {
            Thread.sleep(1000);//set for 1 seconds
        }
        catch (InterruptedException e) {
            System.out.println("InterruptedException");
            e.printStackTrace();
        }
        dismiss();  
    }
    /**
     * A key release event triggers the dismiss()
     * method to be called.
     */

}
