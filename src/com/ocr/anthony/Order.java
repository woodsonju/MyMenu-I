package com.ocr.anthony;

import java.util.Scanner;

public class Order {
    /**
     * Display all available menus in the restaurant.
     */
    public void displayAvailableMenu() {
        System.out.println("Choix Menu \n" +
                "1 - poulet \n" + 
                "2 - boeuf \n" + 
                "3 - végétarien \n" + 
                "Que souhaitez-vous comme menu ?");

    }
    /**
     * Display a selected menu.
     * @param nbMenu The selected menu.
     */
    public void displaySelectedMenu(int nbMenu) {
        if(nbMenu == 1)
            System.out.println("Vous avez choisi comme menu : poulet");
        else if(nbMenu == 2)
            System.out.println("Vous avez choisi comme menu : boeuf");
        else if(nbMenu == 3)
            System.out.println("Vous avez choisi comme menu : végétarien");
        else
            System.out.println("Vous n'avez pas choisi de menu parmi les choix proposés");
    }
    
    /**
     *  Run asking process for a menu
     */
    public void runMenu() {
        this.displayAvailableMenu();
        Scanner sc = new Scanner(System.in);
        int nb = sc.nextInt();
        this.displaySelectedMenu(nb);
    }

    /**
     * Display a selected side depending on all sides enable
     * or not.
     * All sides = vegetables, frites and rice
     * No all sides =rice or not.
     * @param nbSide
     * @param allSideEnable
     */
    public void displaySelectedSide(int nbSide, boolean allSideEnable) {
       if(allSideEnable) {
           switch (nbSide) {
               case 1:
                   System.out.println("Vous avez choisi comme accompagnement : légumes frais");
                   break;
               case 2:
                   System.out.println("Vous avez choisi comme accompagnement : frites");
                   break;
               case 3:
                   System.out.println("Vous avez choisi comme accompagnement : riz");
                   break;
               default:
                   System.out.println("Vous n'avez pas choisi d'accompagnememnt parmi les choix proposés");
                   break;
           }
       }
       else {
           switch (nbSide) {
               case 1:
                   System.out.println("Vous avez choisi comme accompagnement : riz");
                   break;
               case 2:
                   System.out.println("Vous avez choisi comme accompagnement : pas de riz");
                   break;
               default:
                   System.out.println("Vous n'avez pas choisi d'accompagnememnt parmi les choix proposés");
                   break;
           }
       }
       
    }

    /**
     * Display a selected drink
     * @param nbDrink The selected drink
     */
    public void displaySelectedDrink(int nbDrink) {
        switch (nbDrink){
            case 1:
                System.out.println("Vous avez choisi comme boisson : eau plate");
                break;
            case 2:
                System.out.println("Vous avez choisi comme boisson : eau gazeuse");
                break;
            case 3:
                System.out.println("Vous avez choisi comme boisson : soda");
                break;
            default:
                System.out.println("Vous n'avez pas choisi de  boisson parmi les choix proposés");
        }
    }
}