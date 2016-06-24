package br.com.leo.ed.core;

public class Node {
    private Node left;
    private Node right;
    private int value;

    public Node(int value){
        super();
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public Node getNodeLeft(){
        return left;
    }

    public void setNodeLeft(Node nodeLeft){
        this.left = nodeLeft;
    }

    public Node getNodeRight(){
        return right;
    }

    public void setNoDireita(Node nodeRight){
        this.right = nodeRight;
    }

    @Override
    public String toString(){
        return "'"+value+"'";
    }
    
}