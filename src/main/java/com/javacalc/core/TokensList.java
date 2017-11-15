package main.java.com.javacalc.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TokensList<E> extends LinkedList<E> {

    public TokensList(List<E> list) {
        super(list);
    }

    public TokensList(){
        super();
    }

    @Override
    public String toString() {
        Iterator<E> it = iterator();
        if (!it.hasNext())
            return "List is empty";

        StringBuilder sb = new StringBuilder();
        for (; ; ) {
            E e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (!it.hasNext())
                return sb.toString();
        }
    }
}

