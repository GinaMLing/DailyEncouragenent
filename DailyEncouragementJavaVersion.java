import java.util.Scanner;

public class DailyEncouragementJavaVersion {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);// Initialize Scanner


        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.println("Welcome," + name + "!");

        System.out.println("How are you feeling on the scale of 1-5? (rate from 1 (very bad) to 5 (very good)) ");
        System.out.println("(please enter an integer:))");

        int feelScore = scanner.nextInt();


        if(feelScore >= 4){
            System.out.println("Looks like you are having a good day:)");
            System.out.println("Take a deep breath and remember how this moment makes you feel...");
            System.out.println("Cuz this moment will break our falls");
        }
        else{
            System.out.println("Aww there must be something tough happening:(");
            System.out.println("Do you want to talk about it? (yes/no)");

            scanner.nextLine(); // Consume newline left-over
            String WhatMakesUSad = scanner.nextLine();
            System.out.println("You said:" + WhatMakesUSad);

            if (WhatMakesUSad.equals("yes")) {
                System.out.println("You are already brave to try to open up!");

            } else {
                System.out.println("It is tough to open up. I get it. You should take your time.");

            }

            System.out.println("We are first gonna give you some random encouraging sentences, and then break things down for you! ");
            System.out.println("Here are some random encouraging sentences:");
            DailyEncouragementImproved1 Sentence = new DailyEncouragementImproved1();
            Sentence.randomtest((int)(Math.random()*100)-50);
        }


        //venture game with some changes

        int happiness = 10 * feelScore;
        int experience = 0;
        boolean areHappy = false;
        boolean getExperience = false;

        System.out.println("Let's break things down! It is gonna make you feel better.:)");


        System.out.println("So let's talk about it now? (yes/no)");
        String txt = scanner.nextLine().toLowerCase();

        if (txt.equals("yes")) {
            happiness += 10;
            System.out.println("You got 10 points of happiness for opening up!");
            System.out.println("You have also got a diamond for opening up!");

            int size = 5;  // Controls the size of the diamond

            // Upper half of the diamond
            for (int i = 1; i <= size; i++) {
                for (int j = size; j > i; j--) {
                    System.out.print(" ");
                }
                for (int k = 1; k <= 2 * i - 1; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }

            // Lower half of the diamond
            for (int i = size - 1; i >= 1; i--) {
                for (int j = size; j > i; j--) {
                    System.out.print(" ");
                }
                for (int k = 1; k <= 2 * i - 1; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }


        } else {
            System.out.println("You decide not to continue on your journey.:(nvm.");
        }




        //breaking down the problems
        System.out.println("What is on your mind?");
        txt = scanner.nextLine().toLowerCase();

        /*how to list more than 3 scenarios--update situations like loneliness(isolation)/life changes/
        self-image/financial and health stress/lack of purpose*/

        if (txt.contains("boy friend")||txt.contains("boyfriend")||txt.contains("bf")||txt.contains("relationship")||txt.contains("breakup")||txt.contains("friend")||txt.contains("family")) {
            System.out.println("You should find someone who respects and supports you. If he doesn't matter in a year, he doesn't deserve your time of thinking.");
            System.out.println("Think of one person that you are grateful about, and stay at the moment for 10 seconds.");
            System.out.println("You gained 100 points of experience!");
            experience += 100;

            if (Math.random() < 0.5) {
                System.out.println("Woah..you got really lucky this time.");
                System.out.println("You gained extra happiness!");
                happiness += 500;
            } else{
                System.out.println("To cheer u up, I would recommend Taylor Swift's You Are on Your Own kid or I Can Do It with a Broken Heart.");
            }
        } else if ((txt.contains("test")||txt.contains("school")||txt.contains("work")||txt.contains("career"))||(txt.contains("suck")||txt.contains("screw")||txt.contains("burnout"))) {
            System.out.println("You gotta focus on what you can control! ");
            System.out.println("It is just a factual fact that you can be whoever you want to be.");
            System.out.println("Take several deep breaths or watch the celling for 15 seconds.");
            System.out.println("Plan out what you gonna do from now.");
            System.out.println("You gained 100 points of experience!");
            experience += 100;

            if (Math.random() < 0.5) {
                System.out.println("Woah..you got really lucky this time.");
                System.out.println("You gained extra happiness!");
                happiness += 500;
            } else{
                System.out.println("To make you feel grounded, I would recommend Lana Del Rey's Brooklyn Baby and Young and Beautiful.");
            }
        } else {
            System.out.println("I have heard your problem, and it must be tough and overwhelming to deal with everything all at once.  ");
            System.out.println("Hey..maybe you should take a 5-min break and continue.");
            System.out.println("Do you think you can solve it on your own? (yes/no)");
            String solveItOrNot = scanner.nextLine().toLowerCase();

            if (solveItOrNot.equals("yes")) {
                System.out.println("Look at u girl!!");
                System.out.println("That's great to hear.:)");
                System.out.println("You gained 500 points of happiness and experience!");
                happiness += 500;
                experience += 500;
            } else{

                System.out.println("To make you feel better, I would recommend Tessa Violet's Bad Bitch, Doja Cat's Best Friend, and Taylor Swift's Cruel Summer.");
                System.out.println("You can also call one of our therapists: ");
            }

        }
        System.out.println("How do you feel now? (rate from 1 (very bad) to 5 (very good)))");
        feelScore = scanner.nextInt();
        feelScore *= 10;




        // Display updated status
        System.out.println("Name:" + name);

        System.out.println("Current status: Happiness: " + happiness + ", Experience: " + experience);
        if (happiness >= 50 && experience >= 100){
            areHappy = !areHappy;
            getExperience = !getExperience;
            System.out.println("Are you happy now:" + areHappy);
            System.out.println("Are you wise now:" + getExperience);
        } else {
            System.out.println("I am sorry that you feel this way.");
            System.out.println("You can also call one of our therapists: ");

            /*will use knowledge of array to list doctors
            add function to select therapists and connect
            improve the flow of the app
            seek for other opportunities to improve the app
             */

        }



        scanner.close();


    }
    public void randomtest(int x){
        int y = 0;
        if (x == y) {
            System.out.println("After realizing that u r the sun, you won't be afraid of the darkness anymore.");
            System.out.println("Focus on your vision. Fear is the devil.");
        }

        else if (x > y){
            System.out.println("You have endless power, and you get them from the universe. ");
            System.out.println("You are whole, perfect, strong, powerful, loving, harmonious, and happy.");
        }
        else{
            System.out.println("Care about the things that you will keep caring for for 10 yrs.");
            System.out.println("You can be the person that you want to be.");
        }
    }
}
