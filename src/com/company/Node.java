package com.company;

public class Node {
    private int val;
    protected Node left;
    protected Node right;
    protected Node parent;
    protected boolean alreadyUsed = false;

    public Node(int val) {
        this.val = val;
    }

    public int getVal() {
        return this.val;
    }
}
