package segundaparte;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Input extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPai;
	private JTextField txtFilho;
	private int pai;
	private int filho;

	public static void main(String[] args) {
		try {
			Input dialog = new Input();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Input() {
		
		setType(Type.UTILITY);
		setModal(true);
		setBounds(100, 100, 401, 346);
		setLocation(495, 170);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(102, 51, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblInsiraOsValores = new JLabel("INSIRA OS VALORES");
		lblInsiraOsValores.setForeground(Color.WHITE);
		lblInsiraOsValores.setFont(new Font("Impact", Font.PLAIN, 30));
		lblInsiraOsValores.setBounds(73, 11, 244, 38);
		contentPanel.add(lblInsiraOsValores);
		
		JLabel lblPai = new JLabel("PAI:");
		lblPai.setForeground(new Color(0, 0, 0));
		lblPai.setFont(new Font("Impact", Font.PLAIN, 28));
		lblPai.setBounds(94, 78, 53, 49);
		contentPanel.add(lblPai);
		
		JLabel lblFilho = new JLabel("FILHO:");
		lblFilho.setForeground(new Color(0, 0, 0));
		lblFilho.setFont(new Font("Impact", Font.PLAIN, 28));
		lblFilho.setBounds(83, 164, 72, 49);
		contentPanel.add(lblFilho);
		
		txtPai = new JTextField();
		txtPai.setFont(new Font("Impact", Font.PLAIN, 22));
		txtPai.setBounds(157, 78, 120, 38);
		contentPanel.add(txtPai);
		txtPai.setColumns(10);
		
		txtFilho = new JTextField();
		txtFilho.setFont(new Font("Impact", Font.PLAIN, 22));
		txtFilho.setColumns(10);
		txtFilho.setBounds(157, 164, 120, 38);
		contentPanel.add(txtFilho);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vPai = txtPai.getText();
				String vFilho = txtFilho.getText();
				
				if(vPai != null && vFilho != null && (vPai.length() > 0) && (vFilho.length() > 0)) {
					pai = Integer.parseInt(vPai);
					filho = Integer.parseInt(vFilho);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Insira um valor válido !", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnOk.setBackground(Color.GRAY);
		btnOk.setForeground(Color.BLACK);
		btnOk.setFont(new Font("Impact", Font.PLAIN, 24));
		btnOk.setBounds(129, 253, 99, 31);
		contentPanel.add(btnOk);
	}
	
	public int getPai() {
		return pai;
	}
	
	public int getFilho() {
		return filho;
	}
}