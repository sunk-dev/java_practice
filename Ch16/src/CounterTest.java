import javax.swing.*;
import javax.xml.stream.util.EventReaderDelegate;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterTest extends JFrame implements ActionListener{
	public JLabel j1= new JLabel();//개수증가보일 레이블
	public int num=0; //개수 바뀌어야하므로
	JButton b1=new JButton();//버튼 보일 화면
	Thread t=new Thread();
	public CounterTest(){//public 설정을 해줘여 밖에서 멤버변수 접근 가능!
		
		JPanel p1=new JPanel();//전체화면
		JPanel p2=new JPanel();//개수증가화면
		JPanel p3=new JPanel(); //증가버튼 화면
		int num=0; //개수 바뀌어야하므로
		p1.setLayout(new BorderLayout());
		j1.setText("개수=0");
		b1.setText("시작");
		b1.addActionListener(this);
		p2.add(j1);p3.add(b1);
		
		t=null;
		p1.add("Center",p2);p1.add("South",p3);
		this.setSize(500,150);
		this.add(p1);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CounterTest();

	}



	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd=e.getActionCommand();
		System.out.println(e.getActionCommand());
		if(t==null||t.isAlive()==false) {
			b1.setText("중지");
		
			new Thread(()->{
				while(true) {
					num+=1;
					j1.setText("개수="+num);
					
					
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			
		}).start();
		}
		else {
			 
		}
		
	
		
		
	




}
}
