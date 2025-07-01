package forms;

import javax.swing.*;
import java.util.ArrayList;

public class BancoData extends JFrame {
    public JPanel panelBanco;
    public JLabel lblUsuario, lblSaldo;
    public JTextArea areaHistorial;
    public JButton btnDeposito, btnRetiro, btnTransferencia, btnSalir;

    private double saldo = 1000.0;
    private ArrayList<String> historial = new ArrayList<>();

    public BancoData(String usuario) {
        setTitle("Banco");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(panelBanco);

        lblUsuario.setText("Cliente: " + usuario);
        lblSaldo.setText("Saldo: $" + saldo);
        areaHistorial.setEditable(false);
        actualizarHistorial("Sistema iniciado con $" + saldo);

        btnDeposito.addActionListener(e -> realizarDeposito());
        btnRetiro.addActionListener(e -> realizarRetiro());
        btnTransferencia.addActionListener(e -> realizarTransferencia());
        btnSalir.addActionListener(e -> System.exit(0));
    }

    private void actualizarSaldo() {
        lblSaldo.setText("Saldo: $" + String.format("%.2f", saldo));
    }

    private void actualizarHistorial(String texto) {
        historial.add(texto);
        areaHistorial.setText(String.join("\n", historial));
    }

    private void realizarDeposito() {
        String input = JOptionPane.showInputDialog("Valor a depositar:");
        try {
            double valor = Double.parseDouble(input);
            saldo += valor;
            actualizarSaldo();
            actualizarHistorial("Depósito de $" + valor);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Valor inválido.");
        }
    }

    private void realizarRetiro() {
        String input = JOptionPane.showInputDialog("Valor a retirar:");
        try {
            double valor = Double.parseDouble(input);
            if (valor <= saldo) {
                saldo -= valor;
                actualizarSaldo();
                actualizarHistorial("Retiro de $" + valor);
            } else {
                JOptionPane.showMessageDialog(this, "Fondos insuficientes.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Valor inválido.");
        }
    }

    private void realizarTransferencia() {
        JTextField destino = new JTextField();
        JTextField monto = new JTextField();
        Object[] msg = {"Destinatario:", destino, "Monto:", monto};
        int opt = JOptionPane.showConfirmDialog(null, msg, "Transferencia", JOptionPane.OK_CANCEL_OPTION);
        if (opt == JOptionPane.OK_OPTION) {
            try {
                double valor = Double.parseDouble(monto.getText());
                if (valor <= saldo) {
                    saldo -= valor;
                    actualizarSaldo();
                    actualizarHistorial("Transferencia a " + destino.getText() + " por $" + valor);
                } else {
                    JOptionPane.showMessageDialog(this, "Saldo insuficiente.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error en datos.");
            }
        }
    }
}
