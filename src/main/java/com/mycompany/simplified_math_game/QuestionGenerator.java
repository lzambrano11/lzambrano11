import java.util.Random;

public class QuestionGenerator {
    private Random random;
    private int difficultyLevel;

    public QuestionGenerator(int difficultyLevel) {
        this.random = new Random();
        this.difficultyLevel = difficultyLevel;
    }

    public int[] generateOperands() {
        int maxNumber = (int) Math.pow(10, difficultyLevel) - 1;
        int operand1 = random.nextInt(maxNumber) + 1;
        int operand2 = random.nextInt(maxNumber) + 1;
        return new int[]{operand1, operand2};
    }

    public String generateQuestion(int operand1, int operand2, int operationType) {
        String question = "";
        switch (operationType) {
            case 1:
                question = "¿Cuánto es " + operand1 + " + " + operand2 + "?";
                break;
            case 2:
                question = "¿Cuánto es " + operand1 + " - " + operand2 + "?";
                break;
            case 3:
                question = "¿Cuánto es " + operand1 + " * " + operand2 + "?";
                break;
            case 4:
                question = "¿Cuánto es " + operand1 + " / " + operand2 + "?";
                break;
            // Aquí puedes agregar más tipos de operaciones si quieres
            default:
                question = "Operación no válida";
                break;
        }
        return question;
    }

    public int calculateAnswer(int operand1, int operand2, int operationType) {
        int answer = 0;
        switch (operationType) {
            case 1:
                answer = operand1 + operand2;
                break;
            case 2:
                answer = operand1 - operand2;
                break;
            case 3:
                answer = operand1 * operand2;
                break;
            case 4:
                if (operand2 != 0) {
                    answer = operand1 / operand2; // Cuidado con la división entre 0
                }
                break;
            // Aquí puedes agregar más tipos de operaciones si quieres
            default:
                System.out.println("Operación no válida");
                break;
        }
        return answer;
    }
}

