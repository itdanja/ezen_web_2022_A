package Day07;

public class Calculator2 {
	//1.�ʵ�
	//2.������
	//3.�޼ҵ�
		// 1. ����޼ҵ�
	void execute() { // �μ�x��ȯx
		double result = avg( 7 , 10); // ���ο��� �޼ҵ�ȣ��
		println("������ : " + result );
	}
		// 2. ��ո޼ҵ�
	double avg( int x , int y ) { // �μ�o��ȯo
		double sum = plus( x , y);
		double result = sum / 2 ; return result;
	}
		// 3. ���ϱ�޼ҵ�
	int plus( int x , int y ) { // �μ�o��ȯo
		int result = x+y; return result;
	}
		// 4. �����¸޼ҵ� 
	void println( String message ) { //�μ�o��ȯx
		System.out.println( message );
	}
}
