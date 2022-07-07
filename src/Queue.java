/**
 * This class implements a queue
 * This queue uses a linked list constructed by QueueElements
 * @version 1.0.0
 * @author Amy Estep
 */

import java.util.NoSuchElementException;

public class Queue<T> {

    private QueueElement head;
    private QueueElement tail;
    private int leng;

    /**
     * Constructs an empty Queue
     * initiates length, head, tail
     */
    public Queue() {
        this.head = null;
        this.tail = null;
        leng = 0;
    }

    /**
     * Returns true if the queue is empty
     * @return leng==0 whether the queue is empty
     */
    public boolean isEmpty() {
        return ((leng == 0));
    }

    /**
     * Returns the element at the head of the queue
     * @return this.head.getElement() the element at the front of the queue
     */
    public T peek() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return (T) this.head.getElement();
        }
    }

    /**
     * Removes the front element of the queue
     */
    public void dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        this.head = this.head.getNext();
        if (this.head == null) {
            tail = null;
        }
        leng--;
    }

    /**
     * Puts an element on the back of the queue.
     * @param element to be added to the queue
     */
    public void enqueue(T element) {
        QueueElement temp = new QueueElement(element, head);
        if (this.tail == null) {
            this.head = temp;
            this.tail = temp;
        }
        this.tail.setNext(temp);
        this.tail = temp;
        leng++;
    }

    /**
     * Method to print the full contents of the queue in order from head to
     * tail.
     */
    public void print() {
        if (!isEmpty()) {
            QueueElement current = this.head;
        for (int i = 0; i < leng; i++) {
            System.out.println(current.getElement());
            current = current.getNext();
        }
        }
    }
}

