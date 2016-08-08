package chap12.sec02.exam01_createthread;

import java.awt.Toolkit;

public class BeepPrintExampleAnonymousNested {
	public static void main(String[] args) {
		System.out.println("���� �������� �̸� "+Thread.currentThread().getName());
		
		//thread ����
		Thread worker = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("���� �������� �̸� "+Thread.currentThread().getName());
				Toolkit toolkit = Toolkit.getDefaultToolkit();	
				for(int i=0; i<5; i++) {		
					toolkit.beep();
					try { Thread.sleep(500); } catch(Exception e) {}
				}
			}
		});
		worker.start();
		

		
		for(int i=0; i<5; i++) {
			System.out.println("��");
			try { Thread.sleep(500); } catch(Exception e) {}
		}
	}// main
	
/*	// static inner class
	static class MyThread extends Thread{
		@Override
		public void run(){
			System.out.println("���� �������� �̸� "+Thread.currentThread().getName());
			Toolkit toolkit = Toolkit.getDefaultToolkit();	
			for(int i=0; i<5; i++) {		
				toolkit.beep();
				try { Thread.sleep(500); } catch(Exception e) {}
			}
		}
	}// MyThread ������ ù��° ���
	
	// Instance Inner class
	class MyThreadJob implements Runnable{
		@Override
		public void run() {
			System.out.println("���� �������� �̸� "+Thread.currentThread().getName());
			Toolkit toolkit = Toolkit.getDefaultToolkit();	
			for(int i=0; i<5; i++) {		
				toolkit.beep();
				try { Thread.sleep(500); } catch(Exception e) {}
			}
		}
	} //MyThreadJob ������ �ι�° ���
*/	
} // BeepPrintExample1�� ����.

// inner class ���·� �غ���. main�ȿ� ����. nestedclass ���·� ����ϱ� ������ Ŭ���� ���𰡴�. 



