
public class Main {
	
	public static void main(String[] args) {
		String codigo = "<html>\r\n" + 
				"<body>\r\n" + 
				"<h1>Aqui cabeçalho do arquivo</h1>\r\n" + 
				"</html>\r\n" + 
				"<p>Meu parágrafo da página web.</p>\r\n" + 
				"<p>Meu segundo parágrafo.</p>\r\n" + 
				"</body>\r\n" + 
				"</html>";
		CodigoHTML c1 = new CodigoHTML(codigo);
		System.out.println("Código válido = "+c1.estaValido());
		System.out.println(c1.getDados());
	}
}
