import java.util.concurrent.RecursiveAction;

public class QuicksortRecursiveAction extends RecursiveAction {

	private static final long serialVersionUID = 1L;

	private int[] lista;
	private int limiteEsquerdo;
	private int limiteDireito;

	public QuicksortRecursiveAction(int[] lista) {
		this.lista = lista;
		limiteEsquerdo = 0;
		limiteDireito = lista.length - 1;
	}

	public QuicksortRecursiveAction(int[] lista, int limiteEsquerdo, int limiteDireito) {
		this.lista = lista;
		this.limiteEsquerdo = limiteEsquerdo;
		this.limiteDireito = limiteDireito;
	}

	private int particao(int[] lista, int limiteMenor, int limiteMaior) {
		int pivo = lista[limiteMenor];
		int i = limiteMenor - 1;
		int j = limiteMaior + 1;

		while (true) {
			do {
				i++;
			} while (lista[i] < pivo);

			do {
				j--;
			} while (lista[j] > pivo);
			if (i >= j)
				return j;
			swap(lista, i, j);
		}
	}

	private void swap(int[] lista, int i, int j) {
		int temp = lista[i];
		lista[i] = lista[j];
		lista[j] = temp;
	}

	@Override
	protected void compute() {
		if (limiteEsquerdo < limiteDireito) {
			int pivo = particao(lista, limiteEsquerdo, limiteDireito);
			invokeAll(new QuicksortRecursiveAction(lista, limiteEsquerdo, pivo),
					new QuicksortRecursiveAction(lista, pivo + 1, limiteDireito));
		}
	}
}