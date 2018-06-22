package serviceImpl;
import domain.*;
import repository.MemberDAO;
import repositoryImpl.MemberDAOImpl;
import service.*;
public class MemberServiceImpl implements MemberService {
	private static MemberService instance=new MemberServiceImpl();
	public static MemberService getInstance() {	return instance;}
	private MemberServiceImpl() {}

	@Override
	public void createUser(UserBean member) {
		member.setCreditRating("7등급");
		System.out.println("========== 멤버 서비스==========");
		System.out.println("컨트롤러에서 넘어온 객체:"+member);
		MemberDAOImpl.getInstatnce().insertMember(member);
		
	}

	@Override
	public String login(UserBean member) {
		String msg="";
			/*for(MemberBean e : list){
				if(member.getUid().equals(e.getUid())&&
					member.getPass().equals(e.getPass())){
					//
					msg="로그인에 성공하였습니다.";
				} else {
					msg="로그인에 실패하였습니다.";
				}
			}*/
		return msg;
	}
	
	@Override
	public void updatePassword(MemberBean member) {
		String id = member.getUid();
		String oldPass =member.getPass().split("/")[0];
		String newPass =member.getPass().split("/")[1];
		
	}

	@Override
	public void deleteMember(MemberBean member) {
		/*list.remove(list.indexOf());*/
	}
}
