package segundaparte;

import javax.swing.JButton;

public class NoGUI extends JButton {

	private NoGUI esquerdo;
	private NoGUI direito;
	
	public NoGUI(NoGUI e, NoGUI d) {
		esquerdo = e;
		direito = d;
	}
	
	public NoGUI getEsq() {
		return esquerdo;
	}
	
	public NoGUI getDir() {
		return direito;
	}
	
	public void setEsq(NoGUI no) {
		esquerdo = no;
	}
	
	public void setDir(NoGUI no) {
		direito = no;
	}
	
}
