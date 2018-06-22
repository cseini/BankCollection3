package service;
import domain.*;
public interface MemberService {
	public void createUser(UserBean user);
	public String login(UserBean user);
	public void updatePassword(MemberBean member);
	public void deleteMember(MemberBean member);
}
