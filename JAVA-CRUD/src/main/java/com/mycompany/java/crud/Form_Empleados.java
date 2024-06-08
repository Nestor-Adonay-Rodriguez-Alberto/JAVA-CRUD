package com.mycompany.java.crud;

import Acceso_Datos.EmpleadoDAL;
import Entidades.Empleado;
import Utilerias.OpcionesCRUD;
import static Utilerias.OpcionesCRUD.CREAR;
import static Utilerias.OpcionesCRUD.EDITAR;
import static Utilerias.OpcionesCRUD.ELIMINAR;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Form_Empleados extends javax.swing.JFrame {

    // ATRIBUTOS:
    private OpcionesCRUD opcionesCRUD;
    private Empleado EmpleadoActual;

    // CONTRUCTOR:
    public Form_Empleados(OpcionesCRUD opcion, Empleado empleado) {
        // Guardamos Opcion A Realizar:
        opcionesCRUD = opcion;

        initComponents();

        if (opcion != OpcionesCRUD.CREAR) {
            DatosEnFormulario(empleado);
            EmpleadoActual = empleado;
        }
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
        jLabel2 = new javax.swing.JLabel();
        TxtNOMBRE = new javax.swing.JTextField();
        TxtAPELLIDO = new javax.swing.JTextField();
        TxtCARGO = new javax.swing.JTextField();
        TxtSALARIO = new javax.swing.JTextField();
        TxtFechaContratacion = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        BtnCancelar = new javax.swing.JButton();
        BtnGUARDAR = new javax.swing.JButton();

        jLabel1.setText("DATOS   DEL   EMPLEADO");

        jLabel2.setText("NOMBRE:");

        jLabel3.setText("APELLIDO:");

        jLabel4.setText("CARGO:");

        jLabel5.setText("SALARIO:");

        jLabel6.setText("Fecha De");

        jLabel7.setText("Contratacion");

        BtnCancelar.setText("CANCELAR");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        BtnGUARDAR.setText("GUARDAR");
        BtnGUARDAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGUARDARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(BtnGUARDAR, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TxtCARGO, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                .addComponent(TxtAPELLIDO)
                                .addComponent(TxtNOMBRE)
                                .addComponent(TxtSALARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtFechaContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtAPELLIDO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtCARGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtSALARIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addComponent(TxtFechaContratacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnGUARDAR, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /*                      EVENTOS DE BOTONES
    *********************************************************************/
    // BOTON GUARDAR:
    private void BtnGUARDARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGUARDARActionPerformed
        if (opcionesCRUD != null) {
            switch (opcionesCRUD) {
                case CREAR:
                    CrearRegistro();
                    this.setVisible(false);
                    break;

                case EDITAR:
                    EditarRegistro();
                    this.setVisible(false);
                    break;

                case ELIMINAR:
                    EliminarRegistro();
                    this.setVisible(false);
                    break;

                default:
                    break;
            }
        }
    }//GEN-LAST:event_BtnGUARDARActionPerformed

    // BOTON CANCELAR:
    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_BtnCancelarActionPerformed

    
    
    /*                    METODO REALIZAR CAMBIOS EN DB
    *********************************************************************/
    
    // OBTIENE LOS ATRIBUTOS DEL FORMULARIO Y CREAR UN OBJETO DE ELLOS
    private Empleado DatosDelFormulario() {
        // Objeto:
        Empleado empleado = new Empleado();

        // Datos Del Formulario:
        String nombre = TxtNOMBRE.getText();
        String apellido = TxtAPELLIDO.getText();
        String cargo = TxtCARGO.getText();
        String salarioText = TxtSALARIO.getText();
        Date fechaContratacion = TxtFechaContratacion.getDate();

        // Validamos Que No Esten Vasios:       
        if (nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Debe Ingresar Un Nombre");
        } else {
            empleado.setNombre(nombre);
        }

        if (apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("Debe Ingresar Un Apellido");
        } else {
            empleado.setApellido(apellido);
        }

        if (cargo.trim().isEmpty()) {
            throw new IllegalArgumentException("Debe Ingresar Un Cargo");
        } else {
            empleado.setCargo(cargo);
        }

        if (salarioText.trim().isEmpty()) {
            throw new IllegalArgumentException("Debe Ingresar Un Salario");
        } else {

            try {
                double salario = Double.parseDouble(salarioText);
                empleado.setSalario(salario);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("No Se Permite Letras En Salario");
            }

        }

        if (fechaContratacion == null) {
            throw new IllegalArgumentException("Debe Ingresar Una Fecha De Contratacion");
        } else {
            empleado.setFechaContratacion(fechaContratacion);
        }

        if(opcionesCRUD!=CREAR)
        {
            empleado.setEmpleadoID(EmpleadoActual.getEmpleadoID());
        }
        return empleado;
    }

    // COLOCA DATOS DEL OBJETO EN FORMULARIO
    private void DatosEnFormulario(Empleado empleado) 
    {
        
        TxtNOMBRE.setText(empleado.getNombre());
        TxtAPELLIDO.setText(empleado.getApellido());
        TxtCARGO.setText(empleado.getCargo());
        TxtSALARIO.setText(Double.toString(empleado.getSalario()));
        TxtFechaContratacion.setDate(empleado.getFechaContratacion());
        
    }
    
    private Empleado ObtenerID()
    {
        Empleado empleado = new Empleado();
        empleado.setEmpleadoID(EmpleadoActual.getEmpleadoID());
        return empleado;
    }

    // CREAR NUEVO REGISTRO:
    private void CrearRegistro() {
        try {
            // Obtenemos Objeto Con inf Del Formulario:
            Empleado empleado = DatosDelFormulario();

            // Creamos El Registro:           
            int result = EmpleadoDAL.Crear(empleado);

            // Mensaje De Fila Afectada
            if (result > 0) {
                JOptionPane.showMessageDialog(this,
                        "El Empleado fue registrado existosamente", "REGISTRADO",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Alguno De Los Campos Esta Vasio", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception Error) {
            JOptionPane.showMessageDialog(this,
                    Error.getMessage(), "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
    
     // EDITA EL REGISTRO:
    private void EditarRegistro() 
    {
        try 
        {
            // Objeto Con Los Atributos Del Forulario
            Empleado empleado = DatosDelFormulario();
            
            // Modificar El Registro En DB:
            int result = EmpleadoDAL.Editar(empleado);
            
            if (result > 0) 
            {
                JOptionPane.showMessageDialog(this,
                        "Datos Del Empleado Modificados", "MODIFICADO",
                        JOptionPane.INFORMATION_MESSAGE);
            } 
            else 
            {
                JOptionPane.showMessageDialog(this,
                        "Error Al Querer Modificar Al Empleado", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch (Exception Error) 
        {
            JOptionPane.showMessageDialog(this,
                    Error.getMessage(), "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
     // ELIMINA EL REGISTRO DE LA DB:
    private void EliminarRegistro() 
    {
        try 
        {
            // Objeto Con Datos Del Formulario:
            Empleado persona = ObtenerID();
            
            // Eliminamos El Registro
            int result = EmpleadoDAL.Eliminar(persona);
            
            if (result > 0)
            {
                JOptionPane.showMessageDialog(this,
                        "El Empleado fue eliminado existosamente", "ELIMINADO",
                        JOptionPane.INFORMATION_MESSAGE);
            } 
            else 
            {
                JOptionPane.showMessageDialog(this,
                        "Sucedio un error al eliminar el Empleado", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (Exception Error) 
        {
            JOptionPane.showMessageDialog(this,
                    Error.getMessage(), "ERROR PRODUCTO",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnGUARDAR;
    private javax.swing.JTextField TxtAPELLIDO;
    private javax.swing.JTextField TxtCARGO;
    private com.toedter.calendar.JDateChooser TxtFechaContratacion;
    private javax.swing.JTextField TxtNOMBRE;
    private javax.swing.JTextField TxtSALARIO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
