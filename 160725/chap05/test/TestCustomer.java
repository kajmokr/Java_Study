package chap05.test;

import chap05.Customer;

public class TestCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer cust1 = new Customer();
		cust1.setName("ȫ�浿");
		
		Customer cust2 = new Customer("ȫ�浿");
		
		System.out.println(cust1.equals(cust2));
		// object �� equal(SC)�ּ� ��
		// cust1�� reference Ÿ�� �ʱⰪ�� null�� �ʱ�ȭ �Ǿ�����. �ּҰ��� �Ҵ��ض� cust1��
		// heap�� Customer��� ��ü ����, name null
		
	}
	
}
