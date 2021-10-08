package edu.ncsu.monopoly.gui;

import java.awt.*;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;
import javax.swing.JDialog;
import javax.swing.JLabel;

import edu.ncsu.monopoly.*;
import edu.ncsu.monopoly.TradeDeal;
import edu.ncsu.monopoly.TradeDialog;

public class GUITradeDialog extends JDialog implements TradeDialog {
    private JButton btnOK;
    private JButton btnCancel;
    private JComboBox<Player> cboSellers;
    private JComboBox<Cell> cboProperties;

    private TradeDeal deal;
    private JTextField txtAmount;
    
    public GUITradeDialog(Frame parent) {
        super(parent);
        
        setTitle("Trade Property");
        cboSellers = new JComboBox<>();
        cboProperties = new JComboBox<>();
        txtAmount = new JTextField();
        btnOK = new JButton("OK");
        btnCancel = new JButton("Cancel");
        
        btnOK.setEnabled(false);
        
        buildSellersCombo();
        setModal(true);
             
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(4, 2));
        contentPane.add(new JLabel("Sellers"));
        contentPane.add(cboSellers);
        contentPane.add(new JLabel("Properties"));
        contentPane.add(cboProperties);
        contentPane.add(new JLabel("Amount"));
        contentPane.add(txtAmount);
        contentPane.add(btnOK);
        contentPane.add(btnCancel);
        
        cboSellers.addItemListener(e -> updatePropertiesCombo((Player)e.getItem()));
        
        btnOK.addActionListener(e -> {
                int amount = 0;
                try{
                    amount = Integer.parseInt(txtAmount.getText());
                } catch(NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(GUITradeDialog.this,
                            "Amount should be an integer", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Cell cell = (Cell)cboProperties.getSelectedItem();
                if(cell == null) return;
                Player player = (Player)cboSellers.getSelectedItem();
                Player currentPlayer = GameMaster.instance().getCurrentPlayer();
                if(currentPlayer.getMoney() > amount) { 
	                deal = new TradeDeal();
	                deal.setAmount(amount);
	                deal.setPropertyName(cell.getName());
	                deal.setSellerIndex(GameMaster.instance().getPlayerIndex(player));
                }
        });
        
        this.pack();
    }

    private void buildSellersCombo() {
        List<Player> sellers = GameMaster.instance().getSellerList();
        for (Iterator<Player> iter = sellers.iterator(); iter.hasNext();) {
            Player player = iter.next();
            cboSellers.addItem(player);
        }
        if(!sellers.isEmpty()) {
            updatePropertiesCombo(sellers.get(0));
        }
    }

    public TradeDeal getTradeDeal() {
        return deal;
    }

    private void updatePropertiesCombo(Player player) {
        cboProperties.removeAllItems();
        Cell[] cells = player.getAllProperties();
        btnOK.setEnabled(cells.length > 0);
        for (int i = 0; i < cells.length; i++) {
            cboProperties.addItem(cells[i]);
        }
    }

}
