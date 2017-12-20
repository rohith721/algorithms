/** Queue Data Structure implementation with generics and iterable interface using array **/

package datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueArray<Item> implements Iterable<Item> {
    private Item[] s;
    private int n;
    private int first;
    private int last;
    public QueueArray(){
        s = (Item[])new Object[2];
        n=0;
        first = 0;
        last = 0;
    }
    public void enqueue(Item item){
        if (n == s.length) resize(2*s.length);
        s[last++] = item;
        if (last == s.length) last = 0;
        n++;
    }
    public boolean isEmpty() {
        return n == 0;
    }

    public void resize(int capacity){
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = s[(first + i) % s.length];
        }
        s = temp;
        first = 0;
        last  = n;
    }
    public int size(){
      return n;
    }
    public Item dequeue(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = s[first];
        s[first] = null;
        n--;
        first++;
        if (first == s.length) first = 0;
        if (n > 0 && n == s.length/4) resize(s.length/2);
        return item;
    }

    public static void main(String[] args) {
        QueueArray<String> queue = new QueueArray<String>();
        String r = "rohithrao";

        for(int i=0;i<r.length();i++){
        queue.enqueue(r.substring(i,i+1));}
        Iterator<String> it = queue.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(queue.size());
        for(int i=0;i<r.length();i++){
            System.out.println(queue.dequeue());}

    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueArrayIterator();
    }
    private class QueueArrayIterator implements Iterator<Item>{
        private int i = 0;
        public boolean hasNext()  { return i < n;                               }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = s[(i + first) % s.length];
            i++;
            return item;
        }
    }
}
