package BuscaAutomato;

import BuscaAutomato.UploadFiles.UploadFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainFrameAutomato extends JFrame implements ActionListener
{
    private JTextField tftxcampoBusca;
    private JLabel lblCampoBusca;
    private JButton btnBusca, btnUpload;
    private String textoBusca, tipo;
    private String[] textos;
    private int i;
    private String retornoBusca;
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
            textoBusca = tftxcampoBusca.getText();
            
            if (textoBusca.isEmpty())
            {
                return;
            }
            BuscadorAutomato busca = new BuscadorAutomato();
            try 
            {
                textos = textoBusca.split("[ ]");
                tipo = "";
                for (i=0; i<textos.length;i++)
                {
                    if(textos[i].equals("Imagem"))
                        tipo = "Imagem";
                    if(textos[i].equals("Audio"))
                        tipo = "Audio";
                    if(textos[i].equals("Texto"))
                        tipo = "Texto";
                }
                for(i=0;i<textos.length;i++)
                {
                    int j=0;
                    tipo = tipo.trim();
                    while (j<30)
                    {
                        retornoBusca = busca.lerXML(textos[i], tipo, j);
                        if (retornoBusca != null)
                            tftxcampoBusca.setText(retornoBusca);
                        j++;
                    }
                }
            } 
            catch (Exception ex) {
                Logger.getLogger(MainFrameAutomato.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(objetoEvento == btnUpload)
        {
            closeAutomatoMainFrame();
            UploadFrame upload = new UploadFrame();
            upload.setVisible(true);
        }
    }

}
