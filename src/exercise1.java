
import java.util.Scanner;

class ee implements Runnable{
	
	@Override //run() 오버라이딩
	public void run() { //스레드 코드
		System.out.println("스레드 실행 시작");		
		for(int i=1; i<=10; i++) //1부터 10까지
			System.out.print(i + " ");
		System.out.println(); //줄바꿈
		System.out.println("스레드 종료");
	}
	
}
public class exercise1{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("아무 키나 입력>> ");
		scanner.nextLine(); //어떤 키라도 입력되기를 기다림
		scanner.close();
		
		Thread th = new Thread(new ee()); //스레드 객체 생성
		th.start(); //thread클래스의 start()메소드를 호출하여 스레드를 동작시킴
	}
}
