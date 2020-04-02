package segundaparte;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;

public class ArvoreBinariaGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ArvoreBinaria arvore = new ArvoreBinaria();
	private NoGUI raiz;
	private NoGUI[] nos = new NoGUI[14];
	private JButton[] lines = new JButton[12];

	public static void main(String[] args) {
		try {
			ArvoreBinariaGUI dialog = new ArvoreBinariaGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArvoreBinariaGUI() {
		
		setType(Type.UTILITY);
		setBounds(100, 100, 850, 720);
		setLocation(280, 10);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(51, 51, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnRaiz = new JButton("RA\u00CDZ");
		btnRaiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String in = JOptionPane.showInputDialog("Insira o valor: ");
				
				if(in != null && in.length() > 0) {
					int n = Integer.parseInt(in);
					if(arvore.insereRaiz(n)) {
						raiz.setText("" + n);
						contentPanel.add(raiz);
						raiz.setVisible(true);
						raiz.doClick();
					}
					else {
						JOptionPane.showOptionDialog(null, "A raíz já existe !", "WARNING", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Insira um valor válido !", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRaiz.setFont(new Font("Impact", Font.PLAIN, 18));
		btnRaiz.setForeground(Color.BLACK);
		btnRaiz.setBackground(Color.WHITE);
		btnRaiz.setBounds(90, 73, 126, 24);
		contentPanel.add(btnRaiz);
		
		JLabel lblInserir = new JLabel("INSERIR:");
		lblInserir.setForeground(Color.WHITE);
		lblInserir.setFont(new Font("Impact", Font.PLAIN, 26));
		lblInserir.setBounds(115, 27, 101, 35);
		contentPanel.add(lblInserir);
		
		
		JButton dirRaiz = new JButton();
		dirRaiz.setIcon(new ImageIcon(ArvoreBinariaGUI.class.getResource("/images/lineinclinedtry1 - rright.png")));
		dirRaiz.setBorder(null);
		dirRaiz.setBackground(new Color(51, 51, 51));
		dirRaiz.setBounds(441, 213, 132, 123);
		
		JButton esqRaiz = new JButton();
		esqRaiz.setIcon(new ImageIcon(ArvoreBinariaGUI.class.getResource("/images/lineinclinedtry1 - r.png")));
		esqRaiz.setBorder(null);
		esqRaiz.setBackground(new Color(51, 51, 51));
		esqRaiz.setBounds(264, 224, 123, 101);
		
		JButton btnEsq = new JButton("ESQUERDA");
		btnEsq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Input in = new Input();
				in.setVisible(true);
				
				int p = in.getPai();
				int f = in.getFilho();
				
				if(arvore.insereEsquerda(p, f)) {
					String vpai = Integer.toString(p);
					
					if(vpai.equals(raiz.getText())) {
						NoGUI aux = raiz.getEsq();
						aux.setText("" + f);
						contentPanel.add(aux);
						aux.setVisible(true);
						aux.doClick();
						//adição de linha:
						contentPanel.add(esqRaiz);
						esqRaiz.setVisible(true);
						esqRaiz.doClick();
					}
					else {
						try {
							int i;
							for(i = 0; i <= 13; i++) {
								if(vpai.equals(nos[i].getText())) {
									break;
								}
							}
							
							NoGUI aux = nos[i].getEsq();
							aux.setText("" + f);
							contentPanel.add(aux);
							aux.setVisible(true);
							aux.doClick();
							
							// Adição das linhas:
							int l = -1;
							switch(i) {
								case 0: l = 0;
										break;
								case 1: l = 2;
										break;
								case 2: l = 4;
										break;
								case 7: l = 7;
										break;
								case 8: l = 8;
										break;
								case 9: l = 10;
										break;
								default: break;
							}
							
							contentPanel.add(lines[l]);
							lines[l].setVisible(true);
							lines[l].doClick();
							
							
						}
						catch(Exception b){JOptionPane.showMessageDialog(null, "Memória cheia !", "ERROR", JOptionPane.ERROR_MESSAGE);}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Operação inválida !", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnEsq.setForeground(Color.BLACK);
		btnEsq.setFont(new Font("Impact", Font.PLAIN, 18));
		btnEsq.setBackground(Color.WHITE);
		btnEsq.setBounds(90, 108, 126, 24);
		contentPanel.add(btnEsq);
		
		JButton btnDir = new JButton("DIREITA");
		btnDir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Input in = new Input();
				in.setVisible(true);
				
				int p = in.getPai();
				int f = in.getFilho();
				
				if(arvore.insereDireita(p, f)) {
					String vpai = Integer.toString(p);
					
					if(vpai.equals(raiz.getText())) {
						NoGUI aux = raiz.getDir();
						aux.setText("" + f);
						contentPanel.add(aux);
						aux.setVisible(true);
						aux.doClick();
						// adição da linha:
						contentPanel.add(dirRaiz);
						dirRaiz.setVisible(true);
						dirRaiz.doClick();
						
					}
					else {
						try {
							int i;
							for(i = 0; i <= 13; i++) {
								if(vpai.equals(nos[i].getText())) {
									break;
								}
							}
							
							NoGUI aux = nos[i].getDir();
							aux.setText("" + f);
							contentPanel.add(aux);
							aux.setVisible(true);
							aux.doClick();
							
							//adição das linhas hereditárias
							int l = -1;
							switch(i) {
								case 0: l = 1;
										break;
								case 1: l = 3;
										break;
								case 2: l = 5;
										break;
								case 7: l = 6;
										break;
								case 8: l = 9;
										break;
								case 9: l = 11;
										break;
								default: break;
							}
							
							contentPanel.add(lines[l]);
							lines[l].setVisible(true);
							lines[l].doClick();
							
						}
						catch(Exception b){JOptionPane.showMessageDialog(null, "Memória cheia !", "ERROR", JOptionPane.ERROR_MESSAGE);}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Operação inválida !", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDir.setForeground(Color.BLACK);
		btnDir.setFont(new Font("Impact", Font.PLAIN, 18));
		btnDir.setBackground(Color.WHITE);
		btnDir.setBounds(90, 143, 126, 24);
		contentPanel.add(btnDir);
		
		JLabel lblBuscar = new JLabel("BUSCAR:");
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Impact", Font.PLAIN, 26));
		lblBuscar.setBounds(362, 27, 101, 35);
		contentPanel.add(lblBuscar);
		
		JButton btnBusca = new JButton("BUSCAR ELEMENTO");
		btnBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchInput in = new SearchInput();
				in.setVisible(true);
				
				int elemento = in.getElemento();
				No res = arvore.busca(elemento);
				
				if(res != null) {
					String r = Integer.toString(res.getConteudo());
					JButton arrow = new JButton();
					arrow.setBorder(null);
					arrow.setBackground(new Color(51, 51, 51));
					arrow.setIcon(new ImageIcon(ArvoreBinariaGUI.class.getResource("/images/arrows3 - r.png")));
					contentPanel.add(arrow);
					
					if(r.equals(raiz.getText())) {
						int x = raiz.getX();
						int y = raiz.getY();
						
						arrow.setBounds(x - 65, y, 64, 59);
						arrow.setVisible(true);
						arrow.doClick();
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						arrow.setVisible(false);
						
					}
					else {
						int i;
						for(i = 0; i <= 13; i++) {
							if(r.equals(nos[i].getText())) {
								break;
							}
						}
						
						int x = nos[i].getX();
						int y = nos[i].getY();
						arrow.setBounds(x - 65, y, 64, 59);
						arrow.setVisible(true);
						arrow.doClick();
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						arrow.setVisible(false);
					
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Não encontrado !", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBusca.setForeground(Color.BLACK);
		btnBusca.setFont(new Font("Impact", Font.PLAIN, 18));
		btnBusca.setBackground(Color.WHITE);
		btnBusca.setBounds(321, 73, 188, 24);
		contentPanel.add(btnBusca);
		
		JLabel lblCaminhar = new JLabel("CAMINHAR:");
		lblCaminhar.setForeground(Color.WHITE);
		lblCaminhar.setFont(new Font("Impact", Font.PLAIN, 26));
		lblCaminhar.setBounds(605, 27, 126, 35);
		contentPanel.add(lblCaminhar);
		
		JButton btnPrordem = new JButton("PR\u00C9-ORDEM");
		btnPrordem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arvore.vazia()) {
					JOptionPane.showMessageDialog(null, "A árvore está vazia!", "WARNING", JOptionPane.WARNING_MESSAGE);
				}
				else {
					arvore.printPreOrdem();
					PreOrdem print = new PreOrdem();
					print.setPreo(arvore.getPreo());
					print.setVisible(true);
				}
			}
		});
		btnPrordem.setForeground(Color.BLACK);
		btnPrordem.setFont(new Font("Impact", Font.PLAIN, 18));
		btnPrordem.setBackground(Color.WHITE);
		btnPrordem.setBounds(605, 73, 126, 24);
		contentPanel.add(btnPrordem);
		
		JButton btnInordem = new JButton("IN-ORDEM");
		btnInordem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arvore.vazia()) {
					JOptionPane.showMessageDialog(null, "A árvore está vazia!", "WARNING", JOptionPane.WARNING_MESSAGE);
				}
				else {
					arvore.printInOrdem();
					int[] ino = arvore.getIno();
					InOrdem print = new InOrdem();
					print.setIno(ino);
					print.setVisible(true);
				}
			}
		});
		btnInordem.setForeground(Color.BLACK);
		btnInordem.setFont(new Font("Impact", Font.PLAIN, 18));
		btnInordem.setBackground(Color.WHITE);
		btnInordem.setBounds(605, 108, 126, 24);
		contentPanel.add(btnInordem);
		
		JButton btnPsordem = new JButton("P\u00D3S-ORDEM");
		btnPsordem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arvore.vazia()) {
					JOptionPane.showMessageDialog(null, "A árvore está vazia!", "WARNING", JOptionPane.WARNING_MESSAGE);
				}
				else {
					arvore.printPosOrdem();
					int[] poso = arvore.getPoso();
					PosOrdem print = new PosOrdem();
					print.setPoso(poso);
					print.setVisible(true);
				}
			}
		});
		btnPsordem.setForeground(Color.BLACK);
		btnPsordem.setFont(new Font("Impact", Font.PLAIN, 18));
		btnPsordem.setBackground(Color.WHITE);
		btnPsordem.setBounds(605, 143, 126, 24);
		contentPanel.add(btnPsordem);
		
		
		/* DECLARAÇÕES DOS ELEMENTOS GRÁFICOS */
		
		lines[0] = new JButton();
		lines[0].setIcon(new ImageIcon(ArvoreBinariaGUI.class.getResource("/images/linha-r60.png")));
		lines[0].setBorder(null);
		lines[0].setBackground(new Color(51, 51, 51));
		lines[0].setBounds(151, 336, 61, 61);
		
		lines[1] = new JButton();
		lines[1].setIcon(new ImageIcon(ArvoreBinariaGUI.class.getResource("/images/linha-r60right.png")));
		lines[1].setBorder(null);
		lines[1].setBackground(new Color(51, 51, 51));
		lines[1].setBounds(264, 336, 61, 61);
		
		lines[2] = new JButton();
		lines[2].setBorder(null);
		lines[2].setBackground(new Color(51, 51, 51));
		lines[2].setIcon(new ImageIcon(ArvoreBinariaGUI.class.getResource("/images/linha-pRleft2.png")));
		lines[2].setBounds(90, 448, 43, 44);
		
		lines[3] = new JButton();
		lines[3].setIcon(new ImageIcon(ArvoreBinariaGUI.class.getResource("/images/linha-pRright2.png")));
		lines[3].setBorder(null);
		lines[3].setBackground(new Color(51, 51, 51));
		lines[3].setBounds(150, 448, 43, 44);
		
		lines[4] = new JButton();
		lines[4].setIcon(new ImageIcon(ArvoreBinariaGUI.class.getResource("/images/linha-pRleft2.png")));
		lines[4].setBorder(null);
		lines[4].setBackground(new Color(51, 51, 51));
		lines[4].setBounds(279, 448, 43, 44);
		
		lines[5] = new JButton();
		lines[5].setIcon(new ImageIcon(ArvoreBinariaGUI.class.getResource("/images/linha-pRright2.png")));
		lines[5].setBorder(null);
		lines[5].setBackground(new Color(51, 51, 51));
		lines[5].setBounds(336, 448, 43, 44);
		
		lines[6] = new JButton();
		lines[6].setIcon(new ImageIcon(ArvoreBinariaGUI.class.getResource("/images/linha-r60right.png")));
		lines[6].setBorder(null);
		lines[6].setBackground(new Color(51, 51, 51));
		lines[6].setBounds(625, 336, 61, 61);
		
		lines[7] = new JButton();
		lines[7].setIcon(new ImageIcon(ArvoreBinariaGUI.class.getResource("/images/linha-r60.png")));
		lines[7].setBorder(null);
		lines[7].setBackground(new Color(51, 51, 51));
		lines[7].setBounds(512, 336, 61, 61);
		
		lines[8] = new JButton();
		lines[8].setIcon(new ImageIcon(ArvoreBinariaGUI.class.getResource("/images/linha-pRleft2.png")));
		lines[8].setBorder(null);
		lines[8].setBackground(new Color(51, 51, 51));
		lines[8].setBounds(454, 448, 43, 44);
		
		lines[9] = new JButton();
		lines[9].setIcon(new ImageIcon(ArvoreBinariaGUI.class.getResource("/images/linha-pRright2.png")));
		lines[9].setBorder(null);
		lines[9].setBackground(new Color(51, 51, 51));
		lines[9].setBounds(514, 448, 43, 44);
		
		lines[10] = new JButton();
		lines[10].setIcon(new ImageIcon(ArvoreBinariaGUI.class.getResource("/images/linha-r60.png")));
		lines[10].setBorder(null);
		lines[10].setBackground(new Color(51, 51, 51));
		lines[10].setBounds(643, 448, 43, 44);
		
		lines[11] = new JButton();
		lines[11].setIcon(new ImageIcon(ArvoreBinariaGUI.class.getResource("/images/linha-r60right.png")));
		lines[11].setBorder(null);
		lines[11].setBackground(new Color(51, 51, 51));
		lines[11].setBounds(700, 448, 43, 44);
		
		/* DECLARAÇÃO DOS NÓS */
		
		// LADO DIREITO (DE BAIXO PARA CIMA)
		
		
		nos[13] = new NoGUI(null, null);
		nos[13].setForeground(Color.BLACK);
		nos[13].setFont(new Font("Impact", Font.BOLD, 30));
		nos[13].setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		nos[13].setBackground(Color.WHITE);
		nos[13].setBounds(723, 492, 52, 50);
		
		nos[12] = new NoGUI(null, null);
		nos[12].setForeground(Color.BLACK);
		nos[12].setFont(new Font("Impact", Font.BOLD, 30));
		nos[12].setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		nos[12].setBackground(Color.WHITE);
		nos[12].setBounds(608, 492, 52, 50);
		
		nos[11] = new NoGUI(null, null);
		nos[11].setForeground(Color.BLACK);
		nos[11].setFont(new Font("Impact", Font.BOLD, 30));
		nos[11].setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		nos[11].setBackground(Color.WHITE);
		nos[11].setBounds(534, 492, 52, 50);
		
		nos[10] = new NoGUI(null, null);
		nos[10].setForeground(Color.BLACK);
		nos[10].setFont(new Font("Impact", Font.BOLD, 30));
		nos[10].setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		nos[10].setBackground(Color.WHITE);
		nos[10].setBounds(419, 492, 52, 50);
		
		nos[9] = new NoGUI(nos[12], nos[13]);
		nos[9].setForeground(Color.BLACK);
		nos[9].setFont(new Font("Impact", Font.BOLD, 30));
		nos[9].setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		nos[9].setBackground(Color.WHITE);
		nos[9].setBounds(665, 397, 52, 50);
		
		nos[8] = new NoGUI(nos[10], nos[11]);
		nos[8].setForeground(Color.BLACK);
		nos[8].setFont(new Font("Impact", Font.BOLD, 30));
		nos[8].setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		nos[8].setBackground(Color.WHITE);
		nos[8].setBounds(479, 397, 52, 50);
		
		nos[7] = new NoGUI(nos[8], nos[9]);
		nos[7].setForeground(Color.BLACK);
		nos[7].setFont(new Font("Impact", Font.BOLD, 30));
		nos[7].setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		nos[7].setBackground(Color.WHITE);
		nos[7].setBounds(574, 307, 52, 50);

		// LADO ESQUERDO (DE BAIXO PARA CIMA)
		
		nos[6] = new NoGUI(null, null);
		nos[6].setForeground(Color.BLACK);
		nos[6].setFont(new Font("Impact", Font.BOLD, 30));
		nos[6].setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		nos[6].setBackground(Color.WHITE);
		nos[6].setBounds(361, 492, 52, 50);
		
		nos[5] = new NoGUI(null, null);
		nos[5].setForeground(Color.BLACK);
		nos[5].setFont(new Font("Impact", Font.BOLD, 30));
		nos[5].setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		nos[5].setBackground(Color.WHITE);
		nos[5].setBounds(246, 492, 52, 50);
		
		nos[4] = new NoGUI(null, null);
		nos[4].setForeground(Color.BLACK);
		nos[4].setFont(new Font("Impact", Font.BOLD, 30));
		nos[4].setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		nos[4].setBackground(Color.WHITE);
		nos[4].setBounds(172, 492, 52, 50);
		
		nos[3] = new NoGUI(null, null);
		nos[3].setForeground(Color.BLACK);
		nos[3].setFont(new Font("Impact", Font.BOLD, 30));
		nos[3].setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		nos[3].setBackground(Color.WHITE);
		nos[3].setBounds(57, 492, 52, 50);
		
		nos[2] = new NoGUI(nos[5], nos[6]);
		nos[2].setForeground(Color.BLACK);
		nos[2].setFont(new Font("Impact", Font.BOLD, 30));
		nos[2].setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		nos[2].setBackground(Color.WHITE);
		nos[2].setBounds(303, 397, 52, 50);
		
		nos[1] = new NoGUI(nos[3], nos[4]);
		nos[1].setForeground(Color.BLACK);
		nos[1].setFont(new Font("Impact", Font.BOLD, 30));
		nos[1].setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		nos[1].setBackground(Color.WHITE);
		nos[1].setBounds(117, 397, 52, 50);
		
		nos[0] = new NoGUI(nos[1], nos[2]);
		nos[0].setForeground(Color.BLACK);
		nos[0].setFont(new Font("Impact", Font.BOLD, 30));
		nos[0].setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		nos[0].setBackground(Color.WHITE);
		nos[0].setBounds(212, 307, 52, 50);
		
		raiz = new NoGUI(nos[0], nos[7]);
		raiz.setForeground(Color.BLACK);
		raiz.setFont(new Font("Impact", Font.BOLD, 30));
		raiz.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		raiz.setBackground(Color.WHITE);
		raiz.setBounds(387, 210, 52, 50);
	}
}