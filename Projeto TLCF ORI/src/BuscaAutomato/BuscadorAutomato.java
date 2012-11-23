package BuscaAutomato;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public class BuscadorAutomato 
{
    private DocumentBuilderFactory construtorDocumento;
    private DocumentBuilder parser;
    private Document documentoXML;
    private Element tagsAgrupamento, listaArquivos, listaPalavras, listaEstados;
    private NodeList listaTagsArquivo, ArquivoChilds, listaTagsPalavras, listaTagsEstados; 
    private NamedNodeMap atributos;  
    public static String idArquivo,tipoArquivo, caminhoArquivo, idPalavra, proxEstado, letraAutomato;
    int i,j,k, totalTagsArquivo;    
   
    public BuscadorAutomato() {
    }
    
    
    public void lerXML()throws Exception
    {
         
        construtorDocumento = DocumentBuilderFactory.newInstance();
        parser = construtorDocumento.newDocumentBuilder();
        documentoXML = parser.parse("Files/Automato.xml");
        
        tagsAgrupamento = documentoXML.getDocumentElement();             
    	
	try
	{
            listaTagsArquivo = tagsAgrupamento.getElementsByTagName("Arquivo");	      
            totalTagsArquivo = listaTagsArquivo.getLength();

            System.out.println("Total de Tags <Arquivo> = " + totalTagsArquivo);

            for (i = 0; i < totalTagsArquivo; i++) 
            {
                listaArquivos = (Element)listaTagsArquivo.item(i);
                idArquivo = listaArquivos.getAttribute("id");
                tipoArquivo = listaArquivos.getAttribute("tipo");
                caminhoArquivo = listaArquivos.getAttribute("caminho");
                listaTagsPalavras = listaArquivos.getElementsByTagName("Palavra");

                for (j=0; j<listaTagsPalavras.getLength();j++)
                {
                    listaPalavras = (Element)listaTagsPalavras.item(i);
                    idPalavra = listaPalavras.getAttribute("id");
                    listaTagsEstados = listaPalavras.getElementsByTagName("q"+j);

                    for(k=0; k<listaTagsEstados.getLength();k++)
                    {
                        listaEstados = (Element)listaTagsEstados.item(i);
                        letraAutomato = listaEstados.getTextContent();
                        proxEstado = listaEstados.getAttribute("qp");
                    }
                }    
            }
            
	          		     		         		     		
     	}
     	catch(Exception erro)
     	{
     		System.out.println("Erro de processamento do documento XML \n" + erro.getStackTrace());
                
     	}   
    }
    
}