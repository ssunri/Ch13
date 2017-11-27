import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class exercise2 extends JFrame {
	public exercise2(){
		super("원을 0.5초 간격으로..");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		MyPanel p = new MyPanel();
		setContentPane(p);
		
		setSize(500,500);
		setVisible(true);	
	}	
	class MyPanel extends JPanel{
		public void Mypanel() {
			setLayout(null); //컨텐트팬에 배치관리자 삭제
			addMouseListener(new MouseAdapter() { //Mouse 이벤트 리스너 달기
				public void mousePressed(MouseEvent e) {
					MoveThread moveThread = new MoveThread();
					moveThread.start();
				}
			});
		}	
		public void paintComponent(Graphics g) {	
			Random r = new Random();	
			int x = r.nextInt(getWidth()-50);
			int y = r.nextInt(getHeight()-50);
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.clearRect(0, 0, getWidth(), getHeight()); 
			g.drawOval(x, y, 50, 50); // (x,y)에서 50*50 크기의 내접하는 타원을 그린다
		}	
	}
	
	class MoveThread extends Thread{
		public void run() {
			try {
				while(true) {
					repaint();
					sleep(400);} //0.4초 동안 잠을 잔다	
			}catch(InterruptedException e) {return;}
		}	
	}
	public static void main(String[] args) {
		new exercise2();
	}
}
