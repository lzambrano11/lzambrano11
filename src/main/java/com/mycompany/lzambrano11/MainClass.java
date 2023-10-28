import com.mycompany.simplified_math_game.QuestionGenerator;
import com.mycompany.simplified_math_game.UserInterface;


public class MainClass {
    public static void main(String[] args) {
        QuestionGenerator qg = new QuestionGenerator();
        UserInterface ui = new UserInterface();

        int correctAnswers = 0;
        int totalQuestions = 0;
        int operationType = 1;  // Por ahora, solo suma

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
