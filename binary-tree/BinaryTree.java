package br.com.leo.ed.core;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryTree {
    private Node root;
    
    public void insert(int value){
        insert(root, value);
    }

    private void insert(Node node, int value){
        if(root == null){
            root = new Node(value);
        }else if(value < node.getValue()){
            if(node.getNodeLeft() != null){
                insert(node.getNodeLeft(), value);
            }else{
                node.setNodeLeft(new Node(value));
            }
        }else if(value > node.getValue()){
            if(node.getNodeRight() != null){
                insert(node.getNodeRight(), value);
            }else{
                node.setNoDireita(new Node(value));
            }
        }
    }

    public Node remove(int value){
        try{
            return remove(root, value);
        }catch(Exception ex) {
            Logger.getLogger(BinaryTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Node remove(Node node, int value) throws Exception{
        if(root == null){
            throw new Exception("Árvore vazia!");
        }else{
            if(value < node.getValue()){
                node.setNodeLeft(remove(node.getNodeLeft(), value));
            }else if(value > node.getValue()){
                node.setNoDireita(remove(node.getNodeRight(), value));
            }else if((node.getNodeLeft() != null) && (node.getNodeRight() != null)){
                System.out.println("Nó removido: " + node.getValue());
                node.setValue(searchMin(node.getNodeRight()).getValue());
                node.setNoDireita(removeMin(node.getNodeRight()));
            }else{
                System.out.println("Nó removido: " + node.getValue());
                node = (node.getNodeLeft() != null) ? node.getNodeLeft() : node.getNodeRight();
            }
            return node;
        }
    }

    private Node removeMin(Node node){
        if(node == null){
            System.out.println("Nó Vazio!");
        }else if(node.getNodeLeft() != null){
            node.setNodeLeft(removeMin(node.getNodeLeft()));
            return node;
        }else{
            return node.getNodeRight();
        }
        return null;
    }

    private Node searchMin(Node node){
        if (node != null){
            while(node.getNodeLeft() != null){
                node = node.getNodeLeft();
            }
        }
        return node;
    }

    public boolean isEmpty(){
        if(root == null){
            return true;
        }
        return false;
    }

    public int getHeight(){
        return getHeight(root);
    }

    private int getHeight(Node root){
        if(root == null){
            return 0;
        }
        
        int heightLeft = getHeight(root.getNodeLeft());
        int heightRight = getHeight(root.getNodeRight());
        if(heightLeft > heightRight){
            return heightLeft + 1;
        }else{
            return heightRight + 1;
        }
    }

    public int getQtdNode(){
        return getQtdNode(root);
    }

    private int getQtdNode(Node root){
        if(root == null){
            return 0;
        }
        
        int qtdNodeLeft = getQtdNode(root.getNodeLeft());
        int qtdNodeRight = getQtdNode(root.getNodeRight());
        
        return qtdNodeLeft + qtdNodeRight + 1;
    }

    public void printTree(){
        if(root == null){
            System.out.println("Árvore vazia");
        }else{
            printTree(root);
        }
    }

    private void printTree(Node node){
        if(node.getNodeLeft() != null){
            printTree(node.getNodeLeft());
        }
        if(node.getNodeRight() != null){
            printTree(node.getNodeRight());
        }
        System.out.println("Nó: " + node.getValue());
    }
    
}