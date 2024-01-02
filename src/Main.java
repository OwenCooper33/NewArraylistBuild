public class MyArrayList<E> {

    private E[] array;
    private int theSize;

    private static final int INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        theSize = 0;
        array = (E[]) new Object[INITIAL_CAPACITY];
    }

    public int size() {
        return theSize;
    }

    public boolean add(E value) {

        if(array.length == theSize) {
            grow(array.length*2);
        }

        array[theSize++] = value;
        return true;

    }

    public void add(int loc, E value) {

        if(loc<0 || loc>theSize) {
            throw new IndexOutOfBoundsException();
        }

        if(array.length == theSize) {
            grow(array.length*2);
        }

        for(int i=theSize;i>loc;i--) {
            array[i] = array[i-1];
        }

        array[loc] = value;

        theSize++;

    }

    public E remove(int loc) {

        if(loc<0 || loc>=theSize) {
            throw new IndexOutOfBoundsException();
        }

        E oldValue = array[loc];

        for(int i=loc;i<theSize-1;i++) {
            array[i] = array[i+1];
        }

        theSize--;
        return oldValue;

    }

    @SuppressWarnings("unchecked")
    private void grow(int newCapacity) {

        if(array.length >= newCapacity) {
            return;
        }

        E[] temp = (E[]) new Object[newCapacity];
        for(int i=0;i<array.length;i++) {
            temp[i] = array[i];
        }

        array = temp;

    }

    public E get(int loc) {

        if(loc<0 || loc>=theSize) {
            throw new IndexOutOfBoundsException();
        }

        return array[loc];

    }

    public E set(int loc, E value) {

        if(loc<0 || loc>=theSize) {
            throw new IndexOutOfBoundsException();
        }

        E oldValue = array[loc];
        array[loc] = value;

        return oldValue;

    }



}