import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import java.util.Random;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;


public class InterfaceGraphique extends JFrame implements MouseListener {
	public JPanel principal;
	public JPanel p1;
	public JPanel p2;
	public JPanel p3;
	public JPanel p4;
	
	public JButton indice;
	public JButton charger;
	public JButton valider;
	
	public JTextField score;
	public JTextField temps;
	
	public JLabel l1 = new JLabel("");
	public JLabel img2;
	
	public int x;
	public int y;
	public int xF;
	public int yF;
	
	public Bibliotheque b;
	
	
	public InterfaceGraphique(){
		super("geoguesseur");
		
		b=new Bibliotheque("photos");
		
		File carte = new File("carte2.JPG");
						try{

		BufferedImage bufferedImage2 = ImageIO.read(carte);
		ImageIcon imageIcon2 = new ImageIcon(bufferedImage2);
		ImageIcon scaledImage2 = new ImageIcon(imageIcon2.getImage().getScaledInstance(720, 360, Image.SCALE_DEFAULT));
		img2 = new JLabel(imageIcon2);
		img2.setIcon(scaledImage2);
			} catch(IOException e){
      System.out.println("Error: "+e);
  }

		
		this.setVisible(true);
		this.setSize(1000,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int m = (int) ((Math.random() * (b.photos.size() - 1)) + 1);
		p3 = new JPanel();
		
		int i=1;

		for(Photo p : b.photos){		
			if (i==m){
				try{
					System.out.println(i);
					BufferedImage bufferedImage = ImageIO.read(p.file);
					ImageIcon imageIcon = new ImageIcon(bufferedImage);
					ImageIcon scaledImage = new ImageIcon(imageIcon.getImage().getScaledInstance(720, 360, Image.SCALE_DEFAULT));
					JLabel img = new JLabel(imageIcon);
					img.setIcon(scaledImage);
					p3.add(img);
			} catch(IOException e){
      System.out.println("Error: "+e);
  }
    }
    i++;
		}
		
		p2= new JPanel(new GridLayout(2,1));
		p2.add(p3);
		p4= new JPanel();
		p4.add(img2);
		p2.add(p4);
		p4.addMouseListener(this);  
		
		
		// Panel droite
		p1= new JPanel(new GridLayout(8,1));
		l1.setText("Où a été prise cette photo ? Déplacer le curseur ");
		p1.add(l1);
		indice =new JButton("Obtenir un indice");
		p1.add(indice);
		charger = new JButton("Je ne sais pas! Charger une nouvelle photo");
		p1.add(charger);
		JLabel l2 = new JLabel("Total score");
		p1.add(l2);
		score = new JTextField (5);
		p1.add(score);
		JLabel l3 = new JLabel("Temps écoulé");
		p1.add(l3);
		temps = new JTextField (5);
		p1.add(temps);
		
		valider = new JButton("Valider la position");
		p1.add(valider);
		valider.addActionListener(new EcouteurValider(this));
		
		
		add(p2,BorderLayout.CENTER);
		add(p1,BorderLayout.EAST);
		
		
			
		
	}
	

	public static void main (String[] args){
		InterfaceGraphique i1 = new InterfaceGraphique();
	}
	public void paint(Graphics g){
        super.paint(g);
        g=p4.getGraphics();
        g.setColor(Color.BLUE);
        g.fillOval(x-5, y-5, 10, 10);
    }
    public void mouseClicked(MouseEvent e) { 
		x = e.getX();
        y = e.getY();
        repaint();      
    }

    
    public void mouseEntered(MouseEvent e) {  
        l1.setText("Mouse Entered");  
    }  
    public void mouseExited(MouseEvent e) {  
        l1.setText("Mouse Exited");  
    }  
    public void mousePressed(MouseEvent e) {  
        l1.setText("Mouse Pressed");  
    }  
    public void mouseReleased(MouseEvent e) {  
        l1.setText("Mouse Released");  
    }  
	
	public void ecouteValider(){
		xF=x;
		yF=y;
		System.out.println(xF+" "+yF);
	}
	
	
}
