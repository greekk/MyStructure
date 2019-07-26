package com.greekk;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class MyStructure<T> implements Iterable<T>{

    public int size;
    public Node[] nodes;
    private int currentIndex;

    public MyStructure( int size, T... args) {
        if(args.length > size)
            size = args.length;
        this.nodes = new Node[size];
        this.size = getSize();
        this.currentIndex = 0;

        this.size = size;
        if(args.length > 0){
            for (T data : args) {
                this.setData(data);
            }
        }
    }

    private int getSize(){
        return this.size;
    }

    public T getData() {
        if(Objects.nonNull(nodes[currentIndex]))
            return (T) nodes[currentIndex].getData();
        return null;
    }

    public void setData(T data) {
        if(Objects.isNull(nodes[currentIndex])) {
            nodes[currentIndex] = new Node(data);
        }
        else{
            nodes[currentIndex].setData(data);
        }
        try{
            next();
        }
        catch(IndexOutOfBoundsException iobex){
            increaseSize();
        }
    }

    public void next(){
        currentIndex++;
        if(currentIndex == this.size)
            throw new IndexOutOfBoundsException();
    }
    private void increaseSize(){
        this.size*=2;
        Node[] tmp = new Node[this.size];
        int counter = 0;
        for (Node node : this.nodes) {
            tmp[counter] = node;
            counter++;
        }
        this.nodes = tmp;
    }

    @Override
    public String toString() {
        return "MyStructure{" + ", data=" + Arrays.toString(this.nodes) + '}';
    }


    @Override
    public Iterator<T> iterator() {
        return iterator();
    }
}
