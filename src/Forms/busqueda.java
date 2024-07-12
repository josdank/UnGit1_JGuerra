package Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class busqueda {
    private JLabel cedula;
    private JTextField Cedula;
    public JButton buscar;
    public  JPanel mainPanel1;
    private JButton volverButton;

    public busqueda() {
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedulaPaciente = Cedula.getText();

                // Validación de los campos
                if (cedulaPaciente.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese nombre o cédula para buscar.");
                    return;
                }

                // Búsqueda en la base de datos
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_hospitalario", "root", "123456");
                    String sql = "SELECT * FROM PACIENTE WHERE cedula = ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, cedulaPaciente);
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next()) {
                        String cedula = rs.getString("cedula");
                        String historial = rs.getString("n_historial_clinico");
                        String nombre = rs.getString("nombre");
                        String apellido = rs.getString("apellido");
                        String telefono = rs.getString("telefono");
                        String edad = rs.getString("edad");
                        String descripcion = rs.getString("descripcion_enfermedad");

                        JOptionPane.showMessageDialog(null, "Paciente encontrado:\n" +
                                "Cédula: " + cedula  + "\nHistorial Medico:"+ cedula + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nTelefono: " + telefono +
                                "\nedad: " + edad + "\nDescripción: " + descripcion);
                    } else {
                        int option = JOptionPane.showConfirmDialog(null, "Estudiante no encontrado. ¿Desea registrar un nuevo estudiante?",
                                "Estudiante no encontrado", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            JFrame registroFrame = new JFrame("Registro de paciente");
                            registroFrame.setContentPane(new login().mainPanel);
                            registroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            registroFrame.pack();
                            registroFrame.setVisible(true);
                        }
                    }
                    conn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al buscar paciente: " + ex.getMessage());
                }
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Sistema de gestión de Pacientes");
                frame.setContentPane(new ingreso().mainpanel2);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 700);
                frame.pack();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);

                // Cierra la ventana actual
                ((JFrame) SwingUtilities.getWindowAncestor(volverButton)).dispose();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Búsqueda de Pacientes");
        frame.setContentPane(new busqueda().mainPanel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}