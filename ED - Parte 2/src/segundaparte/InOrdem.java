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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class InOrdem extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton[] pos = new JButton[14];
	public int[] ino;
	
	public static void main(String[] args) {
		try {
			InOrdem dialog = new InOrdem();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public InOrdem() {
		setType(Type.UTILITY);
		setModal(true);
		setBounds(100, 100, 850, 309);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblInordem = new JLabel("IN-ORDEM:");
		lblInordem.setForeground(Color.WHITE);
		lblInordem.setFont(new Font("Impact", Font.PLAIN, 30));
		lblInordem.setBounds(335, 11, 157, 47);
		contentPanel.add(lblInordem);
		
		pos[0] = new JButton("");
		pos[0].setFont(new Font("Impact", Font.PLAIN, 28));
		pos[0].setBorder(null);
		pos[0].setBackground(Color.WHITE);
		pos[0].setBounds(10, 111, 57, 53);
		
		pos[1] = new JButton("");
		pos[1].setFont(new Font("Impact", Font.PLAIN, 28));
		pos[1].setBorder(null);
		pos[1].setBackground(Color.WHITE);
		pos[1].setBounds(68, 111, 57, 53);
		
		pos[2] = new JButton("");
		pos[2].setFont(new Font("Impact", Font.PLAIN, 28));
		pos[2].setBorder(null);
		pos[2].setBackground(Color.WHITE);
		pos[2].setBounds(126, 111, 57, 53);
		
		pos[3] = new JButton("");
		pos[3].setFont(new Font("Impact", Font.PLAIN, 28));
		pos[3].setBorder(null);
		pos[3].setBackground(Color.WHITE);
		pos[3].setBounds(184, 111, 57, 53);
		
		pos[4] = new JButton("");
		pos[4].setFont(new Font("Impact", Font.PLAIN, 28));
		pos[4].setBorder(null);
		pos[4].setBackground(Color.WHITE);
		pos[4].setBounds(242, 111, 57, 53);
		
		pos[5] = new JButton("");
		pos[5].setFont(new Font("Impact", Font.PLAIN, 28));
		pos[5].setBorder(null);
		pos[5].setBackground(Color.WHITE);
		pos[5].setBounds(300, 111, 57, 53);
		
		pos[6] = new JButton("");
		pos[6].setFont(new Font("Impact", Font.PLAIN, 28));
		pos[6].setBorder(null);
		pos[6].setBackground(Color.WHITE);
		pos[6].setBounds(358, 111, 57, 53);
		
		pos[7] = new JButton("");
		pos[7].setFont(new Font("Impact", Font.PLAIN, 28));
		pos[7].setBorder(null);
		pos[7].setBackground(Color.WHITE);
		pos[7].setBounds(416, 111, 57, 53);
	
		pos[8] = new JButton("");
		pos[8].setFont(new Font("Impact", Font.PLAIN, 28));
		pos[8].setBorder(null);
		pos[8].setBackground(Color.WHITE);
		pos[8].setBounds(474, 111, 57, 53);
		
		pos[9] = new JButton("");
		pos[9].setFont(new Font("Impact", Font.PLAIN, 28));
		pos[9].setBorder(null);
		pos[9].setBackground(Color.WHITE);
		pos[9].setBounds(532, 111, 57, 53);
		
		pos[10] = new JButton("");
		pos[10].setFont(new Font("Impact", Font.PLAIN, 28));
		pos[10].setBorder(null);
		pos[10].setBackground(Color.WHITE);
		pos[10].setBounds(590, 111, 57, 53);
		
		pos[11] = new JButton("");
		pos[11].setFont(new Font("Impact", Font.PLAIN, 28));
		pos[11].setBorder(null);
		pos[11].setBackground(Color.WHITE);
		pos[11].setBounds(648, 111, 57, 53);
		
		pos[12] = new JButton("");
		pos[12].setFont(new Font("Impact", Font.PLAIN, 28));
		pos[12].setBorder(null);
		pos[12].setBackground(Color.WHITE);
		pos[12].setBounds(706, 111, 57, 53);
		
		pos[13] = new JButton("");
		pos[13].setFont(new Font("Impact", Font.PLAIN, 28));
		pos[13].setBorder(null);
		pos[13].setBackground(Color.WHITE);
		pos[13].setBounds(764, 111, 57, 53);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOk.setBackground(Color.WHITE);
		btnOk.setForeground(new Color(51, 51, 51));
		btnOk.setFont(new Font("Impact", Font.PLAIN, 26));
		btnOk.setBounds(361, 208, 101, 32);
		contentPanel.add(btnOk);
		
		JButton btnExibir = new JButton("EXIBIR");
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; ino[i] != 0; i++) {
					pos[i].setText("" + ino[i]);
					contentPanel.add(pos[i]);
					pos[i].setVisible(true);
					pos[i].doClick();
				}
			}
		});
		btnExibir.setBackground(new Color(255, 255, 255));
		btnExibir.setForeground(new Color(0, 0, 0));
		btnExibir.setFont(new Font("Impact", Font.PLAIN, 22));
		btnExibir.setBounds(495, 15, 91, 32);
		contentPanel.add(btnExibir);
	}
	
	public void setIno(int[] io) {
		ino = io;
	}
}