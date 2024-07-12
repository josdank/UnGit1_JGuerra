package Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class login {
    public JPanel mainPanel;
    private JPasswordField contrasenia;
    private JTextField usuario;
    private JRadioButton mostrarContra;
    private JButton loginButton;

    public login() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Usuario = usuario.getText();
                String Contrasenia = contrasenia.getText();
                // Validaciión de los campos
                if (Usuario.isEmpty() || Contrasenia.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
                    return;
                }
                //Tabla de datos
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_hospitalario", "root", "123456");
                    String sql = "SELECT * FROM USUARIO WHERE username = ? OR password = ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.executeUpdate();
                    JFrame frame = new JFrame("Sistema de gestión de Pacientes");
                    frame.setContentPane(new ingreso().mainpanel2);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(800, 700);
                    frame.pack();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);

                    // Cierra la ventana actual
                    ((JFrame) SwingUtilities.getWindowAncestor(loginButton)).dispose();
                    JOptionPane.showMessageDialog(null, "Bienvenido al sistema.");
                    conn.close();
                } catch (SQLException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error, No existe ususario dentro de la base de datos: " + ex.getMessage());
                }


                String Usuario1 = usuario.getText();
                String Contra = new String(contrasenia.getPassword());

                JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
            }


        });

        mostrarContra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {
                if (mostrarContra.isSelected()) {
                    contrasenia.setEchoChar((char) 0);
                } else {
                    contrasenia.setEchoChar('•');
                }
            }
        });

    }
}

