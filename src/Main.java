
public class Main {
	
	public static void main(String[] args) {
		String codigo = "<html>\r\n" + 
				"<body>\r\n" + 
				"<h1>Aqui cabe�alho do arquivo</h1>\r\n" + 
				"</html>\r\n" + 
				"<p>Meu par�grafo da p�gina web.</p>\r\n" + 
				"<p>Meu segundo par�grafo.</p>\r\n" + 
				"</body>\r\n" + 
				"</html>";
		CodigoHTML c1 = new CodigoHTML(codigo);
		System.out.println("C�digo v�lido = "+c1.estaValido());
		System.out.println(c1.getDados());
	}
}
