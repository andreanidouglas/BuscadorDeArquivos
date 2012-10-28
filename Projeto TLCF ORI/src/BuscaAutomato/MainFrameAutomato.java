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
        setBounds (400,200,600,380);
        setTitle("Projeto de ORI + TCLF");
        setResizable(false);
        getContentPane().setLayout(null);
        
        tftxcampoBusca = new JTextField("");
        tftxcampoBusca.setBounds(100,100,200,45);
        
        lblCampoBusca = new JLabel();
        lblCampoBusca.setText("BUSCA");
        lblCampoBusca.setBounds(95, 100, 50, 45);
        
        btnBusca = new JButton("Buscar");
        btnBusca.setBounds(300, 100, 50, 45);
        btnBusca.addActionListener(this);
        
        btnUpload = new JButton("Upload");
        btnUpload.setBounds(400, 100, 100, 45);
        btnUpload.addActionListener(this);
        
        getContentPane().add(tftxcampoBusca);
        getContentPane().add(lblCampoBusca);
        getContentPane().add(btnBusca);
        getContentPane().add(btnUpload);
    }     
    
    public void closeAutomatoMainFrame()
    {
        this.dispose();
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
