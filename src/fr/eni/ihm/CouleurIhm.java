package fr.eni.ihm;

import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CouleurIhm extends JFrame {
	private JPanel panneauPrincipal;
	private JLabel label;
	private JButton bRouge;
	private JButton bVert;
	private JButton bBleu;

	
	public CouleurIhm() {
		super("Couleur ");
	
		gestionComposants();//On initialise les différents paramètres
		
		this.setSize(500,200);//Autre maniere de faire une fenêtre rectangulaire en interface graphique
		this.setLocationRelativeTo(null);//position la fenêtre dans l'écran mettre null la positionne au centre
		//this.setResizable(false);//Interdire le redimensionnement de la fenêtre par l'utilisateur
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//On supprime l'instance de la fenêtre 	
	}
	
	private void gestionComposants() {
		//Création des différents éléments dont le panneau dans lequel tout les autres éléments seront intégré
		panneauPrincipal = new JPanel();	
		bRouge = new JButton("Rouge");
		bVert = new JButton("Vert");
		bBleu = new JButton("Bleu");
		this.getContentPane().add(panneauPrincipal);//Renvoyer le panneau courant pour ensuite rajouter dessus le panneau créé
		
		//ajout des différents éléments au panneau
		panneauPrincipal.add(bRouge);
		panneauPrincipal.add(bVert);
		panneauPrincipal.add(bBleu);		
		bRouge.addActionListener(new BoutonRougeActionListener());//détecte un clique sur le bouton nommé Rouge
		bVert.addActionListener(new BoutonVertActionListener());//détecte un clique sur le bouton nommé Vert
		bBleu.addActionListener(new BoutonBleuActionListener());//détecte un clique sur le bouton nommé Bleu
	}
	
	class BoutonRougeActionListener implements ActionListener{//Permet de définir les action à effectueur en fonction de l'action sur le bouton

		@Override
		public void actionPerformed(ActionEvent e) {	
			//e.getSource() permet en le comparant avec un des bouton que c'est bien celui là qui est cliqué.Cela sert si l'on veut regrouper les 3 fonctions BoutonCouleurActionListener en une seule
			panneauPrincipal.setBackground(Color.red);// si l'on mettait le nom de la couleur en majuscule Color.RED ça ne changerait rien, on peut donc l'écrire  à la place si on le souhaite.
													  // par convention on utilise les majuscules pour les constance
		}											  //La différence entre Color.maCouleurEnMinuscule et Color.maCouleurEnMajuscule est que les majuscules le mettent directement alors que les minuscules pointe vers l'équivalent en majuscules(elles font référence à la version en majuscules)
	}
	
	class BoutonVertActionListener implements ActionListener{//Permet de définir les action à effectueur en fonction de l'action sur le bouton

		@Override
		public void actionPerformed(ActionEvent e) {			
			panneauPrincipal.setBackground(Color.green);
		}	
	}
	
	class BoutonBleuActionListener implements ActionListener{//Permet de définir les action à effectueur en fonction de l'action sur le bouton

		@Override
		public void actionPerformed(ActionEvent e) {			
			panneauPrincipal.setBackground(Color.blue);
		}	
	}
}
