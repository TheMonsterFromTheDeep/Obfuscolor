package obfuscolor;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Obfuscolor main class
 * @author TheMonsterFromTheDeep
 */
public class Obfuscolor {
    
    static int frobnicate(int color) {
        Color c = new Color(color, true);
        int blue = c.getBlue();
        blue += (blue < 128 ? 1 : -1);
        return new Color(c.getRed(), c.getGreen(), blue, c.getAlpha()).getRGB();
    }
    
    public static void main(String[] args) {
        if("help".equals(args[0])) {
            System.out.println("Obfuscolor - creates interpolated minor color shifts on an image"
                    + "to prevent usage of basic fill algorithms.\n\n"
                    + "Specify the path to read the image from as the first "
                    + "argument and the path to write the image to as the second argument.\n\n"
                    + "Obfuscolor outputs files in PNG format.");
            System.exit(0);
        }
        if(args.length < 2) {
            System.out.println("Please specify two paths!");
            System.exit(0);
        }
        String imgPath = args[0];
        String writePath = args[1];
        
        BufferedImage base = null;
        
        try {
            base = ImageIO.read(new File(imgPath));
        } catch(IOException e) {
            System.out.println("Error reading input file! " + e.getLocalizedMessage());
            System.exit(0);
        }
        int width = base.getWidth(), height = base.getHeight();
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                if((y + (x % 2)) % 2 == 0) { base.setRGB(x, y, frobnicate(base.getRGB(x, y))); }
            }
        }
        try {
            ImageIO.write(base, "PNG", new File(writePath));
        } catch (IOException e) {
            System.out.println("Error writing obfuscated file! " + e.getLocalizedMessage());
            System.exit(0);
        }
    }
    
}
