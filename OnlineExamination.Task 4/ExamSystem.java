import java.util.*;

public class ExamSystem {
    private User user;
    private List<Question> questions = new ArrayList<>();

    public ExamSystem(User user) {
        this.user = user;
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question("What is Java?", new String[]{"A language", "A coffee", "An island", "None"}, 1));
        questions.add(new Question("OOP stands for?", new String[]{"Only One Principle", "Object Oriented Programming", "Open Oriented Programming", "None"}, 2));
        questions.add(new Question("Which keyword is used to inherit?", new String[]{"this", "import", "extends", "super"}, 3));
    }

    public void startExam() {
        System.out.println("Exam started. Timer: 60 seconds.");
        Scanner sc = new Scanner(System.in);
        Timer timer = new Timer();
        Map<Question, Integer> answers = new HashMap<>();

        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("\nTime's up! Auto-submitting...");
                submit(answers);
                System.exit(0);
            }
        }, 60000);

        for (Question q : questions) {
            q.display();
            System.out.print("Your answer (1-4): ");
            int ans = sc.nextInt();
            answers.put(q, ans);
        }

        timer.cancel();
        submit(answers);
    }

    private void submit(Map<Question, Integer> answers) {
        int score = 0;
        for (Question q : answers.keySet()) {
            if (q.isCorrect(answers.get(q))) {
                score++;
            }
        }
        System.out.println("\nExam Over. " + user.getName() + ", your score is: " + score + "/" + questions.size());
    }

    public void updateProfile() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter new name: ");
        String newName = sc.nextLine();
        System.out.print("Enter new password: ");
        String newPass = sc.nextLine();
        user.setName(newName);
        user.setPassword(newPass);
        System.out.println("Profile updated successfully!");
    }
}