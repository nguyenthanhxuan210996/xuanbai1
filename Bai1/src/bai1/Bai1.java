/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.sqrt;
import javax.imageio.ImageIO;

/**
 *
 * @author Nguyen Thanh Xuan
 */
public class Bai1 {

    /**
     * @param args the command line arguments
     */
    public static void join(String inputPath, String outputPath) throws IOException{
        File dicrectory = new File(inputPath); 
        File[] files = dicrectory.listFiles();
        int height;
        int width;
        int size=(int) Math.sqrt(files.length);
        BufferedImage sprite=ImageIO.read(files[0]);
        width= sprite.getWidth()*size;
        height= sprite.getHeight()*size;                
        BufferedImage spritemap = new BufferedImage (width, height,BufferedImage.TYPE_INT_ARGB);// tao sprite map dau ra
        Graphics2D g2d= spritemap.createGraphics();
        int x=0;
	int y=0;
        int count=0;
        
        for(File file:files){
            sprite= ImageIO.read(file);
            g2d.drawImage(sprite,null,x,y);
            count++;
            if (count<size){ 
            x+= sprite.getWidth();
        }
            else{
                count=0;
                x=0;
                y+=sprite.getHeight();
            }
        }

        ImageIO.write(spritemap,"png",new File(outputPath));
        
    }
    
    public static void main(String[] args) {
        try{
            Bai1.join("D://Pokemon","D://KetQua");
        }catch(IOException ex){
            System.err.println(ex.getMessage());
    }
    
    }
}
