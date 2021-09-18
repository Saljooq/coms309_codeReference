package test.connect.myapplication.model;

public class Trivia {

    private int id;
    private String question;
    private String answer;

    public Trivia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String printable(){
        return "\nQUESTION:  "+ getQuestion()
                +"\nANSWER:  "+getAnswer()+"\n";
    }
}
