
import java.util.Scanner;

class ee implements Runnable{
	
	@Override //run() �������̵�
	public void run() { //������ �ڵ�
		System.out.println("������ ���� ����");		
		for(int i=1; i<=10; i++) //1���� 10����
			System.out.print(i + " ");
		System.out.println(); //�ٹٲ�
		System.out.println("������ ����");
	}
	
}
public class exercise1{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ƹ� Ű�� �Է�>> ");
		scanner.nextLine(); //� Ű�� �ԷµǱ⸦ ��ٸ�
		scanner.close();
		
		Thread th = new Thread(new ee()); //������ ��ü ����
		th.start(); //threadŬ������ start()�޼ҵ带 ȣ���Ͽ� �����带 ���۽�Ŵ
	}
}
