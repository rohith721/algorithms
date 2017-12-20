/** Queue Data Structure implementation with generics and iterable interface using LinkedList **/

package datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueLinkedList<Item> implements Iterable<Item>{
    private int n;
    private Node first;
    private Node last;

    @Override
    public Iterator<Item> iterator() {
        return new QueueLinkedIterator();

    }
    private class QueueLinkedIterator implements Iterator<Item>{
         private Node current;
         public QueueLinkedIterator(){
             current = first;
         }
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item=current.item;
            current = current.next;
            return item;
        }
    }

    private class Node{
        Item item;
        Node next;
    }
    public QueueLinkedList(){
        first = null;
        last = null;
        n = 0;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public int size(){
        return n;
    }
    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldLast.next = last;
        n++;
    }
    public Item dequeue(){
        Item item = first.item;
        first=first.next;
        n--;
        if (isEmpty()) last = null;
        return item;
    }
    public static void main(String[] args) {
        QueueLinkedList<String> queue = new QueueLinkedList<String>();
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
}
