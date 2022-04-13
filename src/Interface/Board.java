package Interface;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import simcity.Appartement;
import simcity.Bibliotheque;
import simcity.ChateauEau;
import simcity.Ecole;
import simcity.Eolienne;
import simcity.ExtracteurFer;
import simcity.GrandeMaison;
import simcity.Immeuble;
import simcity.Nucleaire;
import simcity.PanneauSolaire;
import simcity.PetiteMaison;
import simcity.Plateau;
import simcity.PompeEau;
import simcity.Route;
import simcity.Stockage;
import simcity.TerrainBasket;
import simcity.TerrainFoot;
import simcity.Transport;
import simcity.Usine;
import simcity.UsineBois;
import simcity.Ville;

public class Board extends JFrame{
	

	private static final long serialVersionUID = 1L;
	
	/*
	 * Création des 4 JPanel présents dans le JFrame qui vont contenir dans l'ordre :
	 * Notre plateau de jeu
	 * Nos boutons construction et sauvegarde
	 * Nos attributs de Ville
	 * Les boutons indicateurs, lancer usine et amélioration
	 */
	private JPanel contentPlateau = new JPanel();
	private JPanel contentMenu = new JPanel();
	private JPanel contentVille = new JPanel();
	private JPanel contentIndicateurs = new JPanel();
	
	/*
	 * Notre plateau de jeu P
	 */
	Plateau	P;

	//Boutons composant le plateau :
	private JButton[][] squares = new JButton[12][12];
	
	//On importe les images qu'on met dans des variables ImageIcon
		java.net.URL imgUrl16 = getClass().getResource("Road.png");
		ImageIcon route = new ImageIcon(imgUrl16);
		
		java.net.URL imgUrl = getClass().getResource("BackG.png");
		ImageIcon icon = new ImageIcon(imgUrl);
		
		java.net.URL imgUrl2 = getClass().getResource("PetiteMaison.png");
		ImageIcon petiteMaison = new ImageIcon(imgUrl2);
		
		java.net.URL imgUrl3 = getClass().getResource("GrandeMaison.png");
		ImageIcon grandeMaison = new ImageIcon(imgUrl3);
		
		java.net.URL imgUrl4 = getClass().getResource("Appartement.png");
		ImageIcon appartement = new ImageIcon(imgUrl4);
		
		java.net.URL imgUrl5 = getClass().getResource("Immeuble.png");
		ImageIcon immeuble = new ImageIcon(imgUrl5);
		
		java.net.URL imgUrl6 = getClass().getResource("PompeEau.png");
		ImageIcon pompeEau = new ImageIcon(imgUrl6);
		
		java.net.URL imgUrl7 = getClass().getResource("ChateauEau.png");
		ImageIcon chateauEau = new ImageIcon(imgUrl7);
		
		java.net.URL imgUrl15 = getClass().getResource("Eolienne.png");
		ImageIcon eolienne = new ImageIcon(imgUrl15);
		
		java.net.URL imgUrl8 = getClass().getResource("PanneauSolaire.png");
		ImageIcon panneauSolaire = new ImageIcon(imgUrl8);
		
		java.net.URL imgUrl9 = getClass().getResource("UsineNucleaire.png");
		ImageIcon usineNucleaire = new ImageIcon(imgUrl9);
		
		java.net.URL imgUrl10 = getClass().getResource("UsineBois.png");
		ImageIcon usineBois = new ImageIcon(imgUrl10);
		
		java.net.URL imgUrl11 = getClass().getResource("UsineFer.png");
		ImageIcon usineFer = new ImageIcon(imgUrl11);
		
		java.net.URL imgUrl12 = getClass().getResource("Mairie.png");
		ImageIcon mairie = new ImageIcon(imgUrl12);
		
		java.net.URL imgUrl13 = getClass().getResource("StockBois.png");
		ImageIcon stockBois = new ImageIcon(imgUrl13);
		
		java.net.URL imgUrl14 = getClass().getResource("StockFer.png");
		ImageIcon stockFer = new ImageIcon(imgUrl14);
		
		java.net.URL imgUrl17 = getClass().getResource("GareR.png");
		ImageIcon GareR = new ImageIcon(imgUrl17);
		
		java.net.URL imgUrl18 = getClass().getResource("Ecole.png");
		ImageIcon ecole = new ImageIcon(imgUrl18);
		
		java.net.URL imgUrl19 = getClass().getResource("Library.png");
		ImageIcon bibliotheque = new ImageIcon(imgUrl19);
		
		java.net.URL imgUrl20 = getClass().getResource("TerrainFoot.png");
		ImageIcon terrainfoot = new ImageIcon(imgUrl20);
		
		java.net.URL imgUrl21 = getClass().getResource("TerrainBasket.png");
		ImageIcon terrainbasket = new ImageIcon(imgUrl21);
		
		java.net.URL imgUrl22 = getClass().getResource("RouteV.png");
		ImageIcon routev = new ImageIcon(imgUrl22);
		
		java.net.URL imgUrl23 = getClass().getResource("VirageB.png");
		ImageIcon virageb = new ImageIcon(imgUrl23);
		
		java.net.URL imgUrl24 = getClass().getResource("VirageH.png");
		ImageIcon virageh = new ImageIcon(imgUrl24);
		
	
	//Boutons à droite, de notre menu
	JToggleButton monToggleButtonMenuConstruction = new JToggleButton("Menu de construction");
	JToggleButton monToggleButtonFermerMenuConstruction = new JToggleButton("Retour");
	JToggleButton monToggleButtonHabitations = new JToggleButton("Habitations");
	JToggleButton monToggleButtonUsines = new JToggleButton("Usines");
	JToggleButton monToggleButtonEnergies = new JToggleButton("Energie");
	JToggleButton monToggleButtonServices = new JToggleButton("Service");
	JToggleButton monToggleButtonSauvegarde = new JToggleButton("sauvegarder");
	
	JToggleButton monToggleButtonRoutes = new JToggleButton("Routes");
	JToggleButton monToggleButtonConstruireRoute = new JToggleButton(route);
	JToggleButton monToggleButtonConstruireRouteV= new JToggleButton(routev);
	JToggleButton monToggleButtonConstruireVirageH= new JToggleButton(virageh);
	JToggleButton monToggleButtonConstruireVirageB= new JToggleButton(virageb);
	
	JToggleButton monToggleButtonConstruirePetiteMaison = new JToggleButton("Construire une petite maison");
	JToggleButton monToggleButtonConstruireGrandeMaison = new JToggleButton("Construire une grande maison");
	JToggleButton monToggleButtonConstruireAppartement = new JToggleButton("Construire un appartement");
	JToggleButton monToggleButtonConstruireImmeuble = new JToggleButton("Construire un immeuble");
	JToggleButton monToggleButtonConstruirePompeEau = new JToggleButton("Construire une pompe à eau");
	JToggleButton monToggleButtonConstruireChateauEau = new JToggleButton("Construire un chateau d'eau");
	
	
	JToggleButton monToggleButtonConstruireEolienne = new JToggleButton("Construire une éolienne");
	JToggleButton monToggleButtonConstruirePanneauSolaire = new JToggleButton("Construire une centrale solaire");
	JToggleButton monToggleButtonConstruireUsineNucleaire = new JToggleButton("Construire une usine nucléaire");
	
	JToggleButton monToggleButtonConstruireUsineBois = new JToggleButton("Construire une usine de bois");
	JToggleButton monToggleButtonConstruireUsineFer = new JToggleButton("Construire une usine de fer");
	

	JToggleButton monToggleButtonConstruireTransport= new JToggleButton("Construire une gare routière");
	JToggleButton monToggleButtonConstruireEcole= new JToggleButton("Construire une école");
	JToggleButton monToggleButtonConstruireBibliotheque = new JToggleButton("Construire une Bibliothèque");
	JToggleButton monToggleButtonConstruireTerrainFoot = new JToggleButton("Construire un Terrain de Football");
	JToggleButton monToggleButtonConstruireTerrainBasket = new JToggleButton("Construire un Terrain de BasketBall");
	
	JToggleButton monToggleButtonDetruireConstruction = new JToggleButton("Detruire une construction");
	
	//Boutons en bas pour montrer les emplacements des ressources
	JToggleButton monToggleButtonMontrerCarteEau = new JToggleButton("Montrer la carte d'eau");
	JToggleButton monToggleButtonMontrerCarteMine = new JToggleButton("Montrer la carte des Mines");
	JToggleButton monToggleButtonMontrerCarteSoleil = new JToggleButton("Montrer la carte Soleil");
	JToggleButton monToggleButtonMontrerCarteVent = new JToggleButton("Montrer la carte Vent");
	JToggleButton monToggleButtonMontrerCartePollution = new JToggleButton("Montrer la Pollution");
	
	
	
	JToggleButton monToggleButtonMettreEnMarcheUsine = new JToggleButton("Mettre en marche l'usine");
	JToggleButton monToggleButtonAmeliorerStockage = new JToggleButton("Ameliorer le stockage");
	JToggleButton monToggleButtonDepolluerCase = new JToggleButton("Dépolluer une case");

	
	
	
	//JLabel en haut pour afficher les attributs statiques de Ville
	static JLabel population = new JLabel("population : " + Ville.population);
	static JLabel argent = new JLabel("argent : " + Ville.argent);
	static JLabel bois = new JLabel("bois : " + Ville.Bois+"/"+Ville.stockageBois);
	static JLabel fer = new JLabel("fer : " + Ville.fer +"/"+Ville.stockageFer);
	static JLabel satisfaction = new JLabel("satisfaction : " + Ville.Satisfaction);
	static JLabel eau = new JLabel("Eau : " + Ville.eauC +"/"+ Ville.eauP);
	static JLabel electricite = new JLabel("Electricite : " + Ville.electriciteC + "/"+Ville.electriciteP);

	Color Green = new Color(30,72,23);
	
	//positions
	private int x=5;
	private int y=1;
	
	
	
	
	
	
///////////////////////////////////////////////////////////////////////CONSTRUCTEUR//////////////////////////////////////////////////////////////////////////////////////////////

	public Board(boolean isAlreadySaved) {
		
		super("GUI");
		
		/*
		 * Lancement d'un thread
		 * on implémente la méthode run et on fait une boucle toutes les secondes qui met à jour les Labels attributs de Ville
		 * de plus, toutes les 10 secondes, l'argent du joueur augmente à l'aide d'un calcul incluant nombre d'habitants et satisfaction
		 */
		Timer t = new Timer();
		t.schedule(new TimerTask() {
		 
		long i = 0;
		public void run() {
			updateLabels();            //On met à jour l'affichage
			i++;
			if(i%10 == 0) {
				Ville.argent = Ville.argent + (((int)Ville.Satisfaction)*Ville.population)/100 +Ville.CoefficientRevenu;
				updateLabels();
			}
		
		}
		}, 0, 1000);
		
		/*
		 * Ainsi en fonction d'une partie chargée (load game) ou nouvelle partie (new game) on appelle un constructeur différent du plateau
		 */
		if(isAlreadySaved == false) {
			P = new Plateau(false);
		}else {
			P = new Plateau(true);
		}
		
		//Ainsi le programme s'arrête en cliquant sur la croix
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Mise en place des Layout des Panel, le style
		contentPlateau.setLayout(new GridLayout(12,12));
		contentVille.setLayout(new FlowLayout());
		contentMenu.setLayout(new BoxLayout(contentMenu, BoxLayout.Y_AXIS));
		
		//Mise en place des 4 anels aux bords de la JFrame grâce au Layout BorderLayout()
		this.setLayout(new BorderLayout());
		this.add(contentPlateau, BorderLayout.CENTER);
		this.add(contentMenu, BorderLayout.EAST);
		this.add(contentVille, BorderLayout.NORTH);
		this.add(contentIndicateurs,BorderLayout.SOUTH);
		
		
		//création du handler, le listener de tous les boutons (cases de notre plateau)
		ButtonHandler buttonHandler = new ButtonHandler();

		/*
		 * creation du plateau + ajout des composants (des boutons), 
		 * mise en place d'un background pour chacun d'entre eux,
		 * association de chaque bouton au listener buttonHandler
		 */
		for (int i=0;i<12;i++)
		{
			for(int j=0; j<12;j++) {
				squares[i][j]=new JButton();
				contentPlateau.add(squares[i][j]);
				squares[i][j].setIcon(icon);
				squares[i][j].setBackground(Green);
				
				squares[i][j].addActionListener(buttonHandler);
			}
		}
		
		/*
		 * Ajout de chaque bouton de construction au Panel contentMenu
		 */
		
		contentMenu.add(monToggleButtonMenuConstruction);
		monToggleButtonMenuConstruction.addActionListener(buttonHandler);

		contentMenu.add(monToggleButtonFermerMenuConstruction);
		monToggleButtonFermerMenuConstruction.addActionListener(buttonHandler);
		
		contentMenu.add(monToggleButtonHabitations);
		monToggleButtonHabitations.addActionListener(buttonHandler);
		
		contentMenu.add(monToggleButtonUsines);
		monToggleButtonUsines.addActionListener(buttonHandler);
		
		contentMenu.add(monToggleButtonEnergies);
		monToggleButtonEnergies.addActionListener(buttonHandler);
		
		contentMenu.add(monToggleButtonServices);
		monToggleButtonServices.addActionListener(buttonHandler);

		contentMenu.add(monToggleButtonSauvegarde);
		monToggleButtonSauvegarde.addActionListener(buttonHandler);

		contentMenu.add(monToggleButtonRoutes);
		monToggleButtonRoutes.addActionListener(buttonHandler);
				
		contentMenu.add(monToggleButtonConstruireRoute);
		monToggleButtonConstruireRoute.addActionListener(buttonHandler);
		
		contentMenu.add(monToggleButtonConstruireRouteV);
		monToggleButtonConstruireRouteV.addActionListener(buttonHandler);
		
		contentMenu.add(monToggleButtonConstruireVirageB);
		monToggleButtonConstruireVirageB.addActionListener(buttonHandler);
		
		contentMenu.add(monToggleButtonConstruireVirageH);
		monToggleButtonConstruireVirageH.addActionListener(buttonHandler);
		
		//Code HTML pour certains des boutons pour expliquer leur fonctionnement à l'utilisateur au passage de la souris
		contentMenu.add(monToggleButtonConstruirePetiteMaison);
		monToggleButtonConstruirePetiteMaison.addActionListener(buttonHandler);
		monToggleButtonConstruirePetiteMaison.setToolTipText("<html>"+"Permet de construire une petite Maison"+"<br>"+"Cette Construction de base vous rapporte 5 en population"+"<br>"+"Demande D'electricité : 5"+"<br>"+"Demande D'eau : 5"+"<br>"+"Cout :"+"<br>"+"Argent : 100"+"<br>"+"Fer : 20"+"<br>"+"Bois : 10"+"</html>");
		
		contentMenu.add(monToggleButtonConstruireGrandeMaison);
		monToggleButtonConstruireGrandeMaison.addActionListener(buttonHandler);
		monToggleButtonConstruireGrandeMaison.setToolTipText("<html>"+"Permet de construire une Grande Maison"+"<br>"+"Cette Construction de base vous rapporte 10 en population"+"<br>"+"Demande D'electricité : 10"+"<br>"+"Demande D'eau : 10"+"<br>"+"Cout :"+"<br>"+"Argent : 100"+"<br>"+"Fer : 50"+"<br>"+"Bois : 30"+"</html>");
		
		contentMenu.add(monToggleButtonConstruireAppartement);
		monToggleButtonConstruireAppartement.addActionListener(buttonHandler);
		monToggleButtonConstruireAppartement.setToolTipText("<html>"+"Permet de construire un Appartement"+"<br>"+"Cette Grande Construction vous rapporte 20 en population"+"<br>"+"Demande D'electricité : 20"+"<br>"+"Demande D'eau : 20"+"<br>"+"Cout :"+"<br>"+"Argent : 500"+"<br>"+"Fer : 150"+"<br>"+"Bois : 100"+"</html>");
		
		contentMenu.add(monToggleButtonConstruireImmeuble);
		monToggleButtonConstruireImmeuble.addActionListener(buttonHandler);
		monToggleButtonConstruireImmeuble.setToolTipText("<html>"+"Permet de construire un immense Immeuble"+"<br>"+"Cette gigantesque Construction vous rapporte 500 en population !"+"<br>"+"Demande D'electricité : 500"+"<br>"+"Demande D'eau : 500"+"<br>"+"Cout :"+"<br>"+"Argent : 1000"+"<br>"+"Fer : 500"+"<br>"+"Bois : 450"+"</html>");
		
		contentMenu.add(monToggleButtonConstruirePompeEau);
		monToggleButtonConstruirePompeEau.addActionListener(buttonHandler);
		monToggleButtonConstruirePompeEau.setToolTipText("<html>"+"Permet de construire une Station de Pompage "+"<br>"+"Cette Construction vous rapporte 50 en production d'eau"+"<br>"+"Cout :"+"<br>"+"Argent : 50"+"<br>"+"Fer : 50"+"<br>"+"Bois : 50"+"</html>");
		
		contentMenu.add(monToggleButtonConstruireChateauEau);
		monToggleButtonConstruireChateauEau.addActionListener(buttonHandler);
		monToggleButtonConstruireChateauEau.setToolTipText("<html>"+"Permet de construire un Chateau d'eau"+"<br>"+"Cette Construction vous rapporte 70 en production d'eau"+"<br>"+"Cout :"+"<br>"+"Argent : 100"+"<br>"+"Fer : 100"+"<br>"+"Bois : 100"+"</html>");
		
		contentMenu.add(monToggleButtonConstruireEolienne);
		monToggleButtonConstruireEolienne.addActionListener(buttonHandler);
		monToggleButtonConstruireEolienne.setToolTipText("<html>"+"Permet de construire une éolienne "+"<br>"+"Cette Construction vous rapporte 20 en production d'electricité"+"<br>"+"Cout :"+"<br>"+"Argent : 20"+"<br>"+"Fer : 20"+"<br>"+"</html>");
		
		contentMenu.add(monToggleButtonConstruirePanneauSolaire);
		monToggleButtonConstruirePanneauSolaire.addActionListener(buttonHandler);
		monToggleButtonConstruirePanneauSolaire.setToolTipText("<html>"+"Permet de construire des panneaux solaires"+"<br>"+"Cette Construction vous rapporte 50 en production d'electricité"+"<br>"+"Cout :"+"<br>"+"Argent : 100"+"<br>"+"Fer : 50"+"<br>"+"</html>");
		
		contentMenu.add(monToggleButtonConstruireUsineNucleaire);
		monToggleButtonConstruireUsineNucleaire.addActionListener(buttonHandler);
		monToggleButtonConstruireUsineNucleaire.setToolTipText("<html>"+"Permet de construire une Centrale Nucléaire"+"<br>"+"Attention cette construction est dangereuse pour la santé des habitants car elle pollue"+"<br>"+"Cette Construction vous rapporte 150 en production d'electricité"+"<br>"+"Cout :"+"<br>"+"Argent : 1450"+"<br>"+"Fer : 200"+"<br>"+"Bois : 100"+"</html>");
		
		contentMenu.add(monToggleButtonConstruireUsineBois);
		monToggleButtonConstruireUsineBois.addActionListener(buttonHandler);
		monToggleButtonConstruireUsineBois.setToolTipText("<html>"+"Permet de construire une Usine de bois "+"<br>"+"Cette Construction vous rapporte 1 production de bois par seconde"+"<br>"+"Cout :"+"<br>"+"Argent : 500"+"<br>"+"</html>");
		
		contentMenu.add(monToggleButtonConstruireUsineFer);
		monToggleButtonConstruireUsineFer.addActionListener(buttonHandler);
		monToggleButtonConstruireUsineFer.setToolTipText("<html>"+"Permet de construire Un extracteur de fer "+"<br>"+"Cette Construction vous rapporte 1 production de fer par seconde"+"<br>"+"Cout :"+"<br>"+"Argent : 500 "+"<br>"+"Fer : 20"+"<br>"+"</html>");
		
		contentMenu.add(monToggleButtonConstruireTransport);
		monToggleButtonConstruireTransport.addActionListener(buttonHandler);
		monToggleButtonConstruireTransport.setToolTipText("<html>"+"Permet de construire une Gare Routière pour les Habitants"+"<br>"+"Cette construction permet d'augmenter les revenues en argent de 20"+"<br>"+"Cout :"+"<br>"+"Argent : 2000"+"<br>"+"Fer : 50"+"<br>"+"Bois : 50"+"</html>");
		
		contentMenu.add(monToggleButtonConstruireEcole);
		monToggleButtonConstruireEcole.addActionListener(buttonHandler);
		monToggleButtonConstruireEcole.setToolTipText("<html>"+"L'éducation est importante !!! Permet de construire une école pour les Habitants"+"<br>"+"Cette construction permet d'augmenter les revenues en argent de 20"+"<br>"+"Cout :"+"<br>"+"Argent : 2000"+"<br>"+"Fer : 50"+"<br>"+"Bois : 50"+"</html>");
		
		contentMenu.add(monToggleButtonConstruireBibliotheque);
		monToggleButtonConstruireBibliotheque.addActionListener(buttonHandler);
		monToggleButtonConstruireBibliotheque.setToolTipText("<html>"+"Permet de construire une Bibliothèque pour les Habitants"+"<br>"+"Il est toujours important d'avoir une bibliothèque dans la vile"+ "<br>" + "Cette construction permet d'augmenter les revenues en argent de 10"+"<br>"+"Cout :"+"<br>"+"Argent : 1500"+"<br>"+"Fer : 40"+"<br>"+"Bois : 40"+"</html>");
		
		contentMenu.add(monToggleButtonConstruireTerrainFoot);
		monToggleButtonConstruireTerrainFoot.addActionListener(buttonHandler);
		monToggleButtonConstruireTerrainFoot.setToolTipText("<html>"+"Permet de construire un Terrain de Football pour les Habitants"+"<br>"+"Utile pour former des futurs CR7"+ "<br>" + "Cette construction permet d'augmenter les revenues en argent de 10"+"<br>"+"Cout :"+"<br>"+"Argent : 1500"+"<br>"+"Fer : 40"+"<br>"+"Bois : 40"+"</html>");
		
		contentMenu.add(monToggleButtonConstruireTerrainBasket);
		monToggleButtonConstruireTerrainBasket.addActionListener(buttonHandler);
		monToggleButtonConstruireTerrainBasket.setToolTipText("<html>"+"Permet de construire un Terrain de Basketball pour les Habitants"+"<br>"+"Utile pour former des futurs MJ23"+ "<br>" + "Cette construction permet d'augmenter les revenues en argent de 10"+"<br>"+"Cout :"+"<br>"+"Argent : 1500"+"<br>"+"Fer : 40"+"<br>"+"Bois : 40"+"</html>");
		contentMenu.add(monToggleButtonDetruireConstruction);
		monToggleButtonDetruireConstruction.addActionListener(buttonHandler);
		
		/*
		 * Ajout des boutons de mise en marche de l'usine, d'amélioration et pour montrer les cartes de ressources au JPanel contentIndicateurs
		 */
		
		contentIndicateurs.add(monToggleButtonMettreEnMarcheUsine);
		monToggleButtonMettreEnMarcheUsine.addActionListener(buttonHandler);
		monToggleButtonMettreEnMarcheUsine.setToolTipText("<html>"+"Permet de lancer la production des usines de la ville "+"<br>"+"Cliquez sur ce boutton puis choisisez les usines pour lancer la production"+"</html>");
		
		contentIndicateurs.add(monToggleButtonAmeliorerStockage);
		monToggleButtonAmeliorerStockage.addActionListener(buttonHandler);
		monToggleButtonAmeliorerStockage.setToolTipText("<html>"+"Permet d'améliorer les stockages de bois et de fer "+"<br>"+"Cliquez sur ce boutton puis choisisez les stockages pour les améliorer"+"</html>");
		
		contentIndicateurs.add(monToggleButtonDepolluerCase);
		monToggleButtonDepolluerCase.addActionListener(buttonHandler);
		monToggleButtonDepolluerCase.setToolTipText("<html>"+"Permet de dépolluer une case polluée "+"<br>"+"Cliquez sur ce boutton puis choisisez les cases polluées pour les dépolluer"+"<br>"+"\"Cette action vous coutera 10 000 argent"+"</html>");
		
		contentIndicateurs.add(monToggleButtonMontrerCarteEau);
		monToggleButtonMontrerCarteEau.addActionListener(buttonHandler);
		contentIndicateurs.add(monToggleButtonMontrerCarteMine);
		monToggleButtonMontrerCarteMine.addActionListener(buttonHandler);
		contentIndicateurs.add(monToggleButtonMontrerCarteSoleil);
		monToggleButtonMontrerCarteSoleil.addActionListener(buttonHandler);
		contentIndicateurs.add(monToggleButtonMontrerCarteVent);
		monToggleButtonMontrerCarteVent.addActionListener(buttonHandler);
		contentIndicateurs.add(monToggleButtonMontrerCartePollution);
		monToggleButtonMontrerCartePollution.addActionListener(buttonHandler);
		
		
		
		//Pour que le détail du menu de construction soit invisible
		setMenuInvisible();

		/*
		 * Ajout des contenants des attributs de ville au JPanel contentVille
		 */
		contentVille.add(population);
		contentVille.add(argent);
		contentVille.add(bois);
		contentVille.add(fer);
		contentVille.add(satisfaction);
		contentVille.add(eau);
		contentVille.add(electricite);
		
		//dimensions
		this.setSize(850,744);
		
		//Placement de la fenêtre au centre de l'écran
		this.setLocationRelativeTo(null);
		
		//Met le jeu en plein écran par défault
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		//Affiche la fenêtre
		this.setVisible(true);

		/*
		 * Si c'est une nouvelle partie, on affiche les bâtiments du début
		 * (la construction réelle des bâtiments se faisant dans la case Plateau)
		 */
		if(isAlreadySaved == false) {
			
			squares[5][0].setIcon(route);
			squares[5][1].setIcon(route);
			squares[5][2].setIcon(route);
			squares[5][3].setIcon(route);
			squares[4][1].setIcon(mairie);
			squares[6][0].setIcon(stockBois);
			squares[6][1].setIcon(stockFer);
			
		/*
		 * Sinon en fonction de chaque id des constructions l'affichage doit correspondre
		 */
		}else {
			for(int i = 0 ; i < 12 ; i++){
				for(int y = 0 ; y < 12 ; y++) {
					if(P.getCaseTableau(i, y).getMaConstruction()!=null) {
									squares[i][y].setIcon(route);
						switch (P.getCaseTableau(i, y).getMaConstruction().getClass().getTypeName()) {

							case "simcity.Route":
								squares[i][y].setIcon(route);
								break;
								
							case "simcity.PetiteMaison":
								squares[i][y].setIcon(petiteMaison);
								break;
								
							case "simcity.GrandeMaison":
								squares[i][y].setIcon(grandeMaison);

								break;
							case "simcity.Appartement":
								squares[i][y].setIcon(appartement);
								break;
								
							case "simcity.Immeuble":
								squares[i][y].setIcon(immeuble);
								break;
								
							case "simcity.ChateauEau":
								squares[i][y].setIcon(chateauEau);
								break;
								
							case "simcity.PompeEau":
								squares[i][y].setIcon(pompeEau);
								break;
								
							case "simcity.Eolienne":
								squares[i][y].setIcon(eolienne);
								break;
								
							case "simcity.PanneauSolaire":
								squares[i][y].setIcon(panneauSolaire);
								break;
								
							case "simcity.Nucleaire":
								squares[i][y].setIcon(usineNucleaire);
								break;

							case "simcity.UsineBois":
								squares[i][y].setIcon(usineBois);
								break;
								
							case "simcity.ExtracteurFer":
								squares[i][y].setIcon(usineFer);
								break;
								
							case "simcity.Mairie":
								squares[i][y].setIcon(mairie);
								break;

							case "simcity.Ecole":
								squares[i][y].setIcon(ecole);
								break;
								
							case "simcity.Bibliotheque":
								squares[i][y].setIcon(bibliotheque);
								break;
							case "simcity.Transport":
								squares[i][y].setIcon(GareR);
								break;
								
							case "simcity.TerrainBasket":
								squares[i][y].setIcon(terrainbasket);
								break;

							case "simcity.TerrainFoot":
								squares[i][y].setIcon(terrainfoot);
								break;
								
							case "simcity.StockageFer":
								squares[i][y].setIcon(stockFer);
								break;
								
							case "simcity.StockageBois":
								squares[i][y].setIcon(stockBois);


								break;
							default:

								break;
						}
					}
					}
				}
			updateLabels();
		}
		
	}

//////////////////////////////////////////////////////////////FONCTIONS////////////////////////////////////////////////////////////////////////////////////////////////


	/*
	 * De type void
	 * Cette fonction met à jour les Labels d'affichage des attributs de la ville
	 */
	private static void updateLabels() {
		population.setText("population : " + Ville.population);
		argent.setText("argent : " + Ville.argent);
		bois.setText("bois : " + Ville.Bois+"/"+Ville.stockageBois);
		fer.setText("fer : " + Ville.fer +"/"+Ville.stockageFer);
		satisfaction.setText("satisfaction : " + Ville.Satisfaction);
		eau.setText("Eau : " + Ville.eauC +"/"+ Ville.eauP);
		electricite.setText("Electricite : " + Ville.electriciteC + "/"+Ville.electriciteP);
		
	}
	
	/*
	 * De type void
	 * Cette fonction désactive tous les boutons
	 */
	private void Desactiver() {
		 monToggleButtonMenuConstruction.setSelected(false);
		 monToggleButtonFermerMenuConstruction.setSelected(false);
		 monToggleButtonConstruireRoute.setSelected(false);
		 monToggleButtonConstruirePetiteMaison.setSelected(false);
		 monToggleButtonConstruireGrandeMaison.setSelected(false);
		 monToggleButtonConstruireAppartement.setSelected(false);
		 monToggleButtonConstruireImmeuble.setSelected(false);
		 monToggleButtonConstruirePompeEau.setSelected(false);
		 monToggleButtonConstruireChateauEau.setSelected(false);
		 monToggleButtonConstruireEolienne.setSelected(false);
		 monToggleButtonConstruirePanneauSolaire.setSelected(false);
		 monToggleButtonConstruireUsineNucleaire.setSelected(false);
		 monToggleButtonConstruireUsineBois.setSelected(false);
		 monToggleButtonConstruireUsineFer.setSelected(false);
		 monToggleButtonDetruireConstruction.setSelected(false);
		 monToggleButtonHabitations.setSelected(false);
		 monToggleButtonUsines.setSelected(false);
		 monToggleButtonEnergies.setSelected(false);
		 monToggleButtonServices.setSelected(false);
		 monToggleButtonSauvegarde.setSelected(false);
		 monToggleButtonConstruireTransport.setSelected(false);
		 monToggleButtonConstruireEcole.setSelected(false);
		 monToggleButtonConstruireBibliotheque.setSelected(false);
		 monToggleButtonConstruireTerrainFoot.setSelected(false);
		 monToggleButtonConstruireTerrainBasket.setSelected(false);
		 monToggleButtonConstruireRouteV.setSelected(false);
		 monToggleButtonConstruireVirageB.setSelected(false);
		 monToggleButtonConstruireVirageH.setSelected(false);
		 monToggleButtonRoutes.setSelected(false);
		 monToggleButtonMontrerCarteEau.setSelected(false);
		 monToggleButtonMontrerCarteVent.setSelected(false);
		 monToggleButtonMontrerCarteSoleil.setSelected(false);
		 monToggleButtonMontrerCarteMine.setSelected(false);
		 monToggleButtonMontrerCartePollution.setSelected(false);
		 monToggleButtonMettreEnMarcheUsine.setSelected(false);
		 monToggleButtonAmeliorerStockage.setSelected(false);
		 monToggleButtonDepolluerCase.setSelected(false);
		
	}
	
	/*
	 * De type void
	 * Cette fonction rend le premier détail du menu de construction visible
	 */
	private void setMenuVisible() {
		 setMenuInvisible();
		 monToggleButtonHabitations.setVisible(true);
		 monToggleButtonUsines.setVisible(true);
		 monToggleButtonEnergies.setVisible(true);
		 monToggleButtonServices.setVisible(true);
		monToggleButtonSauvegarde.setVisible(true);
		 monToggleButtonMenuConstruction.setVisible(false);
		 monToggleButtonFermerMenuConstruction.setVisible(true);
		 monToggleButtonDetruireConstruction.setVisible(true);
		 monToggleButtonRoutes.setVisible(true);
	}
	
	/*
	 * De type void
	 * Cette fonction rend le détail du menu de construction invisible
	 */
	private void setMenuInvisible() {
		 monToggleButtonMenuConstruction.setVisible(true);
		 monToggleButtonFermerMenuConstruction.setVisible(false);
		 monToggleButtonConstruireRoute.setVisible(false);
		 monToggleButtonConstruirePetiteMaison.setVisible(false);
		 monToggleButtonConstruireGrandeMaison.setVisible(false);
		 monToggleButtonConstruireAppartement.setVisible(false);
		 monToggleButtonConstruireImmeuble.setVisible(false);
		 monToggleButtonConstruirePompeEau.setVisible(false);
		 monToggleButtonConstruireChateauEau.setVisible(false);
		 monToggleButtonConstruireEolienne.setVisible(false);
		 monToggleButtonConstruirePanneauSolaire.setVisible(false);
		 monToggleButtonConstruireUsineNucleaire.setVisible(false);
		 monToggleButtonConstruireUsineBois.setVisible(false);
		 monToggleButtonConstruireUsineFer.setVisible(false);
		 monToggleButtonDetruireConstruction.setVisible(false);
		 monToggleButtonHabitations.setVisible(false);
		 monToggleButtonUsines.setVisible(false);
		 monToggleButtonEnergies.setVisible(false);
		 monToggleButtonServices.setVisible(false);
		 monToggleButtonSauvegarde.setVisible(false);
		 monToggleButtonConstruireTransport.setVisible(false);
		 monToggleButtonConstruireEcole.setVisible(false);
		 monToggleButtonConstruireBibliotheque.setVisible(false);
		 monToggleButtonConstruireTerrainFoot.setVisible(false);
		 monToggleButtonConstruireTerrainBasket.setVisible(false);
		 monToggleButtonConstruireRouteV.setVisible(false);
		 monToggleButtonConstruireVirageB.setVisible(false);
		 monToggleButtonConstruireVirageH.setVisible(false);
		 monToggleButtonRoutes.setVisible(false);
		 
		 
		 
	}
	
	/*
	 * Les noms de ces 5 fonctions résument leur utilité
	 */
	private void setHabitationsVisible() {
		setMenuInvisible();
		monToggleButtonMenuConstruction.setVisible(false);
		monToggleButtonFermerMenuConstruction.setVisible(true);
		monToggleButtonConstruirePetiteMaison.setVisible(true);
		monToggleButtonConstruireGrandeMaison.setVisible(true);
		monToggleButtonConstruireAppartement.setVisible(true);
		monToggleButtonConstruireImmeuble.setVisible(true);
	}
	
	private void setUsinesVisible() {
		setMenuInvisible();
		monToggleButtonMenuConstruction.setVisible(false);
		monToggleButtonFermerMenuConstruction.setVisible(true);
		monToggleButtonConstruireUsineBois.setVisible(true);
	    monToggleButtonConstruireUsineFer.setVisible(true);
		
	}
	
	private void setEnergiesVisible() {
		setMenuInvisible();
		monToggleButtonMenuConstruction.setVisible(false);
		monToggleButtonFermerMenuConstruction.setVisible(true);
		monToggleButtonConstruirePompeEau.setVisible(true);
		monToggleButtonConstruireChateauEau.setVisible(true);
		monToggleButtonConstruireEolienne.setVisible(true);
		monToggleButtonConstruirePanneauSolaire.setVisible(true);
		monToggleButtonConstruireUsineNucleaire.setVisible(true);
	}
	
	private void setServicesVisible() {
		setMenuInvisible();
		monToggleButtonMenuConstruction.setVisible(false);
		monToggleButtonFermerMenuConstruction.setVisible(true);
		monToggleButtonConstruireTransport.setVisible(true);
		monToggleButtonConstruireEcole.setVisible(true);
		monToggleButtonConstruireBibliotheque.setVisible(true);
		monToggleButtonConstruireTerrainFoot.setVisible(true);
		monToggleButtonConstruireTerrainBasket.setVisible(true);
	}
	
	
	private void setRoutesVisible() {
		setMenuInvisible();
		monToggleButtonMenuConstruction.setVisible(false);
		monToggleButtonFermerMenuConstruction.setVisible(true);
		monToggleButtonConstruireRoute.setVisible(true);
		monToggleButtonConstruireRouteV.setVisible(true);
		monToggleButtonConstruireVirageB.setVisible(true);
		monToggleButtonConstruireVirageH.setVisible(true);
	}
	
	/*
	 * Ces 5 fonctions appellent les constructeurs des classes
	 * ShowWater, ShowMine, ShowWind, ShowSun
	 * à l'écran apparaitront des maps des ressources disponibles sur chaque case
	 */
	private void MontrerCarteEau() {
		ShowWater water = new ShowWater(this.P);
	}
	
	private void MontrerCarteMine() {
		ShowMine mine = new ShowMine(this.P);
	}
	private void MontrerCartePollution() {
		ShowPollution pollution = new ShowPollution(this.P);
	}
	private void MontrerCarteVent() {
		ShowWind wind = new ShowWind(this.P);
	}
	private void MontrerCarteSoleil() {
		ShowSun sun = new ShowSun(this.P);
	}

	
	/*
	 * Jusque ligne 919, toutes ces fonctions appellent les constructeurs de chaque construction, elles ont toutes le même mode opératoire
	 * Créer la construction
	 * Appeler la fonction SetConstruction qui va vérifier si la construction est possible sur la case
	 * On va récupérer un message d'erreur qu'on va envoyer a la fonction PopUpErreur
	 * Cette fonction va soit nous afficher notre erreur en fonction du code, soit mettre en place l'image de notre construction si aucune erreur n'a été effectuée
	 * Mettre à jour les Labels
	 */
	private void ConstruireRoute(int i, int j) {
		Route road = new Route();
		int code = 0;
		code = P.setConstruction(i, j, road);
		PopUpErreur(i,j,code,route);
		updateLabels();
	}
	
	private void ConstruireRouteV(int i,int j) {
		Route road = new Route();
		int code = 0;
		code = P.setConstruction(i, j, road);
		PopUpErreur(i,j,code,routev);
		updateLabels();
	}
	
	private void ConstruireVirageB(int i,int j) {
		Route road = new Route();
		int code = 0;
		code = P.setConstruction(i, j, road);
		PopUpErreur(i,j,code,virageb);
		updateLabels();
	}
	
	private void ConstruireVirageH(int i,int j) {
		Route road = new Route();
		int code = 0;
		code = P.setConstruction(i, j, road);
		PopUpErreur(i,j,code,virageh);
		updateLabels();
	}

	private void ConstruirePetiteMaison(int i, int j) {
		
		PetiteMaison smallHouse = new PetiteMaison();
		int code = 0;
		code = P.setConstruction(i, j, smallHouse);
		PopUpErreur(i,j,code,petiteMaison);
		updateLabels();
	}
	
	private void ConstruireGrandeMaison(int i, int j) {
		
		GrandeMaison bigHouse = new GrandeMaison();
		int code = 0;
		code = P.setConstruction(i, j, bigHouse);
		PopUpErreur(i,j,code,grandeMaison);
		updateLabels();
	}
	
	private void ConstruireAppartement(int i, int j) {
		
		Appartement flat = new Appartement();
		int code = 0;
		code = P.setConstruction(i, j, flat);
		PopUpErreur(i,j,code,appartement);
		updateLabels();
	}
	
	private void ConstruireImmeuble(int i, int j) {
		
		Immeuble building = new Immeuble();
		int code = 0;
		code = P.setConstruction(i, j, building);
		PopUpErreur(i,j,code,immeuble);
		updateLabels();
	}
	
	private void ConstruirePompeEau(int i, int j) {
		
		PompeEau waterPump = new PompeEau();
		int code = 0;
		code = P.setConstruction(i, j, waterPump);
		PopUpErreur(i,j,code,pompeEau);
		updateLabels();
	}
	
	private void ConstruireChateauEau(int i, int j) {
		
		ChateauEau castleWater = new ChateauEau();
		int code = 0;
		code = P.setConstruction(i, j, castleWater);
		PopUpErreur(i,j,code,chateauEau);
		updateLabels();
	}
	
	private void ConstruireEolienne(int i, int j) {
		
		Eolienne windTurbine = new Eolienne();
		int code = 0;
		code = P.setConstruction(i, j, windTurbine);
		PopUpErreur(i,j,code,eolienne);
		updateLabels();
	}
	
	private void ConstruirePanneauSolaire(int i, int j) {
		
		PanneauSolaire solarPanel = new PanneauSolaire();
		int code = 0;
		code = P.setConstruction(i, j,solarPanel);
		PopUpErreur(i,j,code,panneauSolaire);
		updateLabels();
	}
	
	private void ConstruireUsineNucleaire(int i, int j) {
		
		Nucleaire nuclear = new Nucleaire();
		int code = 0;
		code = P.setConstruction(i, j, nuclear);
		PopUpErreur(i,j,code,usineNucleaire);
		
		updateLabels();
	}
	
	private void ConstruireUsineBois(int i, int j) {
		
		UsineBois woodUsine = new UsineBois();
		int code = 0;
		code = P.setConstruction(i, j, woodUsine);
		PopUpErreur(i,j,code,usineBois);
		updateLabels();
	}
	
	private void ConstruireUsineFer(int i, int j) {
		
		ExtracteurFer usineSteel = new ExtracteurFer();
		int code = 0;
		code = P.setConstruction(i, j, usineSteel);
		PopUpErreur(i,j,code,usineFer);
		updateLabels();
	}
	private void ConstruireTransport(int i,int j) {
		Transport GareRoutiere = new Transport();
		int code=0;
		code=P.setConstruction(i, j, GareRoutiere);
		PopUpErreur(i,j,code,GareR);
		updateLabels();
	}
	
	
	private void ConstruireEcole(int i,int j) {
		Ecole school = new Ecole();
		int code=0;
		code=P.setConstruction(i, j, school);
		PopUpErreur(i,j,code,ecole);
		updateLabels();
	}
	
	private void ConstruireBibliotheque(int i, int j) {
		Bibliotheque library = new Bibliotheque();
		int code=0;
		code=P.setConstruction(i, j, library);
		PopUpErreur(i,j,code,bibliotheque);
		updateLabels();
	}
	
	private void ConstruireTerrainFoot(int i, int j) {
		TerrainFoot soccer = new TerrainFoot();
		int code=0;
		code=P.setConstruction(i, j,soccer);
		PopUpErreur(i,j,code,terrainfoot);
		updateLabels();
	}
	
	private void ConstruireTerrainBasket(int i, int j) {
		TerrainBasket basket = new TerrainBasket();
		int code=0;
		code=P.setConstruction(i, j,basket);
		PopUpErreur(i,j,code,terrainbasket);
		updateLabels();
	}
	
	/*
	 * De type void
	 * Cette fonction appelle la fonction qui détruit la construction sur la case en question
	 * Puis elle remet le background d'origine du button
	 */
	private void DetruireConstruction(int i, int j) {
		P.destruct(i, j);
		updateLabels();
		squares[i][j].setIcon(icon);
		x=i;
		y=j;
		updateLabels();
	}
	
	/*
	 * Fonction qui renvoie des affichages messages d'erreur
	 * Traitement des codes d'erreurs renvoyés par la fonction SetConstruction de la classe Plateau
	 */
	private void PopUpErreur(int i, int j, int code, ImageIcon monImage) {
		switch(code) {
		case 1 : 
				squares[i][j].setIcon(monImage);
				x=i;
				y=j;
		break;
		case 2 : JOptionPane.showMessageDialog(this,"Installation d'eau impossible pour cette case");
		break;
		case 3 : JOptionPane.showMessageDialog(this,"Installation d'éolienne impossible pour cette case");
		break;
		case 4 : JOptionPane.showMessageDialog(this,"Installation de panneau solaire impossible pour cette case");
		break;
		case 5 : JOptionPane.showMessageDialog(this,"Installation d'extracteur de fer impossible pour cette case");
		break;
		case 6 : JOptionPane.showMessageDialog(this,"Les ressources ne sont pas suffisantes pour construire, ou veuillez vérifier que la construction est bien à côté d'une route");
		break;
		case 7 : JOptionPane.showMessageDialog(this,"La case doit être vide pour accueillir une construction");
		break;
		default: JOptionPane.showMessageDialog(this,"ERREUR INCONNUE");
		break;
		}
	}
	
	/*
	 * De type void
	 * Cette fonction prend en paramètre int i et int j qui représentent les coordonnées de la case en question
	 * Elle va vérifier que l'utilisateur a bien cliqué sur une Usine, dans le cas contraire afficher des messages d'erreur
	 * Dans le cas ou la construction est une Usine, on va vérifier qu'elle n'est pas déjà en train de produire auquel cas l'utilisateur pourrait la relancer et produire deux fois plus vite
	 * On lance la fonction Chrono de la classe Usine en envoyant le code 0 ou 1 si l'usine est de Fer ou de Bois
	 */
	private void LancerUsine(int i, int j) {
		
		if(P.getCaseTableau(i,j).isVide()) {
			JOptionPane.showMessageDialog(this,"Aucune construction sur cette case");
			
		}else if(P.getCaseTableau(i,j).getMaConstruction().getClass().getSuperclass().getTypeName()!="simcity.Usine"){
			JOptionPane.showMessageDialog(this,"La construction sur cette case n'est pas une usine");
		}else {
			
			boolean estElleEnConstruction = ((Usine)P.getCaseTableau(i,j).getMaConstruction()).getProduction();
			
			if(!estElleEnConstruction) {
				
				if(P.getCaseTableau(i,j).getMaConstruction().getClass().getTypeName()=="simcity.ExtracteurFer") {
					
					((Usine)P.getCaseTableau(i,j).getMaConstruction()).Chrono(0);
					
				}else if(P.getCaseTableau(i,j).getMaConstruction().getClass().getTypeName()=="simcity.UsineBois"){
					
					((Usine)P.getCaseTableau(i,j).getMaConstruction()).Chrono(1);
					
				}
			}else {
				JOptionPane.showMessageDialog(this,"Cette usine est déjà en train de produire");
			}
			
		}

	}
	
	/*
	 * De type void
	 * Cette fonction prend en paramètre int i et int j qui représentent les coordonnées de la case en question
	 * Elle va vérifier que l'utilisateur a bien cliqué sur un stocks, dans le cas contraire afficher des messages d'erreur
	 * Puis elle va appeler la fonction amelioration de la classe Stockage, 
	 * et récupérer un code d'erreur au ca sou l'utilisateur n'aurait pas assez de ressources pour améliorer, pour pouvoir lui afficher un message d'erreur
	 */
	private void AmeliorerStockage(int i, int j) {
		
		if(P.getCaseTableau(i,j).isVide()) {
			JOptionPane.showMessageDialog(this,"Aucune construction sur cette case");
			
		}else if(P.getCaseTableau(i,j).getMaConstruction().getClass().getSuperclass().getTypeName()!="simcity.Stockage"){
			JOptionPane.showMessageDialog(this,"La construction sur cette case n'est pas un stockage");
		}else {
			
			boolean isAmeliorable = ((Stockage)P.getCaseTableau(i,j).getMaConstruction()).amelioration();
			
			if(!isAmeliorable)
				JOptionPane.showMessageDialog(this,"Vous n'avez pas assez de ressources pour améliorer");

		}
	}
	
	
	
	
	
	
	
	
	/*
	 * De type void
	 * Cette fonction prend en paramètre int i et int j qui représentent les coordonnées de la case en question
	 * Elle va vérifier que l'utilisateur a bien cliqué sur une case polluée, dans le cas contraire afficher des messages d'erreur
	 * Puis elle va appeler la fonction Unpolluted de la classe Case, 
	 * et récupérer un code d'erreur au cas sou l'utilisateur n'aurait pas assez de ressources pour améliorer, pour pouvoir lui afficher un message d'erreur
	 */
	private void DepolluerCase(int i, int j) {
		
		if(!P.getCaseTableau(i,j).getPollution()) {
			JOptionPane.showMessageDialog(this,"Cette case n'est pas polluée");

		}else {
			
			boolean isDepolluable = (P.getCaseTableau(i,j).Unpolluted());
			
			if(!isDepolluable)
				JOptionPane.showMessageDialog(this,"Vous n'avez pas assez de ressources pour dépolluer");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Implémentation de la classe ButtonHandler le listener de tous les boutons
	 * Pour chaque bouton :
	 * On appelle la fonction adéquate
	 * On désactive tous les boutons
	 */
		 private class ButtonHandler implements ActionListener{
			 
			 public void actionPerformed(ActionEvent e) {
				 
				 Object source = e.getSource();
				 

				 if(source==monToggleButtonMontrerCarteEau) {
					 MontrerCarteEau();
					 Desactiver();
				 }
				 if(source==monToggleButtonMontrerCarteMine) {
					 MontrerCarteMine();
					 Desactiver();
				 }
				 
				 if(source==monToggleButtonMontrerCartePollution) {
					 MontrerCartePollution();
					 Desactiver();
				 }
				 
				 if(source== monToggleButtonMontrerCarteVent) {
					 MontrerCarteVent();
					 Desactiver();
				 }
				 
				 if(source== monToggleButtonMontrerCarteSoleil) {
					 MontrerCarteSoleil();
					 Desactiver();
				 }
				 if(source==monToggleButtonMenuConstruction) {
					 setMenuVisible();
					 Desactiver();
				 }
				 if(source==monToggleButtonFermerMenuConstruction) {
					 setMenuInvisible();
					 Desactiver();
				 }
				 
				 if(source==monToggleButtonHabitations) {
					 setHabitationsVisible();
					 Desactiver();
				 }
				 if(source==monToggleButtonUsines) {
					 setUsinesVisible();
					 Desactiver();
				 }
				 if(source==monToggleButtonEnergies) {
					 setEnergiesVisible();
					 Desactiver();
				 }
				 if(source==monToggleButtonServices) {
					 setServicesVisible();
					 Desactiver();
				 }

				 if(source==monToggleButtonSauvegarde) {
						 P.sauvegarde();
						 Desactiver();
				 }
				 if(source==monToggleButtonRoutes) {
					 setRoutesVisible();
					 Desactiver();
				 }
				 if(source==monToggleButtonConstruirePetiteMaison) {
					 Desactiver();
					 monToggleButtonConstruirePetiteMaison.setSelected(true);
					 
				 }
				 if(source==monToggleButtonConstruireGrandeMaison) {
					 Desactiver();
					 monToggleButtonConstruireGrandeMaison.setSelected(true);
				 }
				 if(source==monToggleButtonConstruireAppartement) {
					 Desactiver();
					 monToggleButtonConstruireAppartement.setSelected(true);
				 }
				 if(source==monToggleButtonConstruireImmeuble) {
					 Desactiver();
					 monToggleButtonConstruireImmeuble.setSelected(true);
				 }
				 if(source==monToggleButtonConstruireUsineBois) {
					 Desactiver();
					 monToggleButtonConstruireUsineBois.setSelected(true);
				 }
				 if(source==monToggleButtonConstruireUsineFer) {
					 Desactiver();
					 monToggleButtonConstruireUsineFer.setSelected(true);
				 }
				 if(source==monToggleButtonConstruirePompeEau) {
					 Desactiver();
					 monToggleButtonConstruirePompeEau.setSelected(true);
				 }
				 if(source==monToggleButtonConstruireChateauEau) {
					 Desactiver();
					 monToggleButtonConstruireChateauEau.setSelected(true);
				 }
				 if(source==monToggleButtonConstruireEolienne) {
					 Desactiver();
					 monToggleButtonConstruireEolienne.setSelected(true);
				 }
				 if(source==monToggleButtonConstruirePanneauSolaire) {
					 Desactiver();
					 monToggleButtonConstruirePanneauSolaire.setSelected(true);
				 }
				 if(source==monToggleButtonConstruireUsineNucleaire) {
					 Desactiver();
					 monToggleButtonConstruireUsineNucleaire.setSelected(true);
				 }
				 if(source==monToggleButtonConstruireTransport) {
					 Desactiver();
					 monToggleButtonConstruireTransport.setSelected(true);
				 }
				 if(source==monToggleButtonConstruireEcole) {
					 Desactiver();
					 monToggleButtonConstruireEcole.setSelected(true);
				 }
				 if(source==monToggleButtonConstruireBibliotheque) {
					 Desactiver();
					 monToggleButtonConstruireBibliotheque.setSelected(true);
				 }
				 if(source==monToggleButtonConstruireTerrainFoot) {
					 Desactiver();
					 monToggleButtonConstruireTerrainFoot.setSelected(true);
				 }
				 if(source==monToggleButtonConstruireTerrainBasket) {
					 Desactiver();
					 monToggleButtonConstruireTerrainBasket.setSelected(true);
				 }
				 if(source==monToggleButtonConstruireRoute) {
					 Desactiver();
					 monToggleButtonConstruireRoute.setSelected(true);
				 }
				 if(source==monToggleButtonConstruireRouteV) {
					 Desactiver();
					 monToggleButtonConstruireRouteV.setSelected(true);
				 }
				 if(source==monToggleButtonConstruireVirageH) {
					 Desactiver();
					 monToggleButtonConstruireVirageH.setSelected(true);
				 }
				 if(source==monToggleButtonConstruireVirageB) {
					 Desactiver();
					 monToggleButtonConstruireVirageB.setSelected(true);
				 }

				 for(int i=0;i<12;i++) {
					 for(int j=0;j<12;j++) {
						 if(source==squares[i][j]) {
							 
							 
							 
							 if(monToggleButtonConstruireRoute.isSelected()) {
								 ConstruireRoute(i,j);
								 Desactiver();
							 
							 }else if(monToggleButtonMettreEnMarcheUsine.isSelected()){
								 LancerUsine(i,j);
								 Desactiver();
								 
							 }else if(monToggleButtonAmeliorerStockage.isSelected()) {
								 AmeliorerStockage(i,j);
								 Desactiver();
							
							 }else if(monToggleButtonDepolluerCase.isSelected()) {
								 DepolluerCase(i,j);
								 Desactiver();
								 
							 }else if(monToggleButtonConstruireRouteV.isSelected()) {
								 ConstruireRouteV(i,j);
								 Desactiver();
								 
							 }else if(monToggleButtonConstruireVirageB.isSelected()) {
								ConstruireVirageB(i,j);
								Desactiver();
								 
							 }else if(monToggleButtonConstruireVirageH.isSelected()) {
									
								ConstruireVirageH(i,j);	 
								Desactiver();
							
							 
							 }else if(monToggleButtonConstruireTerrainFoot.isSelected()) {
								
								 ConstruireTerrainFoot(i,j);
								 Desactiver();
							 }
							 else if(monToggleButtonConstruireTerrainBasket.isSelected()) {
								
								 ConstruireTerrainBasket(i,j);
								 Desactiver();
							 }
							 
							 
							 else if(monToggleButtonConstruireBibliotheque.isSelected()) {
								
								 ConstruireBibliotheque(i,j);
								 Desactiver();
							 }
							 
							 else if(monToggleButtonConstruireEcole.isSelected()) {
								
								 ConstruireEcole(i,j);
								 Desactiver();
						 	 }else if(monToggleButtonConstruireTransport.isSelected()) {
							
								 ConstruireTransport(i,j);
								 Desactiver();
							 
							 }else if(monToggleButtonConstruirePetiteMaison.isSelected()) {
								 ConstruirePetiteMaison(i,j);
								 Desactiver();
								 
							 }else if(monToggleButtonConstruireGrandeMaison.isSelected()) {
								 ConstruireGrandeMaison(i,j);
								 Desactiver();
								 
							 }else if(monToggleButtonConstruireAppartement.isSelected()) {
								 ConstruireAppartement(i,j);
								 Desactiver();
								 
							 }else if(monToggleButtonConstruireImmeuble.isSelected()) {
								 ConstruireImmeuble(i,j);
								 Desactiver();
								 
							 }else if(monToggleButtonConstruirePompeEau.isSelected()) {
								 ConstruirePompeEau(i,j);
								 Desactiver();
								 
							 }else if(monToggleButtonConstruireChateauEau.isSelected()) {
								 ConstruireChateauEau(i,j);
								 Desactiver();
								 
							 }else if(monToggleButtonConstruireEolienne.isSelected()) {
								 ConstruireEolienne(i,j);
								 Desactiver();
								 
							 }else if(monToggleButtonConstruirePanneauSolaire.isSelected()) {
								 ConstruirePanneauSolaire(i,j);
								 Desactiver();
								 
							 }else if(monToggleButtonConstruireUsineNucleaire.isSelected()) {
								 ConstruireUsineNucleaire(i,j);
								 Desactiver();
								 
							 }else if(monToggleButtonConstruireUsineBois.isSelected()) {
								 ConstruireUsineBois(i,j);
								 Desactiver();
								 
							 }else if(monToggleButtonConstruireUsineFer.isSelected()) {
								 ConstruireUsineFer(i,j);
								 Desactiver();
								 
							 }else if(monToggleButtonDetruireConstruction.isSelected()) {
								 DetruireConstruction(i,j);
								 Desactiver();
								 
							 }
							 
						 }
							 
						 }
					 }

				 return;		 
			 }
		 }}
