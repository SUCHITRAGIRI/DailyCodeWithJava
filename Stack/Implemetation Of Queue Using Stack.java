//Theory


package com.example.test;

import java.util.Stack;

//Dequeue efficient: O(1)
public class QueueUsingStacks {
   static Stack<Integer> s1 = new Stack<>();
   static Stack<Integer> s2 = new Stack<>();
    public static void main(String[] args) {
//        enqueueCostly(1);
//        enqueueCostly(2);
//        enqueueCostly(3);
//        enqueueCostly(4);
//        enqueueCostly(5);
//        for(int i = 1; i <= 5; i++)
//            System.out.print(dequeueEfficient() + " ");

        enqueueEfficient(1);
        enqueueEfficient(2);
        enqueueEfficient(3);
        enqueueEfficient(4);
        enqueueEfficient(5);
        for(int i = 1; i <= 5; i++)
            System.out.print(dequeueCostly() + " ");
    }

    static void enqueueCostly(int ele){

        if(s1.isEmpty()){
            s1.push(ele);
        }else{
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(ele);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
    }

    static int dequeueEfficient(){
        if(s1.isEmpty())return - 1;
        return s1.pop();
    }


    //Dequeue costly and enqueue efficient
    static void enqueueEfficient(int ele){
        s1.push(ele);
    }

    static int dequeueCostly(){
        if(s1.isEmpty())return - 1;
        int n = s1.size();
        while(n --> 1){
            s2.push(s1.pop());
        }
        int pop = s1.pop();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }

        return pop;
    }

}



