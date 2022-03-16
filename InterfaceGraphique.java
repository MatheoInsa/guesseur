import java.awt.*;

import javax.swing.*;

public class InterfaceGraphique extends JFrame{
	public JPanel principal;
	public JPanel p1;
	public JPanel p2;
	public JPanel p3;
	public JPanel p4;
	
	public JButton indice;
	public JButton charger;
	public JTextField score;
	public JTextField temps;
	
	
	public InterfaceGraphique(){
		super("geoguesseur");
	
		this.setVisible(true);
		this.setSize(1000,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		p2= new JPanel();
		
		
		// Panel droite
		p1= new JPanel(new GridLayout(7,1));
		JLabel l1= new JLabel("Où a été prise cette photo ? Déplacer le curseur ");
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
}
		
		
		
	
