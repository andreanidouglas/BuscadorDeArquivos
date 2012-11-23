package BuscaAutomato.UploadFiles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class UploadFrame extends JFrame implements ActionListener{
    private JFileChooser escolherArquivo;
    private JTextField tftxArquivoBuscado, tftxTag1, tftxTag2, tftxTag3;
    private JButton btnOpenFileChooser, btnUploadFile, btn_cancel;
    private Runtime processo;
    private String linhaComando;
    
    public UploadFrame() 
    {
        setBounds (530,270,340,200);
        setTitle("Upload de Arquivos | Projeto de ORI + TCLF");
        setResizable(false);
        getContentPane().setLayout(null);
        
        tftxArquivoBuscado = new JTextField("Selecione o local do arquivo...");
        tftxArquivoBuscado.setBounds(10,20,190,25);
        
        tftxTag1 = new JTextField("tag1");
        tftxTag1.setBounds(10,50,310,25);
        
        tftxTag2 = new JTextField("tag2");
        tftxTag2.setBounds(10,80,310,25);
        
        tftxTag3 = new JTextField("tag3");
        tftxTag3.setBounds(10,110,310,25);
                
        btnOpenFileChooser = new JButton("Abrir Arquivo");
        btnOpenFileChooser.addActionListener(this);
        btnOpenFileChooser.setBounds(210,20,110,25);
        
        btnUploadFile = new JButton("Enviar Arquivo");
        btnUploadFile.addActionListener(this);
        btnUploadFile.setBounds(205,140,115,25);
        
        btn_cancel = new JButton("Cancel");
        btn_cancel.setBounds(120,140,75,25);
        btn_cancel.addActionListener(this);
        
        getContentPane().add(tftxArquivoBuscado);
        getContentPane().add(btnOpenFileChooser);
        getContentPane().add(tftxTag1);
        getContentPane().add(tftxTag2);
        getContentPane().add(tftxTag3);
        getContentPane().add(btnUploadFile);
        getContentPane().add(btn_cancel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object evento = e.getSource();
        if (evento == btnOpenFileChooser)
        {
            escolherArquivo = new JFileChooser();
            escolherArquivo.setFileFilter(new ExtensionFileFilter("Arquivos .jpg, .bmp, .gif, .txt, .doc, .docx", "jpg", "bmp", "gif", "txt", "doc", "docx", "png", "mp3", "wav"));
            if (escolherArquivo.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) 
            {
                return;
            }  
            System.out.println("Arquivo selecionado: " + escolherArquivo.getSelectedFile().toString()); 
            tftxArquivoBuscado.setText(escolherArquivo.getSelectedFile().toString());
        }
        else if(evento == btnUploadFile)
        {
            try
            {
                RecordFiles gravacao = new RecordFiles();
                gravacao.setMetadados(tftxTag1.getText() + " " + tftxTag2.getText() + " " + tftxTag3.getText());
                gravacao.setUploadArquivo(CopiaArquivo.CopiaArquivo(escolherArquivo.getSelectedFile()));
                gravacao.gravarDisco();
                
                try {  
                   // Thread.sleep(2000);  
                    processo = Runtime.getRuntime();
                    linhaComando = "cmd /C start cGerenciador.exe 0";
                    processo.exec(linhaComando);
                } 
                catch (Exception event) { 
                    event.printStackTrace();
                }
            }
            catch (Exception error)
            {
                error.printStackTrace();
            }
        }
        else if (evento == btn_cancel)
        {
            this.dispose();
        }
    }
}
