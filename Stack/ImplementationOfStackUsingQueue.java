//Concepts and Theory explaination:







package com.example.test;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    static Queue<Integer> Q1 = new LinkedList<>();
    static Queue<Integer> Q2 = new LinkedList<>();

    public static void main(String[] args) {

//        pushCostly(1);
//        pushCostly(2);
//        pushCostly(3);
//        pushCostly(4);
//        pushCostly(5);
//        for (int i = 1; i <= 5; i++)
//            System.out.println(popEfficient());

        pushEfficiently(1);
        pushEfficiently(2);
        pushEfficiently(3);
        pushEfficiently(4);
        pushEfficiently(5);
        for (int i = 1; i <= 5; i++)
            System.out.println(popCostly());
    }

    //popEfficiently and pushCostly
    static void pushCostly(int ele){
        if(Q1.isEmpty()){
            Q1.add(ele);
        }
        else {
            while(!Q1.isEmpty()){
                Q2.add(Q1.remove());
            }
            Q1.add(ele);
            while(!Q2.isEmpty()){
                Q1.add(Q2.remove());
            }
        }
    }
    static int popEfficient(){
        if(Q1.isEmpty())return- 1;
        return Q1.remove();
    }

    //popCostly and pushEfficiently
    static void pushEfficiently(int ele){
            Q1.add(ele);
        }

        static int popCostly(){
            if(Q1.isEmpty())return - 1;
            int n = Q1.size();
            while(n --> 1){
                Q2.add(Q1.remove());
            }
            int pop = Q1.remove();
            while(!Q2.isEmpty()){
                Q1.add(Q2.remove());
            }
            return pop;
        }
}





