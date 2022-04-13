package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class WelcomeMenu {

	private JFrame frmSimcity;

	/**
	 * Lance l'application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeMenu window = new WelcomeMenu();
					window.frmSimcity.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructeur
	 */
	public WelcomeMenu() {
		initialize();
	
	}

	/**
	 * Initialise le contenu du Frame
	 */
	private void initialize() {
		
		frmSimcity = new JFrame();
		frmSimcity.setTitle("SimCity");
		frmSimcity.setBounds(720, 720, 720, 720);
		frmSimcity.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSimcity.getContentPane().setLayout(null);
		frmSimcity.setResizable(false);
		frmSimcity.setLocationRelativeTo(null);
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setBackground(Color.WHITE);
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Board board =new Board(false);
				frmSimcity.dispose();
			}
		});
		btnNewGame.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnNewGame.setBounds(288, 186, 130, 42);
		frmSimcity.getContentPane().add(btnNewGame);
		
		JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnLoadGame.setBounds(288, 256, 130, 42);
		frmSimcity.getContentPane().add(btnLoadGame);
		btnLoadGame.setBackground(Color.WHITE);
		btnLoadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Board board =new Board(true);
				frmSimcity.dispose();
			}
			});
		
		JButton btnQuit = new JButton("Quit Game");
		btnQuit.setBounds(556, 603, 104, 29);
		frmSimcity.getContentPane().add(btnQuit);
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); 
			}
			});
		
		JButton btnRules = new JButton("Rules");
		btnRules.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnRules.setBounds(288, 331, 130, 42);
		frmSimcity.getContentPane().add(btnRules);
		btnRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					JComponent page;
			        JEditorPane jep = new JEditorPane();
			         jep.setEditable(false);   
			         java.net.URL url = WelcomeMenu.class.getResource("/simcity/Rules.html");
			         try {
			           jep.setPage(url);
			         }
			         catch (IOException e1) {
			           jep.setContentType("text/html");
			           jep.setText("<html>Impossible d'afficher la page</html>");
			         } 
			         JScrollPane scrollPane = new JScrollPane(jep);     
			         JFrame f = new JFrame("Rules");
			         f.getContentPane().add(scrollPane);
			         f.setSize(512, 342);
			         f.setVisible(true);

			}
		});
		
		JLabel lblTitle = new JLabel("SimCity");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.ORANGE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 42));
		lblTitle.setBounds(178, 63, 326, 80);
		frmSimcity.getContentPane().add(lblTitle);
		
		JLabel lblBackGround = new JLabel("");
		lblBackGround.setIcon(new ImageIcon(WelcomeMenu.class.getResource("/Interface/SimCity.png")));
		lblBackGround.setBounds(0, 0, 720, 720);
		frmSimcity.getContentPane().add(lblBackGround);
	}
}
