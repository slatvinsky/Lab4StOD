package com.company;

public class BinaryTree {
    Node root;

    public void add(int val) {
        Node newOne = new Node(val);
        if (root == null) { root = newOne; return; }
        Node current = root;
        int cNum = current.getVal();
        while (true) {
            if (cNum%2==0) { // если четное
                if (val%2==0) { // больше и четное
                    if (val >= cNum) { // значение которое хотим добавить больше или равно текущему
                        if (current.left == null) {
                            current.left = newOne;
                            newOne.parent = current;
                            break;
                        } else {
                            current = current.left;
                            cNum = current.getVal();
                        }
                    } else {
                        if (current.right == null) {
                            current.right = newOne;
                            newOne.parent = current;
                            break;
                        } else {
                            current = current.right;
                            cNum = current.getVal();
                        }
                    }
                } else { // больше и нечетное
                    if (current.right == null) {
                        current.right = newOne;
                        newOne.parent = current;
                        break;
                    } else {
                        current = current.right;
                        cNum = current.getVal();
                    }
                }
            }
            else { // если нечетное
                if (val%2==0) { // нечетное и четное
                    if (current.left == null) {
                        current.left = newOne;
                        newOne.parent = current;
                        break;
                    } else {
                        current = current.left;
                        cNum = current.getVal();
                    }
                }
                else { // нечетное и нечетное
                    if (val > cNum) { // значение которое хотим добавить больше текущего
                        if (current.right == null) {
                            current.right = newOne;
                            newOne.parent = current;
                            break;
                        } else {
                            current = current.right;
                            cNum = current.getVal();
                        }
                    } else { // значение которое хотим добавить меньше текущего
                        if (current.left == null) {
                            current.left = newOne;
                            newOne.parent = current;
                            break;
                        } else {
                            current = current.left;
                            cNum = current.getVal();
                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder srt = new StringBuilder();
        Node current = root;
        int height = 1;
        int maxHeight = 1;
        while (current != null) {
            if (current.left != null && !current.left.alreadyUsed) {
                current = current.left;
                height++; if (maxHeight < height) maxHeight = height;
            } else if (!current.alreadyUsed) {
                srt.append(current.getVal()).append(" ");
                current.alreadyUsed = true;
            } else if (current.right != null && !current.right.alreadyUsed) {
                current = current.right;
                height++; if (maxHeight < height) maxHeight = height;
            } else {
                if (current.right != null) {
                    current.right.alreadyUsed = false;
                }
                if (current.left != null) {
                    current.left.alreadyUsed = false;
                }
                current = current.parent;
                height--;
            }
        }
        if (root.left != null) {
            root.left.alreadyUsed = false;
        }
        if (root.right != null) {
            root.right.alreadyUsed = false;
        }
        root.alreadyUsed = false;
        srt.append("\nВысота дерева: ").append(maxHeight);
        return srt.toString();
    }
}
