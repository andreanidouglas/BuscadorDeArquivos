package Login;


import BuscaAutomato.MainFrameAutomato;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class verificaLogin extends JFrame {
    File login = new File("Files/login.txt");

    loginValidado validacao = new loginValidado();

    public verificaLogin() 
    {
        if (login.exists())
        {
            System.out.println("Arquivo Existe");
            if (validacao.loginValidado() == 1)
            {
                System.out.println("VALIDADO - ACESSO LIBERADO " + validacao.getValidado() + validacao.getCharBuffer());
                JOptionPane.showMessageDialog(this, "Acesso Liberado", "Aviso", JOptionPane.PLAIN_MESSAGE);
                //this.dispose();
                MainFrameAutomato busca = new MainFrameAutomato();
                busca.setVisible(true);
            }
            else if (validacao.loginValidado() == 0)
            {
                System.out.println("NAO VALIDADO - SENHA INCORRETA OU USUÁRIO INEXISTENTE" + validacao.getValidado() + " " + validacao.getCharBuffer() + " " + validacao.loginValidado());
                JOptionPane.showMessageDialog(this, "Senha Incorreta ou Usuário Inexistente", "Aviso", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
