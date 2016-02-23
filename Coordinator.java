package PersonalProjects.Maze;

import java.awt.*;
import javax.swing.*;

public class Coordinator extends JFrame{

	public static Container cont;
	
	public static void main(String [] args){

		Coordinator c = new Coordinator();

	}

	public Coordinator(){

		super("Maze Game");
		setSize(850, 850);
		cont = new Container();
		add(cont);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}
	
	class Container extends JPanel{
		
		CardLayout cards;
		Title t;
		Maze m;
		Options o;
		Instructions i;
		
		public Container(){
			
			cards = new CardLayout();
			
			setLayout(cards);
			
			t = new Title();
			add(t, "title");
			
			m = new Maze();
			add(m, "maze");
			
			o = new Options();
			add(o, "options");
			
			i = new Instructions();
			add(i, "instructions");
			
		}
		
	}

}
