package com.imports;

import java.util.ArrayList;

public class ALQueue<T> implements Queue<T>{
    
    private ArrayList<T> _queue;

    public ALQueue(){
	_queue = new ArrayList<T>();
    }

    public void enqueue(T x){
	_queue.add(0, x);
    }

    public T dequeue(){
	return _queue.remove( _queue.size() -1);
    }

    public T front(){
	return _queue.get(_queue.size() -1);
    }

    public T end(){
	return _queue.get(0);
    }

    public boolean isEmpty(){
	return _queue.size() == 0;
    }
    
    public int getSize(){
    	return _queue.size();
    }

}