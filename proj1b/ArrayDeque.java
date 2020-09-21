public class ArrayDeque<T> implements Deque<T>{

    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    /* Creates an empty array deque. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

//    /* Creates a deep copy of other. */
//    public ArrayDeque(ArrayDeque other) {
//        items = (T[]) new Object[other.items.length];
//        nextFirst = other.nextFirst;
//        nextLast = other.nextLast;
//        size = other.size;
//
//        System.arraycopy(other.items, 0, items, 0, other.items.length);
//
//    }

    /*Returns true if deque is empty, false otherwise.*/
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /*Returns the number of items in the deque.*/
    @Override
    public int size() {
        return size;
    }

    /* Prints the items in the deque from first to last, separated by a space.
    Once all the items have been printed, print out a new line.*/
    @Override
    public void printDeque() {
        for (int i = plusOne(nextFirst); i != nextLast; i = plusOne(i)) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }


    /*Adds an item of type T to the front of the deque.*/
    @Override
    public void addFirst(T item) {
        if (isFull()) {
            upSize();
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    /*Adds an item of type T to the back of the deque.*/
    @Override
    public void addLast(T item) {
        if (isFull()) {
            upSize();
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;
    }

    /*Removes and returns the item at the front of the deque.
    If no such item exists, returns null.*/
    @Override
    public T removeFirst() {
        nextFirst = plusOne(nextFirst);
        T removeItem = items[nextFirst];
        items[nextFirst] = null;
        if (!isEmpty()) {
            size--;
        }
        if (isSparse()) {
            downSize();
        }
        return removeItem;
    }

    /*Removes and returns the item at the back of the deque.
    If no such item exists, returns null.*/
    @Override
    public T removeLast() {
        nextLast = minusOne(nextLast);
        T removeItem = items[nextLast];
        items[nextLast] = null;
        if (!isEmpty()) {
            size--;
        }
        if (isSparse()) {
            downSize();
        }
        return removeItem;
    }

    /*Gets the item at the given index, where 0 is the front, 1 is the next item,
    and so forth. If no such item exists, returns null. Must not alter the deque!*/
    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        //plusOne(nextFirst) is the real index 0
        return items[(plusOne(nextFirst) + index) % items.length];
    }

    /*Helper method for computing nextFirst index*/
    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    /*Helper method for computing nextLast index*/
    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    /*Helper method for checking if the array is full*/
    private boolean isFull() {
        return size == items.length;
    }

    /*Helper method for checking if the array is sparse*/
    private boolean isSparse() {
        return items.length >= 16 && (double) size / items.length < 0.25;
    }

    /*Helper method for resizing the array
     * We won't use arrayCopy considering the downsizing situation*/
    private void resize(int capacity) {
        T[] cache = (T[]) new Object[capacity];
        int realIndex = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            cache[i] = items[realIndex];
            realIndex = plusOne(realIndex);
        }
        items = cache;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    /*Helper method for upSize array*/
    private void upSize() {
        resize(items.length * 2);
    }

    /*Helper method for downSize array*/
    private void downSize() {
        resize(items.length / 2);
    }

}
