import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.awt.GridLayout;
import java.nio.file.*;
import java.util.ArrayList;

public class main {
	public static void main(String[] args) throws IOException {
		Bibliotheque b = new Bibliotheque("C:\\Users\\Elsa Veillon\\Documents\\INSA\\ALGOS4\\PROJETALGO\\LESPHOTOS");
		System.out.println(b.toString());
		
		b.remplirGPS();
		System.out.println(b.toString());
		
	}
}
