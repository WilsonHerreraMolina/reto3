
package Vistas;

import Modelo.Conexión;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class UserMenu extends javax.swing.JFrame {
    Conexión conexion = new Conexión();
    Connection connection;
    Statement st;
    ResultSet rs;
    DefaultTableModel contenidoTablaEmpleados;
   
  
    public UserMenu() {
        informacionEmpresa();
        initComponents();
        this.setLocationRelativeTo(this);
        listarEmpleados();  
        
    }
    
    private void informacionEmpresa(){
       String query = "SELECT * FROM empresa;";
       try{
           connection = conexion.getConnection();
           st = connection.createStatement();
           rs = st.executeQuery(query);
           while (rs.next()){
                int nit = rs.getInt("nit");
                String empresa = rs.getString("nombreEmpresa");
                System.out.println(rs.getInt("nit")+ rs.getString("nombreEmpresa"));
            }
            
       
       }catch (SQLException e) {
           System.out.println(e);
       
       }
    
    }
    private void listarEmpleados(){
     String filtroBusqueda = txtSearch.getText();
     if(filtroBusqueda.isEmpty()){
         String query = " SELECT * FROM empleado";
         try {
            connection = conexion.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Object [] empleado = new Object [7];
            contenidoTablaEmpleados = (DefaultTableModel)tblEmpleados.getModel();
            while(rs.next()){
                empleado [0] = rs.getInt("IDEmp");
                empleado [1] = rs.getString("nombreEmp");
                empleado [2] = rs.getString("apellidos");
                empleado [3] = rs.getString("tipoDocumento");
                empleado [4] = rs.getString("documento");
                empleado [5] = rs.getString("correo");
                empleado [6] = rs.getString("FK_idDependencia");
             contenidoTablaEmpleados.addRow(empleado);
             tblEmpleados.setModel(contenidoTablaEmpleados);
             System.out.println("ID. Emp: " + empleado[0] + ", nombre: " + empleado[1] + ", documento: " + empleado[2] + " " + empleado[3] + ", correo: " + empleado[4] );
                     
                     
            }

        } catch (SQLException e) {
         System.out.println("No se pudo cargar la informaión de los empleados");
        }
      }else{
          String query = "SELECT * FROM empleado WHERE nombreEmp like '%" + filtroBusqueda + "%' OR apellidos like '%" + filtroBusqueda + "%';";
         try {
            connection = conexion.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Object [] empleado = new Object [7];
            contenidoTablaEmpleados = (DefaultTableModel)tblEmpleados.getModel();
            while(rs.next()){
                empleado [0] = rs.getInt("IdEmp");
                empleado [1] = rs.getString("nombreEmp");
                empleado [2] = rs.getString("apellidos");
                empleado [3] = rs.getString("tipoDocumento");
                empleado [4] = rs.getString("documento");
                empleado [5] = rs.getString("correo");
                empleado [6] = rs.getString("FK_idDependencia");
             contenidoTablaEmpleados.addRow(empleado);
             tblEmpleados.setModel(contenidoTablaEmpleados);
             System.out.println("ID. Emp: " + empleado[0] + ", nombre: " + empleado[1] + ", documento: " + empleado[2] + " " + empleado[3] + ", correo: " + empleado[4] );
                     
                     
            }

        } catch (SQLException e) {
         System.out.println("No se pudo cargar la informaión de los empleados");
        }
     }
    }
    private void borrarRegistrosTabla(){
        for (int i = 0; i < tblEmpleados.getRowCount(); i++) {
            contenidoTablaEmpleados.removeRow(i);
            i = i- 1; 
        }
    
    }
            
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Home = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        lb_empresa = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lb_nit = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        btnAdUser = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setText("Nit");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(532, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(26, 26, 26)
                        .addComponent(lb_nit, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lb_empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lb_nit, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(279, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("", null, jPanel3, "");

        Home.addTab("Home", jTabbedPane3);

        jPanel1.setBackground(java.awt.Color.lightGray);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID. Emp", "Nombre", "Apellidos", "Tipo de Documento", "Documento", "Correo", "IdDependencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        btnAdUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/avatar.png"))); // NOI18N
        btnAdUser.setText("Añadir");
        btnAdUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdUserActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Empleados MisionTIC 2022");

        jLabel3.setText("Nombre");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/showUser.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdUser))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(50, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(46, 46, 46))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdUser)
                            .addComponent(jLabel2))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Home.addTab("Empleados", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Home)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdUserActionPerformed
      AdUserForm adUserForm = new AdUserForm (this, true);
      adUserForm.setVisible(true);
      borrarRegistrosTabla();
      listarEmpleados();
    }//GEN-LAST:event_btnAdUserActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        int filaSeleccionada = tblEmpleados.getSelectedRow();
        System.out.println("Fila seleccionada: "+ filaSeleccionada);
        int idEmp = Integer.parseInt(tblEmpleados.getValueAt(filaSeleccionada, 0).toString());
        String nombreEmp = tblEmpleados.getValueAt(filaSeleccionada, 1).toString();
        String apellidos = tblEmpleados.getValueAt(filaSeleccionada, 2).toString();
        String tipoDocumento = tblEmpleados.getValueAt(filaSeleccionada, 3).toString();
        String documento = tblEmpleados.getValueAt(filaSeleccionada, 4).toString();
        String correo = tblEmpleados.getValueAt(filaSeleccionada, 5).toString();
        int idDependencia = Integer.parseInt(tblEmpleados.getValueAt(filaSeleccionada, 6).toString());
        
        String empleadoSeleccionado = "idEmp: " + idEmp + ", nombre: " + nombreEmp + " " + apellidos + ", documento: " + tipoDocumento + " " + documento + ", correo: " + correo;
        System.out.println(empleadoSeleccionado);
        
        ShowUserForm showUserForm = new ShowUserForm(this, true);
        showUserForm.recibirDatosDeUserMenu(idEmp, nombreEmp, apellidos, tipoDocumento, documento, correo);
        showUserForm.setVisible(true);
        borrarRegistrosTabla();
        listarEmpleados();
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        borrarRegistrosTabla();
        listarEmpleados();
    }//GEN-LAST:event_jButton1ActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Home;
    private javax.swing.JButton btnAdUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel lb_empresa;
    private javax.swing.JLabel lb_nit;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
