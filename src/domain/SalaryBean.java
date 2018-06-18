package domain;

public class SalaryBean {
	public static final String DEPT= "인턴쉽";
	protected String dept, name;
	protected int sal;
	public void setpDept(String dept) {
		this.dept=dept;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setSal(int sal) {
		this.sal=sal;
	}
	public String getDept() {
		return dept;
	}
	public String getName() {
		return name;
	}
	public int getSal() {
		return sal;
	}
	public String toString() {
		return String.format("부서 : %s 이름 : %s 본봉 : %d만원 지급",dept,name,sal);
	}
}
