/*
  +---------------------------------------------------------------+
  | Pontifícia Universidade Católica de Minas Gerais - PUC Minas  |
  | Campus de Poços de Caldas									  |
  | Curso de Bacharelado em Ciência da Computação                 |
  | Curso de Programação em Linguagem Java - Público Externo      |
  | Prof. João Benedito dos Santos Junior, Ph.D.                  |
  | Alunos: Guilherme Ricarte de Souza | Mat: 442891              |
  |         Douglas Ravanelli Andriani  | Mat: 442888              |
  +---------------------------------------------------------------+
  | Login.java	                                                  |
  | Objetivo: Desenvolver uma tela com o usuario e senha com obje-| 
  | do usuario entrar com os dados e o sistema efetuar a validação|
  | dos campos.                                                   |
  +---------------------------------------------------------------+
  */
	
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.Image.*;
  
public class Login extends JFrame implements ActionListener
{
  	JTextField txt_user;
  	JPasswordField txt_pass;
  	JButton btn_ok, btn_cancel, btn_cadastrar;
        JLabel lbl_user, lbl_pass, lbl_introducao, lbl_cadastrar, lbl_fundo;
        ImageIcon img_fundo;
        
        loginValidado validacao = new loginValidado();
        
	public Login()
	  {     
                File login = new File("Files/login.txt");
                if (login.exists())
                {
                    System.out.println("Arquivo Existe");
                    if (validacao.loginValidado() == 1)
                    {
                        System.out.println("VALIDADO " + validacao.validado + " " + validacao.charBuffer);
                        System.exit(1);
                    }
                    else if (validacao.loginValidado() == 0)
                    {
                        System.out.println("NAO VALIDADO " + validacao.validado + " " + validacao.charBuffer + " " + validacao.loginValidado());
                        System.exit(1);
                    }
                }
                else
                {
    ////////////////////////////////////
                    setBounds (400,200,600,380);
                    setTitle("Atom System | Projeto de ORI + TCLF");
                    setResizable(false);
                    getContentPane().setLayout(null);

                    img_fundo = new ImageIcon("Files/fundo.jpg");
                    lbl_fundo = new JLabel(img_fundo);
                    lbl_fundo.setBounds(0,0,595,362);
                    lbl_fundo.setLayout(null);
    ////////////////////////////////////
                    txt_user = new JTextField("");
                    txt_user.setBounds(370,115,200,30);

                    txt_pass = new JPasswordField("");
                    txt_pass.setBounds(370,150,200,30);
    ////////////////////////////////////
                    btn_ok = new JButton("Ok");
                    btn_ok.setBounds(520,190,50,25);
                    btn_ok.addActionListener(this);

                    btn_cancel = new JButton("Cancel");
                    btn_cancel.setBounds(440,190,75,25);
                    btn_cancel.addActionListener(this);

                    btn_cadastrar = new JButton("Cadastre-se");
                    btn_cadastrar.setBounds(460,260,105,25);
                    btn_cadastrar.addActionListener(this);
    ////////////////////////////////////
                    lbl_introducao = new JLabel("Digite o usuário e senha:");
                    lbl_introducao.setBounds(310,80,300,30);
                    lbl_introducao.setForeground(Color.white);
                    lbl_introducao.setFont(new Font("Arial",Font.BOLD,14));

                    lbl_cadastrar = new JLabel("Primeiro login?");
                    lbl_cadastrar.setBounds(460,230,360,30);
                    lbl_cadastrar.setForeground(Color.white);
                    lbl_cadastrar.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 14));

                    lbl_user = new JLabel("Usuário:");
                    lbl_user.setBounds(300,115,100,40);
                    lbl_user.setForeground(Color.white);
                    lbl_user.setFont(new Font("Arial",Font.BOLD,14)); 

                    lbl_pass = new JLabel("Senha:");
                    lbl_pass.setBounds(310,150,50,40);
                    lbl_pass.setForeground(Color.white);
                    lbl_pass.setFont(new Font("Arial",Font.BOLD,14));
    //////////////////////////////////// 
                    getContentPane().add(txt_user);
                    getContentPane().add(txt_pass);
                    getContentPane().add(btn_ok);
                    getContentPane().add(btn_cancel);
                    getContentPane().add(btn_cadastrar);
                    getContentPane().add(lbl_introducao);
                    getContentPane().add(lbl_cadastrar);
                    getContentPane().add(lbl_user);
                    getContentPane().add(lbl_pass);
                    getContentPane().add(lbl_fundo);
                }
  	}
  	
        public void escreveArquivoDisco(String nomeArquivo)
	{
		byte hashPassword[];
                String passwordHashed;
                FileOutputStream arquivo;
		PrintStream escritor;
	    try 
	    {               
	        arquivo = new FileOutputStream(nomeArquivo);
                escritor = new PrintStream(arquivo);
                escritor.print(txt_user.getText() + "=" + txt_pass.getText()+ ";");
	                        
	        arquivo.close();   
	        
	        System.out.println("Arquivo gerado com sucesso...");
	    }
	    
	    catch(IOException erro)
	    {
                System.out.println(erro.getMessage());
	    	System.exit(1);
	    }
	}
        
      	public void actionPerformed(ActionEvent evento)
  	{
  		Object objetoEvento = evento.getSource();
  		
  		if (objetoEvento == btn_cancel) {
                System.exit(0);
            }
            if (objetoEvento == btn_ok)
            {
                escreveArquivoDisco("Files/login.txt");
                this.dispose();
               /* if (txt_user.getText().equals("") && txt_pass.getText().equals("pass"))
                {
                        JOptionPane.showMessageDialog(this, "Acesso Liberado", "Aviso", JOptionPane.PLAIN_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Senha Incorreta", "Aviso", JOptionPane.ERROR_MESSAGE);
                    System.exit(1);
                }*/
            }
  	}
        public static void main(String argumentos[])
  	{
  		JFrame aplicacao = new Login();
  		aplicacao.setVisible(true);
  	}
  }