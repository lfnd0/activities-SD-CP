import java.rmi.Naming;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Cliente {
	public static void main(String[] args) {
		double altura, peso;
		String resultado = "";

		try {
			CalculadoraIMCIF calculadoraIMCIF = (CalculadoraIMCIF) Naming.lookup("127.0.0.1");
			altura = Double.parseDouble(JOptionPane.showInputDialog("Informe sua altura (em metros):"));
			peso = Double.parseDouble(JOptionPane.showInputDialog("Informe seu peso:"));
			resultado = calculadoraIMCIF.interpretarResultadoIMC(altura, peso);

		} catch (Exception e) {
			e.printStackTrace();
		}

		JTextArea output = new JTextArea();
		output.setText(resultado);

		JOptionPane.showMessageDialog(null, output, "Resultado do IMC", JOptionPane.INFORMATION_MESSAGE);
	}
}
