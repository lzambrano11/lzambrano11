package com.mycompany.simplified_math_game;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);

    public int getUserAnswer() {
        System.out.println("Ingresa tu respuesta: ");
        return scanner.nextInt();
    }

    public void showQuestion(String question) {
        System.out.println(question);
    }
}
