package br.ufal.ic.queue;

public class FullQueueException extends Exception {

    private static final long serialVersionUID = 1L;

    FullQueueException(String message) {
        super(message);
    }
}
