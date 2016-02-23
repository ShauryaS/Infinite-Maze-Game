package PersonalProjects.Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Maze extends JPanel{

	MazeActual m;
	private Buttons b;

	private int moves = 0;

	private int level = 1;
	private int skipped = 0;

	private int blasts = level*2;
	private int oBlasts = blasts;

	public Maze(){

		setLayout(new BorderLayout());
		b = new Buttons();
		add(b, BorderLayout.SOUTH);
		m = new MazeActual();
		add(m, BorderLayout.CENTER);

	}

	class MazeActual extends JPanel{

		Grid grid;
		Ball ball; 
		Bricks bricks;
		SAE sae;
		
		Color backgroundColor;

		private int mx, my, mw, mh, gridSize, numOfBricks, orgBricks;

		public MazeActual(){

			mx = 50;
			my = 50;
			mw = 700;
			mh = 700;

			gridSize = 7;
			numOfBricks = 20;
			orgBricks = numOfBricks;

			grid = new Grid();
			ball = new Ball(mx, my, mw/gridSize, mh/gridSize, mw/gridSize, mh/gridSize);
			bricks = new Bricks();
			sae = new SAE();
			
			backgroundColor = Color.BLACK;
			
		}

		public void paintComponent(Graphics g){

			requestFocus();

			setBackground(backgroundColor);
			super.paintComponent(g);

			grid.draw(g);
			bricks.draw(g);
			sae.draw(g);
			ball.draw(g);
			
			g.setFont(new Font("Utopia",Font.PLAIN, 25));	
			g.setColor(Color.WHITE);
			g.drawString("Level: "+level, 25, 25);
			g.drawString("Moves: "+moves, 225, 25);
			g.drawString("Skipped: "+skipped, 425, 25);
			g.drawString("Blasts: "+blasts, 625, 25);
			g.drawString("Grid: " + gridSize + "x" + gridSize, 350, 780);

		}

		class Grid{
			
			Color gridColor;
			
			public Grid(){
				
				gridColor = new Color(0, 100, 0);
				
			}
			
			public void draw(Graphics g){

				g.setColor(gridColor);

				for(int i = mx; i<=mx+mw; i+=mw/gridSize){

					for(int j = my; j<=my+mh; j+=mh/gridSize){

						g.drawLine(i, j, i, my+mh);
						g.drawLine(i, j, mx+mw, j);

					}

				}

			}

		}

		class Ball implements KeyListener{

			private int x, y;
			private int w, h;
			private int dx, dy;
			private boolean up, down, right, left;
			private boolean blastEffect;
			Color ballColor;

			public Ball(int _x, int _y, int _w, int _h, int _dx, int _dy){

				x = _x;
				y = _y;
				w = _w;
				h = _h;
				dx = _dx;
				dy = _dy;

				up = false;
				down = false;
				right = false;
				left = false;

				blastEffect = false;
				
				ballColor = Color.CYAN;

				addKeyListener(this);

			}

			public void draw(Graphics g){

				g.setColor(ballColor);
				g.fillOval(x+1, y+1, w-2, h-2);

			}

			public void check(){
				
				if(x<mx){

					x = mx;
					moves--;

				}

				if(x>(mx+mw)-w){

					x = (mx+mw) - w;
					moves--;

				}

				if(y<my){

					y = my;
					moves--;

				}

				if(y>(my+mh)-h){

					y = (my+mh) - h;
					moves--;

				}

				if(y==(my+mh)-h && x==(mx+mw)-w){

					level++;
					b.reset();
					m.repaint();

				}

				for(int i = numOfBricks-1; i>=0; i--){

					if(x>bricks.xvals.get(i)-bricks.wvals.get(i) && x<bricks.xvals.get(i)+bricks.wvals.get(i) && y>bricks.yvals.get(i)-bricks.hvals.get(i) && y<bricks.yvals.get(i)+bricks.hvals.get(i)){

						if(up){

							y = bricks.yvals.get(i)+bricks.hvals.get(i);
							moves--;

							if(blastEffect){

								bricks.xvals.remove(i);
								bricks.yvals.remove(i);
								bricks.wvals.remove(i);
								bricks.hvals.remove(i);
								numOfBricks--;
								blasts--;
								blastEffect = false;

							}

						}

						if(down){

							y = bricks.yvals.get(i)-bricks.hvals.get(i);
							moves--;

							if(blastEffect){

								bricks.xvals.remove(i);
								bricks.yvals.remove(i);
								bricks.wvals.remove(i);
								bricks.hvals.remove(i);
								numOfBricks--;
								blasts--;
								blastEffect = false;

							}

						}

						if(right){

							x = bricks.xvals.get(i)-bricks.wvals.get(i);
							moves--;

							if(blastEffect){

								bricks.xvals.remove(i);
								bricks.yvals.remove(i);
								bricks.wvals.remove(i);
								bricks.hvals.remove(i);
								numOfBricks--;
								blasts--;
								blastEffect = false;

							}

						}

						if(left){

							x = bricks.xvals.get(i)+bricks.wvals.get(i);
							moves--;

							if(blastEffect){

								bricks.xvals.remove(i);
								bricks.yvals.remove(i);
								bricks.wvals.remove(i);
								bricks.hvals.remove(i);
								numOfBricks--;
								blasts--;
								blastEffect = false;

							}

						}

					}

				}

			}

			public void keyPressed(KeyEvent e){

				if(e.getKeyCode()==KeyEvent.VK_RIGHT){

					x += dx;
					right = true;
					left = false;
					up = false;
					down = false;
					moves++;
					check();
					m.repaint();

				}

				if(e.getKeyCode()==KeyEvent.VK_LEFT){

					x -= dx;
					right = false;
					left = true;
					up = false;
					down = false;
					moves++;
					check();
					m.repaint();

				}

				if(e.getKeyCode()==KeyEvent.VK_UP){

					y -= dy;
					right = false;
					left = false;
					up = true;
					down = false;
					moves++;
					check();
					m.repaint();

				}

				if(e.getKeyCode()==KeyEvent.VK_DOWN){

					y += dy;
					right = false;
					left = false;
					up = false;
					down = true;
					moves++;
					check();
					m.repaint();

				}

				if(e.getKeyCode()==KeyEvent.VK_SPACE){

					if(blasts != 0){

						blastEffect = true;
						check();
						m.repaint();

					}

				}

			}

			public void keyTyped(KeyEvent e){}

			public void keyReleased(KeyEvent e){}

		}

		class Bricks{

			private ArrayList <Integer> xvals = new ArrayList();
			private ArrayList <Integer> yvals = new ArrayList();
			private ArrayList <Integer> wvals = new ArrayList();
			private ArrayList <Integer> hvals = new ArrayList();
			Color bricksColor;

			public Bricks(){

				for(int i = 0; i<numOfBricks; i++){

					xvals.add(((int)(Math.random()*gridSize))*(mw/gridSize)+mx);
					yvals.add(((int)(Math.random()*gridSize))*(mh/gridSize)+my);
					wvals.add(mw/gridSize);
					hvals.add(mh/gridSize);
					
				}
				
				bricksColor = Color.DARK_GRAY;

			}

			public void draw(Graphics g){

				g.setColor(bricksColor);

				for(int i = 0; i<numOfBricks; i++){

					g.fillRect(xvals.get(i)+1, yvals.get(i)+1, wvals.get(i)-2, hvals.get(i)-2);

				}

			}

		}

		class SAE{
			
			Color startColor;
			Color endColor;
			
			public SAE(){
				
				startColor = Color.GREEN;
				endColor = Color.RED;
				
			}

			public void draw(Graphics g){

				g.setColor(startColor);
				g.fillRect(mx+1, my+1, mw/gridSize-2, mh/gridSize-2);
				g.setColor(endColor);
				g.fillRect((mx+mw)-(mw/gridSize)+1, (my+mh)-(mh/gridSize)+1, mw/gridSize-2, mh/gridSize-2);

			}

		}

	}

	class Buttons extends JPanel implements ActionListener{

		private JButton reset;
		private JButton goHome;

		public Buttons(){

			setLayout(new GridLayout(1, 2));

			reset = new JButton("Reset");
			reset.setBackground(Color.MAGENTA);
			reset.setForeground(Color.WHITE);
			add(reset);
			reset.addActionListener(this);

			goHome = new JButton("Go Home");
			goHome.setBackground(Color.ORANGE);
			goHome.setForeground(Color.WHITE);
			add(goHome);
			goHome.addActionListener(this);

		}

		public void reset(){

			moves = 0;

			if(level%5==0){

				do{
					m.gridSize += 1;
				}while(m.mw%m.gridSize!=0);

				m.numOfBricks = m.gridSize*m.gridSize/2-10;
				m.orgBricks = m.numOfBricks;

			}
			

			m.numOfBricks = m.orgBricks;
			
			m.bricks.xvals.clear();
			m.bricks.yvals.clear();
			m.bricks.wvals.clear();
			m.bricks.hvals.clear();

			for(int i = 0; i<m.numOfBricks; i++){

				m.bricks.xvals.add(((int)(Math.random()*m.gridSize))*(m.mw/m.gridSize)+m.mx);
				m.bricks.yvals.add(((int)(Math.random()*m.gridSize))*(m.mh/m.gridSize)+m.my);

				if(m.bricks.xvals.get(i) == (m.mx+m.mw) - (m.mw/m.gridSize) && m.bricks.yvals.get(i) == (m.my+m.mh) - (m.mh/m.gridSize)){

					m.bricks.xvals.add(i, m.bricks.xvals.get(i) - m.mw/m.gridSize);
					m.bricks.yvals.add(i, m.bricks.yvals.get(i) - m.mh/m.gridSize);

				}

				if(m.bricks.xvals.get(i) == m.mx && m.bricks.yvals.get(i) == m.my){

					m.bricks.xvals.add(i, m.bricks.xvals.get(i) + m.mw/m.gridSize);
					m.bricks.yvals.add(i, m.bricks.yvals.get(i) + m.mh/m.gridSize);

				}

				m.bricks.wvals.add(m.mw/m.gridSize);
				m.bricks.hvals.add(m.mh/m.gridSize);

			}

			m.ball.x = m.mx;
			m.ball.y = m.my;

			m.ball.w = m.mw/m.gridSize;
			m.ball.h = m.mh/m.gridSize;

			m.ball.dx = m.mw/m.gridSize;
			m.ball.dy = m.mh/m.gridSize;
			
			blasts = (int)(level*1.5);
			
			m.repaint();

		}

		public void resetAll(){

			moves = 0;

			blasts = oBlasts;
			level = 1;
			
			m.gridSize = 7;
			m.numOfBricks = 20;
			m.orgBricks = m.numOfBricks;
			
			m.bricks.xvals.clear();
			m.bricks.yvals.clear();
			m.bricks.wvals.clear();
			m.bricks.hvals.clear();


			for(int i = 0; i<m.numOfBricks; i++){

				m.bricks.xvals.add(((int)(Math.random()*m.gridSize))*(m.mw/m.gridSize)+m.mx);
				m.bricks.yvals.add(((int)(Math.random()*m.gridSize))*(m.mh/m.gridSize)+m.my);

				if(m.bricks.xvals.get(i) == (m.mx+m.mw) - (m.mw/m.gridSize) && m.bricks.yvals.get(i) == (m.my+m.mh) - (m.mh/m.gridSize)){

					m.bricks.xvals.add(i, m.bricks.xvals.get(i) - m.mw/m.gridSize);
					m.bricks.yvals.add(i, m.bricks.yvals.get(i) - m.mh/m.gridSize);

				}

				if(m.bricks.xvals.get(i) == m.mx && m.bricks.yvals.get(i) == m.my){

					m.bricks.xvals.add(i, m.bricks.xvals.get(i) + m.mw/m.gridSize);
					m.bricks.yvals.add(i, m.bricks.yvals.get(i) + m.mh/m.gridSize);

				}

				m.bricks.wvals.add(m.mw/m.gridSize);
				m.bricks.hvals.add(m.mh/m.gridSize);

			}


			m.ball.x = m.mx;
			m.ball.y = m.my;

			m.ball.w = m.mw/m.gridSize;
			m.ball.h = m.mh/m.gridSize;

			m.ball.dx = m.mw/m.gridSize;
			m.ball.dy = m.mh/m.gridSize;

			m.repaint();

		}

		public void actionPerformed(ActionEvent e){

			if(level!=1){
				
				if(e.getSource()==reset){

					resetAll();

				}
				
			}
			
			if(e.getSource()==goHome){

				Coordinator.cont.cards.show(Coordinator.cont, "title");
				resetAll();

			}

		}

	}

}
