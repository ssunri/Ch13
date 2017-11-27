import java.awt.*;
import javax.swing.*;
import java.util.*;

public class exercise4 extends JFrame{
	public exercise4() {
		setTitle("�����ϴ� ������ �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setSize(300,300);
		setLocation(100,100); //�ʱ���ġ
		setVisible(true);	
		VibratingThread thread = new VibratingThread(this);
		thread.start(); //������ ����
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
					Thread.sleep(10); //0.01�� ���� ���� �ܴ�
				}
				catch(InterruptedException e){return;}
				
				//�������� �����¿� ��ġ�� ���ݾ� �̵�			
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

