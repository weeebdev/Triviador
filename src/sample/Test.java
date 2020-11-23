package sample;
import java.util.ArrayList;

public class Test extends Question{
	private int numberOfOptions;
	private String[] options;
	private ArrayList<String> labels = new ArrayList<>();
	public Test(int n){
		super();
		numberOfOptions=n;
		for(int i =0;i<numberOfOptions;i++){
			labels.add(String.valueOf((char)(i+65)));
		}
	}
	public void setOptions(String[] op){
		options = op;
	}
	public String getOptionAt(int ind){
		return options[ind];
	}
	
	public String toString(){
		String question="";
		question+=getDescription()+"\n";
		for(int i = 0;i<numberOfOptions;i++){
			question+=labels.get(i)+") "+getOptionAt(i)+"\n";
		}
		return question;
	}

}