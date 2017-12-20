/** Stack Data Structure implementation with generics and iterable interface using LinkedList **/

package datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackLinkedList<Item> implements Iterable<Item> {
    private Node first;
    private int n;
    public StackLinkedList(){
        first = null;
        n =0;
    }
    @Override
    public Iterator<Item> iterator() {
        return new FirstIteratorLinkedList();
    }
private class FirstIteratorLinkedList implements Iterator<Item>{
  private Node current = first;
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
    public boolean isEmpty(){
      return  first == null;
    }
    public int size(){
        return n;
    }
    public Item pop(){
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;
        first=first.next;
        n--;
        return item;

    }
    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item=item;
        first.next=oldFirst;
        n++;
    }

    public static void main(String[] args) {
        StackLinkedList<String> stack = new StackLinkedList<>();
        String r = "rohith";
        for(int i = 0;i<r.length();i++){
            stack.push(r.substring(i,i+1));
        }
        Iterator<String> it = stack.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(stack.size());
        for(int i = 0;i<r.length();i++){
            System.out.println(stack.pop());
        }
    }
}
