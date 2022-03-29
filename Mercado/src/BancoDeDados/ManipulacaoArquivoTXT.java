package BancoDeDados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Modelos.Produto;
import Util.ListaDeProdutos;

public class ManipulacaoArquivoTXT {

//Criando arquivo TXT	
	
private static String nomeDoArquivo = "CadastroDeProduto.txt";
	
//Salvando informações na lista do arquivo TXT
	public static void SalvarArquivoTXT() throws IOException {
		
		try (BufferedWriter buffer = new BufferedWriter(new FileWriter(nomeDoArquivo));
				PrintWriter pw = new PrintWriter(buffer)) {
			for (Produto a : ListaDeProdutos.getInstance())
				pw.println(a);
		}
		
	}
	
//Lendo a lista que foi salva no arquivo TXT
	public static void LerArquivoTXT() throws FileNotFoundException, IOException {
		
		try(FileWriter arq = new FileWriter(nomeDoArquivo,true)){};

		String line;

		try (BufferedReader reader = new BufferedReader(new FileReader(nomeDoArquivo))) {

			while ((line = reader.readLine()) != null && !"".equals(line)) {				
					Produto produto = new Produto(line);
					ListaDeProdutos.getInstance().add(produto);				
			}
		} 
		
	}
	
}
