package View;

import java.io.BufferedReader;
import java.io.IOException;

import Modelos.Produto;
import Util.ListaDeProdutos;

//Classe que mostra todos os tipos de mansagens na tela	
public class ViewCRUDProduto {

//ViewMenuPrincipal mostra as opções no menu
public static int ViewMenuPrincipal(BufferedReader reader) throws NumberFormatException, IOException {
		
		System.out.println("1 - Cadastrar Produto\n"
						+ "2 - Listar Produtos\n"
						+ "3 - Deletar Produto\n"
						+ "4 - Editar Produto\n"
						+ "5 - Sair");
		
		System.out.println();
		
		return Integer.parseInt(reader.readLine());	
	}
	
//Método que mostra o menu da categoria,com condiçao switch para escolher entre as opções
public static int ViewMenuCat(BufferedReader reader) throws NumberFormatException, IOException {
		
	System.out.println("|== PRODUTO ==|\n");
	System.out.println("++ Categoria:\n"
						+ "[1] Alimento\n"
						+ "[2] Limpeza\n"
						+ "[3] Bebida\n"
						+ "[4] Higiene Pessoal\n"
						+ "[5] PetShop");

		return Integer.parseInt(reader.readLine());	
	}
	
//View mostrando cada atributo que está sendo salvo
public static String[] ViewMenuSalvarProduto(BufferedReader reader) throws IOException {
	String[] menuProd = {"Nome do Produto: ", "Marca: ","Preço: "};
	String[] dadosProd = {"","","",""};
	
	for(int i=0; i < menuProd.length; i++) {
		System.out.println(menuProd[i]);
		dadosProd[i] = reader.readLine();			
	}
		
	return dadosProd;
}
	
//View mostra a lista de produtos cadastrados e se usuario vai deletar ou editar
public static int ViewMenuEditarOuDeletarProduto(String editar_deletar,BufferedReader reader) throws NumberFormatException, IOException {		

	for (int i = 0; i < ListaDeProdutos.getInstance().size(); i++) {
		System.out.println(i + " - " + ListaDeProdutos.getInstance().get(i));
	}
	System.out.println();
	System.out.println("Dentre a lista acima, escolha o indice do produto que deseja "+ editar_deletar);
					
	return Integer.parseInt(reader.readLine());
}

//View Edicao,usuario escolhe qual atributo editar
public static String[] ViewOpcaoEdicao (BufferedReader reader) throws IOException {		
	String[] dadosEditados = {"",""};
	
	System.out.println("Escolha o Atributo que deseja alterar:");
	System.out.println(   "1 - Nome do Produto\n" 
						+ "2 - Categoria\n" 
						+ "3 - Marca\n"
						+ "4 - Preço\n");

	dadosEditados[0] = reader.readLine();
	System.out.println("Escreva o novo valor do atributo");
	dadosEditados[1] = reader.readLine();		
	
	return dadosEditados;
}

//View lista de produtos editada com um pouco de design
public static void ViewListaProdutosEditada() {
	
	for (Produto a : ListaDeProdutos.getInstance()) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("|-----------Produto------------");
		System.out.println("| Nome do Produto = " + a.getNome());
		System.out.println("| Categoria = " + a.getCategoria());
		System.out.println("| Marca = " + a.getMarca().getNome());
		System.out.println("| Preço: " + a.getMarca().getPreco());
		System.out.println("|-------------------------------");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.println();	
}
}

//View mensagem qundo um metodo do CRUD for efetuado
public static void ViewMsgFinal(int op) {
	
	String[] msgFinal = {   "Produto salvo com sucesso!!",
							"Produto editado com sucesso!!",
							"Produto deletado com sucesso!!",
							"Fim do Programa!!"};
	
	System.out.println(msgFinal[op]);
}


}
