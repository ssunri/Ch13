import java.awt.*; 
import java.awt.event.*;  
import java.util.*; 
import java.util.Timer; 

import javax.swing.*; 
 public class exercise6 extends JFrame 

{ 
   int bubbleRadius = 10;//������ ������ 

   ArrayList<Point> bubblePosition = new  ArrayList<Point>();//������ ������ ����Ʈ 

   public exercise6() 
    { 
      setVisible(true); 
      setSize(500,500); 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      Timer timer = new Timer();//Ÿ�̸� ���� 
      timer.schedule(new TimerTask()//Ÿ�̸Ӹ� 20/1000�ʸ��� ���� 
       {    
    	  @Override 
          public void run() 
         { 
           //����Ʈ�� ����ִ� ������ ������ 
          for(int i=0;i < bubblePosition.size();i++) 
          	{ 

             bubblePosition.get(i).y -= 5;//���� �̵� 
              if(bubblePosition.get(i).y < 0)//���� �� �ö󰬴ٸ� 
              { 
                   bubblePosition.remove(i);//����Ʈ���� ����       
               } 
           }     
            repaint();//ȭ�� ���� 
          } 
       }, 0, 20); 

       //���콺 ������ �߰� 
      addMouseListener(new MouseAdapter() 
       { 
          @Override 
         public void mousePressed(MouseEvent e) 
          { 
        
             bubblePosition.add(e.getPoint());//���콺�� ����� ������ġ�� ����Ʈ�� ���� 
          } 
      }); 
   } 
    @Override 
   public void paint(Graphics g) 
   { 
      //����� ���� 
      Image img = createImage(getWidth(), getHeight()); 
      Graphics bg = img.getGraphics();//����� ������ ���� 
      for(int i=0;i < bubblePosition.size();i++) 

      { 
         //������ ��ġ ������ 
         int x = bubblePosition.get(i).x; 
         int y= bubblePosition.get(i).y; 
         //����㿡 �׸��� 
          bg.drawOval(x-bubbleRadius, y-bubbleRadius, bubbleRadius+bubbleRadius, bubbleRadius+bubbleRadius); 
      } 

       //�� ���۸� ���̰� ��� 
       g.drawImage(img, 0, 0, this); 
    } 
    @Override 
   public void update(Graphics g) 
   { 
       paint(g); 
   } 
    static public void main(String str[]) 
   { 
      new exercise6(); 
    } 
 } 

