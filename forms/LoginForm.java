
package forms;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {
    public JPanel panelMain;
    public JTextField txtUsuario;
    public JPasswordField txtClave;
    public JButton btnIngresar;

    public LoginForm() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(panelMain);

        btnIngresar.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String clave = new String(txtClave.getPassword());
            if (usuario.equals("cliente123") && clave.equals("clave456")) {
                new BancoForm(usuario).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas");
            }
        });
    }
}
