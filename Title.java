package PersonalProjects.Maze;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Title extends JPanel{

	private Buttons b;
	private Image img;

	public Title(){

		setLayout(new BorderLayout());
		b = new Buttons();
		add(b, BorderLayout.SOUTH);
		
		img = Toolkit.getDefaultToolkit().getImage("MazeTitle.PNG");

	}

	public void paintComponent(Graphics g){

		setBackground(Color.BLACK);
		super.paintComponent(g);

		g.setColor(Color.CYAN);
		g.setFont(new Font("Utopia",Font.PLAIN, 70));
		g.drawString("The Maze Game", 10, 60);
		
		g.drawImage(img, 10, 80, 820, 700, this);

	}

	class Buttons extends JPanel implements ActionListener{

		private JButton options;
		private JButton ins;
		private JButton start;

		public Buttons(){

			setLayout(new GridLayout(1, 3));

			ins = new JButton("Instructions");
			add(ins);
			ins.setBackground(Color.GREEN);
			ins.setForeground(Color.WHITE);
			ins.addActionListener(this);

			options = new JButton("Options");
			add(options);
			options.setBackground(Color.BLUE);
			options.setForeground(Color.WHITE);
			options.addActionListener(this);

			start = new JButton("Start Game");
			add(start);
			start.setBackground(Color.MAGENTA);
			start.setForeground(Color.WHITE);
			start.addActionListener(this);

		}

		public void actionPerformed(ActionEvent e){

			if(e.getSource()==start){

				Coordinator.cont.cards.show(Coordinator.cont, "maze");
				
			}

			if(e.getSource()==options){

				Coordinator.cont.cards.show(Coordinator.cont, "options");

			}

			if(e.getSource()==ins){

				Coordinator.cont.cards.show(Coordinator.cont, "instructions");

			}

		}

	}

}
