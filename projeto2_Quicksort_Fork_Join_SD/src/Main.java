import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {

		int[] lista = IntStream.generate(() -> new Random().nextInt(100000)).limit(100000).toArray();
		System.out.println("Lista desordenada = " + Arrays.toString(lista));

		long tempoDeExecucao = System.currentTimeMillis();
		QuicksortRecursiveAction quicksort = new QuicksortRecursiveAction(lista);

		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(quicksort);

		pool.shutdown();

		System.out.println("Lista ordenada = " + Arrays.toString(lista));

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("Tempo de execucao = " + (System.currentTimeMillis() - tempoDeExecucao) + "ms");
		}));
	}
}