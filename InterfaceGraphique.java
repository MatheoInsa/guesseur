import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import java.util.Random;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.SwingUtilities;


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
	
	public JLabel l1;
	public JLabel carte;

	
	public Bibliotheque b;
	public Photo photoactuelle;
	public int points = 0;
	
	private int x;
	private int y;
	public int xF;
	public int yF;


	
	
	public InterfaceGraphique(){
		
		super("geoguesseur");
		addMouseListener(this);  
		this.setVisible(true);
		this.setSize(900,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		p1 = new JPanel(new GridLayout(8,1));
		p3 = new JPanel();
		p2 = new JPanel(new GridLayout(2,1));
		p4 = new JPanel();
		
		b=new Bibliotheque("LESPHOTOS");
		File f = new File("carte2.jpg");

		p2.add(p3);	
		p2.add(p4);

		
		add(p2,BorderLayout.CENTER);
		add(p1,BorderLayout.EAST);


		try{
			BufferedImage bufferedImage2 = ImageIO.read(f);
			ImageIcon imageIcon2 = new ImageIcon(bufferedImage2);
			ImageIcon scaledImage2 = new ImageIcon(imageIcon2.getImage().getScaledInstance(p4.getHeight(),p4.getWidth(), Image.SCALE_DEFAULT));
			carte = new JLabel(imageIcon2);
			carte.setIcon(scaledImage2);
			} catch(IOException e){
				System.out.println("Error: "+e);
			}

		p4.add(carte);

		
		int m = (int)((Math.random()*(b.photos.size()-1))+1);
		int i=1;

		for(Photo p : b.photos){		
			if (i==m){
				try{
					BufferedImage bufferedImage = ImageIO.read(p.file);
					ImageIcon imageIcon = new ImageIcon(bufferedImage);
					ImageIcon scaledImage = new ImageIcon(imageIcon.getImage().getScaledInstance(720, 360, Image.SCALE_DEFAULT));
					JLabel img = new JLabel(imageIcon);
					img.setIcon(scaledImage);
					p3.add(img);
					photoactuelle = p;
					p.utilise=true;
					
					} catch(IOException e){
						System.out.println("Error: "+e);
						}
						}
						i++;
						}
		
		
		// Panel droite
		l1 = new JLabel("Où a été prise cette photo ? Clique sur la carte ");
		p1.add(l1);
		
		indice =new JButton("Obtenir un indice");
		p1.add(indice);
		indice.addActionListener(new EcouteurIndice(this));
		
		charger = new JButton("Je ne sais pas! Charger une nouvelle photo");
		p1.add(charger);
		charger.addActionListener(new EcouteurCharger(this));
		
		JLabel l2 = new JLabel("Total score");
		p1.add(l2);
		
		score = new JTextField (5);
		score.setEditable(false);
		p1.add(score);
		
		JLabel l3 = new JLabel("Temps écoulé");
		p1.add(l3);
		
		temps = new JTextField (5);
		temps.setEditable(false);
		p1.add(temps);
		
		valider = new JButton("Valider la position");
		p1.add(valider);
		valider.addActionListener(new EcouteurValider(this));
		
		
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

@Override
    public void mouseClicked(MouseEvent e) { 
		this.x = e.getX();
        this.y = e.getY();        
        
        System.out.println(x+" - "+y);
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
        if(y>=p4.getHeight() && x<=p2.getWidth()){ //on pourrait rajouter quelque chose pour que si on clique en dehors, ca clique sur la meme ligne mais dans le panel

		xF=x;
		yF=y;
		System.out.println(xF+" "+yF);
		System.out.println(this.convertirX()+" - "+this.convertirY());
		photoactuelle.compareGPS(this.convertirY(), this.convertirX());
	}
	}
	
    
    public void indice(){
		JPanel zoneindice = new JPanel();
		zoneindice.setBackground(new Color(0,100, 0, 50));
		zoneindice.setBounds(1000, 100, 400, 400);
		p3.add(zoneindice);
}

	public void charger(){
		int m = (int)((Math.random()*(b.photos.size()-1))+1);
		int i=1;
		
		for(Photo p : b.photos){		
			if (i==m && p.utilise==false){ //gerer le fait que ça ne peut pas etre la meme
				try{
					System.out.println(i);
					BufferedImage bufferedImage = ImageIO.read(p.file);
					ImageIcon imageIcon = new ImageIcon(bufferedImage);
					ImageIcon scaledImage = new ImageIcon(imageIcon.getImage().getScaledInstance(720, 360, Image.SCALE_DEFAULT));
					JLabel img = new JLabel(imageIcon);
					img.setIcon(scaledImage);
					p3.removeAll();
					p3.add(img);
					photoactuelle = p;
					p.utilise=true;
					points = points - 10;
					score.setText(""+points);
					} catch(IOException e){
						System.out.println("Error: "+e);
						}
						}
						i++;
						}
						validate();
						repaint();
		
	}
	
	public double convertirX(){
		double aF = ( (double)xF - 8)/ (610 - 8 ) * ( 4.887425 - 4.868898 ) + 4.868898 ;
														// xI est les coordones du point en haut a gauche et xO en bas a droite
														// aI est les coordones en alt, latitude en haut a gauche et aO en bas a droite    
				return aF;
			}
		
	
				
		public double convertirY(){
				double bF = ( (double)yF - 367 )/(367 - 685 ) * ( 45.788118 - 45.780469 ) + 45.788118;
																																   
				return bF;
		}
	}

