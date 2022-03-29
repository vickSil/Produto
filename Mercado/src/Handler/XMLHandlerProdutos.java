package Handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import Modelos.Marca;
import Modelos.Produto;
import Util.ListaDeProdutos;



public class XMLHandlerProdutos extends DefaultHandler{

	private StringBuilder objeto;
	Produto prod;
	Marca marca;
	
	//inicializando elemento (vai usar para ler o XML depois)
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if(qName.equals("Produto")) {
			prod = new Produto();
			marca = new Marca();
		}else {
			objeto = new StringBuilder();
		}
		
	}
	
//mostrando no XML com as respectivas tags
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if(qName.equals("Nome")) {
			
	// teste se o elemento está vazio	
	//	System.out.println(objeto.toString().isEmpty()); 
			prod.setNome(objeto.toString());
		}else if(qName.equals("Categoria")) {
			prod.setCategoria(objeto.toString());
		}else if(qName.equals("NomeMarca")) {
			marca.setNome(objeto.toString());
		}else if(qName.equals("Preco")) {
			marca.setPreco(Double.parseDouble(objeto.toString()));
			prod.setMarca(marca);
			ListaDeProdutos.getInstance().add(prod);
		}
		
	}
		
		
		
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		objeto.append(ch, start, length);		
	}
	
	
	@Override
	public void error(SAXParseException e) throws SAXException {
	
	}
		
}
