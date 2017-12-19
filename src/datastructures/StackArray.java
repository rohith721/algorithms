/** Stack Data Structure implementation with generics and iterable interface using array **/

package datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackArray<Item> implements Iterable<Item>{
    private Item[] s;
    private int N;
    @Override
    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item>{
        private int i;
        public ReverseArrayIterator(){
            i=N-1;
        }
        @Override
        public boolean hasNext() {
            return i>=0;
        }
        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return s[i--];
        }
    }
    public StackArray(){
        s = (Item[]) new Object[2];
        N=0;
    }
    public void push(Item item){
        if(N==s.length)resize(2*s.length);
        s[N++]=item;
    }
    public void resize(int capacity){
        Item[] newArray = (Item[])new Object[capacity];
        for(int i=0;i<N;i++){
            newArray[i]=s[i];
        }
        s=newArray;
    }
    public Item pop(){
        Item item = s[--N];
        s[N]=null;
        if(N>0&&N==s.length/4)resize(s.length/2);
        return item;
    }
    public int size(){
        return N;
    }

    public static void main(String[] args) {
        StackArray<String> stack = new StackArray<String>();
        String r = "rohith";
        for(int i = 0;i<r.length();i++){
            stack.push(r.substring(i,i+1));
        }

        Iterator<String> it = stack.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        for(int i = 0;i<r.length();i++){
            System.out.println(stack.pop());
        }
    }
}
