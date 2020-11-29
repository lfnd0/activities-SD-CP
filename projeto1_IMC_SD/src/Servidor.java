import java.rmi.Naming;

public class Servidor {
	public Servidor() {
		try {
			CalculadoraIMCIF calculcatorIMC = new CalculadoraIMC();
			Naming.rebind("127.0.0.1", calculcatorIMC);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Servidor();
	}
}
