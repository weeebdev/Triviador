package sample;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.io.*;

public class Quiz{
	private String name;
	private ArrayList<Question> questions = new ArrayList<>();
	public Quiz(){
	}
	public void setName(String na){
		name = na.substring(0,na.length()-4);
	}
	public String getName(){
		return name;
	}
	public void addQuestion(Question a){
		questions.add(a);
	}
	public static Quiz loadFromFile(String fileName) {
		try{
			File file = new File(fileName);
			Scanner fin = new Scanner(file);
			Quiz quiz = new Quiz();
			quiz.setName(fileName);
			String line = fin.nextLine();
			ArrayList<String> lines = new ArrayList<>();
			while (fin.hasNextLine()) {
				while (!line.equals("")) {
					lines.add(line);
					if (fin.hasNextLine()) {
						line = fin.nextLine();

					} else {
						break;
					}
				}


				Test tques = new Test(lines.size() - 1);
				Random rand = new Random();
				tques.setDescription(lines.get(0));
				lines.remove(0);
				tques.setAnswer(lines.get(0));
				String[] options = new String[lines.size()];
				int n = lines.size();
				int ind = rand.nextInt(lines.size());
				for (int i = 0; i < n - 1; i++) {
					options[i] = lines.get(ind);
					lines.remove(ind);
					ind = rand.nextInt(lines.size());
				}
				options[n - 1] = lines.get(0);
				tques.setOptions(options);
				quiz.addQuestion(tques);


				if (fin.hasNextLine())
					line = fin.nextLine();
				else {
					break;
				}
				lines.clear();
			}
			quiz.shuffle();
			return quiz;
		}catch(Exception ex) {
			return null;
		}
	}
	public void shuffle(){
		Collections.shuffle(questions);

	}


	public Question getQuestion(int ind){
		return questions.get(ind%questions.size());
	}
}