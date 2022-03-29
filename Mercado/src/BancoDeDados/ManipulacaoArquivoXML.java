package BancoDeDados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import Handler.XMLHandlerProdutos;
import Modelos.Produto;
import Util.ListaDeProdutos;


public class ManipulacaoArquivoXML {

	private static String nomeDoArquivo = "CadastroDeProduto.xml";

	public static void SalvarArquivoXML() throws ParserConfigurationException, UnsupportedEncodingException, FileNotFoundException, IOException, TransformerException {

		
//Criando fábrica,construtor de documento e documento do XML		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();

		Element produtosTag = doc.createElement("produtos");
		doc.appendChild(produtosTag);

//Criando tag para cada elemento que será salvo no XML	
		for(Produto a :ListaDeProdutos.getInstance()) {			
			Element produtoTag = doc.createElement("Produto");
			produtoTag.setAttribute("id", "1");
			produtosTag.appendChild(produtoTag);			

			Element nomeTag = doc.createElement("Nome");
			nomeTag.setTextContent(a.getNome());
			produtoTag.appendChild(nomeTag);	

			Element catTag = doc.createElement("Categoria");
			catTag.setTextContent(a.getCategoria());
			produtoTag.appendChild(catTag);	

			Element marcaTag = doc.createElement("Marca");
			produtoTag.appendChild(marcaTag);

			Element nomeMarcaTag = doc.createElement("NomeMarca");
			nomeMarcaTag.setTextContent(a.getMarca().getNome());
			marcaTag.appendChild(nomeMarcaTag);	

			Element precoTag = doc.createElement("Preco");
			precoTag.setTextContent(String.valueOf(a.getMarca().getPreco()));
			marcaTag.appendChild(precoTag);

		}

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans  = tf.newTransformer();
		
		trans.setOutputProperty( OutputKeys.INDENT,"yes");
		trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","4" );
		
		DOMSource source = new DOMSource(doc);

		try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(nomeDoArquivo),"ISO-8859-1")){			
			StreamResult result = new StreamResult(osw);	
			trans.transform(source, result);
		}

	}
	
//Lendo informações do arquivo XML	
	public static void LerArquivoXML() throws ParserConfigurationException, SAXException, UnsupportedEncodingException, FileNotFoundException, IOException {
		
		SAXParserFactory spf =  SAXParserFactory.newInstance();		
		SAXParser parser = spf.newSAXParser();
		
		File arquivoXML = new File(nomeDoArquivo);
		if(arquivoXML.exists()) 
		{
			try(InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeDoArquivo),"ISO-8859-1")){
			InputSource source =  new InputSource(isr);
			XMLHandlerProdutos handler = new XMLHandlerProdutos();			
			parser.parse(source, handler);	
			}
	
		}else {try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(nomeDoArquivo),"ISO-8859-1")){}	}	
	}
	
	
	
}
