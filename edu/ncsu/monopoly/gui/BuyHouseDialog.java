
package edu.ncsu.monopoly.gui;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import edu.ncsu.monopoly.Player;


public class BuyHouseDialog extends JDialog {
	private JComboBox<String[]> cboMonopoly;
	private JComboBox<Integer> cboNumber;

	private Player player;

	public BuyHouseDialog(Player player) {
		this.player = player;
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(3, 2));
		c.add(new JLabel("Select monopoly"));
		c.add(buildMonopolyComboBox());
		c.add(new JLabel("Number of houses"));
		c.add(buildNumberComboBox());
		c.add(buildOKButton());
		c.add(buildCancelButton());
		c.doLayout();
		this.pack();
	}

	private JButton buildCancelButton() {
		JButton btn = new JButton("Cancel");
		btn.addActionListener(input -> cancelClicked());
		return btn;
	}

	private JComboBox<String[]> buildMonopolyComboBox() {
		cboMonopoly = new JComboBox<String[]>();
		cboMonopoly.addItem(player.getMonopolies());
		return cboMonopoly;
	}
	
	private JComboBox<Integer> buildNumberComboBox() {
		cboNumber = new JComboBox<Integer>();
		return cboNumber;
	}

	private JButton buildOKButton() {
		JButton btn = new JButton("OK");
		btn.addActionListener(input -> okClicked());
		return btn;
	}
	
	private void cancelClicked() {
		this.dispose();
	}
	
	private void okClicked() {
		String monopoly = (String)cboMonopoly.getSelectedItem();
		int number = cboNumber.getSelectedIndex() + 1;
		player.purchaseHouse(monopoly, number);
		this.dispose();
	}
}
