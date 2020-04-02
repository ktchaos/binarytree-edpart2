package segundaparte;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SearchInput extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private int elemento;

	public static void main(String[] args) {
		try {
			SearchInput dialog = new SearchInput();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SearchInput() {
		
		setType(Type.UTILITY);
		setModal(true);
		setBounds(100, 100, 401, 346);
		setLocation(495, 170);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(102, 51, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblInsiraOsValores = new JLabel("BUSCAR");
		lblInsiraOsValores.setBounds(140, 11, 115, 38);
		lblInsiraOsValores.setForeground(Color.WHITE);
		lblInsiraOsValores.setFont(new Font("Impact", Font.PLAIN, 30));
		contentPanel.add(lblInsiraOsValores);
		
		JLabel lblPai = new JLabel("ELEMENTO:");
		lblPai.setBounds(39, 129, 121, 49);
		lblPai.setForeground(new Color(0, 0, 0));
		lblPai.setFont(new Font("Impact", Font.PLAIN, 28));
		contentPanel.add(lblPai);
		
		textField = new JTextField();
		textField.setForeground(Color.DARK_GRAY);
		textField.setFont(new Font("Impact", Font.PLAIN, 26));
		textField.setBounds(170, 135, 115, 40);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String el = textField.getText();
				
				if(el != null && (el.length() > 0)) {
					elemento = Integer.parseInt(el);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Insira um valor válido !", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnOk.setBackground(Color.DARK_GRAY);
		btnOk.setForeground(Color.BLACK);
		btnOk.setFont(new Font("Impact", Font.PLAIN, 24));
		btnOk.setBounds(140, 232, 98, 38);
		contentPanel.add(btnOk);
	}
	
	public int getElemento() {
		return elemento;
	}
}
