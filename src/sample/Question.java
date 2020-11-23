package sample;

public abstract class Question{
	private String description;
	private String answer;
	protected Question(){}
	public void setDescription(String des){
		description = des;
	}
	public void setAnswer(String ans){
		answer  = ans;
	}
	public String getDescription(){
		return description;
	}
	public String getAnswer(){
		return answer;
	}

}