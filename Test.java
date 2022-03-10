import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.awt.GridLayout;

public class Test{
	public static void main(String[] args) throws IOException {
		
	File file1 = new File("C:\\Users\\Elsa Veillon\\Documents\\INSA\\ALGOS4\\PROJETALGO\\LESPHOTOS\\photo1.jpg");
	File file2 = new File("C:\\Users\\Elsa Veillon\\Documents\\INSA\\ALGOS4\\PROJETALGO\\LESPHOTOS\\photo2.jpg");
	File file3 = new File("C:\\Users\\Elsa Veillon\\Documents\\INSA\\ALGOS4\\PROJETALGO\\LESPHOTOS\\photo3.jpg");
	
	Photo p1 = new Photo(file1, 48.09280, 34.7289);
	Photo p2 = new Photo(file2, 4.829827, 0.783922);
	Photo p3 = new Photo(file3, 6.728929, 23.37783);
	
	BufferedImage bufferedImage = ImageIO.read(p1.file);
	ImageIcon imageIcon = new ImageIcon(bufferedImage);
	JFrame jFrame = new JFrame();
	jFrame.setLayout(new GridLayout()); 
	jFrame.setSize(500, 500);
	
	JLabel img = new JLabel();
	JLabel txt = new JLabel();
	
	txt.setText(" longitude : "+p1.lg+" - latitude : "+p1.lt);
	img.setIcon(imageIcon);
	
	jFrame.add(img);
	jFrame.add(txt);
	
	jFrame.setVisible(true);
	jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}

