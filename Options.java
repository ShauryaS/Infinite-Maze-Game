package PersonalProjects.Maze;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Options extends JPanel{

	private Top t;
	private Buttons b;

	public Options(){

		setLayout(new BorderLayout());

		b = new Buttons();
		add(b, BorderLayout.SOUTH);

		t = new Top();
		add(t, BorderLayout.CENTER);

	}

	public void paintComponent(Graphics g){

		setBackground(Color.BLACK);
		super.paintComponent(g);

	}

	class Top extends JPanel{//1967

		private ButtonGroup s;
		private ButtonGroup e;
		private ButtonGroup g;
		private ButtonGroup ba;
		private ButtonGroup br;
		private ButtonGroup ballc;

		private OpSet s1;
		private OpSet s2;
		private OpSet s3;
		private OpSet s4;
		private OpSet s5;
		private OpSet s6;

		private JLabel title;

		public Top(){

			setLayout(new GridLayout(7, 1));

			title = new JLabel("Options");
			title.setFont(new Font("Utopia",Font.PLAIN, 70));
			title.setForeground(Color.ORANGE);
			add(title);

			s = new ButtonGroup();
			e = new ButtonGroup();
			g = new ButtonGroup();
			ba = new ButtonGroup();
			br = new ButtonGroup();
			ballc = new ButtonGroup();

			s1 = new OpSet(s, "Start Base:");
			s2 = new OpSet(e, "End Base:");
			s3 = new OpSet(g, "Grid:");
			s4 = new OpSet(ba, "Background:");
			s5 = new OpSet(br, "Bricks:");
			s6 = new OpSet(ballc, "Ball:");

			add(s1);
			add(s2);
			add(s3);
			add(s4);
			add(s5);
			add(s6);

		}

		public void paintComponent(Graphics g){

			setBackground(Color.BLACK);
			super.paintComponent(g);

		}

		class OpSet extends JPanel implements ActionListener{

			private JCheckBox red;
			private JCheckBox blue;
			private JCheckBox green;
			private JCheckBox magenta;
			private JCheckBox black;

			private JLabel label;

			private String check;

			public OpSet(ButtonGroup bg, String a){

				setLayout(new GridLayout(1, 6));

				label = new JLabel(a);

				red = new JCheckBox("Red");
				blue = new JCheckBox("Blue");
				green = new JCheckBox("Green");
				magenta = new JCheckBox("Magenta");
				black = new JCheckBox("Black");

				add(label);
				label.setForeground(Color.WHITE);
				label.setFont(new Font("Utopia",Font.PLAIN, 20));

				bg.add(red);
				add(red);
				red.setBackground(Color.BLACK);
				red.setForeground(Color.RED);
				red.setFont(new Font("Utopia",Font.PLAIN, 20));
				red.addActionListener(this);

				bg.add(blue);
				add(blue);
				blue.setBackground(Color.BLACK);
				blue.setForeground(Color.BLUE);
				blue.setFont(new Font("Utopia",Font.PLAIN, 20));
				blue.addActionListener(this);

				bg.add(green);
				add(green);
				green.setBackground(Color.BLACK);
				green.setForeground(Color.GREEN);
				green.setFont(new Font("Utopia",Font.PLAIN, 20));
				green.addActionListener(this);

				bg.add(magenta);
				add(magenta);
				magenta.setBackground(Color.BLACK);
				magenta.setForeground(Color.MAGENTA);
				magenta.setFont(new Font("Utopia",Font.PLAIN, 20));
				magenta.addActionListener(this);

				bg.add(black);
				add(black);
				black.setBackground(Color.BLACK);
				black.setForeground(Color.DARK_GRAY);
				black.setFont(new Font("Utopia",Font.PLAIN, 20));
				black.addActionListener(this);

				check = a;

			}

			public void paintComponent(Graphics g){

				setBackground(Color.BLACK);
				super.paintComponent(g);

			}

			public void actionPerformed(ActionEvent e){

				if(check.equalsIgnoreCase("Start Base:")){

					if(red.isSelected()){

						Coordinator.cont.m.m.sae.startColor = Color.RED;

					}

					if(blue.isSelected()){

						Coordinator.cont.m.m.sae.startColor = Color.BLUE;

					}

					if(green.isSelected()){

						Coordinator.cont.m.m.sae.startColor = Color.GREEN;

					}

					if(magenta.isSelected()){

						Coordinator.cont.m.m.sae.startColor = Color.MAGENTA;

					}

					if(black.isSelected()){

						Coordinator.cont.m.m.sae.startColor = Color.BLACK;

					}

				}

				if(check.equalsIgnoreCase("End Base:")){

					if(red.isSelected()){

						Coordinator.cont.m.m.sae.endColor = Color.RED;

					}

					if(blue.isSelected()){

						Coordinator.cont.m.m.sae.endColor = Color.BLUE;

					}

					if(green.isSelected()){

						Coordinator.cont.m.m.sae.endColor = Color.GREEN;

					}

					if(magenta.isSelected()){

						Coordinator.cont.m.m.sae.endColor = Color.MAGENTA;

					}

					if(black.isSelected()){

						Coordinator.cont.m.m.sae.endColor = Color.BLACK;

					}


				}

				if(check.equalsIgnoreCase("Grid:")){

					if(red.isSelected()){

						Coordinator.cont.m.m.grid.gridColor = Color.RED;

					}

					if(blue.isSelected()){

						Coordinator.cont.m.m.grid.gridColor = Color.BLUE;

					}

					if(green.isSelected()){

						Coordinator.cont.m.m.grid.gridColor = Color.GREEN;

					}

					if(magenta.isSelected()){

						Coordinator.cont.m.m.grid.gridColor = Color.MAGENTA;

					}

					if(black.isSelected()){

						Coordinator.cont.m.m.grid.gridColor = Color.BLACK;

					}


				}

				if(check.equalsIgnoreCase("Background:")){

					if(red.isSelected()){

						Coordinator.cont.m.m.backgroundColor = Color.RED;
						
					}

					if(blue.isSelected()){

						Coordinator.cont.m.m.backgroundColor = Color.BLUE;

					}

					if(green.isSelected()){

						Coordinator.cont.m.m.backgroundColor = Color.GREEN;

					}

					if(magenta.isSelected()){

						Coordinator.cont.m.m.backgroundColor = Color.MAGENTA;

					}

					if(black.isSelected()){

						Coordinator.cont.m.m.backgroundColor = Color.BLACK;

					}


				}

				if(check.equalsIgnoreCase("Bricks:")){

					if(red.isSelected()){

						Coordinator.cont.m.m.bricks.bricksColor = Color.RED;

					}

					if(blue.isSelected()){

						Coordinator.cont.m.m.bricks.bricksColor = Color.BLUE;

					}

					if(green.isSelected()){

						Coordinator.cont.m.m.bricks.bricksColor = Color.GREEN;

					}

					if(magenta.isSelected()){

						Coordinator.cont.m.m.bricks.bricksColor = Color.MAGENTA;

					}

					if(black.isSelected()){

						Coordinator.cont.m.m.bricks.bricksColor = Color.BLACK;

					}


				}
				
				if(check.equalsIgnoreCase("Ball:")){

					if(red.isSelected()){

						Coordinator.cont.m.m.ball.ballColor = Color.RED;

					}

					if(blue.isSelected()){

						Coordinator.cont.m.m.ball.ballColor = Color.BLUE;

					}

					if(green.isSelected()){

						Coordinator.cont.m.m.ball.ballColor = Color.GREEN;

					}

					if(magenta.isSelected()){

						Coordinator.cont.m.m.ball.ballColor = Color.MAGENTA;

					}

					if(black.isSelected()){

						Coordinator.cont.m.m.ball.ballColor = Color.BLACK;

					}


				}

			}

		}

	}

	class Buttons extends JPanel implements ActionListener{

		private JButton save;
		private JButton goHome;

		public Buttons(){

			setLayout(new GridLayout(1, 2));

			save = new JButton("Save");
			add(save);
			save.setBackground(Color.RED);
			save.setForeground(Color.WHITE);
			save.addActionListener(this);

			goHome = new JButton("Go Home");
			add(goHome);
			goHome.setBackground(Color.BLUE);
			goHome.setForeground(Color.WHITE);
			goHome.addActionListener(this);

		}

		public void actionPerformed(ActionEvent e){

			if(e.getSource()==save){



			}

			if(e.getSource()==goHome){

				Coordinator.cont.cards.show(Coordinator.cont, "title");

			}

		}

	}

}
