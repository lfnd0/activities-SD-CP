import java.util.concurrent.RecursiveAction;

public class QuicksortRecursiveAction extends RecursiveAction {

	private static final long serialVersionUID = 1L;

	private int[] vector;
	private int left;
	private int right;

	public QuicksortRecursiveAction(int[] vector) {
		this.vector = vector;
		left = 0;
		right = vector.length - 1;
	}

	public QuicksortRecursiveAction(int[] vector, int left, int right) {
		this.vector = vector;
		this.left = left;
		this.right = right;
	}

	private int partition(int[] vector, int low, int high) {
		int pivot = vector[low];
		int i = low - 1;
		int j = high + 1;

		while (true) {
			do {
				i++;
			} while (vector[i] < pivot);

			do {
				j--;
			} while (vector[j] > pivot);
			if (i >= j)
				return j;
			swap(vector, i, j);
		}
	}

	private void swap(int[] vector, int i, int j) {
		int temp = vector[i];
		vector[i] = vector[j];
		vector[j] = temp;
	}

	@Override
	protected void compute() {
		if (left < right) {
			int pivot = partition(vector, left, right);
			invokeAll(new QuicksortRecursiveAction(vector, left, pivot),
					new QuicksortRecursiveAction(vector, pivot + 1, right));
		}
	}
}