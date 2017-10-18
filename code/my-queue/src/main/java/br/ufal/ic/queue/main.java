package br.ufal.ic.queue;

public class main {

	/**
	 * @param args
	 * @throws EmptyQueueException
	 */
	public static void main(String[] args) {
		Queue<String> newStringQueue = new Queue<String>(3);

		try {
			newStringQueue.insert("banana");
			newStringQueue.insert("orange");
			newStringQueue.insert("apple");
			System.out.println(newStringQueue.toString());
			System.out.println(newStringQueue.getFirst());
			System.out.println(newStringQueue.getSize());

			newStringQueue.remove();
			System.out.println(newStringQueue.toString());
			System.out.println(newStringQueue.getFirst());
			System.out.println(newStringQueue.getSize());

		} catch (FullQueueException e) {
			e.printStackTrace();
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}
	}

}
