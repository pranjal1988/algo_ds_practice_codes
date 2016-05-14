package org.coursera.dataStructure.progAssign1.checkBracketProblem;

public class Bracket {

	private char type;
	private int position;
	
	public Bracket(final char t, final int p){
		this.type = t;
		this.position = p;
	}
	
	public boolean match(final char c){
		switch (c) {
		case ')':
			if(this.type == '(')
				return true;
			break;
		case '}':
			if(this.type == '{')
				return true;
			break;
		case ']':
			if(this.type == '[')
				return true;
			break;
		default:
			break;
		}
		return false;
	}
	
	/**
	 * @return the type
	 */
	public char getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(char type) {
		this.type = type;
	}
	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}
	
	
}
