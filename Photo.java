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
	
	public String compareGPS(double lg2, double lt2){
		String s = "";
		double eps1 = 1E-6;
		double eps2 = 1E-3;
		double eps3 = 1E-1;
		
		if(Math.abs(lg2-this.lg)<eps1 && Math.abs(lt2-this.lt)<eps1){
			s="victoire";
		}
		if(Math.abs(lg2-this.lg)<eps2 && Math.abs(lt2-this.lt)<eps2){
			s="pas mal";
		}
		if(Math.abs(lg2-this.lg)<eps3 && Math.abs(lt2-this.lt)<eps3){
			s="un peu loin comem";
		} else {
			s="non";
		}
		return s;
	}

}



