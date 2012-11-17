
package BuscaAutomato.UploadFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class RecordFiles 
{
    
    private File uploadArquivo;
    private String metadados;
    private File metaFile;
    private Long fileId;

    public RecordFiles() {
    }

    
    
    public void setUploadArquivo(File uploadArquivo) {
        this.uploadArquivo = uploadArquivo;
    }

    public String getMetadados() {
        return metadados;
    }

    public void setMetadados(String metadados) {
        this.metadados = metadados;
    }
    

    public void gravarDisco() throws IOException
    {
        try (FileWriter escritor = new FileWriter(metaFile, true); PrintWriter sobrescritor = new PrintWriter(escritor)) {
        metaFile = new File("Files/bancoArquivos.txt");
        if (!metaFile.exists())
        {
                metaFile.createNewFile();
                fileId = 0L;
                sobrescritor.println("Banco De Arquivos:"); //necessario para a correta execucao do codigo em C                
        }
        else 
        {
            fileId = getFileId(metaFile) + 1;
        }
            sobrescritor.println(fileId.toString() + '#' + uploadArquivo.getName() + '=' + metadados + '@' + getTipoArquivo(uploadArquivo) + '$' + 0 + ';');
            sobrescritor.flush();
        }
    }

    public static long getFileId(File bancoArquivos) throws IOException 
    {
        FileReader leitor = new FileReader(bancoArquivos);
        int c;
        
        String leitura = null;
       
              
        while ((c = leitor.read()) != -1)
        {
            if ((char)c == '\n')
            {
                leitor.mark(40);
            }
            
        }
        leitor.reset();
        while ((c=leitor.read()) != '#') 
        {
            leitura = leitura + (char)c;
        }
        return Long.parseLong(leitura);
    }
    
    public static String getTipoArquivo(File selectedFile)
    {
       String caminho;
       String[] split;
       String extensao;
       caminho = selectedFile.getPath().toString();
       split = caminho.split("[.]");
       System.out.println("tamanho " +split.length);
       System.out.println("caminho " + caminho);
       extensao = split[split.length - 1];
       
       System.out.println(extensao);
       switch (extensao)
       {
           case "jpg":
               return "Imagem";
           case "png":
               return "Imagem";
           case "gif":
               return "Imagem";
           case "doc":
               return "Texto";
           case "docx":
               return "Texto";
           case "bmp":
               return "Imagem;";
           case "mp3":
               return "Audio";
           case "wav":
               return "Audio";
           case "txt":
               return "Texto";
           default:
               return "Não definido";
       }
    }
}
