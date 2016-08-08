package chap12.sec02.exam01_createthread;

import java.awt.Toolkit;

public class BeepPrintExample4 {
	public static void main(String[] args) {
		
		System.out.println("���� �������� �̸�"+Thread.currentThread().getName());
		Runnable job = new MyThreadJob2();
		Thread worker2 = new Thread(job);
		worker2.setName("������");
		worker2.start();
		
/*		System.out.println("���� �������� �̸� "+Thread.currentThread().getName());
		//thread ���� �� ����
		Toolkit toolkit = Toolkit.getDefaultToolkit();	
		//Thread worker = new MyThread();
		Runnable job = new MyThreadJob();
		Thread worker = new Thread(job);
		worker.setName("��� ������");
		worker.start();*/

		for(int i=0; i<5; i++) {
			System.out.println("��");
			try { Thread.sleep(500); } catch(Exception e) {}
		}
	}
} // BeepPrintExample1�� ����.

class MyThread2 extends Thread{
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

class MyThreadJob2 implements Runnable{
	@Override
	public void run() {
		System.out.println("���� �������� �̸� "+Thread.currentThread().getName());
		Toolkit toolkit = Toolkit.getDefaultToolkit();	
		for(int i=0; i<5; i++) {		
			toolkit.beep();
			try { Thread.sleep(500); } catch(Exception e) {}
		}
	}
} // ������ �ι�° ���

