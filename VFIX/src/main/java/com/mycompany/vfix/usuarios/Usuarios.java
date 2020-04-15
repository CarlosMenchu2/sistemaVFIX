/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vfix.usuarios;

import java.util.List;

/**
 *
 * @author carlo
 */
public class Usuarios extends javax.swing.JPanel {
    
    private List<DatosEmpleado> datosEmpleados;
    /**
     * Creates new form Usuarios
     */
    public Usuarios() {
        initComponents();
        datosEmpleados();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(54, 159, 128));
        jSeparator1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1080, 10));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(54, 159, 128));
        jLabel1.setText("Usuarios");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 200, -1));

        jButton1.setBackground(new java.awt.Color(26, 46, 70));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("+ Nuevo Usuario");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 210, 40));

        tablaEmpleados.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaEmpleados);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 590, 140));

        jButton2.setBackground(new java.awt.Color(26, 46, 70));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Modificar Informacion");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, 190, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String nombre = tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(),0).toString();
        String rol = tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 1).toString();
        PanelModificarUsuario panelModificarUsuario = new PanelModificarUsuario();
        panelModificarUsuario.setNombre(nombre);
        panelModificarUsuario.setRol(rol);
        panelModificarUsuario.setImagen(datosEmpleados.stream()
                .filter(empleado -> empleado.getNombre().equals(nombre))
                .map(DatosEmpleado::getNombre).findAny().orElse(""));
        panelModificarUsuario.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        NuevoUsuario nuevoUsuario = new NuevoUsuario();
        nuevoUsuario.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void datosEmpleados(){
        EjecutarPeticion ejecutarPeticion = new EjecutarPeticion();
        datosEmpleados = ejecutarPeticion.ObtenerDatos();
        AdaptadorDatosEmpleado adaptadorDatosEmpleado = new AdaptadorDatosEmpleado(datosEmpleados);
        tablaEmpleados.setModel(adaptadorDatosEmpleado.obtenerDatos());
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaEmpleados;
    // End of variables declaration//GEN-END:variables
}