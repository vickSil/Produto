package Modelos;

public class Produto {

	private String categoria;
	private String nome;
	private Marca marca;
	
	
	//M�todo que quebra as informa��es para guarda-las
	public Produto(String dados) {
		
		String[] atributos = dados.split(",");
		
		String[] categoria = atributos[1].split("=");
		String[] nome = atributos[2].split("=");
		
		Marca marca = new Marca(atributos);
		
		this.categoria = categoria[1].trim();
		this.nome = nome[1].trim();
		this.marca = marca;
	}
	
	public Produto() {
		
	}

//metodos a seguir est�o guardando as informa��es
//Get = Pegar a informa��o que j� est� salva
//Set = Guardar a informa��o na variavel
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String i) {
		this.categoria = i;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	
//Mostra informa��o da variavel no arquivo TXT,da mesma forma que est� no toString		
	@Override
	public String toString() {
		return "Produto, Categoria = " + categoria + ", Nome = " + nome + /*"\nMarca: " +*/ "," + marca ;
	}
	
}
