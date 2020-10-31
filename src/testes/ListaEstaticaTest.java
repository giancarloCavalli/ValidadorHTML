package testes;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import colecao.ListaEstatica;

public class ListaEstaticaTest {
	
	@Test
	public void testInserir() {
		ListaEstatica<Integer> l1 = new ListaEstatica<>();
		l1.inserir(5);
		l1.inserir(10);
		l1.inserir(15);
		l1.inserir(20);
		assertEquals("5,10,15,20", l1.toString());
	}
	
	@Test
	public void testGetTamanho() {
		ListaEstatica<Integer> l1 = new ListaEstatica<>();
		l1.inserir(5);
		l1.inserir(10);
		l1.inserir(15);
		l1.inserir(20);
		assertEquals(4, l1.getTamanho());
	}
	
	@Test
	public void testBuscar() {
		ListaEstatica<Integer> l1 = new ListaEstatica<>();
		l1.inserir(5);
		l1.inserir(10);
		l1.inserir(15);
		l1.inserir(20);
		assertEquals(2, l1.buscar(15));
	}
	
	@Test
	public void testBuscarValorInexistente() {
		ListaEstatica<Integer> l1 = new ListaEstatica<>();
		l1.inserir(5);
		l1.inserir(10);
		l1.inserir(15);
		l1.inserir(20);
		assertEquals(-1, l1.buscar(30));
	}
	
	@Test
	public void testRetirarEGetTamanho() {
		ListaEstatica<Integer> l1 = new ListaEstatica<>();
		l1.inserir(5);
		l1.inserir(10);
		l1.inserir(15);
		l1.inserir(20);
		l1.retirar(10);
		assertEquals(l1.toString(), "5,15,20");
		assertEquals(3, l1.getTamanho());
	}
	
	@Test
	public void testToStringEGetTamanho() {
		ListaEstatica<Integer> l1 = new ListaEstatica<>();
		StringBuilder str = new StringBuilder();
		for (int i = 1; i < 15; i++) {
			l1.inserir(i);
			str.append(i+",");
		}
		l1.inserir(15);
		str.append("15");
		assertEquals(l1.toString(), String.valueOf(str));
		assertEquals(15, l1.getTamanho());
	}
	
	@Test
	public void testObterElemento() {
		ListaEstatica<Integer> l1 = new ListaEstatica<>();
		l1.inserir(5);
		l1.inserir(10);
		l1.inserir(15);
		l1.inserir(20);
		assertEquals((Integer)20, l1.obterElemento(3));
	}
	
	//TODO ajustar
	@Test
	public void testObterElementoResultandoExcessao() {
		ListaEstatica<Integer> l1 = new ListaEstatica<>();
		l1.inserir(5);
		l1.inserir(10);
		l1.inserir(15);
		l1.inserir(20);
		
		try {
			l1.obterElemento(5);
			fail();
		} catch (IndexOutOfBoundsException e) {
			
		}
	}
	
	@Test
	public void testLiberarEEstaVazia() {
		ListaEstatica<Integer> l1 = new ListaEstatica<>();
		l1.inserir(5);
		l1.inserir(10);
		l1.inserir(15);
		l1.inserir(20);
		l1.liberar();
		assertEquals(true, l1.estaVazia());
	}

	@Test
	public void testInverterComQtdeParElementos() {
		ListaEstatica<Integer> lista = new ListaEstatica<>();
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		lista.inverter();
		assertEquals("20,15,10,5", lista.toString());
	}
	
	@Test
	public void testInverterComQtdeImparElementos() {
		ListaEstatica<Integer> lista = new ListaEstatica<>();
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		lista.inserir(25);
		lista.inverter();
		assertEquals("25,20,15,10,5", lista.toString());
	}

}
