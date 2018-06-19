package service;

import domain.*;

public interface MemberService {
	public void createJoin(UserBean member);
	public void createAdd(StaffBean member);
	public void addList(MemberBean member);
	public int showCount();
	public MemberBean[] list();
	public String createAccessNum();
	public MemberBean findById(MemberBean member);
	public MemberBean[] findByName(String name);
	public int sameNameCount(String name);
	public String changePass(MemberBean member);
	public String withdrawal(MemberBean member);
}
/*JOIN,ADD, //join 일반회원, add 직원추가
COUNT, LIST,FIND_BY_ID,FIND_BY_NAME,
UPDATE,
WITHDRAWAL*/
