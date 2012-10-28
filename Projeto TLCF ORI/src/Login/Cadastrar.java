import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Image.*; 

public class Cadastrar extends JFrame implements ActionListener
{
    JTextField txt_nome, txt_rua, txt_num, txt_comp, txt_cid, txt_cep, txt_tel, txt_email, txt_rg, txt_user;
    JPasswordField txt_pass;
    JFormattedTextField txt_dta_nasc, txt_cpf;
    JLabel lbl_intro, lbl_nome, lbl_rua, lbl_num, lbl_comp, lbl_cid, lbl_cep, lbl_nasc, lbl_tel, lbl_email, lbl_cpf, lbl_rg, lbl_user, lbl_pass;
    JButton btn_cad, btn_cancel;
    
    public Cadastrar()
    {
        setBounds (400,250,600,290);
        setTitle("Cadastrar novo usuário | Projeto de ORI + TCLF");
        setResizable(false);
        getContentPane().setLayout(null);

        txt_nome = new JTextField("");
        txt_nome.setBounds(55,40,320,25);
        
        txt_dta_nasc = new JFormattedTextField("");
        txt_dta_nasc.setBounds(465,40,120,25);  
        
        txt_rua = new JTextField("");
        txt_rua.setBounds(45,70,230,25);
        
        txt_num = new JTextField("");
        txt_num.setBounds(320,70,55,25);
        
        txt_comp = new JTextField("");
        txt_comp.setBounds(435,70,150,25);
                
        txt_cid = new JTextField("");
        txt_cid.setBounds(60,100,315,25);
        
        txt_cep = new JTextField("");
        txt_cep.setBounds(435,100,150,25);
        
        txt_tel = new JTextField("");
        txt_tel.setBounds(70,130,205,25);
        
        txt_email = new JTextField("");
        txt_email.setBounds(325,130,260,25);
        
        txt_cpf = new JFormattedTextField("");
        txt_cpf.setBounds(75,160,200,25);     
        
        txt_rg = new JFormattedTextField("");
        txt_rg.setBounds(345,160,240,25);        
        
        txt_user = new JTextField("");
        txt_user.setBounds(65,190,210,25);        

        txt_pass = new JPasswordField("");
        txt_pass.setBounds(325,190,260,25);
        
////////////////////////////////////       
        
        lbl_intro = new JLabel("Preencha todos os campos abaixo e depois tente efetuar o login novamente.");
        lbl_intro.setBounds(27,07,600,30);
        lbl_intro.setFont(new Font("Arial",Font.BOLD,14));
        
        lbl_nome = new JLabel("Nome:");
        lbl_nome.setBounds(10,40,200,30);
        
        lbl_nasc = new JLabel("Nascimento:");
        lbl_nasc.setBounds(385,40,200,30);
        
        lbl_rua = new JLabel("Rua:");
        lbl_rua.setBounds(10,70,200,30);
        
        lbl_num = new JLabel("Num:");
        lbl_num.setBounds(280,70,200,30);
        
        lbl_comp = new JLabel("Compl:");
        lbl_comp.setBounds(385,70,200,30);
        
        lbl_cid = new JLabel("Cidade:");
        lbl_cid.setBounds(10,100,200,30);
        
        lbl_cep = new JLabel("CEP:");
        lbl_cep.setBounds(395,100,200,30);
        
        lbl_tel = new JLabel("Telefone:");
        lbl_tel.setBounds(10,130,200,30);
        
        lbl_email = new JLabel("Email:");
        lbl_email.setBounds(280,130,200,30);
        
        lbl_cpf = new JLabel("CPF/CNPJ:");
        lbl_cpf.setBounds(10,160,200,30);        
        
        lbl_rg = new JLabel("RG/INSCR:");
        lbl_rg.setBounds(280,160,200,30);        
        
        lbl_user = new JLabel("Usuário:");
        lbl_user.setBounds(10,190,200,30);        

        lbl_pass = new JLabel("Senha:");
        lbl_pass.setBounds(280,190,200,30);
        
////////////////////////////////////         
        
        btn_cad = new JButton("Cadastrar");
        btn_cad.setBounds(484,225,100,25);
        btn_cad.addActionListener(this);

        btn_cancel = new JButton("Cancel");
        btn_cancel.setBounds(400,225,75,25);
        btn_cancel.addActionListener(this);  
        
////////////////////////////////////                       
        
        getContentPane().add(txt_nome);
        getContentPane().add(txt_rua);
        getContentPane().add(txt_num);
        getContentPane().add(txt_comp);
        getContentPane().add(txt_cid);
        getContentPane().add(txt_cep);
        getContentPane().add(txt_dta_nasc);
        getContentPane().add(txt_tel);
        getContentPane().add(txt_email);
        getContentPane().add(txt_cpf);
        getContentPane().add(txt_rg);
        getContentPane().add(txt_user);
        getContentPane().add(txt_pass);
        
        getContentPane().add(lbl_intro);
        getContentPane().add(lbl_user);
        getContentPane().add(lbl_pass);
        getContentPane().add(lbl_nome);
        getContentPane().add(lbl_rua);
        getContentPane().add(lbl_num);
        getContentPane().add(lbl_comp);
        getContentPane().add(lbl_cid);
        getContentPane().add(lbl_cep);
        getContentPane().add(lbl_rg);
        getContentPane().add(lbl_nasc);
        getContentPane().add(lbl_tel);
        getContentPane().add(lbl_email);
        getContentPane().add(lbl_cpf);

        getContentPane().add(btn_cad);
        getContentPane().add(btn_cancel);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {

        Object objetoEvento = evento.getSource();
            if (objetoEvento == btn_cancel) {
                this.dispose();
            }
            if (objetoEvento == btn_cad){
                
                String dados = ("1" + "#" + txt_user.getText() + "=" + txt_pass.getText()+ ";" + txt_nome.getText()+ "%" + txt_dta_nasc.getText() + "%" + txt_rua.getText()+ "%" + txt_num.getText()+ "%" + txt_comp.getText()+ "%" + txt_cid.getText()+ "%" + txt_cep.getText()+ "%" + txt_tel.getText()+ "%" +  txt_email.getText()+ "%" +  txt_cpf.getText()+ "%" + txt_rg.getText()+ "*");
                Login.escreveArquivoDisco("Files/bancoUsuarios.txt", dados, 0);
                JOptionPane.showMessageDialog(this, "Arquivo Gravado com Sucesso !", "Aviso", JOptionPane.PLAIN_MESSAGE);
                this.dispose();
            }   
    }

}
