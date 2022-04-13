package Interface;
import simcity.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;


public class ShowWind extends JFrame {
	private JPanel contentPlateau = new JPanel();
	private JButton[][] squares = new JButton[12][12];
	
	java.net.URL imgUrl = getClass().getResource("BackG.png");
	ImageIcon icon = new ImageIcon(imgUrl);
	
	java.net.URL imgUrl2 = getClass().getResource("Eolienne.png");
	ImageIcon wind = new ImageIcon(imgUrl2);
	
	private Plateau P;
	
	public ShowWind(Plateau P) {
		super("Carte pour les installations de type Eoliennes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPlateau.setLayout(new GridLayout(12,12));
		this.setLayout(new BorderLayout());
		this.add(contentPlateau, BorderLayout.CENTER);
		
		/*
		 * On parcourt notre tableau de boutons squares, et pour chaque coordonnée de boutons,
		 * on regarde dans le tableau P si la case contient du vent ou pas grâce à getVent()
		 * On affiche un background en conséquence
		 */
		for (int i=0;i<12;i++)
		{
			for(int j=0; j<12;j++) {
				squares[i][j]=new JButton();
				contentPlateau.add(squares[i][j]);
				if(P.getCaseTableau(i, j).getVent()) {
					squares[i][j].setIcon(wind);
				}else {
				squares[i][j].setIcon(icon);
			}
			}
		}
		this.setSize(650,500);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	

}
