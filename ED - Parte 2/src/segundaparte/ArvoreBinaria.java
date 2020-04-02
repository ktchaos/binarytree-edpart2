package segundaparte;

public class ArvoreBinaria {

	private No raiz;
	private int[] preo = new int[14];
	private int i = -1;
	private int[] ino = new int[14];
	private int j = -1;
	private int[] poso = new int[14];
	private int k = -1;
	
	public ArvoreBinaria() {
		raiz = null;
	}
	
	public boolean vazia() {
		return (raiz == null);
	}
	
	public No busca(No T, int valor) {
		// Condição de parada 1:
		if(T == null) {
			return null;
		}
		//Condição de parada 2:
		if(T.getConteudo() == valor) {
			return T;
		}
		
		No achou = busca(T.getNoEsquerdo(), valor);
		if(achou == null) {
			achou = busca(T.getNoDireito(), valor);
		}
		
		return achou;
	}
	
	public No busca(int valor) {
		if(vazia()) {
			return null;
		}
		
		return busca(raiz, valor);
	}
	
	public boolean insereRaiz(int valor) {
		if(raiz != null) {
			return false;
		}
		
		No aux = new No();
		aux.setConteudo(valor);
		aux.setNoEsquerdo(null);
		aux.setNoDireito(null);
		
		raiz = aux;
		
		return true;
	}
	
	public boolean insereDireita(int vPai, int vFilho) {
		
		No filho = busca(vFilho);
		if(filho != null) {
			return false;
		}
		
		No pai = busca(vPai);
		if(pai == null) {
			return false;
		}
		
		if(pai.getNoDireito() != null) {
			return false;
		}
		
		No aux = new No();
		aux.setConteudo(vFilho);
		aux.setNoDireito(null);
		aux.setNoEsquerdo(null);
		
		pai.setNoDireito(aux);
		
		return true;
	}
	
	public boolean insereEsquerda(int vPai, int vFilho) {
		
		No filho = busca(vFilho);
		if(filho != null) {
			return false;
		}
		
		No pai = busca(vPai);
		if(pai == null) {
			return false;
		}
		
		if(pai.getNoEsquerdo() != null) {
			return false;
		}
		
		No aux = new No();
		aux.setConteudo(vFilho);
		aux.setNoDireito(null);
		aux.setNoEsquerdo(null);
		
		pai.setNoEsquerdo(aux);
		
		return true;
	}
	
	public void printPreOrdem(No T) {
		i++;
		if(T == null) {
			return;
		}
		
		//System.out.print(" " + T.getConteudo());
		preo[i] = T.getConteudo();
		
		if(T.getNoEsquerdo() != null) {
			printPreOrdem(T.getNoEsquerdo());
		}
		
		if(T.getNoDireito() != null) {
			printPreOrdem(T.getNoDireito());
		}
	}
	
	public void printPreOrdem() {
		if(raiz == null) {
			System.out.println("Arvore vazia !");
		}
		else {
			printPreOrdem(raiz);
			i = -1;
		}
	}
	
	public void printInOrdem(No T) {
		if(T == null) {
			return;
		}
		
		if(T.getNoEsquerdo() != null) {
			printInOrdem(T.getNoEsquerdo());
		}
		j++;
		//System.out.print(" " + T.getConteudo());
		ino[j] = T.getConteudo();
		
		if(T.getNoDireito() != null) {
			printInOrdem(T.getNoDireito());
		}
	}
	
	public void printInOrdem() {
		if(raiz == null) {
			System.out.println("Arvore vazia !");
		}
		else {
			printInOrdem(raiz);
			j = -1;
		}
	}
	
	public void printPosOrdem(No T) {
		if(T == null) {
			return;
		}
		
		if(T.getNoEsquerdo() != null) {
			printPosOrdem(T.getNoEsquerdo());
		}
		if(T.getNoDireito() != null) {
			printPosOrdem(T.getNoDireito());
		}
		k++;
		//System.out.print(" " + T.getConteudo());
		poso[k] = T.getConteudo();
	}
	
	public void printPosOrdem() {
		if(raiz == null) {
			System.out.println("Arvore vazia !");
		}
		else {
			printPosOrdem(raiz);
			k = -1;
		}
	}
	
	public int altura(No atual) {
	     if(atual == null || (atual.getNoEsquerdo() == null && atual.getNoDireito() == null))
	       return 0;
	     else {
	    	 if (altura(atual.getNoEsquerdo()) > altura(atual.getNoDireito())) {
	    		 return (altura(atual.getNoEsquerdo()) + 1);
	    	 } 
	    	 else {
	    		 return (altura(atual.getNoDireito()) + 1);
	    	 }
	     }
	  }
	
	public int altura() {
		if(raiz == null) {
			return 0;
		}
		return altura(raiz);
	}
	
	public int[] getPreo() {
		return preo;
	}
	
	public int[] getIno() {
		return ino;
	}
	
	public int[] getPoso() {
		return poso;
	}
	
}