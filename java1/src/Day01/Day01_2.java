

package Day01;

public class Day01_2 { // c s
	// 1. ��� 
		// 1. print() : ��¸�
		// 2. println() : ����� �ٹٲ� ����
		// 3. printf() : ��¿� �ٹ̱�
			// ���Ĺ���
				// %s : ���ڿ� ���� �ڸ� 
				// %d : ���� ���� �ڸ� 
				// %f : �Ǽ� ���� �ڸ�
	
			// ����� [ \ : �������� ��ȭ��ȣ ]
				// \n : �ٹٲ�
				// \t : �鿩����[5ĭ]
				// \\ : \
				// \" : "
	
	// 1. System : �ý��� Ŭ���� [ ����� ���� ������� �ڵ� ���� ] 
	// 2. out : ��� ��Ʈ��
	// 3. print() : ����Լ� 
	// 4. ;	: ���� �ڵ� ���˸�
	// * �ý���Ŭ������ out �̶�� ��½�Ʈ���� ���� print �Լ��� ����ؼ�
	//    console�� ���ϴ� ��� ����Ҽ� �ִ�.
	public static void main(String[] args) { // m s 
		
		// 1. �⺻��� 
		System.out.print("�ϰ������");	// ; : �ڵ� ���� ����
		System.out.print("java 1����");	// ����ó�� " " ó�� 
		System.out.print(123);			// ���� " " ó�� X
			// * �̸� ������� �ܾ�[ ����� ] �� ������ ��� ���ڴ� " " ó�� 
		// 2. �ڵ��ϼ� ( syso + ctrl+�����̹� )
		System.out.println("�ڹٴ� ��ü�����̴�.");
		System.out.println("jdk8");
		System.out.println(123);
		
		// 3. ������� 
		System.out.printf( "%s" , "�ϰ������");
		System.out.printf( "java %d����" , 1 );
		System.out.printf( "%d" , 123);
		
		// ����1 [ print ] 
		System.out.println("\n\t\t[[�⼮��]]");
		System.out.println("-------------------------------------------");
		System.out.println("�̸�\t1����\t2����\t3����\t���");
		System.out.println("��ȣ��\t�⼮\t�Ἦ\t�⼮");
		System.out.println("���缮\t�⼮\t�Ἦ\t�⼮");
		System.out.println("-------------------------------------------");
		
		// ����2 [ ����1 -> printf ] 
		System.out.printf("\n\t\t%s" , "[[�⼮��]]\n" );
		System.out.printf("--------------------------------------------\n");
		System.out.printf("%s\t%s\t%s\t%s\t%s \n" ,"�̸�","1����","2����","3����","���");
		System.out.printf("%s\t%s\t%s\t%s\t%s \n" ,"��ȣ��","�⼮","�Ἦ","�⼮"," ");
		System.out.printf("%s\t%s\t%s\t%s\t%s \n" ,"���缮","�⼮","�Ἦ","�⼮"," ");
		System.out.printf("--------------------------------------------\n");
		
		// ����1 : �����
		System.out.println("\\    /\\");
		System.out.println(" )  ( ')");
		System.out.println("(  /  )");
		System.out.println(" \\(__)|"); // | : shift + \

		 // ����2 : ������ 
		System.out.println("|\\_/|");		// \ ��½� -> \\
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");// " ��½� -> \"
		System.out.println("|\"^\"`");
		System.out.println("||_/=\\\\__|");
		
		
		/*		\    /\
				 )  ( ')
				(  /  )
				 \(__)|
		*/ 

		/*
				|\_/|
				|q p|   /}
				( 0 )"""\
				|"^"`    |
				||_/=\\__|
		*/	
		
		
	} // m e 


} // c e 










