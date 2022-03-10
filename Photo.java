import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.io.*; 
  
public class Photo {
	public File file;
	public double lg;
	public double lt;
	
	public Photo(File file, double lg, double lt){
		this.file=file;
		this.lg=lg;
		this.lt=lt;
	}
}



