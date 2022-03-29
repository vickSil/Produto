package Aplicacao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import Modelos.Produto;
import View.ViewCRUDProduto;

public class Main {
	
//Main:chamando os outros métodos sem apresentar nenhum Syso,os mesmo estão no pacote View	
public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException, NumberFormatException, SAXException {
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	CRUDProduto.ListarProdutos(1);
	
	int menu = 0;
	
	while (menu != 5) {
		
			menu = ViewCRUDProduto.ViewMenuPrincipal(reader);
			
			switch(menu) {		
			case 1:
				CRUDProduto.SalvarProduto(reader);
				break;
				
			case 2:
				CRUDProduto.ListarProdutos(0);
				break;
				
			case 3:
				CRUDProduto.DeletarProduto(reader);
				break;
				
			case 4:
				CRUDProduto.EditarProduto(reader);
				break;
				
			case 5:
				ViewCRUDProduto.ViewMsgFinal(3);
				break;
			}
	//chamando do CRUD pois os métodos principais estão lá	
		
	}
	
	
}
}
