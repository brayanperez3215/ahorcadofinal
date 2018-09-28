package ahorcado2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ahorcado2 extends JFrame implements ActionListener {

    private Pintar panelGrafico;
    private JPanel panelComponentes;
    private JButton botonReIniciar;
    private JButton botonIniciar;
    private JButton botonValidarLetra;
    private JButton botonSalir;
    private JLabel etiqueta;
    private JTextField letra;
    private JTextField palabra;
    private Palabras p;
    private int vidas;
    
    public Ahorcado2() {
        
        setLayout(new BorderLayout(1,1));
        setSize(600,600);
        agregarElementos();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        vidas = 0;
    }
    
    public void agregarElementos()
    {
        //Panel donde se dibujara 
        
        panelGrafico = new Pintar();
        panelGrafico.setBackground(Color.WHITE);
        add(panelGrafico,BorderLayout.CENTER);
        
        //Panel donde estaran los elementos
        
        panelComponentes = new JPanel();
        panelComponentes.setBackground(Color.GREEN);
        panelComponentes.setLayout(null);
        
        botonReIniciar = new JButton("REINICIAR JUEGO");
        botonIniciar = new JButton("INICIAR JUEGO");
        botonValidarLetra = new JButton("VERIFICAR");
        botonSalir = new JButton("SALIR");
        
        etiqueta = new JLabel("PALABRA");
        
        palabra = new JTextField("");
        letra = new JTextField("");
        
        //Colocando elementos en el panel
        
        botonReIniciar.setBounds(30,400,150,30);
        etiqueta.setBounds(250,400,100,30);
        palabra.setBounds(300,400,150,30);
        botonIniciar.setBounds(30,450,150,30);
        botonValidarLetra.setBounds(30,500,150,30);
        letra.setBounds(200,500,50,30);
        botonSalir.setBounds(430,500,150,30);
        
        botonReIniciar.addActionListener(this);
        botonIniciar.addActionListener(this);
        botonValidarLetra.addActionListener(this);
        botonSalir.addActionListener(this);
        
        panelComponentes.add(botonReIniciar);
        panelComponentes.add(botonIniciar);
        panelComponentes.add(botonValidarLetra);
        panelComponentes.add(botonSalir);
        panelComponentes.add(letra);
        panelComponentes.add(etiqueta);
        panelComponentes.add(palabra);
        
        add(panelComponentes,BorderLayout.CENTER);
        
        
    }
    
    
    public void actionPerformed(ActionEvent evento) 
    {
        if(evento.getSource() == botonReIniciar)
        {
            panelGrafico.error(0);
            palabra.setText("");
            letra.setText("");
            vidas = 0;
        }
        else if(evento.getSource() == botonIniciar)
        {
            panelGrafico.error(0);
            p = new Palabras();
            String aux="";
            int contador =0;
            while(contador < p.getElegida().length())
            {
                aux+="_ ";
                contador++;
            }
            palabra.setText(aux);
        }
        else if(evento.getSource() == botonValidarLetra)
        {
            String l="";
            l = letra.getText();
            char c = l.charAt(0);
            if(p.comparar(c).equals(p.getElegida()))
            {
                palabra.setText(p.comparar(c));
                JOptionPane.showMessageDialog(null,"Ganaste");
            }
            else if(vidas == 6)
            {
                JOptionPane.showMessageDialog(null,"Has perdido");
            }
            else if(p.getBandera() == 1)
            {
                palabra.setText(p.comparar(c));
            }
            else if(p.getBandera() == 0)
            {
                vidas = vidas + 1;
                panelGrafico.error(vidas);
            }
        }
        else if(evento.getSource() == botonSalir)
        {
            System.exit(0);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ahorcado2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ahorcado2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ahorcado2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ahorcado2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
         Ahorcado2 a = new Ahorcado2();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ahorcado2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
