package chap18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		String inputFile = args[0];
		String outputFile = args[1];
		FileCopy job1 = new FileCopy();
		// ���۽ð�
		long start = System.currentTimeMillis();
		
		// Thread ����
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				// job1.nodeStream(inputFile, outputFile); 
				job1.processingStream(inputFile, outputFile);
			}
		});
		thread.start();
		
		// ������ ����ɶ����� �Ͻ����� ���µ�.  join() �����ϸ� ��������� ������ ���������� ���ν����尡 ��ٷ������ʴ´�.
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// job1.nodeStream(inputFile, outputFile); // 120ms
		// job1.processingStream(inputFile, outputFile); // 12ms 1000ms 1��
		// ����ð�
		long end = System.currentTimeMillis();
		System.out.println("File Copy�ϴµ� �ɸ��ð�" + (end - start) + "ms");

		
	}

	public void nodeStream(String inFile, String outFile) {
		FileInputStream input = null;
		FileOutputStream output = null;
		try {
			input = new FileInputStream(inFile);
			output = new FileOutputStream(outFile);
			int data;
			// -1�̸� eof end of file�̴�. ���ϳ����� ���� �������ִ� ����
			while ((data = input.read()) != -1) {
				output.write(data);
			}
			output.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ie) {

		} finally{
			try {
				input.close();
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void processingStream(String inFile, String outFile) {
		BufferedInputStream input = null;
		BufferedOutputStream output = null;
		try {
			// ������ ��彺Ʈ�� �����ߴµ� �ٷ� �־��ش�.
			input = new BufferedInputStream(new FileInputStream(inFile));
			output = new BufferedOutputStream(new FileOutputStream(outFile));
			int data;
			// -1�̸� eof end of file�̴�. ���ϳ����� ���� �������ִ� ����
			while ((data = input.read()) != -1) {
				output.write(data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ie) {

		} finally{
			try {
				input.close();
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
