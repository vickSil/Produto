package Aplicacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import BancoDeDados.ManipulacaoArquivoTXT;
import BancoDeDados.ManipulacaoArquivoXML;
import Modelos.Marca;
import Modelos.Produto;
import Util.ListaDeProdutos;
import View.ViewCRUDProduto;

public class CRUDProduto {

	
//Método que salva o produto
	public static void SalvarProduto(BufferedReader reader) throws IOException, ParserConfigurationException, TransformerException {

		Produto produto = new Produto();
		Marca marcaProd = new Marca();
		
		int cat;
		cat = ViewCRUDProduto.ViewMenuCat(reader);
		
		String[] dadosProduto = ViewCRUDProduto.ViewMenuSalvarProduto(reader);
		
			switch(cat) {

			case 1:
				produto.setCategoria(dadosProduto[3] = "Alimento");
				break;
			case 2:
				produto.setCategoria(dadosProduto[3] = "Limpeza");				
				break;
			case 3:
				produto.setCategoria(dadosProduto[3] = "Bebida");				
				break;
			case 4:
				produto.setCategoria(dadosProduto[3] = "Higiene Pessoal");				
				break;
			case 5:
				produto.setCategoria(dadosProduto[3] = "PetShop");				
				break;
			}

			produto.setNome(dadosProduto[0]);
			marcaProd.setNome(dadosProduto[1]);
			marcaProd.setPreco(Double.parseDouble(dadosProduto[2]));
			produto.setMarca(marcaProd);
			
			ListaDeProdutos.getInstance().add(produto);

			ManipulacaoArquivoTXT.SalvarArquivoTXT();
			ManipulacaoArquivoXML.SalvarArquivoXML();
			
			ViewCRUDProduto.ViewMsgFinal(0);
			
			System.out.println();
	}
	

//Método que lista os produtos cadastrados
	public static void ListarProdutos(int op) throws FileNotFoundException, IOException, ParserConfigurationException, TransformerException, SAXException {

		ListaDeProdutos.getInstance().clear();
		
		ManipulacaoArquivoXML.LerArquivoXML();
		
		if(op == 0) {
		
		ViewCRUDProduto.ViewListaProdutosEditada();
		
		System.out.println();
		
		}
		}	
	
	
//Método que deleta o produto que o usuário escolher	
	public static void DeletarProduto(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException {

		int indice = ViewCRUDProduto.ViewMenuEditarOuDeletarProduto("deletar", reader);

		ListaDeProdutos.getInstance().remove(indice);

		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();
		
		ViewCRUDProduto.ViewMsgFinal(2);
		System.out.println();
	}
	
	
//Método que edita o produto que o usuário escolher
	public static void EditarProduto(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, SAXException, TransformerException {

		String[] dadosEditados = {"",""};
		int indice = ViewCRUDProduto.ViewMenuEditarOuDeletarProduto("editar", reader);

		Produto prod = ListaDeProdutos.getInstance().get(indice);

		dadosEditados = ViewCRUDProduto.ViewOpcaoEdicao(reader);

		switch (Integer.parseInt(dadosEditados[0])) {
		case 1:
			prod.setNome(dadosEditados[1]);
			break;
		case 2:
			prod.setCategoria(dadosEditados[1]);
			break;
		case 3:
			prod.getMarca().setNome(dadosEditados[1]);
			break;
		case 4:
			prod.getMarca().setPreco(Double.parseDouble(dadosEditados[1]));
			break;
		}		
		ListaDeProdutos.getInstance().set(indice, prod);
		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();
		
		ViewCRUDProduto.ViewMsgFinal(1);
		
		System.out.println();
	}
		
	}




