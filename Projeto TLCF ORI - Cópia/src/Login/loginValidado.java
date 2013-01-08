package Login;

import Utils.FilesOps;

public class loginValidado {
    private char validado;
    private char charBuffer;

    public int loginValidado()
    {
        char validacao;
 
            validacao = FilesOps.lerArquivoDisco("Files/login.txt", '@');
            if (((int)validacao - 48) >= 0 && ((int)validacao - 48) < 3)
            {
                return (int)validacao - 48 ;
            }
        
        return 0;
    }

    public char getValidado() {
        return validado;
    }

    public char getCharBuffer() {
        return charBuffer;
    }
}