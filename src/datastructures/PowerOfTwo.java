package datastructures;

public class PowerOfTwo {
    public static void main(String[] args) {
        int number = 2048;
        if((number & (number-1))==0){
            System.out.println("number is power of 2");
        }
        else{
            System.out.println("no");
        }
    }
}
