/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Clases.clsCodigos;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author willg
 */
public class frmEjercicio1 extends javax.swing.JDialog {
    clsCodigos con = new clsCodigos();
    

    /**
     * Creates new form frmEjercicio1
     */
    public frmEjercicio1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Ejercicio 1");
        getContentPane().setBackground(Color.DARK_GRAY);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        btnMostrar = new javax.swing.JButton();
        lblimg = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Código a analizar");

        btnMostrar.setText("Mostrar Tokens");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        lblimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Ex1.png"))); // NOI18N

        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jtable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnMostrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblimg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 239, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblimg)
                        .addGap(18, 18, 18)
                        .addComponent(btnMostrar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private final Integer size = 35;
    
    
    private Integer hash(Integer k){
        Integer key = 0;
        key = (k & 0x7fffffff) % size;
        return key;
    }
    
    public void insertar(Integer k){
        System.out.println(k+"tiene el hash -> "+hash(k));
    }
    
    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Hash");
        model.addColumn("Tipo");
        model.addColumn("Ingreso");
        String patron = "(for|if|static|void|int)|([a-zA-Z]+)|([<|>]+)|([+]|[-])|([=]+)|([0-9]+)|([++]{2}|[--]{2})|"
                + "([(|)]+)|([{|}]+)|([\\[|\\]])|(;)|(\\.)";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(con.CodigoEx1);
        int kk = 0;
        
        while(matcher.find()){
            String token1 = matcher.group(1);
            if (token1 != null) {
                kk++;
                model.addRow(new Object[]{hash(kk),"Palabras reservadas:",token1});

            }
            
            String token2 = matcher.group(2);
            if (token2 != null) {
                kk++;
                model.addRow(new Object[]{hash(kk),"Identificadores:",token2});
          
            
            }
            
            String token3 = matcher.group(3);
            if (token3 != null) {
                kk++;
                model.addRow(new Object[]{hash(kk),"Operadores relacionales:",token3});
         
            }
            
            String token4 = matcher.group(4);
            if (token4 != null) {
                kk++;
                model.addRow(new Object[]{hash(kk),"Operadores de aritméticos:",token4});
            }
            
            String token5 = matcher.group(5);
            if (token5 != null) {
                kk++;
                model.addRow(new Object[]{hash(kk),"Operadores de asignación:",token5});
            }
            
            String token6 = matcher.group(6);
            if (token6 != null) {
                kk++;
                model.addRow(new Object[]{hash(kk),"Números:",token6});
            }
            
            String token7 = matcher.group(7);
            if (token7 != null) {
                kk++;
                model.addRow(new Object[]{hash(kk),"Operadores de incremento/decremento:",token7});
            }
            
            String token8 = matcher.group(8);
            if (token8 != null) {
                kk++;
                model.addRow(new Object[]{hash(kk),"Parentesis:",token8});
            }
            
            String token9 = matcher.group(9);
            if (token9 != null) {
                kk++;
                model.addRow(new Object[]{hash(kk),"Llaves:",token9});
            }
            
            String token10 = matcher.group(10);
            if (token10 != null) {
                kk++;
                model.addRow(new Object[]{hash(kk),"Corchetes:",token10});
            }
            
            String token11 = matcher.group(11);
            if (token11 != null) {
                kk++;
                model.addRow(new Object[]{hash(kk),"Punto y coma:",token11});
            }
            
            String token12 = matcher.group(12);
            if (token12 != null) {
                kk++;
                model.addRow(new Object[]{hash(kk),"Punto:",token12});
            }
            jtable.setModel(model);
        }
        
    }//GEN-LAST:event_btnMostrarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(frmEjercicio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEjercicio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEjercicio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEjercicio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmEjercicio1 dialog = new frmEjercicio1(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMostrar;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtable;
    private javax.swing.JLabel lblimg;
    // End of variables declaration//GEN-END:variables
}
