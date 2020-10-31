import excecoes.TagSemFechamentoException;

public class TagHTML {
	private String nome;
	private boolean singleton;
	
	public TagHTML(String tag) {
		this.nome = tag;
		this.setSingleton();
	}
	
	public boolean eFechamento() {
		if(this.singleton)
			return false;
		else if(nome.charAt(0) != '/')
			return false;
		else
			return true;
	}
	
	private void setSingleton() {
		this.singleton = this.isSingleton();
	}

	private boolean isSingleton() {
		String[] singletonTags = {"meta", "base", "br", "col", "command", "embed", "hr", "img", "input", "link", "param", "source", "!DOCTYPE"};
		for (int i = 0; i < singletonTags.length; i++) {
			if(this.nome.equals(singletonTags[i]))
				return true;
		}
		return false;
	}
	
	public boolean getSingleton() {
		return this.singleton;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public static boolean matchParDeTags(TagHTML inicio, TagHTML fim) throws TagSemFechamentoException {
		if(inicio.getNome().equals(fim.getNome().substring(1)))
			return true;
		throw new TagSemFechamentoException("A tag "+inicio.getNome()+" não possui fechamento.");
	}
}
