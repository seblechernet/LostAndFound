package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class LostandFound {
  private  ArrayList<Item> items=new ArrayList<Item>();
  private ArrayList<Item> trash=new ArrayList<Item>();
  private int clothingCount;
  private int petCount;
  private int otherCount;

 static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
	     LostandFound lostandFound=new LostandFound();
	     lostandFound.menu();

    }
    public void menu() {
    String exit="";
        do {

            System.out.println("\n\nChoose what you want to do:");
            System.out.println("1.Add a lost item\n2.Mark an Item as Lost or Found\n3.See the count\n4.Delete Item\n5.Undelete Item\n6.History\n7.Exit\n\n");
            String choice = sc.nextLine();
            switch (choice) {
                case "1": {

                    addlostItem();
                    break;
                }
                case "2": {
                    System.out.println("The ID of the item that you want to mark");
                    String id = sc.nextLine();
                    mark(id);
                    break;
                }
                case "3": {
                    showCount();
                    break;
                }
                case "4": {

                    System.out.println("The ID of the item that you want to Delete");
                    String id = sc.nextLine();
                    delete(id);
                    break;
                }
                case "5": {
                    System.out.println("The ID of the item that you want to UnDelete");
                    String id = sc.nextLine();
                    unDelete(id);
                    break;
                }
                case "6": {
                     list();
                    break;
                }
                case "7":{
                    exit = "exit";
                    System.out.println("Thank you for using this APP");
                    break;
                }
                default:
                    System.out.println("Choose only from the list of the menu");
                    break;
            }
        }while(!exit.equalsIgnoreCase("exit"));
    }

    public void addlostItem(){
        String add="";
        do {
            Item item = new Item();

            System.out.println("Enter the ID of the item");
            String id = sc.nextLine();
            item.setId(id);
            System.out.println("Enter the name of the item");
            String name = sc.nextLine();
            item.setName(name);
            System.out.println("Type Which category is it\n ");
            System.out.println("\t\t\t - Clothing\n\t\t\t -Pet\n\t\t\t -Other");
            String category = sc.nextLine();
            item.setCategory(category);
            if (category.equalsIgnoreCase("clothing")) {
                clothingCount += 1;
            }
            if (category.equalsIgnoreCase("pet")) {
                petCount += 1;
            }
            if (category.equalsIgnoreCase("other")) {
                otherCount += 1;
            }
            item.setStatus("Lost");
            items.add(item);
            System.out.println("You have added ");
            System.out.println("ID \t\t\t\t Name \t\t\t\t Catergory \t\t\t Status");
            System.out.println(item.getId() + "\t\t\t\t" + item.getName() + "\t\t\t\t" + item.getCategory() + "\t\t\t\t" + item.getStatus());
            System.out.println("\n\n DO you have any other lost Items (Y/N) ?");
            add=sc.nextLine();
        }while(add.equalsIgnoreCase("Y"));
    }
    public  void mark(String id){
    for(Item eachItem:items){
        if (id.equalsIgnoreCase(eachItem.getId())){
            System.out.println("You want to mark " + id + " as a Lost or as a Found? ");
            String status=sc.nextLine();
            if (status.equalsIgnoreCase(eachItem.getStatus())){
                System.out.println("You did not make any change the item was marked " + status + " already");
            }
            else
            eachItem.setStatus(status);
        }

    }
    }

    public void showCount(){
        System.out.println("There are " + clothingCount+ " item(s) of clothing," + petCount + " pet(s) and " + otherCount + " other items missing ");

    }

    public void delete(String id){

    for (int i=0;i<items.size();i++){

        if (id.equalsIgnoreCase(items.get(i).getId())){
            trash.add(items.get(i));
            items.remove(items.get(i));
            break;
        }

    }


    }
    public void unDelete(String id){
        for (Item eachItem:trash){
            System.out.println(eachItem.getId());
        }
        for (int i=0;i<trash.size();i++){
            if (id.equalsIgnoreCase(trash.get(i).getId())){
                items.add(trash.get(i));
                trash.remove(trash.get(i));

            }

        }
    }
    public void list(){
        System.out.println("Name \t\t\t\t\t\t\t\t  ID \t\t\t\t\t\t   Category\t\t\t\t\t\t\t  Status");
        for (Item eachItem:items){
            System.out.println(eachItem.getName() +"\t\t\t\t\t\t\t\t\t   " + eachItem.getId() +"\t\t\t\t\t\t\t\t" + eachItem.getCategory()+
              "\t\t\t\t\t\t\t\t" + eachItem.getStatus());
        }
    }
}
