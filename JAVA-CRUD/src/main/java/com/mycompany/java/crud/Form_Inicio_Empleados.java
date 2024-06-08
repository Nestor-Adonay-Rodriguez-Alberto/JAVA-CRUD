package com.mycompany.java.crud;

import Acceso_Datos.EmpleadoDAL;
import Entidades.Empleado;
import Utilerias.OpcionesCRUD;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Form_Inicio_Empleados extends javax.swing.JFrame {

    // CONSTRUCTOR:
    public Form_Inicio_Empleados() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TxtNOMBRE = new javax.swing.JTextField();
        BtnCREAR = new javax.swing.JButton();
        BtnBUSCAR = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaResultados = new javax.swing.JTable();
        BtnEDITAR = new javax.swing.JButton();
        BtnELIMINAR = new javax.swing.JButton();
        BtnCANCELAR = new javax.swing.JButton();

        jLabel1.setText("NOMBRE:");

        BtnCREAR.setText("CREAR");
        BtnCREAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCREARActionPerformed(evt);
            }
        });

        BtnBUSCAR.setText("BUSCAR");
        BtnBUSCAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBUSCARActionPerformed(evt);
            }
        });

        TablaResultados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TablaResultados);

        BtnEDITAR.setText("EDITAR");
        BtnEDITAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEDITARActionPerformed(evt);
            }
        });

        BtnELIMINAR.setText("ELIMINAR");
        BtnELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnELIMINARActionPerformed(evt);
            }
        });

        BtnCANCELAR.setText("CANCELAR");
        BtnCANCELAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCANCELARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnCANCELAR, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnBUSCAR, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnCREAR, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBUSCAR, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCREAR, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnEDITAR)
                    .addComponent(BtnELIMINAR)
                    .addComponent(BtnCANCELAR))
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    /*                      EVENTOS DE BOTONES
    *********************************************************************/
    
    // BOTON CREAR:
    private void BtnCREARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCREARActionPerformed
        
        // LLamada Del Formulario:
        Form_Empleados Formulario_Empleados = new Form_Empleados(OpcionesCRUD.CREAR, new Empleado());
        Formulario_Empleados.setTitle("NUEVO REGISTRO");
        Formulario_Empleados.setVisible(true);
        
    }//GEN-LAST:event_BtnCREARActionPerformed

    // BOTON EDITAR:
    private void BtnEDITARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEDITARActionPerformed
        // Fila Seleccionada:
        int row = TablaResultados.getSelectedRow();

        if (row != -1) 
        {
            
            // LLamada Del Formulario:
        Form_Empleados Formulario_Empleados = new Form_Empleados(OpcionesCRUD.EDITAR, DatosFila());
        Formulario_Empleados.setTitle("EDITAR REGISTRO");
        Formulario_Empleados.setVisible(true);
        } 
        else 
        {
            JOptionPane.showMessageDialog(this,
                    "Seleccionar una fila", "SELECCIONE",
                    JOptionPane.WARNING_MESSAGE);
        }        
    }//GEN-LAST:event_BtnEDITARActionPerformed

    // BOTON ELIMINAR:
    private void BtnELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnELIMINARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnELIMINARActionPerformed

    // BOTON BUSCAR:
    private void BtnBUSCARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBUSCARActionPerformed
        // Objeto:
        Empleado empleado = new Empleado();

        // Agregamos El Nombre Del Texbox Del Formulario
        empleado.setNombre(TxtNOMBRE.getText());

        // Lista De Registros Encontrados:
        ArrayList<Empleado> Objetos_Obtenidos = EmpleadoDAL.Buscar(empleado);

        // Nombrando Las Columnas De La Tabla:
        String[] COLUMNAS = {"ID", "NOMBRE", "APELLIDO", "CARGO", "SALARIO", "Fecha De Contratacion"};

        // Lista De Registros Encontrados Y Pasados A Object:
        Object[][] DATOS = new Object[Objetos_Obtenidos.size()][6];

        for (int i = 0; i < Objetos_Obtenidos.size(); i++) {
            // Registro Con Su Posicion:
            Empleado Registro = Objetos_Obtenidos.get(i);

            // Creacion De Objeto Segun Objeto De La Posicion:
            DATOS[i][0] = Registro.getEmpleadoID();
            DATOS[i][1] = Registro.getNombre();
            DATOS[i][2] = Registro.getApellido();
            DATOS[i][3] = Registro.getCargo();
            DATOS[i][4] = Registro.getSalario();
            DATOS[i][5] = Registro.getFechaContratacion();
        }

        // Agregando Los Nombres De Las Columnas Y Los Registros
        DefaultTableModel ResultadosTabla = new DefaultTableModel(DATOS, COLUMNAS);

        // Mandamos A La Tabla Del Formulario
        TablaResultados.setModel(ResultadosTabla);
    }//GEN-LAST:event_BtnBUSCARActionPerformed
   
    // BOTON CANCELAR:
    private void BtnCANCELARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCANCELARActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BtnCANCELARActionPerformed

    
    /*                    METODO REALIZAR CAMBIOS EN DB
    *********************************************************************/
    
    // CREA UN OBJETO CON TODOS LOS DATOS DE LA FILA SELECCIONADA:
    private Empleado DatosFila()
    {
        // Objeto:
        Empleado empleado = new Empleado();
        
        // Fila Seleccionada:
        int row = TablaResultados.getSelectedRow();
        
        // Atributos De La Fila Colocarlos En El Objeto:
        empleado.setEmpleadoID((int) TablaResultados.getValueAt(row, 0));
        empleado.setNombre(TablaResultados.getValueAt(row, 1).toString());  
        empleado.setApellido(TablaResultados.getValueAt(row, 2).toString()); 
        empleado.setCargo(TablaResultados.getValueAt(row, 3).toString());
        empleado.setSalario((double)TablaResultados.getValueAt(row, 4)); 
        
        Object valorFecha = TablaResultados.getValueAt(row, 5);
        java.util.Date fechaContratacion = (java.util.Date) valorFecha;
        empleado.setFechaContratacion(fechaContratacion);
     
        return empleado;
    }
    
    
    
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
            java.util.logging.Logger.getLogger(Form_Inicio_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Inicio_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Inicio_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Inicio_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Inicio_Empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBUSCAR;
    private javax.swing.JButton BtnCANCELAR;
    private javax.swing.JButton BtnCREAR;
    private javax.swing.JButton BtnEDITAR;
    private javax.swing.JButton BtnELIMINAR;
    private javax.swing.JTable TablaResultados;
    private javax.swing.JTextField TxtNOMBRE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
