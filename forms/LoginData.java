package forms;

import javax.swing.*;

public class LoginData extends JFrame {
    public JPanel panelMain;
    public JTextField txtUsuario;
    public JPasswordField txtClave;
    public JButton btnIngresar;

    public LoginData() {
        setTitle("Login");
        setSize(250, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(panelMain);

        btnIngresar.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String clave = new String(txtClave.getPassword());
            if (usuario.equals("cliente123") && clave.equals("clave456")) {
                new BancoData(usuario).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas");
            }
        });
    }
}

