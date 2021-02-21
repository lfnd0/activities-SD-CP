import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraIMC extends UnicastRemoteObject implements CalculadoraIMCIF {

	private static final long serialVersionUID = 1L;

	public CalculadoraIMC() throws RemoteException {
		super();
	}

	@Override
	public double calcularIMC(double altura, double peso) throws RemoteException {
		return peso / (Math.pow(altura, 2));
	}

	@Override
	public String interpretarResultadoIMC(double altura, double peso) throws RemoteException {
		double IMC = calcularIMC(altura, peso);

		if (IMC <= 18.5) {
			return "Valor do IMC: " + String.format("%.2f", IMC) + "\nStatus do IMC: magreza";

		} else if ((IMC > 18.5) && (IMC <= 24.9)) {
			return "Valor do IMC: " + String.format("%.2f", IMC) + "\nStatus do IMC: normal";

		} else if ((IMC > 25.0) && (IMC <= 29.9)) {
			return "Valor do IMC: " + String.format("%.2f", IMC) + "\nStatus do IMC: sobrepeso";

		} else if ((IMC > 30.0) && (IMC <= 39.9)) {
			return "Valor do IMC: " + String.format("%.2f", IMC) + "\nStatus do IMC: obesidade";

		} else if (IMC > 40.0) {
			return "Valor do IMC: " + String.format("%.2f", IMC) + "\nStatus do IMC: obesidade grave";
		}

		return "";
	}
}