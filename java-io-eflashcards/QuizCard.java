import java.io.*;

public class QuizCard implements Serializable{

	private static final long serialVersionUID = 1833265526945738206L;

	private String question;
	private String answer;

	public QuizCard (String question, String answer) {
		this.question = question;
		this.answer = answer;
	}

	public String getQuestion () {
		return question;
	}

	public String getAnswer () {
		return answer;
	}
}