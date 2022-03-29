package Util;

import java.util.ArrayList;
import java.util.List;

import Modelos.Produto;

public class ListaDeProdutos {

//método usado apenas para criar a lista e retorna-la para mostrar em outros métodos
private static List<Produto> listaDeProdutos = new ArrayList<Produto>();
	
	public static List<Produto> getInstance(){
		return listaDeProdutos;
	}

	
}
