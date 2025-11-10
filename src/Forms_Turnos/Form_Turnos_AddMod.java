/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Forms_Turnos;

import Controllers.MedicoController;
import Controllers.PacienteController;
import Controllers.TurnosController;
import Model.Medico;
import Model.Paciente;
import Model.Turno;
import Service.HorarioDisponibleService;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class Form_Turnos_AddMod extends javax.swing.JFrame {

  
  private TurnosController controller = new TurnosController();
    DateTimeFormatter dayformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public Form_Turnos_AddMod() {
        initComponents();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
      public Form_Turnos_AddMod(Turno turno) {
        initComponents();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        controller.Load(turno);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new java.awt.Button();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPacienteNombre = new javax.swing.JTextField();
        txtPacienteNroDoc = new javax.swing.JTextField();
        txtId_Medico = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMedicoNombre = new javax.swing.JTextField();
        txtMedicoEspecialidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        dtFecha = new javax.swing.JFormattedTextField();
        cboHorario = new javax.swing.JComboBox<>();
        txtId_Paciente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Apellido y Nombre:");

        btnGuardar.setActionCommand("btnAceptar");
        btnGuardar.setLabel("Aceptar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel8.setText("Nro Doc:");

        jLabel2.setText("Estado:");

        jLabel6.setText("Id Paciente:");

        jLabel9.setText("Id Medico:");

        jLabel10.setText("Especialidad:");

        txtId_Medico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtId_MedicoFocusLost(evt);
            }
        });

        jLabel3.setText("Apellido y Nombre:");

        jLabel4.setText("Fecha:");

        jLabel5.setText("Horario:");

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Cancelado", "Finalizado", " " }));

        try {
            dtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dtFecha.setToolTipText("");
        dtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtFechaActionPerformed(evt);
            }
        });

        txtId_Paciente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtId_PacienteFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtId_Medico, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtId_Paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(1, 1, 1)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtMedicoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(137, 137, 137))
                                                .addComponent(txtMedicoEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel1))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(txtPacienteNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(11, 11, 11)
                                                    .addComponent(txtPacienteNroDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(cboHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(dtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId_Medico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtMedicoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtMedicoEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtPacienteNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtPacienteNroDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId_Paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cboHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)))
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
         try {
            
              String Id_Paciente = txtId_Paciente.getText().trim();
              String Id_Medico = txtId_Medico.getText().trim();
            //  String documento = txtNroDoc.getText().trim();
        
        if (Id_Paciente.isEmpty() || Id_Medico.isEmpty() /*|| documento.isEmpty()*/) {
            JOptionPane.showMessageDialog(this, 
                "Por favor complete todos los campos obligatorios", 
                "Validación", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
            
         controller._Model.setId_Paciente(Integer.parseInt(Id_Paciente));
         controller._Model.setId_Medico(Integer.parseInt(Id_Medico));
         
         String textoFecha = dtFecha.getText().trim();
        
       
         LocalDate fecha = LocalDate.parse(textoFecha,dayformatter);
         controller._Model.setFecha(fecha);
         
         DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
         LocalTime Hora = LocalTime.parse(cboHorario.getSelectedItem().toString(),timeFormatter);
         controller._Model.setHora(Hora);
         
         controller._Model.setDuracion(30);
         controller._Model.setEstado(cboEstado.getSelectedItem().toString());
        
         
         if (controller._Model.getId()!= null)
         {
             controller.update(controller._Model);
         }
         else{  controller.Insert(controller._Model);
         }
       
       
          JOptionPane.showMessageDialog(this, "Turno guardado exitosamente");
          this.setVisible(false);
          this.dispose();
       }  catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
        "Error al guardar: " + e.getMessage(), 
        "Error", 
        JOptionPane.ERROR_MESSAGE);
         e.printStackTrace();
     }
       
        
    }//GEN-LAST:event_btnGuardarActionPerformed
private void cargarHorariosDisponibles() {
    
    try {
        // Obtener valores seleccionados
        int idMedico =Integer.parseInt(txtId_Medico.getText());//((Medico) cboMedico.getSelectedItem()).getId();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(dtFecha.getText().toString().trim(),timeFormatter); // O desde un JDateChooser
        
        // Obtener horarios disponibles
        HorarioDisponibleService service = new HorarioDisponibleService();
        List<String> horarios = service.obtenerHorariosDisponibles(idMedico, fecha);
        
        // Cargar en ComboBox
        cboHorario.removeAllItems();
        for (String horario : horarios) {
            cboHorario.addItem(horario);
        }
        
        if (horarios.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "No hay horarios disponibles para esta fecha", 
                "Aviso", 
                JOptionPane.INFORMATION_MESSAGE);
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error al cargar horarios: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}
    
    private void txtId_MedicoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtId_MedicoFocusLost
      GetMedico();
    }//GEN-LAST:event_txtId_MedicoFocusLost

    private void dtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dtFechaActionPerformed
    private void GetMedico(){
         try {    
            
             int Id_Medico =Integer.parseInt(txtId_Medico.getText().toString().trim());
             MedicoController controller = new MedicoController();
             controller._Model= controller.findById(Id_Medico) ;
             if (controller._Model == null) {
                JOptionPane.showMessageDialog(this, "Medico no encontrado");  
                txtId_Medico.setText("");
                txtMedicoNombre.setText("");
                txtMedicoEspecialidad.setText("");
             } 
             else{ 
              controller.Load(controller._Model);
              String NombreCompleto =controller._Model.getApellido() +","+ controller._Model.getNombre();
              txtMedicoNombre.setText(NombreCompleto);
              txtMedicoEspecialidad.setText(controller._Model.getEspecialidad());
              cargarHorariosDisponibles();
             }
        } catch (Exception ex) {
            Logger.getLogger(Form_Turnos_AddMod.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    private void GetPaciente(){
          try {    
             int Id_Paciente =Integer.parseInt(txtId_Paciente.getText().toString().trim());
             PacienteController controller = new PacienteController();
             controller._Model= controller.findById(Id_Paciente) ;
             if (controller._Model == null) {
                JOptionPane.showMessageDialog(this, "Paciente no encontrado");  
                txtId_Paciente.setText("");
                txtPacienteNombre.setText("");
                txtPacienteNroDoc.setText("");
             } 
             else{ 
              controller.Load(controller._Model);
              String NombreCompleto =controller._Model.getApellido() +","+ controller._Model.getNombre();
              txtPacienteNombre.setText(NombreCompleto);
              txtPacienteNroDoc.setText(controller._Model.getNumeroDocumento());
             
             }
        } catch (Exception ex) {
            Logger.getLogger(Form_Turnos_AddMod.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    
    private void txtId_PacienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtId_PacienteFocusLost
        GetPaciente();
    }//GEN-LAST:event_txtId_PacienteFocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       if (controller._Model.getId()!=0){
           String Fecha = dayformatter.format(controller._Model.getFecha());
           dtFecha.setText(Fecha);
           txtId_Medico.setText(controller._Model.getId_Medico().toString());
           txtId_Paciente.setText(controller._Model.getId_Paciente().toString());
           GetMedico();
           cboHorario.addItem(controller._Model.getHora().toString());
           cboHorario.setSelectedIndex(cboHorario.getItemCount() - 1);
           GetPaciente();
           String Estado = controller._Model.getEstado();

          switch (Estado) {
               case "Activo":
                 cboEstado.setSelectedIndex(0);

               break;
               case "Cancelado":
                cboEstado.setSelectedIndex(1);

               break;
               case "Finalizado":
                cboEstado.setSelectedIndex(2);
              break;   
             }
       }
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Form_Turnos_AddMod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Turnos_AddMod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Turnos_AddMod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Turnos_AddMod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Turnos_AddMod().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnGuardar;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JComboBox<String> cboHorario;
    private javax.swing.JFormattedTextField dtFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtId_Medico;
    private javax.swing.JTextField txtId_Paciente;
    private javax.swing.JTextField txtMedicoEspecialidad;
    private javax.swing.JTextField txtMedicoNombre;
    private javax.swing.JTextField txtPacienteNombre;
    private javax.swing.JTextField txtPacienteNroDoc;
    // End of variables declaration//GEN-END:variables
}
