import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculadoraIMCIF extends Remote {

	public double calcularIMC(double altura, double peso) throws RemoteException;

	public String interpretarResultadoIMC(double altura, double peso) throws RemoteException;
}
