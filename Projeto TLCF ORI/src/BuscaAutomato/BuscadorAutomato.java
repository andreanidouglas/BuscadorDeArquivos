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
    public static String idArquivo,tipoArquivo, caminhoArquivo, idPalavra, proxEstado, letraAutomato, idEstado;
    int i,j,k,l,m, totalTagsArquivo; 
    char[] stringBusca;
    private String[] retornoResultado, vazio;
   
    public BuscadorAutomato() {
    }
    
    
    public String[] lerXML(String busca, String tipo)throws Exception
    {
        stringBusca = busca.toCharArray();
        m=1;
        vazio=null;
        construtorDocumento = DocumentBuilderFactory.newInstance();
        parser = construtorDocumento.newDocumentBuilder();
        documentoXML = parser.parse("Files/Automato.xml");
        
        tagsAgrupamento = documentoXML.getDocumentElement();             
    	
	try
	{
            listaTagsArquivo = tagsAgrupamento.getElementsByTagName("Arquivo");	      
            totalTagsArquivo = listaTagsArquivo.getLength();

            System.out.println("Total de Tags <Arquivo> = " + totalTagsArquivo);

            for (i=0; i < totalTagsArquivo; i++) 
            {
                listaArquivos = (Element)listaTagsArquivo.item(i);
                idArquivo = listaArquivos.getAttribute("id");
                tipoArquivo = listaArquivos.getAttribute("tipo");
                caminhoArquivo = listaArquivos.getAttribute("caminho");
                if(!tipo.isEmpty() && !tipo.equals(tipoArquivo))
                {
                    return vazio;
                }
                listaTagsPalavras = listaArquivos.getElementsByTagName("Palavra");
                System.out.println("id tipo caminho:" + idArquivo + tipoArquivo + caminhoArquivo);
                

                for (j=0; j<listaTagsPalavras.getLength();j++)
                {
                    listaPalavras = (Element)listaTagsPalavras.item(j);
                    idPalavra = listaPalavras.getAttribute("id");
                    listaTagsEstados = listaPalavras.getElementsByTagName("q");
                    System.out.println("id palavra" + idPalavra + listaTagsPalavras.getLength() + j);

                    for(k=0; k<listaTagsEstados.getLength();k++)
                    {
                        listaEstados = (Element)listaTagsEstados.item(k);
                        
                        letraAutomato = listaEstados.getTextContent();
                        proxEstado = listaEstados.getAttribute("qp");
                        idEstado = listaEstados.getAttribute("id");
                        letraAutomato = listaEstados.getTextContent();
                        System.out.println("letra Proxestado:" + letraAutomato + proxEstado);
                        
                        if(stringBusca[k] != letraAutomato.charAt(0))
                        {
                            return vazio;
                        }
                    }
                    retornoResultado[m] = caminhoArquivo.toLowerCase();
                    m++;
                }
                
            }
            return retornoResultado;    		
     	}
     	catch(Exception erro)
     	{
     		System.out.println("Erro de processamento do documento XML \n" + erro.getStackTrace());
                
     	}   
        return null;
    }
    
}