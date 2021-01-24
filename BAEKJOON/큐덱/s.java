package 큐덱;

import java.util.*;
import java.lang.*;

public class s {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        int testCase = sc.nextInt();
        int pushValue = 0;

        for(int i = 0 ; i < testCase; i++) {
            String command = sc.next();
            if(command.equals("push")) {
                pushValue = sc.nextInt();
                queue.add(pushValue);
                }

            else {
                switch(command) {
                    case "pop":
                        if(queue.isEmpty())
                            System.out.println("-1");
                        else
                            System.out.println(queue.poll());
                        break;
                    case "size":
                        System.out.println(queue.size());
                        break;
                    case "empty":
                        if(queue.isEmpty()) 
                            System.out.println("1");
                        else
                            System.out.println("0");
                        break;
                    case "front":
                        if(!queue.isEmpty())
                            System.out.println(queue.peek());
                        else 
                            System.out.println("-1");
                        break;
                    case "back":
                        if(!queue.isEmpty())
                            System.out.println(pushValue);
                        else 
                            System.out.println("-1");
                        break;
                }
            }
        }        
    }
}