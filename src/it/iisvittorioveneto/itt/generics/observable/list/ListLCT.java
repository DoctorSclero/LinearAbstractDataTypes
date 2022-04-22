package it.iisvittorioveneto.itt.generics.observable.list;

import it.iisvittorioveneto.itt.generics.observable.utils.TemplateNode;

public class ListLCT<T> implements ListT<T> {

    protected TemplateNode<T> head;
    protected TemplateNode<T> cursor;

    public ListLCT() {
        head = new TemplateNode<T>((T) "First Handle", null);
        cursor = head;
    }

    public ListLCT(T object) {
        this();
        this.insert(object);
    }

    /**
     * This method clears out the list by removing all the elements
     */
    @Override
    public void flush() {
        head.setNext(null);
    }

    protected void _insert(T object) {
        this.cursor.setNext(new TemplateNode<T>(object, this.cursor.getNext()));
    }

    /**
     * This method inserts a new node in the positio n next to the
     * current node (cursor.next).
     *
     * @param object The object to be added to the list
     */
    @Override
    public boolean insert (T object) {
        boolean res = true;
        if (head.getNext() == null) {
            this._insert(object);
        } else if (hasNext()) {
            moveNext();
            this._insert(object);
        } else {
            res = false;
        }
        return res;
    }

    /**
     * This method reads the current element and returns it
     *
     * @return The current element
     */
    @Override
    public T read() {
        T res = null;
        if (hasNext()) {
            res = cursor.getNext().getObject();
        }
        return res;
    }

    /**
     * This method removes the current element and returns it
     *
     * @return The current element
     */
    @Override
    public T extract() {
        T res = this.read();
        if (this.hasNext()) {
            cursor.setNext(cursor.getNext().getNext());
        }
        return res;
    }

    /**
     * This method calculates the number of elements in the list
     *
     * @return The number of elements
     */
    @Override
    public int size() {
        TemplateNode<T> temp = this.head.getNext();
        int i = 0;
        for (; temp != null; i++) {
            temp = temp.getNext();
        }
        return i;
    }

    /**
     * This method sets the cursor to the element 0 in the list
     */
    @Override
    public void reset() {
        head.setNext(null);
        cursor = head;
    }

    /**
     * This method moves the cursor to the next element
     *
     * @return (true) if successful
     */
    @Override
    public boolean moveNext() {
        boolean res = this.hasNext();
        cursor = cursor.getNext();
        return res;
    }

    /**
     * This method checks if the cursor isn't pointing to the
     * last element
     *
     * @return (true) if the cursor isn't pointing to the last element
     */
    @Override
    public boolean hasNext() {
        return cursor.getNext() != null;
    }

    /**
     * This method checks if there are no elements in the list
     *
     * @return (true) if there are no elements
     */
    @Override
    public boolean isEmpty() {
        return this.head.getNext() == null;
    }

    /**
     * This method checks if the list reached the maximum size
     *
     * @return (true) if the list reached its size limit
     */
    @Override
    public boolean isFull() {
        return false;
    }

    /**
     * Moves the cursor to the index(th) element of the list
     * from the beginning of the list
     *
     * @param index The index of the element to select
     * @return (true) if operation is successful
     */
    @Override
    public boolean seek(int index) {
        boolean res = false;
        this.cursor = this.head;

        if (index >= 0) {
            int i = 0;
            for (i = 0; i < (index) && this.hasNext(); i++) {
                this.cursor = this.cursor.getNext();
            }
            if (i == index) res = true;
        }

        return res;
    }

    /**
     * This method returns the current position of the cursor
     *
     * @return The position of the cursor
     */
    @Override
    public int peek() {
        TemplateNode<T> temp = head;
        int i = 0;
        for (; temp != cursor; i++) {
            temp = temp.getNext();
        }
        return i;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int currentNodeIdx = 0;
        TemplateNode<T> temp = this.head.getNext();

        stringBuilder.append(super.toString());
        stringBuilder.append(" = {\n");
        stringBuilder
                        .append("\tsize: ").append(this.size()).append('\n')
                        .append("\tpeek: ").append(this.peek()).append('\n')
                        .append("\telements: {");

        while (temp != null) {
            stringBuilder.append("\n\t\t(Node #").append(currentNodeIdx).append(") ").append(temp.getObject());
            currentNodeIdx++;
            temp = temp.getNext();
        }

        stringBuilder.append("\n\t}\n}");
        return stringBuilder.toString();
    }
}
