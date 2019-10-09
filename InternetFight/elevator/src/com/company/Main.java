package com.company;

import java.util.*;

import static java.lang.StrictMath.random;

/**
 * param:capacity 电梯容量
 * param:TOP_FLOOR 电梯最高层
 * param:capacity 电梯最底层
 * author:qhj
 * time:2019/10/09 15:02
 */

public class Main {
    final static int CAPACITY = 1000;
    final static int TOP_FLOOR = 12;
    final static int BOTTOM_FLOOR = 1;

    public static void main(String[] args) throws Exception {
        int live = 1;
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] str = in.nextLine().split(" ");
            LinkedList<Integer> l1 = conv(str);
            Collections.sort(l1);
            l1.removeFirst();
            //  System.out.println(Arrays.toString(str));
            //      System.out.println(l1);
            //处理异常楼层
            exp(l1);
            //up and down
            int one = l1.get(0); //from 1
            int tail = l1.getLast();
            if (live >= tail) {
                live = down(live, l1);
            } else if (live <= one) {
                live = up(live, l1);

            } else {   //默认先下后上
                live = ud(live, l1);
            }
        }
    }

    private static int ud(int live, LinkedList<Integer> l1) throws Exception{
        int index = 0;
        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) > live) {
                index = i;
                break;
            }
        }
        live = down(live, new LinkedList<>(l1.subList(0, index)));
        live = up(live, new LinkedList<>(l1.subList(index, l1.size())));
        return l1.getLast();
    }

    private static int up(int live, LinkedList<Integer> l1) throws Exception{
        int limit = 0;
        while (true) {
            System.out.println("第 " + live + "层");
            Thread.sleep(500);
            live++;
            if (l1.contains(live)) {
                System.out.println("你已到达第 " + live + "层 ,开门");
                Thread.sleep(500);
                Weight();
                limit++;
            }
            if (limit >= l1.size())
                break;
        }
        return l1.getLast();
    }

    private static void Weight() {
        int weight = (int) (Math.random() * 1500);
        if (weight > CAPACITY)
            System.err.println("电梯已超重,重量为 " + weight);
        else
            System.out.println("当前电梯重量为 " + weight);
    }

    private static int down(int live, LinkedList<Integer> l1) throws Exception{
        int limit = 0;
        while (true) {
            System.out.println("第 " + live + "层");
            Thread.sleep(500);
            live--;
            if (l1.contains(live)) {
                System.out.println("你已到达第 " + live + "层 ,开门");
                Thread.sleep(500);
                Weight();
                limit++;
            }
            if (limit >= l1.size())
                break;
        }

        return l1.getFirst();
    }

    private static LinkedList<Integer> conv(String[] str) {
        LinkedList<Integer> l1 = new LinkedList();
        for (int i = 0; i < str.length; i++) {
            l1.add(Integer.parseInt(str[i]));
        }
        return l1;
    }

    private static void exp(LinkedList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {   // from 1
            if (arr.get(i) > TOP_FLOOR || arr.get(i) < BOTTOM_FLOOR) {
                System.out.println("楼层输入错误");
                System.exit(0);
            }
        }
    }
}
