/*+---------------------------------------------------------------+
  | Pontif�cia Universidade Cat�lica de Minas Gerais - PUC Minas  |
  | Campus de Po�os de Caldas									  |
  | Curso de Bacharelado em Ci�ncia da Computa��o                 |
  | Curso de Programa��o em Linguagem Java - P�blico Externo      |
  | Prof. Jo�o Benedito dos Santos Junior, Ph.D.                  |
  | Alunos: Guilherme Ricarte de Souza | Mat: 442891              |
  |         Douglas Ravaneli Andriani  | Mat: 442888              |
  +---------------------------------------------------------------+
  | Login.java	                                                  |
  | Objetivo: Desenvolver uma tela com o usuario e senha com obje-| 
  | do usuario entrar com os dados e o sistema efetuar a valida��o|
  | dos campos.                                                   |
  +---------------------------------------------------------------+*/
	
	import java.awt.*;
	import javax.swing.*;
	import java.awt.event.*;
  	
  
public class Login extends JFrame implements ActionListener
{
  	JTextField txt_user;
  	JPasswordField txt_pass;
  	JButton btn_ok, btn_cancel;
    JLabel lbl_user, lbl_pass, lbl_introducao;
    
    String senha = "pass", nome = "user";
    
	public Login()
	  {
	  	setBounds (550,250,220,175);
	  	setTitle("Projeto de ORI + TCLF");
	  	setResizable(false);
	  	getContentPane().setLayout(null);
	  		
	  	txt_user = new JTextField("");
	  	txt_user.setBounds(70,40,135,25);
	  	
	  	txt_pass = new JPasswordField("");
		txt_pass.setBounds(70,75,135,25);
		  	
		btn_ok = new JButton("Ok");
		btn_ok.setBounds(155,110,50,25);
		btn_ok.addActionListener(this);
				
		btn_cancel = new JButton("Cancel");
		btn_cancel.setBounds(70,110,75,25);
		btn_cancel.addActionListener(this);
				
		lbl_introducao = new JLabel("Digite o Usu�rio e Senha:");
		lbl_introducao.setBounds(10,05,150,30);
		
		lbl_user = new JLabel("Usu�rio:");
		lbl_user.setBounds(10,35,50,40);
		
		lbl_pass = new JLabel("Senha:");
		lbl_pass.setBounds(10,70,50,40);
						
		getContentPane().add(txt_user);
		getContentPane().add(txt_pass);
		getContentPane().add(btn_ok);
		getContentPane().add(btn_cancel);
		getContentPane().add(lbl_introducao);
		getContentPane().add(lbl_user);
		getContentPane().add(lbl_pass);
		
		System.out.println(nome);  
		System.out.println(senha);
		
  	}
  	
  	public void actionPerformed(ActionEvent evento)
  	{
  		Object objetoEvento = evento.getSource();
  		
  		if (objetoEvento == btn_cancel)
  			System.exit(0);
  			
  		if (objetoEvento == btn_ok)
  		{
	  		if (txt_user.getText().equals(nome) && txt_pass.getText().equals(senha))
	  			JOptionPane.showMessageDialog(this, "Acesso Liberado", "Aviso", JOptionPane.PLAIN_MESSAGE);
	  		else
				JOptionPane.showMessageDialog(this, "Senha Incorreta", "Aviso", JOptionPane.ERROR_MESSAGE);
  		}
  		
  	}
  	
	public static void main(String argumentos[])
  	{
  		JFrame aplicacao = new Login();
  		aplicacao.setVisible(true);
  	}
  	
  	
  }