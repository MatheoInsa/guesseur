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
	public double x;
	public double y;
	public boolean utilise;
	
	public Photo(File file, double x, double y){
		this.file=file;
		this.x=x;
		this.y=y;
		this.utilise=false;
	}
		
	public void compareGPS(double x2, double y2){
		double eps1 = 1E-4;
		double eps2 = 1E-2;
		double eps3 = 1E-1;
		
		double distancex = (Math.abs(x2-this.x))*111195;
		double distancey = (Math.abs(y2-this.y))*111195;
		double distance = Math.sqrt((distancex)*(distancex)+(distancey)*(distancey));

		
		if(Math.abs(x2-this.x)<eps1 && Math.abs(y2-this.y)<eps1){
			System.out.println(" clic : "+x2+" - "+y2+" - vraies coordonnées : "+this.x+" - "+this.y+" : victoire");
		} else if(Math.abs(x2-this.x)<eps2 && Math.abs(y2-this.y)<eps2){
			System.out.println(" clic : "+x2+" - "+y2+" - vraies coordonnées : "+this.x+" - "+this.y+" : pas mal");
		}else if(Math.abs(x2-this.x)<eps3 && Math.abs(y2-this.y)<eps3){
			System.out.println(" clic : "+x2+" - "+y2+" - vraies coordonnées : "+this.x+" - "+this.y+" : t'es loin");
		} else {
			System.out.println(" clic : "+x2+" - "+y2+" - vraies coordonnées : "+this.x+" - "+this.y+" : t'es sur le meme continent bien joue bg");
		}
		System.out.println("tu es a "+distance);
	}

}

