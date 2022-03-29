package Modelos;

public class Produto {

	private String categoria;
	private String nome;
	private Marca marca;
	
	
	//Método que quebra as informações para guarda-las
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

//metodos a seguir estão guardando as informações
//Get = Pegar a informação que já está salva
//Set = Guardar a informação na variavel
	
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
	
	
//Mostra informação da variavel no arquivo TXT,da mesma forma que está no toString		
	@Override
	public String toString() {
		return "Produto, Categoria = " + categoria + ", Nome = " + nome + /*"\nMarca: " +*/ "," + marca ;
	}
	
}
