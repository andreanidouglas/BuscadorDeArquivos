/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BuscaAutomato.UploadFiles;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UploadFrame extends JFrame implements ActionListener{
    private JFileChooser escolherArquivo;
    private JTextField tftxArquivoBuscado, tftxTag1, tftxTag2, tftxTag3;
    private JButton btnOpenFileChooser;
    
    public UploadFrame() 
    {
        setBounds (400,200,600,380);
        setTitle("Projeto de ORI + TCLF");
        setResizable(false);
        getContentPane().setLayout(null);
        
        tftxArquivoBuscado = new JTextField("file path");
        tftxArquivoBuscado.setBounds(100, 100, 400, 45);
        
        tftxTag1 = new JTextField("tag1");
        tftxTag1.setBounds(100,150,400,45);
        tftxTag2 = new JTextField("tag2");
        tftxTag2.setBounds(100,200,400,45);
        tftxTag3 = new JTextField("tag3");
        tftxTag3.setBounds(100,250,400,45);
        
        
        btnOpenFileChooser = new JButton("Abrir Arquivo");
        btnOpenFileChooser.addActionListener(this);
        btnOpenFileChooser.setBounds(500,100,100,45);
        
   
        
        getContentPane().add(tftxArquivoBuscado);
        getContentPane().add(btnOpenFileChooser);
        getContentPane().add(tftxTag1);
        getContentPane().add(tftxTag2);
        getContentPane().add(tftxTag3);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object evento = e.getSource();
        if (evento == btnOpenFileChooser)
        {
            escolherArquivo = new JFileChooser();
            escolherArquivo.setFileFilter(new ExtensionFileFilter("Arquivos .jpg, .bmp, .gif, .txt, .doc, .docx", "jpg", "bmp", "gif", "txt", "doc", "docx"));
            if (escolherArquivo.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) 
            {
                return;
            }  
            System.out.println("Arquivo selecionado: " + escolherArquivo.getSelectedFile().toString()); 
            tftxArquivoBuscado.setText(escolherArquivo.getSelectedFile().toString());
        }
    }
    
}
