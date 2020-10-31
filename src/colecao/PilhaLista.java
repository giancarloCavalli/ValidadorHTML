package colecao;

import java.util.ArrayList;

import excecoes.PilhaVaziaException;

public class PilhaLista<T> implements Pilha<T> {
	
	private ListaEncadeada<T> lista = new ListaEncadeada<>();
	
	public PilhaLista() {
		
	}

	@Override
	public void push(T info) {
		lista.inserir(info);
	}

	@Override
	public T pop() throws PilhaVaziaException {
		if (estaVazia())
			throw new PilhaVaziaException("Pilha vazia! Não há elementos a serem resgatados.");
		T info = lista.getPrimeiro().getInfo();
		this.lista.retirar(info);
		return info;
	}

	@Override
	public T peek() {
		if (estaVazia())
			throw new PilhaVaziaException("Pilha vazia! Não há elementos a serem resgatados.");
		return this.lista.getPrimeiro().getInfo();
	}

	@Override
	public boolean estaVazia() {
		if (this.lista.getPrimeiro() == null)
			return true;
		return false;
	}

	@Override
	public void liberar() {
		this.lista = new ListaEncadeada<>();
	}
	
	public String toString() {
		return this.lista.toString();
	}

}
