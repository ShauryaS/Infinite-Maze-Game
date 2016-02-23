package PersonalProjects.Maze;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Instructions extends JPanel{
	
	private Top t;
	private Bottom b;

	public Instructions(){

		setLayout(new BorderLayout());
		
		t = new Top();
		add(t, BorderLayout.CENTER);
		
		b = new Bottom();
		add(b, BorderLayout.SOUTH);

	}

	class Top extends JPanel{

		public void paintComponent(Graphics g){

			setBackground(Color.BLACK);
			super.paintComponent(g);
			g.setFont(new Font("Utopia",Font.PLAIN, 70));
			g.setColor(Color.GREEN);
			g.drawString("Instructions", 10, 80);
			g.setFont(new Font("Utopia",Font.PLAIN, 15));
			g.setColor(Color.MAGENTA);
			g.drawString("Use arrow Keys to move the ball around the maze.", 20, 110);
			g.drawString("The green square is the start block. The red square is the end block.", 20, 130);
			g.drawString("The grid size changes every 5 levels. The game is endless.", 20, 150);
			g.drawString("You have a certain number of Blasts (used by pressing Spacebar) in each level to destroy bricks and reach the end.", 20, 170);
			g.drawString("To change color scheme, go to options page.", 20, 190);
			g.setFont(new Font("Utopia",Font.PLAIN, 30));
			g.setColor(Color.BLUE);
			g.drawString("Good Luck!!!", 10, 250);

		}

	}

	class Bottom extends JPanel implements ActionListener{

		private JButton start;
		private JButton goHome;

		public Bottom(){

			setLayout(new GridLayout(1, 2));

			start = new JButton("Start Game");
			add(start);
			start.setBackground(Color.ORANGE);
			start.setForeground(Color.WHITE);
			start.addActionListener(this);
			
			goHome = new JButton("Go Home");
			add(goHome);
			goHome.setBackground(Color.PINK);
			goHome.setForeground(Color.WHITE);
			goHome.addActionListener(this);

		}

		public void actionPerformed(ActionEvent e){

			if(e.getSource()==start){

				Coordinator.cont.cards.show(Coordinator.cont, "maze");

			}

			if(e.getSource()==goHome){

				Coordinator.cont.cards.show(Coordinator.cont, "title");

			}

		}

	}

}
