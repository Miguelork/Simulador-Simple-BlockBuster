package Vistas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Manager;
import modelos.Pelicula;
import modelos.Usuario;

/**
 *
 * @author Lants
 */
public class Administrador extends javax.swing.JFrame {

    DefaultTableModel tablaAdmi;
    int arrayCode[];
    int cont = 100000;
    Manager manage = new Manager();
    public Usuario selected;

    public Administrador() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        tablaAdmi = new DefaultTableModel();
        tablaAdmi.addColumn("Codigo");
        tablaAdmi.addColumn("Titulo");
        tablaAdmi.addColumn("Costo");
        tablaAdmi.addColumn("Alquilado por");
        tablaAdmi.addColumn("Bit Muerto");
        this.tablePeli.setModel(tablaAdmi);
        manage.cargarPeliculas();
        this.actualizarT(manage.listPeli);
    }

    public Administrador(Usuario selected) {
        initComponents();
        this.selected = selected;
        this.textcost1.setText(Integer.toString(selected.getNumSocio()));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        tablaAdmi = new DefaultTableModel();
        tablaAdmi.addColumn("Codigo");
        tablaAdmi.addColumn("Titulo");
        tablaAdmi.addColumn("Costo");
        tablaAdmi.addColumn("Alquilado por");
        tablaAdmi.addColumn("Bit Muerto");
        this.tablePeli.setModel(tablaAdmi);
        manage.cargarPeliculas();
        this.actualizarT(manage.listPeli);
    }

    public void actualizarT(ArrayList<Pelicula> a) {

        //Resetear valores
        int cantidadfilas = tablePeli.getRowCount();
        for (int i = cantidadfilas - 1; i >= 0; i--) {
            tablaAdmi.removeRow(i);
        }

        //Cargar valores
        for (Pelicula peli : a) {
            String[] Data = new String[5];
            Data[0] = String.valueOf(peli.getCode());
            Data[1] = peli.getTitle();
            Data[2] = String.valueOf(peli.getCost());
            if (peli.getNumSocio() == 0) {
                Data[3] = "No ha sido alquilado";
            } else {
                Data[3] = String.valueOf(peli.getNumSocio());
            }
            Data[4] = String.valueOf(peli.isBitMuerto());
            tablaAdmi.addRow(Data);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePeli = new javax.swing.JTable();
        btnDel = new javax.swing.JButton();
        btnAgg = new javax.swing.JButton();
        texttitle = new javax.swing.JTextField();
        textcost = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAgg1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        textcost1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(41, 49, 51));

        tablePeli.setBackground(new java.awt.Color(0, 0, 0));
        tablePeli.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablePeli.setForeground(new java.awt.Color(245, 245, 245));
        tablePeli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Title", "Cost", "Rented by"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablePeli);

        btnDel.setBackground(new java.awt.Color(41, 49, 51));
        btnDel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnDel.setForeground(new java.awt.Color(245, 245, 245));
        btnDel.setText("Eliminar Pelicula");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnAgg.setBackground(new java.awt.Color(41, 49, 51));
        btnAgg.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAgg.setForeground(new java.awt.Color(245, 245, 245));
        btnAgg.setText("Agregar Pelicula");
        btnAgg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggActionPerformed(evt);
            }
        });

        textcost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textcostActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(245, 245, 245));
        jLabel1.setText("Costo:");
        jLabel1.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(245, 245, 245));
        jLabel3.setText("Titulo de la Pelicula:");
        jLabel3.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Magneto", 1, 54)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(245, 245, 245));
        jLabel5.setText("Retro Club");
        jLabel5.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Magneto", 1, 54)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(245, 245, 245));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/image (1) (1).png"))); // NOI18N
        jLabel6.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Magneto", 1, 54)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(245, 245, 245));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/image (2).png"))); // NOI18N
        jLabel7.setToolTipText("");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        btnAgg1.setBackground(new java.awt.Color(41, 49, 51));
        btnAgg1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAgg1.setForeground(new java.awt.Color(245, 245, 245));
        btnAgg1.setText("Reindexar");
        btnAgg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgg1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(245, 245, 245));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("#");
        jLabel2.setToolTipText("");

        textcost1.setBackground(new java.awt.Color(51, 51, 51));
        textcost1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        textcost1.setForeground(new java.awt.Color(255, 255, 255));
        textcost1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textcost1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textcost1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(texttitle, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(textcost, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(171, 171, 171)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textcost1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(btnAgg1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(btnAgg, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textcost, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(texttitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgg, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgg1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textcost1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggActionPerformed
        //Aqui falta lo de pasar a tabla y luego a doc
        if (!(texttitle.getText().equals("")) && !(textcost.getText().equals(""))) {
            if (texttitle.getText().length() <= 30) {
                if (isNumber(textcost.getText())) {
                    if (textcost.getText().length() <= 5) {
                        int tncost, tncode;
                        String[] Data = new String[3];
//                        Data[0] = pass();
                        Data[0] = String.valueOf(manage.codeGenerator());
                        tncode = Integer.parseInt(Data[0]);
                        Data[1] = texttitle.getText();
                        texttitle.setText(null);
                        Data[2] = textcost.getText();
                        textcost.setText(null);
                        tncost = Integer.parseInt(Data[2]);
                        manage.aggPeli(tncode, Data[1], tncost, 0, false);
                        this.actualizarT(manage.listPeli);
                    } else {
                        JOptionPane.showMessageDialog(null, "El número que usted ha ingresado excede el maximo (5 digitos) \nVerifiquelo e intente nuevamente", "Error en Costo", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Tal parece que no ingreso un numero en el campo de costo \nVerifiquelo e intente nuevamente", "Error en Costo", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El titulo que usted ha ingresado excede el maximo (30 caracteres) \nVerifiquelo e intente nuevamente", "Error en Titulo", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Uno o más campos del formulario se encuentran vacios \nPor favor verifique e intente nuevamente", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAggActionPerformed
    //Llevar control de codigo
    public String pass() {
        String baton = String.valueOf(cont);
        cont++;
        return baton;
    }

    //Generar codigo aleatorio
    public int generatorC() {
        int codigo = 0;
        boolean acept = false;
        do {
            codigo = (int) (Math.random() * (100000 - 999999 + 1)) + 100000;
            for (int i = 0; i < arrayCode.length; i++) {
            }
        } while (acept);
        return codigo;
    }

    //Comprobación si es un numero
    public boolean isNumber(String n) {
        try {
            int aux = Integer.parseInt(n);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    //Pasar String a numero
    public int number(String n) {
        try {
            int aux = Integer.parseInt(n);
            return aux;
        } catch (NumberFormatException nfe) {
            return 0;
        }
    }
    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        //Aqui falta lo de quitar a tabla y luego el doc
        int rowSelect = tablePeli.getSelectedRow();
        if (rowSelect >= 0) {
            //tablaAdmi.removeRow(rowSelect);
            manage.marcaParaEliminar(rowSelect);
            this.actualizarT(manage.listPeli);
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila \nVerifique e intente nuevamente", "Señalar fila", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void textcostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textcostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textcostActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        Tienda tienda = new Tienda(selected);
        tienda.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void btnAgg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgg1ActionPerformed
        manage.reindexador();
        this.actualizarT(manage.listPeli);
    }//GEN-LAST:event_btnAgg1ActionPerformed

    private void textcost1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textcost1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textcost1ActionPerformed

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
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgg;
    private javax.swing.JButton btnAgg1;
    private javax.swing.JButton btnDel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablePeli;
    private javax.swing.JTextField textcost;
    private javax.swing.JTextField textcost1;
    private javax.swing.JTextField texttitle;
    // End of variables declaration//GEN-END:variables
}
