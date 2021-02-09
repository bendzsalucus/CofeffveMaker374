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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Austin {

	private JFrame frame;

	public static void main(String[] args) {
		new Austin();
	}

	public Austin() {
		frame = new JFrame();
		frame.setTitle("Austin's Specials");
		JPanel panel = new JPanel();
		MainHelper menuComp = new MainHelper("Resoruces//AustinSpecials.png");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.add(menuComp, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		frame.setFocusable(true);
		frame.setBackground(Color.PINK);
		JButton mocha = new JButton("Mocha");
		JButton americano = new JButton("Americano");
		panel.setBackground(Color.BLACK);
		panel.add(mocha);
		panel.add(americano);

		class AmericanoListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.out.println("make Americano");
			}

		}

		class MochaListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.out.println("make mocha");
			}

		}

		americano.addActionListener(new AmericanoListener());
		mocha.addActionListener(new MochaListener());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(520, 520);
		frame.setVisible(true);
		
	}
}
