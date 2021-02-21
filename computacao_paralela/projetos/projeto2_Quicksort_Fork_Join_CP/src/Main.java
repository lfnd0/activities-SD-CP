import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {

		int[] vector = IntStream.generate(() -> new Random().nextInt(1000)).limit(1000).toArray();
		System.out.println("Lista desordenada = " + Arrays.toString(vector));

		long time = System.currentTimeMillis();
		QuicksortRecursiveAction quicksort = new QuicksortRecursiveAction(vector);

		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(quicksort);

		pool.shutdown();

		System.out.println("Lista ordenada = " + Arrays.toString(vector));

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("Tempo de execucao = " + (System.currentTimeMillis() - time) + "ms");
		}));
	}
}