package presentation_layer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainGUI {

	private JFrame frame;

	public static void main(String[] args) {
		new MainGUI();
	}

	public MainGUI() {
		frame = new JFrame();
		frame.setTitle("Deluxe Coffee Shop");
		JPanel panel = new JPanel();
		MainHelper menuComp = new MainHelper("Resoruces//coffeeShop.png");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.add(menuComp, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		frame.setFocusable(true);
		frame.setBackground(Color.PINK);
		JButton newScarlett = new JButton("Scarlett's Usuals");
		JButton newAustin = new JButton("Austin's Usuals");
		panel.setBackground(Color.BLACK);
		panel.add(newScarlett);
		panel.add(newAustin);

		class AustinListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Austin();
			}

		}

		class ScarlettListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Scarlett();
			}

		}

		newScarlett.addActionListener(new ScarlettListener());
		newAustin.addActionListener(new AustinListener());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(520, 520);
		frame.setVisible(true);

	}

}
