package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    BinaryTree bt;

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }

    private void run() {
        bt = new BinaryTree();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Что делать с бинарным деревом?\n- добавить элемент(a)\n- добавить n-ное кол-во элементов(n)\n- вывести дерево как строку(p)");
            char in = input.nextLine().charAt(0);
            if (in == 'a') {
                System.out.println("Введите число, чтобы добавить в бинарное дерево:");
                String str = input.nextLine();
                int in_ = Integer.parseInt(str);
                bt.add(in_);
            } else if (in == 'p') {
                System.out.println(bt.toString());
            } else if (in == 'n') {
                System.out.println("Введите количество элементов для добавления:");
                String str = input.nextLine();
                int in_ = Integer.parseInt(str);
                addToTree(in_);
            } else if (in == 'e') {
                break;
            }
        }
    }

    private void addToTree(int amount) {
        long from = System.currentTimeMillis();
        Random rnd = new Random();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            int value = rnd.nextInt(amount);
            bt.add(value);
            str.append(value).append(" ");
        }
        long to = System.currentTimeMillis();
        System.out.println("Добавлено "+amount+" чисел в бинарное дерево за "+(to-from)+" миллисекунд\n"+str);
    }
}
