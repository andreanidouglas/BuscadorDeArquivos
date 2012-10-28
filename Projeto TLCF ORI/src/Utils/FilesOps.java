package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;


public class FilesOps 
{
    
    public static void escreveArquivoDisco(String nomeArquivo, String dados, int flag)
    {
            FileOutputStream arquivo1;
            PrintStream escritor;
        try 
        {               
            if (flag == 0)
            {
                File arquivo = new File(nomeArquivo);
                if (!arquivo.exists())
                {
                    arquivo.createNewFile();
                }
                FileWriter filewriter = new FileWriter(arquivo, true);
                try (PrintWriter printwriter = new PrintWriter(filewriter)) 
                {
                    printwriter.println(dados);
                    printwriter.flush();
                }
            }
            else
            {
                arquivo1 = new FileOutputStream(nomeArquivo);
                escritor = new PrintStream(arquivo1);
                escritor.print(dados);

                arquivo1.close();   
            }
            System.out.println("Arquivo gerado com sucesso...");
        }

        catch(IOException erro)
        {
            System.out.println(erro.getMessage());
            System.exit(1);
        }
    }        

    public static char lerArquivoDisco(String localArquivo, char parametro) {
        char charBuffer, validado = 0;
        try
        {
            FileInputStream arquivo;
            arquivo = new FileInputStream (localArquivo);
            Reader pointer;
            pointer = new InputStreamReader(arquivo);
            
            int intBuffer = pointer.read();
            while (intBuffer != -1)
            {
               charBuffer = (char)intBuffer;
               if (charBuffer == parametro)
               {
                   break;
               }
               validado = charBuffer;
               intBuffer = pointer.read();
            }
            return validado;
        }
        catch (IOException e)
        {
            System.out.println("Exception " + e.getMessage());
        }
        return '0';
        
    }
}
