package com.ocr.anthony;

import java.util.Scanner;

public class Order {
    Scanner sc = new Scanner(System.in);



    /**
     * Run asking process for a menu
     */
    public void runMenu() {
        this.displayAvailableMenu();
        int nbMenu;
        int nbSide;
        int nbDrink;
        do {
            nbMenu = sc.nextInt();
            this.displaySelectedMenu(nbMenu);
            switch (nbMenu) {
                case 1:
                    askSide(true);
                    askDrink();
                    break;
                case 2:
                    askSide(true);
                    break;
                case 3:
                    askSide(false);
                    askDrink();
                    break;
            }
        } while(nbMenu < 1 || nbMenu > 3);
    }

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
     *
     * @param nbMenu The selected menu.
     */
    public void displaySelectedMenu(int nbMenu) {
        if (nbMenu == 1)
            System.out.println("Vous avez choisi comme menu : poulet");
        else if (nbMenu == 2)
            System.out.println("Vous avez choisi comme menu : boeuf");
        else if (nbMenu == 3)
            System.out.println("Vous avez choisi comme menu : végétarien");
        else
            System.out.println("Vous n'avez pas choisi de menu parmi les choix proposés");
    }



    /**
     * Display a selected side depending on all sides enable
     * or not.
     * All sides = vegetables, frites and rice
     * No all sides =rice or not.
     *
     * @param nbSide
     * @param allSideEnable
     */
    public void displaySelectedSide(int nbSide, boolean allSideEnable) {
        if (allSideEnable) {
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
                    System.out.println("Vous n'avez pas choisi d'accompagnement parmi les choix proposés");
                    break;
            }
        } else {
            switch (nbSide) {
                case 1:
                    System.out.println("Vous avez choisi comme accompagnement : riz");
                    break;
                case 2:
                    System.out.println("Vous avez choisi comme accompagnement : pas de riz");
                    break;
                default:
                    System.out.println("Vous n'avez pas choisi d'accompagnement parmi les choix proposés");
                    break;
            }
        }

    }

    /**
     * Display a selected drink
     *
     * @param nbDrink The selected drink
     */
    public void displaySelectedDrink(int nbDrink) {
        switch (nbDrink) {
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
                System.out.println("Vous n'avez pas choisi de boisson parmi les choix proposés");
        }
    }
    

    public void runMenus() {
        System.out.println("Combien souhaitez vous commander de menus ?");
        int menuQuantity = sc.nextInt();
        int counter = 0;
        while(counter < menuQuantity) {
            runMenu();
            counter ++;
        }
    }

    /**
     * Display a question about a category in the standard
     * input, get response and display it
     * @param category the category of the question
     * @param responses available responses
     */
    public void askSomething(String category, String[] responses) {
        System.out.println("Choix " + category);
        for (int i = 1; i <= responses.length; i++) {
            System.out.println(i + " - " + responses[i - 1]);
        }
        System.out.println("Que souhaitez vous comme " + category + "?");
        int nbResponse;
        boolean responseIsGood = false;
        do {
            nbResponse = sc.nextInt();
            if(nbResponse >= 1 && nbResponse <= responses.length)
                responseIsGood = true;
            if(responseIsGood == true)
                System.out.println("Vous avez choisi comme " + category + " : " + responses[nbResponse - 1]);
            else {
                boolean isVowel = "aeiouy".contains(Character.toString(category.charAt(0)));
                if (isVowel) {
                    System.out.println("Vous n'avez pas choisi d'" + category + " parmi les choix proposés");
                } else {
                    System.out.println("Vous n'avez pas choisi de " + category + " parmi les choix proposés");
                }
            }
        } while(responseIsGood == false);
        
    }

    /**
     * Display a question about menu in the standard input, get response and display it
     */
    public void askMenu() {
        String[] menus = {"poulet", "boeuf", "végétarien"};
        askSomething("menu", menus);
    }

    /**
     * Display a question about menu in the standard input, get response and display it 
     * @param allSideEnable
     */
    public void askSide(boolean allSideEnable) {
        if(allSideEnable){
            String[] responseAllSide = {"légumes frais", "frites", "riz"};
            askSomething("accompagnement", responseAllSide);
        } else {
            String[] responsesOnlyRice = {"riz", "pas de riz"};
            askSomething("accompagnement", responsesOnlyRice);
        }
    }

    /**
     * Display a question about drink in the standard input, get response and display it
     */
    public void askDrink(){
        String[] responseDrink = {"eau plate", "eau gazeuse", "soda"};
       askSomething("boisson", responseDrink);
    }
}