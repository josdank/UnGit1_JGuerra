package Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ingreso {
    private JTextField cedula;
    private JTextField N_historial;
    private JTextField Nombre;
    private JTextField Apellido;
    private JTextField Telefono;
    private JButton Registrar;
    public JPanel mainpanel2;
    private JButton volverButton;
    private JTextField edad;
    private JButton limpiar;
    private JLabel Cedula;
    private JLabel Historial;
    private JLabel nombre;
    private JLabel apellido;
    private JLabel telefono;
    private JTextField Descripcion;
    private JButton Buscar;
    private JLabel Edad;
    private JLabel dESCRIPCIONENFE;

    public ingreso() {
        Registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedulaText = cedula.getText();
                String nHistorialText = N_historial.getText();
                String nombreText = Nombre.getText();
                String apellidoText = Apellido.getText();
                String telefonoText = Telefono.getText();
                String edadText = edad.getText();
                String descripcionText = Descripcion.getText();


                // Validaciión de los campos
                if (cedulaText.isEmpty() || nHistorialText.isEmpty() ||
                        nombreText.isEmpty() || apellidoText.isEmpty() || telefonoText.isEmpty() || edadText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
                    return;
                }

                //Inserción de la base
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_hospitalario", "root", "123456");
                    String sql = "INSERT INTO PACIENTE (cedula, n_historial_clinico, nombre, apellido, telefono, edad, descripcion_enfermedad) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, cedulaText);
                    pstmt.setString(2, nHistorialText);
                    pstmt.setString(3, nombreText);
                    pstmt.setString(4, apellidoText);
                    pstmt.setString(5, telefonoText);
                    pstmt.setString(6, edadText);
                    pstmt.setString(7, descripcionText);
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Paciente registrado correctamente.");
                    conn.close();
                } catch (SQLException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error al insertar el Paciente: " + ex.getMessage());
                }
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Sistema de gestión Hospitalario");
                frame.setContentPane(new login().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 700);
                frame.pack();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);

                // Cierra la ventana actual
                ((JFrame) SwingUtilities.getWindowAncestor(volverButton)).dispose();
            }
        });

        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cedula.setText(null);
                N_historial.setText(null);
                Nombre.setText(null);
                Apellido.setText(null);
                Telefono.setText(null);
                edad.setText(null);
            }
        });
        Buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Sistema de gestión Hospitalario ");
                frame.setContentPane(new busqueda().mainPanel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 700);
                frame.pack();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);

                // Cierra la ventana actual
                ((JFrame) SwingUtilities.getWindowAncestor(Buscar)).dispose();
            }
        });
    }
}
