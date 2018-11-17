package com.z.mylist;

/**
 * @ClassName MyArrayList
 * @Description my array list
 * @Author alex
 * @Date 2018/11/17
 **/
public class MyArrayList<T> {
    private T[] data;
    private int size;

    public MyArrayList(int capacity) {
        data = (T[]) new Object[capacity];
        this.size = 0;
    }

    public MyArrayList() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void add(int index, T t) {
        if (index < 0 || index > getSize()) {
            throw new IllegalArgumentException("index is wrong");
        }
        if (getSize() == getCapacity()) {
            resize(getCapacity() * 2);
        }
        for (int i = getSize(); i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = t;
        size++;
    }

    public void addFirst(T t) {
        add(0, t);
    }

    public void addLast(T t) {
        add(getSize(), t);
    }

    public T get(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IllegalArgumentException("index is wrong");
        }
        return data[index];
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(getSize() - 1);
    }

    public void set(int index, T t) {
        if (index < 0 || index >= getSize()) {
            throw new IllegalArgumentException("index is wrong");
        }
        data[index] = t;
    }

    public boolean contains(T t) {
        for (int i = 0; i < getSize(); i++) {
            if (data[i].equals(t)) {
                return true;
            }
        }
        return false;
    }

    public int find(T t) {
        for (int i = 0; i < getSize(); i++) {
            if (data[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    public T remove(int index) {
        if (index < 0 || index > getSize()) {
            throw new IllegalArgumentException("index is wrong");
        }

        T t = data[index];

        for (int i = index + 1; i < getSize(); i++) {
            data[i - 1] = data[i];
        }

        size--;

        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return t;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(getSize() - 1);
    }

    public void removeT(T t) {
        int index = find(t);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Size : %d, Capacity : %d\n", getSize(), getCapacity()));
        res.append("MyArrayList[");
        for (int i = 0; i < getSize(); i++) {
            res.append(data[i]);
            if (i != getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];

        for (int i = 0; i < this.getSize(); i++) {
            newData[i] = this.data[i];
        }
        data = newData;
    }

    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeT(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        for (int i = 0; i < 4; i++) {
            arr.removeFirst();
            System.out.println(arr);
        }
    }
}
