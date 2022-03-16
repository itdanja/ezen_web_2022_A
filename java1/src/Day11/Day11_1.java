package Day11;

public class Day11_1 {
	
	// p.386 Ȯ�ι���
		// 1. 3 [ �������̽��� ��� : 1.����ʵ� 2.�߻�޼ҵ�* 3.����Ʈ�޼ҵ� 4. �����޼ҵ� ] 
		// 2. 4 [  �������̽� ���� = ������ü ]
			// ������ü = Ŭ������ implements �� ��ü 
		 
	private static void printSound( Soundable  soundable) {
//  ���������� ����    ��ȯŸ��   �޼ҵ��  (  �μ�[ ����,�迭,��ü,�������̽� ] )
		System.out.println( soundable.sound() );
		
	}
	
	public static void dbWork( DataAccessObject dao ) {
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
	}
	
	public static void main(String[] args) {
		// 3.
		printSound( new Cat() ); // 2
					// ������ü
		printSound( new Dog() );
		Soundable soundable = new Cat();  // 1
		Soundable[] soundables = new Cat[100]; // 3
		
		// 4. 
			// Dao : DB���ٰ�ü    Dto : �������̵���ü 
		dbWork( new OracleDao() );
		dbWork( new MysqlDao() );
		
		// 5. �͸�ü [ �������̽��� ���� ���� ]
			// ������ü : �������̽� ��ü�� = new Ŭ����();
			// �͸�ü : �������̽� ��ü�� = new �������̽�( ){ ���� }; // 1ȸ��
		Action action = new Action() {
			
			@Override
			public void work() {
				System.out.println("���縦 �մϴ�.");
			}
			
		}; // ������ 
		
		action.work(); // �������̽� ��ü�� �޼ҵ� ���� 
		
	}
}


















