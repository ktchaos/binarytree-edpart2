package segundaparte;

public class No {

	private int conteudo;
	private No esquerdo;
	private No direito;
	
	public No() {
		esquerdo = null;
		direito = null;
	}
	
	public int getConteudo() {
		return conteudo;
	}
	
	public void setConteudo(int valor) {
		this.conteudo = valor;
	}
	
	public No getNoEsquerdo() {
		return esquerdo;
	}
	
	public void setNoEsquerdo(No no) {
		this.esquerdo = no;
	}
	
	public No getNoDireito() {
		return direito;
	}
	
	public void setNoDireito(No no) {
		this.direito = no;
	}
	
}
