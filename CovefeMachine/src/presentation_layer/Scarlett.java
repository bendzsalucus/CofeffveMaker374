package presentation_layer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Scarlett {
	private JFrame frame;

	public static void main(String[] args) {
		new Scarlett();
	}

	public Scarlett() {
		frame = new JFrame();
		frame.setTitle("Scarlett Specials");
		JPanel panel = new JPanel();
		MainHelper menuComp = new MainHelper("Resoruces//ScarlettSpecials.png");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.add(menuComp, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		frame.setFocusable(true);
		frame.setBackground(Color.PINK);
		JButton scarlettSurprise = new JButton("Scarlett Surprise");
		JButton expresso = new JButton("Expresso");
		panel.setBackground(Color.BLACK);
		panel.add(scarlettSurprise);
		panel.add(expresso);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(520, 520);
		frame.setVisible(true);

		class ScarlettSurpriseListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.out.println("make Scarlett Surprise");
			}

		}

		class ExpressoListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.out.println("make expresso");
			}

		}

		scarlettSurprise.addActionListener(new ScarlettSurpriseListener());
		expresso.addActionListener(new ExpressoListener());

	}

}
