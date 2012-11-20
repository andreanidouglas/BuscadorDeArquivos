package BuscaAutomato;

import BuscaAutomato.UploadFiles.UploadFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainFrameAutomato extends JFrame implements ActionListener
{
    private JTextField tftxcampoBusca;
    private JLabel lblCampoBusca;
    private JButton btnBusca, btnUpload;

    public MainFrameAutomato()
    {
        setBounds (350,150,700,480);
        setTitle("Pesquisa | Projeto de ORI + TCLF");
        setResizable(false);
        getContentPane().setLayout(null);
        
        lblCampoBusca = new JLabel();
        lblCampoBusca.setText("Buscar:");
        lblCampoBusca.setBounds(05,20,320,25);
        
        tftxcampoBusca = new JTextField("O que deseja procurar?");
        tftxcampoBusca.setBounds(60,20,405,25);
                
        btnBusca = new JButton("Ir");
        btnBusca.setBounds(475,20,50,25);
        btnBusca.addActionListener(this);
        
        btnUpload = new JButton("Enviar Arquivos");
        btnUpload.setBounds(535,20,150,25);
        btnUpload.addActionListener(this);
        
        getContentPane().add(tftxcampoBusca);
        getContentPane().add(lblCampoBusca);
        getContentPane().add(btnBusca);
        getContentPane().add(btnUpload);
    }     
    
    public void closeAutomatoMainFrame()
    {
        //this.dispose();
    }
    @Override
    
    public void actionPerformed(ActionEvent evento)
    {
        Object objetoEvento = evento.getSource();
        if (objetoEvento == btnBusca)
        {
            
        }
        
        if(objetoEvento == btnUpload)
        {
            closeAutomatoMainFrame();
            UploadFrame upload = new UploadFrame();
            upload.setVisible(true);
        }
    }

}
