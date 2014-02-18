package com.imports;

public interface Queue<T>{
    public void enqueue( T x);
    
    public T dequeue();

    public T front();

    public boolean isEmpty();

}
