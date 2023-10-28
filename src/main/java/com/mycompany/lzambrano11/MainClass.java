import com.mycompany.simplified_math_game.QuestionGenerator;
import com.mycompany.simplified_math_game.UserInterface;
import java.util.Scanner;  // Importante para el nuevo Scanner

public class MainClass {
    public static void main(String[] args) {
        QuestionGenerator qg = new QuestionGenerator();
        UserInterface ui = new UserInterface();

        int correctAnswers = 0;
        int totalQuestions = 0;

        System.out.println("Elige el tipo de operación que quieres practicar: ");
        System.out.println("1: Suma");
        System.out.println("2: Resta");
        System.out.println("3: Multiplicación");
        int operationType = new Scanner(System.in).nextInt();  // Aquí se cambió la línea para que el usuario elija el tipo de operación

        while (correctAnswers < 10) {
            int[] operands = qg.generateOperands();
            String question = qg.generateQuestion(operands[0], operands[1], operationType);

            ui.showQuestion(question);
            int userAnswer = ui.getUserAnswer();

            int correctAnswer = qg.calculateAnswer(operands[0], operands[1], operationType);

            if (userAnswer == correctAnswer) {
                correctAnswers++;
            }
            
            totalQuestions++;
        }

        System.out.println("Has respondido correctamente a " + correctAnswers + " de " + totalQuestions + " preguntas.");
    }
}
