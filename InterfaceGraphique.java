import java.awt.*;

import javax.swing.*;

public class InterfaceGraphique extends JFrame{
	public JPanel principal;
	public JPanel p1;
	public JPanel p2;
	
	public JButton indice;
	public JButton charger;
	public JTextField score;
	public JTextField temps;
	
	
	public InterfaceGraphique(){
		
		this.setVisible(true);
		this.setSize(1500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		principal =new JPanel( new BorderLayout());
		add(principal);
		
		p1= new JPanel();
		principal.add(p1,BorderLayout.EAST);
		
		JLabel l1= new JLabel("Où a été prise cette photo ? \n Déplacer le curseur sur la carte");
		p1.add(l1);
		
		indice =new JButton("Obtenir un indice");
		p1.add(indice);
		
		charger = new JButton("Je ne sais pas! Charger une nouvelle photo");
		p1.add(charger);
		
		JLabel l2 = new JLabel("Total score");
		p1.add(l2);
		
		score = new JTextField (5);
		p1.add(score);
		
		JLabel l3 = new JLabel("temps écoulé");
		p1.add(l3);
		
		temps = new JTextField (5);
		p1.add(temps);
		
		
		p2= new JPanel();
		principal.add(p2,BorderLayout.CENTER);
		
	}

	public static void main (String[] args){
		InterfaceGraphique i1 = new InterfaceGraphique();
	}
}
		
		
		
	
