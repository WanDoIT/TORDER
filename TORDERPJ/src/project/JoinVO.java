package project;


public class JoinVO {
	
	//특별한 알고리즘을 가진 클래스가 아니라, 조회한 데이터를 저장할 클래스
	//변수는 은닉하고, 테이블이 가지고 있는 멤버 변수를 그대로 사용합니다.
	private String name;
	private String phonenumber;
	
	//생성자 - 기본 생성자, 모든 멤버 변수를 저장하는 생성자
	public JoinVO() {}  //ctrl+space+enter

	public JoinVO(String name, String phonenumber) {
		super();
		this.name = name;
		this.phonenumber = phonenumber;
	}
	

	//toString 
	@Override
	public String toString() {
		return "전체 고객 내역 [이름=" + name + ", 핸드폰 번호=" + phonenumber + "]";
	}

	//getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}



	

	
	
}
