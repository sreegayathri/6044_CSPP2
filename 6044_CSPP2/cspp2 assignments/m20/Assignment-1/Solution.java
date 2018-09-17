/**
 * @ author sree gayathri : 20186044
 */
import java.util.Scanner;
/**
 * Class for question.
 */
class Question {
    /**.
     * { var_description }
     */
    private final int t = 10;
    /**
     * { var_description }.
     */
    private String questiontext;
    /**
     * { var_description }.
     */
    private String[] choices;
    /**
     * { var_description }.
     */
    private int correctAnswer;
    /**
     * { var_description }.
     */
    private int maxMarks;
    /**
     * { var_description }.
     */
    private int penalty;
    /**
     * { var_description }.
     */
    private String response;
    /**
     * Constructs the object.
     */
    Question() {
        choices = new String[t];
    }
    /**
     * Constructs the object.
     *
     * @param      question1       The question 1
     * @param      choices1        The choices 1
     * @param      correctAnswer1  The correct answer 1
     * @param      maxMarks1       The maximum marks 1
     * @param      penalty1        The penalty 1
     */
    Question(final String question1, final String[] choices1,
             final int correctAnswer1, final int maxMarks1,
             final int penalty1) {
        this.questiontext = question1;
        this.choices = choices1;
        this.correctAnswer = correctAnswer1;
        this.maxMarks = maxMarks1;
        this.penalty = penalty1;
    }
    /**.
     * Constructs the object.
     *
     * @param      response1  The response 1
     */
    Question(final String response1) {
        this.response = response1;
    }
    /**
     * { function_description }.
     *
     * @param      choice  The choice
     *
     * @return     { description_of_the_return_value }
     */
    public boolean evaluateResponse(final String choice) {
        return getCorrectAnswer().equals(choice);
    }
    /**
     * Gets the correct answer.
     *
     * @return     The correct answer.
     */
    public String getCorrectAnswer() {
        return Integer.toString(this.correctAnswer);
    }
    /**
     * Gets the question text.
     *
     * @return     The question text.
     */
    public String getQuestionText() {
        return this.questiontext;
    }
    /**
     * Gets the correct response.
     *
     * @return     The correct response.
     */
    public String getCorrectResponse() {
        return choices[correctAnswer - 1];
    }
    /**
     * Gets the choice.
     *
     * @return     The choice.
     */
    public String[] getChoice() {
        return this.choices;
    }
    /**
     * Gets the maximum marks.
     *
     * @return     The maximum marks.
     */
    public int getMaxMarks() {
        return this.maxMarks;
    }
    /**
     * Gets the penalty.
     *
     * @return     The penalty.
     */
    public int getPenalty() {
        return this.penalty;
    }
    /**
     * Sets the response.
     *
     * @param      answer  The answer
     */
    public void setResponse(final String answer) {
        // this.response = answer.subString(4);
    }
    /**
     * Gets the response.
     *
     * @return     The response.
     */
    public String getResponse() {
        return this.response;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        s += getQuestionText() + "(" + getMaxMarks() + ")" + "\n";
        for (int i = 0; i < getChoice().length - 1; i++) {
            s += choices[i] + "\t";
        }
        return s + choices[getChoice().length - 1] + "\n";
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    /**.
     * { var_description }
     */
    private final int t = 10;
    /**
     * { var_description }.
     */
    private final int onehundred = 100;
    /**
     * { var_description }.
     */
    private Question[] questions;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Quiz() {
        questions = new Question[t];
        size = 0;
    }
    /**
     * Adds a question.
     *
     * @param      q     The question
     */
    public void addQuestion(final Question q) {
        questions[size++] = q;
    }
    /**
     * Gets the question.
     *
     * @param      index  The index
     *
     * @return     The question.
     */
    public Question getQuestion(final int index) {
        return questions[index];
    }
    /**
     * Shows the report.
     *
     * @return     { description_of_the_return_value }
     */
    public String showReport() {
        String s = "";
        return s;
    }
    /**.
     * { function_description }
     *
     * @param      ques  The ques
     */
    public void print(final int ques) {
        for (int i = 0; i < ques; i++) {
            System.out.println(questions[i].toString());
        }
    }
}
/**.
 * Solution class for code-eval.
 */
public final class Solution {
    /**.
     * { var_description }
     */
    private static final int T3 = 3;
    /**.
     * { var_description }
     */
    private static final int F = 4;
    /**.
     * { var_description }
     */
    private static final int FV = 5;
    /**.
     * { var_description }
     */
    private static int size1 = 0;
    /**.
     * { var_description }
     */
    private static final int T = 10;
    /**.
     * { var_description }
     */
    private static int responeCount = 0;
    /**.
     * { var_description }
     */
    private static String[] str = new String[T];
    /**.
    * Constructs the object.
    */
    private Solution() {
        // leave this blank
    }
    /**.
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this Quiz
        Quiz q = new Quiz();
        // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            try {
                switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                    System.out.println("|----------------|");
                    System.out.println("| Load Questions |");
                    System.out.println("|----------------|");
                    loadQuestions(s, q, Integer.parseInt(tokens[1]));
                    break;
                case "START_QUIZ":
                    System.out.println("|------------|");
                    System.out.println("| Start Quiz |");
                    System.out.println("|------------|");
                    startQuiz(s, q, Integer.parseInt(tokens[1]));
                    break;
                case "SCORE_REPORT":
                    System.out.println("|--------------|");
                    System.out.println("| Score Report |");
                    System.out.println("|--------------|");
                    displayScore(q);
                    break;
                default:
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    /**.
     * Loads questions.
     *
     * @param      scan       The scan
     * @param      quiz       The quiz
     * @param      q          The quarter
     *
     * @throws     Exception  { exception_description }
     */
    public static void loadQuestions(final Scanner scan,
                                     final Quiz quiz,
                                     final int q)throws Exception {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        if (q == 0) {
            throw new Exception("Quiz does not have questions");
        } else {
            for (int i = 0; i < q; i++) {
                String questions = scan.nextLine();
                String[] items = questions.split(":");
                if (items.length < FV || items[0].length() == 0) {
                    throw new Exception("Error! Malformed question");
                } else if (items[1].split(",").length < 2) {
                    throw new Exception(
                        "trick question  does not have enough answer choices");
                } else if (Integer.parseInt(items[2]) > F) {
                    throw new Exception(
                        "Error! Correct answer choice number is out of"
                        + " range for question text 1");
                } else if (Integer.parseInt(items[T3]) < 0) {
                    throw new Exception(
                        "Invalid max marks for question about sony");
                } else if (Integer.parseInt(items[F]) > 0) {
                    throw new Exception(
                        "Invalid penalty for question about sony");
                }
                quiz.addQuestion(new Question(items[0], items[1].split(","),
                                              Integer.parseInt(items[2]),
                                              Integer.parseInt(items[T3]),
                                              Integer.parseInt(items[F])));
                size1++;
            }
            System.out.println(q + " are added to the quiz");
        }
    }
    /**.
     * Starts a quiz.
     *
     * @param      scan  The scan
     * @param      quiz  The quiz
     * @param      q     The answer count
     */
    public static void startQuiz(final Scanner scan,
                                 final Quiz quiz, final int q) {
        // write your code here to display the quiz questions on the console.
        // read the user responses from the console using scanner object.
        // store the user respone in the question object
        if (size1 == 0) {
            return;
        }
        quiz.print(q);
        for (int i = 0; i < q; i++) {
            str[i] = scan.nextLine();
            responeCount++;
        }
    }
    /**.
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.

        if (size1 == 0) {
            return;
        }
        int count = 0;
        for (int i = 0; i < responeCount; i++) {
            String ans = quiz.getQuestion(i).getCorrectResponse();
            System.out.println(quiz.getQuestion(i).getQuestionText());
            String sub = str[i];
            if (ans.equals(sub)) {
                System.out.println(
                    " Correct Answer! - Marks Awarded: "
                    + quiz.getQuestion(i).getMaxMarks());
                count += quiz.getQuestion(i).getMaxMarks();
            } else {
                System.out.println(
                    " Wrong Answer! - Penalty: "
                    + quiz.getQuestion(i).getPenalty());
                count += quiz.getQuestion(i).getPenalty();
            }
        }
        System.out.print("Total Score: " + count);

    }
}
