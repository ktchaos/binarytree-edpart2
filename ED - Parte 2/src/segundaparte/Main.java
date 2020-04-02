package segundaparte;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 479);
		setLocation(400, 100);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblrvoreBinria = new JLabel("\u00C1RVORE BIN\u00C1RIA");
		lblrvoreBinria.setForeground(Color.WHITE);
		lblrvoreBinria.setFont(new Font("Impact", Font.PLAIN, 30));
		lblrvoreBinria.setBounds(214, 232, 198, 54);
		contentPane.add(lblrvoreBinria);
		
		JButton btnCriar = new JButton("CRIAR");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArvoreBinariaGUI agui = new ArvoreBinariaGUI();
				agui.setVisible(true);
			}
		});
		btnCriar.setFont(new Font("Impact", Font.PLAIN, 18));
		btnCriar.setBackground(Color.BLACK);
		btnCriar.setForeground(Color.WHITE);
		btnCriar.setBounds(258, 298, 105, 31);
		contentPane.add(btnCriar);
		
		JLabel lblEstruturaDeDados = new JLabel("ESTRUTURA DE DADOS");
		lblEstruturaDeDados.setForeground(new Color(0, 0, 0));
		lblEstruturaDeDados.setFont(new Font("Impact", Font.PLAIN, 36));
		lblEstruturaDeDados.setBounds(163, 22, 318, 54);
		contentPane.add(lblEstruturaDeDados);
		
		JLabel lblParte = new JLabel("- Parte 2 -");
		lblParte.setForeground(SystemColor.scrollbar);
		lblParte.setFont(new Font("Impact", Font.PLAIN, 28));
		lblParte.setBounds(267, 72, 115, 43);
		contentPane.add(lblParte);
	}
}
