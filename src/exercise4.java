import java.awt.*;
import javax.swing.*;
import java.util.*;

public class exercise4 extends JFrame{
	public exercise4() {
		setTitle("진동하는 프레임 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setSize(300,300);
		setLocation(100,100); //초기위치
		setVisible(true);	
		VibratingThread thread = new VibratingThread(this);
		thread.start(); //스레드 시작
	}
	class VibratingThread extends Thread {
		Component comp;
		public VibratingThread(Component comp) {
			this.comp = comp;
		}
		public void run() {
			Random r = new Random();
			int y = comp.getY();
			int x = comp.getX();		
			while(true) {
				try {
					Thread.sleep(10); //0.01초 동안 잠을 잔다
				}
				catch(InterruptedException e){return;}
				
				//프레임의 상하좌우 위치를 조금씩 이동			
				int sign = 1;
				if(r.nextBoolean()) sign = 1;
				else sign = -1;
				int tmpX = x + r.nextInt(5)*sign;

				if(r.nextBoolean()) sign = 1;
				else sign = -1;
				int tmpY = y + r.nextInt(5)*sign;			
				comp.setLocation(tmpX, tmpY);
			}
		}
	}
	public static void main(String [] args) {
		new exercise4();
	}
} 

