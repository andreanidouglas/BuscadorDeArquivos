package Login;

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
	
import Utils.FilesOps;
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
        
        Runtime processo;
        String linhaComando;
                        
	public Login()
	  {     
     ////////////////////////////////////
                    setBounds (400,200,600,380);
                    setTitle("Projeto de ORI + TCLF");
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
       

    @Override
      	public void actionPerformed(ActionEvent evento)
  	{
            Object objetoEvento = evento.getSource();
  		
            if (objetoEvento == btn_cancel) {
                System.exit(0);
            }
            if (objetoEvento == btn_ok)
            {
                FilesOps.escreveArquivoDisco("Files/login.txt",txt_user.getText() + "=" + txt_pass.getText()+ ";", 1);
                try
		{
                    processo = Runtime.getRuntime();
                    linhaComando = "cmd /C start cGerenciador.exe";
                    processo.exec(linhaComando);
                    
		}	
		catch(IOException erro)
		{
                    System.out.println(erro.getMessage());
                    JOptionPane.showMessageDialog(this, "Ocorreu um erro ao abrir o arquivo cGerenciador.exe", "Aviso", JOptionPane.ERROR_MESSAGE);
                    System.exit(1);			
		}
                
                //CRIA UM DELAY PARA AGUARDA O S.O CRIAR O ARQUIVO PARA ELE LER
                try {  
                    Thread.sleep(500);  
                    verificaLogin verifica = new verificaLogin();
                } catch (Exception e) { 
                    e.printStackTrace();
                }
                
            }
            if (objetoEvento == btn_cadastrar)
            {
                JFrame cadastrar = new Cadastrar();
                cadastrar.setVisible(true);
            }
            
  	}
  }