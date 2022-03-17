import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class InterfaceGraphique extends JFrame implements MouseListener {
	public JPanel principal;
	public JPanel p1;
	public JPanel p2;
	public JPanel p3;
	public JPanel p4;
	
	public JButton indice;
	public JButton charger;
	public JTextField score;
	public JTextField temps;
	
	public JLabel l1;
	
	
	public InterfaceGraphique(){
		super("geoguesseur");
		addMouseListener(this);  

	
		this.setVisible(true);
		this.setSize(1000,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		p2= new JPanel(new GridLayout(2,1));
		p3 = new JPanel();
		p3.setBackground(Color.BLUE);
		p2.add(p3);
		p4= new JPanel();
		p4.setBackground(Color.RED);
		p2.add(p4);

		
		
		// Panel droite
		p1= new JPanel(new GridLayout(7,1));
		l1= new JLabel("Où a été prise cette photo ? Déplacer le curseur ");
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
		
		
		
		
		add(p2,BorderLayout.CENTER);
		add(p1,BorderLayout.EAST);
		
		
			
		
	}

	public static void main (String[] args){
		InterfaceGraphique i1 = new InterfaceGraphique();
	}
	
	public void mouseClicked(MouseEvent e) {  
        l1.setText("Mouse Clicked");  
        Graphics g=getGraphics();  
        g.setColor(Color.BLUE);  
        g.fillOval(e.getX(),e.getY(),30,30);  
        System.out.println("x"+e.getX() + "y"+e.getY());
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
	
	
	
}
		
		
		
	
