package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import colecao.PilhaLista;

public class PilhaListaTest {

	@Test
	public void testEstaVazia() {
		PilhaLista<Integer> p = new PilhaLista<>();
		assertEquals(true, p.estaVazia());
	}
	
	@Test
	public void testEstaVaziaFalse() {
		PilhaLista<Integer> p = new PilhaLista<>();
		p.push(10);
		assertEquals(false, p.estaVazia());
	}
	
	@Test
	public void testPopEEstaVazia() {
		PilhaLista<Integer> p = new PilhaLista<>();
		p.push(10);
		p.push(20);
		p.push(30);
		assertEquals(30, p.pop().intValue());
		assertEquals(20, p.pop().intValue());
		assertEquals(10, p.pop().intValue());
		assertEquals(true, p.estaVazia());
	}
	
	@Test
	public void testPeek() {
		PilhaLista<Integer> p = new PilhaLista<>();
		p.push(10);
		p.push(20);
		p.push(30);
		assertEquals(30, p.peek().intValue());
		assertEquals(30, p.pop().intValue());
	}

}
