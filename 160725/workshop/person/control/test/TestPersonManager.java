package workshop.person.control.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;


import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import workshop.person.control.PersonManager;
import workshop.person.entity.PersonEntity;

public class TestPersonManager {
	PersonManager mgr;
	PersonEntity[] persons;
	
	// Before ������̼��� ���̸� �׽�Ʈ �޼��� �ҷ��������� ���� �� �ʱ�ȭ ��.
	@Before
	public void init() {
		System.out.println("init ȣ��");
		mgr = new PersonManager();
		persons = new PersonEntity[10];
		mgr.fillPersons(persons);
	}

	@Test
	public void fillPerson() {
		System.out.println("fillPerson ȣ��");
		assertEquals("�̼�ȣ", persons[0].getName()); // ù��° ���
		assertEquals("��ö��", persons[9].getName()); // ������ ���
	}

	@Test
	public void findByGender() {
		System.out.println("find ȣ��");
		int count = mgr.findByGender(persons, '��');
		assertThat(count,CoreMatchers.is(7));
	}

}
