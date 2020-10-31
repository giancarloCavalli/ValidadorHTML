package colecao;

public class ListaEstatica<T> {
	private T[] info;
	private int tamanho;
	
	public ListaEstatica() {
		info = (T[])new Object[10];
		tamanho = 0;
	}
	
	public int getTamanho() {
		return this.tamanho;
	}
	
	private void redimensionar() {
		T[] novoInfo = (T[])new Object[this.tamanho+10];
		for (int i = 0; i < info.length; i++) {
			novoInfo[i] = info[i];
		}
		this.info = novoInfo;
	}
	
	public void inserir(T valor) {
		if(tamanho == info.length) {
			redimensionar();
		}
		info[tamanho] = valor;
		tamanho++;
	}
	
	public void exibir() {
		for (int i = 0; i < tamanho; i++) {
			System.out.println(i+") "+info[i]);
		}
	}
	
	public int buscar(T valor) {
		for (int i = 0; i < tamanho; i++) {
			if(info[i].equals(valor)) {
				return i;
			}
		}
		return -1;
	}
	
	public void retirar(T valor) {
		for (int i = 0; i < tamanho; i++) {
			if(info[i].equals(valor)) {
				for (int j = i; j < tamanho-1; j++) {
					info[j] = info[j+1];
				}
				tamanho--;
				break;
			}
		}
	}
	
	public void liberar() {	//Ver com o professor se há uma maneira mais elegante de fazer esse method
		info = (T[])new Object[10];
		tamanho = 0;
	}
	
	public T obterElemento(int posicao) {
		if(posicao < tamanho) {
			return info[posicao];
		}
		throw new IndexOutOfBoundsException();
	}
	
	public boolean estaVazia() {
		if(tamanho == 0) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < tamanho-1; i++) {
			str.append(info[i]+",");
		}
		str.append(info[tamanho-1]);
		return String.valueOf(str);
	}
	
	public void inverter() {
		T objetoTemporario = (T)new Object();
		int indexPontaDaDireita = this.getTamanho()-1;
		for (int indexPontaDaEsquerda = 0; indexPontaDaEsquerda < this.getTamanho()/2; indexPontaDaEsquerda++) {
			objetoTemporario = info[indexPontaDaEsquerda];
			info[indexPontaDaEsquerda] = info[indexPontaDaDireita];
			info[indexPontaDaDireita] = objetoTemporario;
			indexPontaDaDireita--;
		}
	}
	
}
