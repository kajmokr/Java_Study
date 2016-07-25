package workshop.person.control;
import workshop.person.entity.PersonEntity;

public class PersonManager {
	public static void main(String[] args) {
		PersonManager pManager = new PersonManager();
		PersonManager.printTitle("@@@ �ι� ���� ��ȸ �ý��� @@@ ");
		PersonManager.printTitleLine("====================");
		PersonEntity[ ] persons = new PersonEntity[10];
		PersonManager.fillPersons(persons);
		PersonManager.showPerson(persons);
		PersonManager.findByGender(persons, '��');
		PersonManager.printTitleLine("====================");
		PersonManager.showPerson(persons, "���ϴ�");
	}

	private static void showPerson(PersonEntity[] persons, String string) {
		// TODO Auto-generated method stub
		for (int i = 0; i < persons.length; i++) {
			if (persons[i].getName()=="���ϴ�") {
				System.out.println("�̸�\t"+persons[i].getName()+"\n����\t"+persons[i].getGender()+"\n��ȣ\t"+persons[i].getPhone()+"\n�ּ�\t"+persons[i].getAddress());
			}
		}
	}

	private static int findByGender(PersonEntity[] persons, char c) {
		int count = 0;
		for (int i = 0; i < persons.length; i++) {
			if(persons[i].getGender()=='��'){
				count++;
			}
		}
		System.out.println("���� : '�� '(��)�� "+count+"�� �Դϴ�.");
		return count;
		// TODO Auto-generated method stub
	}

	private static void showPerson(PersonEntity[] persons) {
		// TODO Auto-generated method stub
		for (int i = 0; i < persons.length; i++) {
			System.out.println("�̸�"+"\t"+persons[i].getName()+"\t"+"����"+"\t"+persons[i].getGender()+"\t"+"��ȭ��ȣ"+"\t"+persons[i].getPhone());
			System.out.println("----------------------------------------------------");
		}
	}

	private static void fillPersons(PersonEntity[] persons) {
		// TODO Auto-generated method stub
		persons[0] = new PersonEntity("�̼�ȣ","7212121028102", "��õ ��籸", "032-392-2932"); 
		persons[1] = new PersonEntity("���ϴ�","7302132363217", "���� ������", "02-362-1932"); 
		persons[2] = new PersonEntity("�ڿ���","7503111233201", "���� ���ϱ�", "02-887-1542"); 
		persons[3] = new PersonEntity("���μ�","7312041038988", "���� ������", "032-384-2223"); 
		persons[4] = new PersonEntity("ȫ����","7606221021341", "���� ��õ��", "02-158-7333"); 
		persons[5] = new PersonEntity("�̹̼�","7502142021321", "���� ������", "02-323-1934"); 
		persons[6] = new PersonEntity("�ڼ���","7402061023101", "���� ���α�", "02-308-0932"); 
		persons[7] = new PersonEntity("������","7103282025101", "���� ����", "02-452-0939"); 
		persons[8] = new PersonEntity("Ȳ����","7806231031101", "��õ �߱�", "032-327-2202"); 
		persons[9] = new PersonEntity("��ö��","7601211025101", "��õ ��籸", "032-122-7832");
	}         

	private static void printTitleLine(String string) {
		// TODO Auto-generated method stub
		System.out.println("\n"+string+"\n");
	}

	private static void printTitle(String string) {
		// TODO Auto-generated method stub
		System.out.println("\n"+string+"\n");
	}
}
