package shop.tripass.api.cmm.util;

import java.util.ArrayList;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("vc") @Lazy
public class Vector<T> {
    private ArrayList<T> vc;
    public Vector() {vc = new ArrayList<T>();}
    public void add(T t) {vc.add(t);}
    public T get(int i) {return vc.get(i);}
    public ArrayList<T> get(){return vc;}
    public void clear() {vc.clear();}
    public int size() {return vc.size();}
    public void set(ArrayList<T> list) {vc = list;}
}

