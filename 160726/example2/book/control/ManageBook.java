package example2.book.control;

import example2.book.entity.*;
public class ManageBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Publication[] books = new Publication[5];
		books[0] = new Magazine( "����ũ�μ���Ʈ", "2007-10-01", 328 , 9900, "�ſ�" );
		books[1] = new Magazine( "�濵�� ��ǻ��", "2007-10-03", 316, 9000, "�ſ�" );
		books[2] = new Novel( "���ǿ�", "2007-07-01", 396, 9800, "�������� ��������", "������ ����Ҽ�" );
		books[3] = new Novel( "���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�" );
		books[4] = new ReferenceBook( "�ǿ����� ���α׷���", "2006-01-20", 496, 25000, "����Ʈ���� ����" );
		
		for (Publication publication : books) { // Ÿ�� ���� : �迭
			System.out.println(publication.toString());
		}
		System.out.println(books[2].getTitle()+""+books[2].getPrice());
		modifyPrice(books[2]);
		System.out.println(books[2].getTitle()+""+books[2].getPrice());

	}

	private static void modifyPrice(Publication papa) {
		// TODO Auto-generated method stub
		if(papa instanceof Magazine){
			papa.setPrice((int)(papa.getPrice()*0.6));
		}
		else if(papa instanceof Novel){
			papa.setPrice((int)(papa.getPrice()*0.8));
		}
		else if(papa instanceof ReferenceBook){
			papa.setPrice((int)(papa.getPrice()*0.9));
		}
	}

}
