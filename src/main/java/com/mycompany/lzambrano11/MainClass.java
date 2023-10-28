
import com.mycompany.simplified_math_game.UserInterface;
import java.util.Random;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String continuePlaying;

        String[] positiveFeedback = {
            "¡Muy bien!",
            "¡Excelente!",
            "¡Buen trabajo!",
            "¡Sigue así!"
        };

        String[] negativeFeedback = {
            "No. Por favor intenta de nuevo.",
            "Incorrecto. Intenta una vez más.",
            "¡No te rindas!",
            "No. Sigue intentando."
        };

        do {
            System.out.println("Elige el nivel de dificultad: ");
            System.out.println("1: Números de un dígito");
            System.out.println("2: Números de dos dígitos");
            int difficultyLevel = scanner.nextInt();
            
            QuestionGenerator qg = new QuestionGenerator(difficultyLevel);
            UserInterface ui = new UserInterface();
            
            int correctAnswers = 0;
            int totalQuestions = 0;

            System.out.println("Elige el tipo de operación que quieres practicar: ");
            System.out.println("1: Suma");
            System.out.println("2: Resta");
            System.out.println("3: Multiplicación");
            System.out.println("4: División");
            System.out.println("5: Mezcla aleatoria");
            int operationType = scanner.nextInt();

            while (correctAnswers < 10) {
                int[] operands = qg.generateOperands();
                String question = qg.generateQuestion(operands[0], operands[1], operationType);

                ui.showQuestion(question);
                int userAnswer = ui.getUserAnswer();

                int correctAnswer = qg.calculateAnswer(operands[0], operands[1], operationType);

                if (userAnswer == correctAnswer) {
                    correctAnswers++;
                    int randomIndex = random.nextInt(positiveFeedback.length);
                    System.out.println(positiveFeedback[randomIndex]);
                } else {
                    int randomIndex = random.nextInt(negativeFeedback.length);
                    System.out.println(negativeFeedback[randomIndex]);
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
