package chap05.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import chap05.Customer;

public class TestCustomerJunit {
	// �׽�Ʈ �޼���� ����Ƿ��� @test�� �ݵ�� �޼��� ����� ������ �����������.
	@Test @Ignore
	// @Ignore�� �������� �ʰڴ�.
	public void custEquals(){
		Customer cust1 = new Customer("�Ѹ�");
		Customer cust2 = new Customer("�Ѹ�");
		
		System.out.println(cust1 == cust2); // �ּ� ��
		System.out.println(cust1.equals(cust2)); // �� ��
		

		assertNotSame(cust1, cust2);
//		assertSame(cust1, cust2); // ���۷����� false�� ���ͼ�  �׽�Ʈ ����
//		// ������ �ֿܼ� �� ����� jUnit�� ���������ش�.
//		
		assertEquals(cust1, cust2);
	}
	
	@Test
	public void strEquals(){
		String str1 = new String("hello");
		String str2 = new String("hello");
		
		assertEquals(str1, str2);
		
		assertNotNull(str1);
		assertNotSame(str1, str2);
	}
}
