package Modelos;

public class Marca {

	private String nome;
	private double preco;
	
	public Marca() {
	}
	
//Criando variaveis da classe Marca	
	public Marca(String [] dados) {
		
		String[] nome = dados[3].split("=");
		String[] preco = dados[4].split("=");
		this.nome = nome[1].trim();
		this.preco = Double.parseDouble(preco[1].trim());	}

	
//M�todos GET e SET que v�o, respectivamente, pegar informa��o e guardar a informa��o na variavel	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
//Mostra informa��o da variavel no arquivo TXT	
	@Override
	public String toString() {
		return "Marca= " + nome + ", Pre�o= " + preco;
		
	}
	
}
