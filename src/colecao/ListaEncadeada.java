package colecao;

public class ListaEncadeada<T> {
	private NoLista<T> primeiro;
	private NoLista<T> ultimo;
	
	public ListaEncadeada() {
		
	}
	
	public NoLista<T> getPrimeiro() {
		return this.primeiro;
	}
	
	public void inserir(T info) {
		NoLista<T> novo = new NoLista<>();
		novo.setInfo(info);
		novo.setProximo(primeiro); //seta no "proximo" o elemento incluído por último/o último da lista. (Pra mim, seria mais o "anterior", ao invés de próximo.) 
		this.primeiro = novo; //"primeiro" será sempre igual ao último elemento incluído na lista
	}
	
	public void exibir() {
		NoLista<T> p = this.getPrimeiro();
		while(p != null) {
			System.out.println(p.getInfo().toString());
			p = p.getProximo();
		}
	}
	
	public boolean estaVazia() {
		return this.primeiro==null; // Jeito elegante de fazer o if
	}
	
	public NoLista<T> buscar(T info) {
		NoLista<T> p = this.getPrimeiro();
		while(p != null) {
			if(info.equals(p.getInfo())) {
				return p;
			}
			p = p.getProximo();
		}
		return null;
	}
	
	public void retirar(T info) {
		NoLista<T> no = this.getPrimeiro();
		NoLista<T> noAnterior = null;
		while(no != null) {
			if(info.equals(no.getInfo())) {
				if (noAnterior != null) {
					noAnterior.setProximo(no.getProximo());;
				} else {
					this.primeiro = no.getProximo();
				}
				break;
			}
			noAnterior = no;
			no = no.getProximo();
		}
	}
	
	public int obterComprimento() {
		int count = 0;
		NoLista<T> no = this.getPrimeiro();
		while(no != null) {
			count++;
			no = no.getProximo();
		}
		return count;
	}
	
	public NoLista<T> obterNo(int idx) {
		NoLista<T> no = this.getPrimeiro();
		for (int i = 0; i < idx; i++) {
			if(no.getProximo() == null) {
				throw new IndexOutOfBoundsException("Posição inválida!");
			} else {
				no = no.getProximo();
			}
		}
		return no;
	}
	
	public String toString() {
		NoLista<T> p = this.getPrimeiro();
		StringBuilder sb = new StringBuilder();
		while(p != null) {
			sb.append(p.getInfo().toString()+", ");
			p = p.getProximo();
		}
		int index = sb.lastIndexOf(",");
		if (index != -1) {
			return String.valueOf(sb.delete(index, index+2));
		} else {
			return null;
		}
	}
	
	public void inserirNoFinal(T valor) {
		NoLista<T> novo = new NoLista<>();
		novo.setInfo(valor);
		novo.setProximo(null);
		
		if(this.estaVazia()) {
			primeiro = novo;
		} else {
			ultimo.setProximo(novo);
		}
		ultimo = novo;
	}
}
