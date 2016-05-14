package org.coursera.dataStructure.progAssign1.checkBracketProblem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.Stack;

public class CheckBracketMain {

	public static void main(String[] args) throws IOException {
		CheckBracketMain ck = new CheckBracketMain();
		InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
		if(!text.equals("file")){
			while((text=reader.readLine()) != null){
				System.out.println(ck.doBracketChecking(text));
			}
			
		}else{
			int testCaseSize = Integer.parseInt(reader.readLine());
			String testDir = "E:\\Coursera_Working_Directory\\DataStructure\\assignment1\\Starters PA1\\check_brackets_in_code\\tests\\";
			for(int i = 1; i <= testCaseSize; i++){
				reader = new BufferedReader(new FileReader(testDir+"" + String.format("%02d", i)));
				text = reader.readLine();
				System.out.println(ck.doBracketChecking(text));
			}	
		}
		
	}
	
	public String doBracketChecking(final String inputText){
		String output;
		boolean success = true;
		Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
		for (int position = 0; position < inputText.length(); ++position) {
			char next = inputText.charAt(position);
			if (next == '(' || next == '[' || next == '{') {
				Bracket openBrack = new Bracket(next, position);
				opening_brackets_stack.add(openBrack);
			}

			if (next == ')' || next == ']' || next == '}') {
				Bracket closeBrack = new Bracket(next, position);
				if(opening_brackets_stack.isEmpty()){
					opening_brackets_stack.add(closeBrack);
					success = false;
					break;
				}else if(opening_brackets_stack.peek().match(next)){
					opening_brackets_stack.pop();
				}else{
					opening_brackets_stack.add(closeBrack);
					success = false;
					break;
				}
			}
		}
		if(success && opening_brackets_stack.isEmpty())
			output = "Success";
		else 
			output = opening_brackets_stack.pop().getPosition()+1+"";

		return output;
	}
}
