package BuscaAutomato;

import BuscaAutomato.UploadFiles.UploadFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class MainFrameAutomato extends JFrame implements ActionListener
{
    private JTextField tftxcampoBusca;
    private JLabel lblCampoBusca, lbl_result, lblCaminho;
    private JButton btnBusca, btnUpload, btnresultV,btnresultI, btnresultA;
    private String textoBusca, tipo;
    private String[] textos;
    private int i;
    private String retornoBusca;
    private String caminhoarquivo = "Files/search.png";
    ImageIcon img_result;
    
            Runtime processo;
        String linhaComando;
    public MainFrameAutomato()
    {
        setBounds (350,150,700,480);
        setTitle("Pesquisa | Projeto de ORI + TCLF");
        setResizable(false);
        getContentPane().setLayout(null);
        
        img_result = new ImageIcon(caminhoarquivo);
        lbl_result = new JLabel(img_result);
        lbl_result.setBounds(5,50,520,370);
        lbl_result.setLayout(null);
        
        lblCampoBusca = new JLabel();
        lblCampoBusca.setText("Buscar:");
        lblCampoBusca.setBounds(05,20,320,25);
        
        lblCaminho = new JLabel();
        lblCaminho.setText("Caminho: ");
        lblCaminho.setBounds(05,420,320,25);
        
        btnresultV = new JButton();
        btnresultV.setText("Video");
        btnresultV.setBounds(535,50,150,25);
        btnresultV.addActionListener(this);
        
        btnresultA = new JButton();
        btnresultA.setText("Audio");
        btnresultA.setBounds(535,80,150,25);
        btnresultA.addActionListener(this);
        
        btnresultI = new JButton();
        btnresultI.setText("Imagem");
        btnresultI.setBounds(535,110,150,25);
        btnresultI.addActionListener(this);
        
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
        getContentPane().add(lblCaminho);
        getContentPane().add(btnresultV);
        getContentPane().add(btnresultI);
        getContentPane().add(btnresultA);
        getContentPane().add(btnBusca);
        getContentPane().add(btnUpload);
        getContentPane().add(lbl_result);
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
                          System.out.println("retorno busca"+ retornoBusca);
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
        
        if(objetoEvento == btnresultI)
        {
            caminhoarquivo = "\"" + tftxcampoBusca.getText() + "\"";
            lbl_result = new JLabel(new ImageIcon(caminhoarquivo));
            lblCaminho.setText("Caminho: " + caminhoarquivo);
            lblCaminho.setBounds(05,420,320,25);            
        }
        
        if(objetoEvento == btnresultA)
        {
            
        }
        
        if(objetoEvento == btnresultV)
        {
            
        }
    }

}
