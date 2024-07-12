import javax.swing.*;
import Forms.login;
import Forms.busqueda;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        JFrame frame = new JFrame("Sistema de gestión de estudiantes");
        frame.setContentPane(new login().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}