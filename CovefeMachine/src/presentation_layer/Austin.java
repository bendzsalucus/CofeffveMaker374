package presentation_layer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import business_layer.Usual;

public class Austin {
	public  Usual AustinUsualSlot; 
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
		ArrayList<String> austinUsualDrinks = new ArrayList<String>();
		austinUsualDrinks.add("Mocha");
		austinUsualDrinks.add("Americano");
		austinUsualDrinks.add("Regular Latte");

		class AmericanoListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				Orderer orderer = new Orderer("GUI Command");
				Usual AustinUsual = orderer.createUsual(austinUsualDrinks, 123456, "5611 Hazen St", 77081);
//				AustinUsual.getOrderDrinkName();
				setCommand(AustinUsual);
				invokeCommand(AustinUsualSlot);
			}

			private void invokeCommand(Usual commandSlot) {
				commandSlot.execute();
			}

			private void setCommand(Usual austinUsual) {
				AustinUsualSlot = austinUsual;
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
