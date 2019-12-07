package FunctionLibrary;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
 
public class JavaScreenCaptureUtil {
 
    public String takeScreenShot() throws Exception{
 
        /**
         * This class (Robot.java) is used to generate native system input events for the
         * purposes of test automation, self-running demos, and other
         * applications where control of the mouse and keyboard is needed.
         * The primary purpose of Robot is to facilitate automated testing
         * of Java platform implementations.
         */
        Robot robot = new Robot();
         
        /**
         * Get the current screen dimensions.
         */
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        int width = (int) d.getWidth();
        int height = (int) d.getHeight();
         
         
        /**
         * Delay the robot for 5 seconds (5000 ms) allowing you to switch to proper
         * screen/window whose screenshot is to be taken.
         *
         * You can change the delay time as required.
         */
        robot.delay(5000);
         
        /**
         * Create a screen capture of the active window and then create a buffered image
         * to be saved to disk.
         */
        
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_PRINTSCREEN);
        robot.keyRelease(KeyEvent.VK_PRINTSCREEN);
        robot.keyRelease(KeyEvent.VK_ALT);
        
        Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        Image image = null;
//        try {
            if (t != null && t.isDataFlavorSupported(DataFlavor.imageFlavor)) {
                image = (Image)t.getTransferData(DataFlavor.imageFlavor);
            }
//                
//            }
//        } catch (UnsupportedFlavorException e) {
        
//        Image image = robot.createScreenCapture(new Rectangle(0, 0, width,
//                height));
//        
        BufferedImage bi = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        g.drawImage(image, 0, 0, width, height, null);
 
        /**
         * Filename where to save the file to.
         * I am appending formatted timestamp to the filename.
         */
        String fileNameToSaveTo = Global.gstrResultPath+"ScreeenShots/"
                + createTimeStampStr() + ".PNG";
         
        /**
         * Write the captured image to a file.
         * I am using PNG format. You can choose PNG, JPG, GIF.
         */
        writeImage(bi, fileNameToSaveTo, "PNG");
 
        System.out.println("Screen Captured Successfully and Saved to:\n"+fileNameToSaveTo);
 return fileNameToSaveTo;
    }
 
    /**
     * This method writes a buffered image to a file
     *
     * @param img -- > BufferedImage
     * @param fileLocation --> e.g. "C:/testImage.jpg"
     * @param extension --> e.g. "jpg","gif","png"
     */
    public void writeImage(BufferedImage img, String fileLocation,
            String extension) {
        try {
            BufferedImage bi = img;
            File outputfile = new File(fileLocation);
            ImageIO.write(bi, extension, outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    /**
     *
     * @return String representation of timestamp
     * in the format of yyyyMMdd_hhmmss (e.g. 20100426_111612)
     * @throws Exception
     */
    public String createTimeStampStr() throws Exception {
        Calendar mycalendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_hhmmss");
        String timeStamp = formatter.format(mycalendar.getTime());
 
        return timeStamp;
 
    }
}