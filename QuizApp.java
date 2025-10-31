import java.util.*;

class Question {
    String questionText;
    List<String> options;
    int correctOption; 
    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }
    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctOption;
    }
}
public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?",
                Arrays.asList("Berlin", "Madrid", "Paris", "Rome"), 2));
        questions.add(new Question("Which language runs in a web browser?",
                Arrays.asList("Java", "C", "Python", "JavaScript"), 3));
        questions.add(new Question("What does HTML stand for?",
                Arrays.asList("Hyper Trainer Marking Language", "Hyper Text Markup Language", "Hyper Text Marketing Language", "Hyper Tool Multi Language"), 1));

        int score = 0;
        Collections.shuffle(questions);

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.questionText);
            for (int j = 0; j < q.options.size(); j++) {
                System.out.println((j + 1) + ". " + q.options.get(j));
            }

            System.out.print("Your answer (1-4): ");
            int userAnswer = scanner.nextInt() - 1;

            if (q.isCorrect(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. Correct answer: " + q.options.get(q.correctOption));
            }
        }

        System.out.println("\n Quiz Completed!");
        System.out.println("Your Score: " + score + "/" + questions.size());
    }
}