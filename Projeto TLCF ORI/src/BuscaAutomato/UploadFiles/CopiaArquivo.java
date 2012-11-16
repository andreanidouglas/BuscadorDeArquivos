package BuscaAutomato.UploadFiles;

import java.io.*;

public class CopiaArquivo {
    
    public static File CopiaArquivo(File inputFilePath) throws IOException
    {
        String strOutputFile;
        strOutputFile = "Files/" + inputFilePath.getName();
     
        //Instancia objetos de leitura binaria
        FileInputStream fis =  null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
        //Instancia objetos de escrita binaria
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        DataOutputStream dos = null;
        
        ////Instancia objetos de leitura de text
        RandomAccessFile rafi = null;
        
        try
        {
            fis = new FileInputStream(inputFilePath);
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);
            
            fos = new FileOutputStream(strOutputFile);
            bos = new BufferedOutputStream(fos);
            dos = new DataOutputStream(bos);
         //tenta fazer a copia se for arquivo binario   
            while (dis.available() != 0)
            {
                dos.write(dis.read());
            }
           
         //se for arquivo de texto, o arquivo vai estar vazio, entao faz a copia de texto.
            rafi = new RandomAccessFile(strOutputFile, "rw");
            rafi.seek(0L);
            if(rafi.read() == -1)
            {
                RandomAccessFile rafo = new RandomAccessFile(inputFilePath, "r");
                int ch;
                while ((ch = rafo.read()) != -1)
                {
                    rafi.write(ch);       
                }
                rafo.close();
            }
            System.out.println("Arquivo Copiado com Sucesso...");
            File fileCreated = new File("Files/" + inputFilePath.getName());
            
            
            //fecha todos os streams abertos        
            rafi.close();
            fis.close();
            bis.close();
            dis.close();
            fos.close();
            bos.close();
            dos.close();
            
            return fileCreated;
        }
        catch (Exception error)
        {
            error.printStackTrace();
        }
        return null;
    }    
}
