import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.awt.GridLayout;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Bibliotheque {
	
	public ArrayList<Photo> photos = new ArrayList<Photo>();
	public String path;
	
	//constructeur
	public Bibliotheque(String s){
		this.path=s;
		File dossier = new File(s);
		File[] list = dossier.listFiles();
		for(File item : list){
			photos.add(new Photo(item,1,1));
		}
	}
	
	public void remplirGPS(){
		for(Photo p : photos){
			System.out.print(p.file.getName()+" : ");
			Scanner k1 = new Scanner(System.in);
			System.out.println("quelle longitude?");
			double lg = (double)k1.nextDouble();
			p.lg = lg;
			
			Scanner k2 = new Scanner(System.in);
			System.out.println("quelle latitude?");
			double lt = (double)k2.nextDouble();
			p.lt = lt;
		}
		System.out.println("Fini ! Toutes les coordonnées ont été rentrées");
	}
	
	public String toString(){
		String s = "";
		File dossier = new File(path);
		File[] list = dossier.listFiles();
		for(File item : list){
			s=s+"\n"+item.getName();
		}
		return s;
	}
}
