import com.mycompany.simplified_math_game.QuestionGenerator;
import com.mycompany.simplified_math_game.UserInterface;
import java.util.Scanner;  // Importante para el nuevo Scanner

public class MainClass {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);  // Este scanner se usará para reiniciar el juego y para elegir la operación
        String continuePlaying;

        do {
            QuestionGenerator qg = new QuestionGenerator();
            UserInterface ui = new UserInterface();
            
            int correctAnswers = 0;
            int totalQuestions = 0;

            System.out.println("Elige el tipo de operación que quieres practicar: ");
            System.out.println("1: Suma");
            System.out.println("2: Resta");
            System.out.println("3: Multiplicación");
            int operationType = scanner.nextInt();

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

            double percentageCorrect = ((double) correctAnswers / totalQuestions) * 100;

            if (percentageCorrect < 75) {
                System.out.println("Por favor pide ayuda adicional a tu instructor.");
            } else {
                System.out.println("Felicidades, estás listo para pasar al siguiente nivel!");
            }
            
            System.out.println("¿Quieres continuar jugando? (s/n)");
            continuePlaying = scanner.next();
        } while (continuePlaying.equalsIgnoreCase("s"));
    }
}
