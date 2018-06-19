package serviceImpl;
import domain.*;
import service.MemberService;
public class MemberServiceImpl implements MemberService {
	MemberBean[] list;
	int count;
	public MemberServiceImpl() {
		list = new MemberBean[10];
		count=0;
	}
	@Override
	public void createJoin(UserBean member) {
		member.setCreditRating("7등급");
		addList(member);
	}
	@Override
	public void addList(MemberBean member) {
		list[count++]=member;
	}
	@Override
	public MemberBean[] list() {
		return list;
	}
	@Override
	public int showCount() {
		return count;
	}
	@Override
	public void createAdd(StaffBean member) {
		member.setAccessNum(createAccessNum());
		addList(member);
	}
	@Override
	public String createAccessNum() {
		return String.valueOf(((int)(Math.random()*9999)+1));
	}
	@Override
	public MemberBean findById(MemberBean member) {
		MemberBean result=new MemberBean();
		String id=member.getUid();
		String pass=member.getPass();
		for(int i=0;i<count;i++) {
			if(id.equals(list[i].getUid())&&pass.equals(list[i].getPass())){
				result = list[i];
			}
		}
		return result;
	}
	@Override
	public MemberBean[] findByName(String name) {
		int temp=0;
		MemberBean[] result=new MemberBean[sameNameCount(name)];
		for(int i=0;i<count;i++) {
			if(name.equals(list[i].getName())) {
				result[temp++]=list[i];
			}
		}
		return result;
	}
	@Override
	public int sameNameCount(String name) {
		int temp=0;
		for(int i=0;i<count;i++) {
			if(name.equals(list[i].getName())) {
				temp++;
			}
		}
		return temp;
	}
	@Override
	public String changePass(MemberBean member) {
		String result="";
		String id = member.getUid();
		String pass =member.getPass().split("/")[0];
		String newPass = member.getPass().split("/")[1];
		member.setPass(pass);
		member=findById(member);
		if(member.getUid()==null) {
			result="아이디가 없거나 비밀번호가 틀립니다.";
		} else {
			if(member.getUid().equals(id)&&member.getPass().equals(pass)) {
				member.setPass(newPass);
				result="변경성공";
			} else {
				result="변경 실패";
			}
		}
		return result;
		
	}
	@Override
	public String withdrawal(MemberBean member) {
		String result="";
		String id = member.getUid();
		String pass =member.getPass().split("/")[0];
		String samePass = member.getPass().split("/")[1];
		for(int i=0;i<count;i++) {
			if(id.equals(list[i].getUid())&&pass.equals(list[i].getPass())&&samePass.equals(list[i].getPass())) {
				list[i]=list[--count];
				list[count]=null;
				result="삭제성공";
				break;
			} else {
				result="삭제 실패";
			}
		}
		return result;
	}

}
