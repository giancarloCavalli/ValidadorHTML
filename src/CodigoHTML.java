import colecao.ListaEstatica;
import colecao.NoLista;
import colecao.PilhaLista;
import excecoes.PilhaVaziaException;
import excecoes.TagSemFechamentoException;

public class CodigoHTML {
	private String codigo;
	private ListaEstatica<TagHTML> tags = new ListaEstatica<>();
	private String logErros = "";
	
	public CodigoHTML(String codigo) {
		this.setCodigo(codigo);
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
		this.gerarTags(codigo);
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public boolean estaValido() {
		return matchEntreTags();
	}
	
	private boolean matchEntreTags() {
		this.logErros = "";
		boolean codigoValido = true;
		PilhaLista<TagHTML> pilha = new PilhaLista<>();
		TagHTML tag;
		for (int i = 0; i < this.tags.getTamanho(); i++) {
			tag = this.tags.obterElemento(i);
			
			if(tag.getSingleton()) {
				
			} else if(tag.eFechamento() == false) {
				pilha.push(tag);
			} else {
				try {
					TagHTML.matchParDeTags(pilha.pop(), tag);
				} catch(TagSemFechamentoException tsfe) {
					this.logErros += tsfe.getMessage()+"\n";
					codigoValido = false;
				} catch(PilhaVaziaException pve) {
					this.logErros += "Erro de estrutura no código HTML.\n";
				}
			}
		}
		return codigoValido;
	}

	private void gerarTags(String codigo) {
		String[] tags = codigo.split("<");
		for (int i = 1; i < tags.length; i++) {
			try {
				tags[i] = tags[i].substring(0, tags[i].indexOf(">"));
			} catch (StringIndexOutOfBoundsException e) {

			}
			if(tags[i].contains(" "))
				tags[i] = retiraAtributosDaTag(tags[i]);
			this.tags.inserir(new TagHTML(tags[i]));
		}
		
	}
	
	private String retiraAtributosDaTag(String tag) {
		String[] s = tag.split(" ");
		return s[0];
	}

	public String getDados() {
		if(this.estaValido())
			return this.getOcorrenciaTags();
		return this.getLogErros();
	}
	
	private String getLogErros() {
		return this.logErros;
	}
	
	private String getOcorrenciaTags() {
		String s = "";
		ListaEstatica<TagHTML> tags = new ListaEstatica<>();
		int[] frequencia = new int[this.tags.getTamanho()];
		TagHTML tag;
		for (int i = 0; i < this.tags.getTamanho(); i++) {
			
			boolean encontrou = false;
			tag = this.tags.obterElemento(i);
			
			for (int j = 0; j < tags.getTamanho(); j++) {
				if(tags.obterElemento(j).getNome().equals(tag.getNome())) {
					frequencia[j] += 1;
					encontrou = true;
					break;
				}
			}
			
			if(encontrou == false && !tag.eFechamento()) {
				tags.inserir(tag);
				frequencia[tags.getTamanho()-1] = 1;
			}
		}
		
		if(tags.getTamanho() >= 1)
			s += frequencia[0]+" "+tags.obterElemento(0).getNome(); 
		for (int i = 1; i < tags.getTamanho(); i++) {
			s += "\n"+frequencia[i]+" "+tags.obterElemento(i).getNome(); 
		}
		return s;
	}
}
