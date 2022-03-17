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
	public int x;
	public int y;
	
	public Photo(File file, int x, int y){
		this.file=file;
		this.x=x;
		this.y=y;
	}
	
	public String compareGPS(int x2, int y2){
		String s = "";
		double eps1 = 1E-6;
		double eps2 = 1E-3;
		double eps3 = 1E-1;
		
		if(Math.abs(x2-this.x)<eps1 && Math.abs(y2-this.y)<eps1){
			s="victoire";
		}
		if(Math.abs(x2-this.x)<eps2 && Math.abs(y2-this.y)<eps2){
			s="pas mal";
		}
		if(Math.abs(x2-this.x)<eps3 && Math.abs(y2-this.y)<eps3){
			s="un peu loin comem";
		} else {
			s="non";
		}
		return s;
	}

}



