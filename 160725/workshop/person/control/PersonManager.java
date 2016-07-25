package workshop.person.control;

import workshop.person.entity.PersonEntity;

public class PersonManager {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
	   PersonManager pManger=new PersonManager();
      pManger.printTitle("@@@ �ι� ���� ��ȸ �ý��� @@@");
      pManger.printTitleLine();
      PersonEntity[ ] persons = new PersonEntity[10];
      pManger.fillPersons(persons);
      pManger.showPerson(persons);
      pManger.findByGender(persons, '��');
      pManger.showPerson(persons, "������");
      pManger.printTitleLine();
   }
   public void printTitle(String Title){
      System.out.println("\t"+Title+"\t");
   }
   public void fillPersons(PersonEntity[] persons){
      persons[0]=new PersonEntity("�̼�ȣ","7212121028102", "��õ ��籸", "032-392-2932");
      persons[1]=new PersonEntity("���ϴ�","7302132363217", "���� ������", "02-362-1932");
      persons[2]=new PersonEntity("�ڿ���","7503111233201", "���� ���ϱ�", "02-887-1542");
      persons[3]=new PersonEntity("���μ�","7312041038988", "���� ������", "032-384-2223");
      persons[4]=new PersonEntity("ȫ����","7606221021341", "���� ��õ��", "02-158-7333");
      persons[5]=new PersonEntity("�̹̼�","7502142021321", "���� ������", "02-323-1934");
      persons[6]=new PersonEntity("�ڼ���","7402061023101", "���� ���α�", "02-308-0932");
      persons[7]=new PersonEntity("������","7103282025101", "���� ����", "02-452-0939");
      persons[8]=new PersonEntity("Ȳ����","7806231031101", "��õ �߱�", "032-327-2202");
      persons[9]=new PersonEntity("��ö��","7601211025101", "��õ ��籸", "032-122-7832");
   }
   public void showPerson(PersonEntity[] persons){
      for (PersonEntity temp : persons) {
         System.out.println("[�̸�]"+temp.getName()+"\t[����]"+temp.getGender()+"\t[��ȭ��ȣ]"+temp.getPhone());
         printItemLine();
      }
   }
   public int findByGender(PersonEntity[] persons,char gender){
      int count=0;
      for (PersonEntity temp : persons) {
         if(temp.getGender()==gender){
            count++;
         }
      }
      System.out.println("���� : '"+gender+"' (��)�� "+count+"���Դϴ�.");
	return count;
   }
   public void showPerson(PersonEntity[] persons,String name){
      for (PersonEntity temp : persons) {
         if(temp.getName()==name){
            System.out.println("[�̸�]"+temp.getName()+"\n[����]"+temp.getGender()+"\n[��ȭ��ȣ]"+temp.getPhone()+"\n[�ּ�]"+temp.getAddress());
            break;
         }
         
         
      }
   }
   public void printTitleLine(){
      for (int i = 0; i <60; i++) {
         System.out.print("=");
      }
      System.out.println();
   }
   public void printItemLine(){
      for (int i = 0; i <60; i++) {
         System.out.print("-");
      }
      System.out.println();
   }
}