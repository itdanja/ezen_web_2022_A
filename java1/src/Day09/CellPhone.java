package Day09;

public class CellPhone { // Ŭ���� ���� 
	//1. �ʵ�
	String model;
	String color;
	//2. ������
	//3. �޼ҵ� [ void : ��ȯŸ�Ծ���( return �������� ) ]
	void powerOn() {System.out.println("������ �մϴ�.");}
// ��ȯx �޼ҵ��(�μ�x){ �����ڵ� } // �μ�x��ȯx
	void powerOff() {System.out.println("������ ���ϴ�.");}
	void bell() {System.out.println("���� �︳�ϴ�.");}
	void sendVoice(String message) {System.out.println("�ڱ� : "+message);}
// ��ȯx �޼ҵ��( �μ�o ) { } // �μ�o ��ȯx
	void receiveVoice(String message) {System.out.println("���� : "+message);}
	void hangUp() {System.out.println("��ȭ�� �����ϴ�.");}
}
