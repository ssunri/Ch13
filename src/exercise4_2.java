import java.awt.*;
import javax.swing.*;
import java.util.*;

public class exercise4_2 extends JFrame{
	public exercise4_2() {
		setTitle("진동하는 레이블 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("진동레이블");
		c.add(label);
		
		setSize(300,300);
		setLocation(100,100); //초기위치
		setVisible(true);
		
		VibratingThread thread = new VibratingThread(label);
		thread.start(); //스레드 시작
	}
	class VibratingThread extends Thread implements Runnable{
		JLabel la;
		public VibratingThread(JLabel la) {
			this.la = la;
		}
		public void run() {
			Random r = new Random();
			int y = la.getY();
			int x = la.getX();		
			while(true) {
				try {
					Thread.sleep(10); //0.01초 동안 잠을 잔다
				}
				catch(InterruptedException e){return;}
				
				//라벨의 상하좌우 위치를 조금씩 이동			
				int sign = 1;
				if(r.nextBoolean()) sign = 1;
				else sign = -1;
				int tmpX = x + r.nextInt(5)*sign;

				if(r.nextBoolean()) sign = 1;
				else sign = -1;
				int tmpY = y + r.nextInt(5)*sign;			
				la.setLocation(tmpX, tmpY);
			}
		}
	}
	public static void main(String [] args) {
		new exercise4_2();
	}
} 
