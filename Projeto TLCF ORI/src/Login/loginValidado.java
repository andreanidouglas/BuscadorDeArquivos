import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.swing.JFrame;

public class loginValidado {
    char validado;
    char charBuffer;

    public int loginValidado()
    {
        try
        {
            FileInputStream arquivo;
            arquivo = new FileInputStream ("Files/login.txt");
            Reader pointer;
            pointer = new InputStreamReader(arquivo);
            int intBuffer = pointer.read();
            while (intBuffer != -1)
            {
               charBuffer = (char)intBuffer;
               if (charBuffer == '@')
               {
                   break;
               }
               validado = charBuffer;
               intBuffer = pointer.read();
            }
            if (((int)validado - 48) >= 0 && ((int)validado - 48) < 3)
            {
                return (int)validado - 48 ;
            }

        }
        catch (IOException e)
        {
            System.out.println("Exception");
        }
        return 0;
    }
}
