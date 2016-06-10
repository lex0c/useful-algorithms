package br.com.leo.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BankAction {
    private static List<Integer> queueOne;
    private static List<Integer> queueTwo;
    private static List<Integer> queueThree;
    private static List<Integer> queueElderly;
    private static List<Integer> queueSpecial;
    
    private int people;
    
    public BankAction(){
        queueOne = new ArrayList<>();
        queueTwo = new ArrayList<>();
        queueThree = new ArrayList<>();
        queueElderly = new ArrayList<>();
        queueSpecial = new ArrayList<>();
    }
    
    public void start(){
        people = 0;
        actionBank();
        showQueueList();
    }
    
    private void actionBank(){
        while(people <= 30){
            switch(new Random().nextInt(2)){
                case 0:
                    addPeopleInQueue(people);
                    break;
                case 1:
                    removePeopleInQueue(people);
                    break;
            }           
            people++;
        }
    }
    
    private void addPeopleInQueue(int people){
        switch(new Random().nextInt(5)){
            case 0:
                System.out.println("Inserindo na fila '1' o cliente: "+people);
                queueOne.add(people);
                break;
            case 1:
                System.out.println("Inserindo na fila '2' o cliente: "+people);
                queueTwo.add(people);
                break;
            case 2:
                System.out.println("Inserindo na fila '3' o cliente: "+people);
                queueThree.add(people);
                break;
            case 3:
                System.out.println("Inserindo na fila 'idoso' o cliente: "+people);
                queueElderly.add(people);
                break;
            case 4:
                System.out.println("Inserindo na fila 'especial' o cliente: "+people);
                queueSpecial.add(people);
                break;
        }
    }
    
    private void removePeopleInQueue(int people){
        switch(new Random().nextInt(5)){
            case 0:
                if(!(queueOne.isEmpty())){
                    System.out.println("Removendo na fila '1' o cliente: "+people);
                    queueOne.remove(0);
                }else{
                    System.out.println("Fila '1' está vazia!");
                }
                break;
            case 1:
                if(!(queueTwo.isEmpty())){
                    System.out.println("Removendo na fila '2' o cliente: "+people);
                    queueTwo.remove(0);
                }else{
                    System.out.println("Fila '2' está vazia!");
                }
                break;
            case 2:
                if(!(queueThree.isEmpty())){
                    System.out.println("Removendo na fila '3' o cliente: "+people);
                    queueThree.remove(0);
                }else{
                    System.out.println("Fila '3' está vazia!");
                }
                break;
            case 3:
                if(!(queueElderly.isEmpty())){
                    System.out.println("Removendo na fila 'idoso' o cliente: "+people);
                    queueElderly.remove(0);
                }else{
                    System.out.println("Fila 'idoso' está vazia!");
                }
                break;
            case 4:
                if(!(queueSpecial.isEmpty())){
                    System.out.println("Removendo na fila 'especial' o cliente: "+people);
                    queueSpecial.remove(0);
                }else{
                    System.out.println("Fila 'especial' está vazia!");
                }
                break;
        }
    }
    
    private void showQueueList(){
        System.out.println("---Status Atual da Fila---");
        if(!(queueOne.isEmpty()))
            System.out.println("Fila '1': "+queueOne.toString());
        else
            System.out.println("Fila '1' está vazia!");
        //...
        if(!(queueTwo.isEmpty()))
            System.out.println("Fila '2': "+queueTwo.toString());
        else
            System.out.println("Fila '2' está vazia!");
        //...
        if(!(queueThree.isEmpty()))
            System.out.println("Fila '3': "+queueThree.toString());
        else
            System.out.println("Fila '3' está vazia!");
        //...
        if(!(queueElderly.isEmpty()))
            System.out.println("Fila 'idoso': "+queueElderly.toString());
        else
            System.out.println("Fila 'idoso' está vazia!");
        //...
        if(!(queueSpecial.isEmpty()))
            System.out.println("Fila 'especial': "+queueSpecial.toString());
        else
            System.out.println("Fila 'especial' está vazia!"); 
    }
    
}