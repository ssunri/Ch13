import java.awt.*;
import javax.swing.*;
import java.util.*;

public class exercise4_2 extends JFrame{
	public exercise4_2() {
		setTitle("�����ϴ� ���̺� �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("�������̺�");
		c.add(label);
		
		setSize(300,300);
		setLocation(100,100); //�ʱ���ġ
		setVisible(true);
		
		VibratingThread thread = new VibratingThread(label);
		thread.start(); //������ ����
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
					Thread.sleep(10); //0.01�� ���� ���� �ܴ�
				}
				catch(InterruptedException e){return;}
				
				//���� �����¿� ��ġ�� ���ݾ� �̵�			
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
