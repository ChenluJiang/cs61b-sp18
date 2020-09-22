public class LinkedListDeque<T> implements Deque<T> {

    // Inner ListNode Class
    private class ListNode {

        ListNode prev;
        T item;
        ListNode next;

        public ListNode(ListNode p, T i, ListNode n) {

            prev = p;
            item = i;
            next = n;

        }
    }

    /* A circular sentinel node. */
    private ListNode sentinel;
    private int size;

    /*Creates an empty LinkedListDeque*/
    public LinkedListDeque() {
        sentinel = new ListNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

//    /* Creates a deep copy of other*/
//    public LinkedListDeque(LinkedListDeque other) {
//
//        sentinel = new ListNode(null, null, null);
//        sentinel.prev = sentinel;
//        sentinel.next = sentinel;
//        size = 0;
//
//        for (int i = 0; i < other.size(); i++) {
                //needs casting!!
//            addLast((T) other.get(i));
//        }
//
//    }

    /* Adds an item of type T to the front of the deque. */

    @Override
    public void addFirst(T item) {
        sentinel.next = new ListNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;

    }

    /*  Adds an item of type T to the back of the deque. */
    @Override
    public void addLast(T item) {
        sentinel.prev = new ListNode(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    /* Returns true if deque is empty, false otherwise. */
//    @Override
//    public boolean isEmpty() {
//        return size == 0;
//    }

    /* Returns the number of items in the deque. */
    @Override
    public int size() {
        return size;
    }

    /*
     * Prints the items in the deque from first to last,
     * separated by a space.
     * Once all the items have been printed,
     * print out a new line.
     */
    @Override
    public void printDeque() {
        ListNode node = sentinel;
        while (node.next != sentinel) {
            System.out.print(node.next.item + " ");
            node = node.next;
        }
        System.out.println();
    }

    /*
    Removes and returns the item at the front of the deque.
    If no such item exists, returns null.
     */
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            T removeItem = sentinel.next.item;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size--;
            return removeItem;
        }
    }

    /*
    Removes and returns the item at the back of the deque.
    If no such item exists, returns null.
     */
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T removeItem = sentinel.prev.item;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size--;
            return removeItem;
        }
    }

    /*
    Gets the item at the given index,
    where 0 is the front,
    1 is the next item, and so forth.
    If no such item exists, returns null.
    Must not alter the deque!
     */
    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        } else {
            ListNode node = sentinel.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node.item;
        }

    }

    /*Helper method for getRecursive*/
    private T getRecursive(int index, ListNode sen) {
        if (index == 0) {
            return sen.next.item;
        } else {
            return getRecursive(index - 1, sen.next);
        }
    }

    /*Same as get, but uses recursion.*/
    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursive(index, sentinel);
    }
}

