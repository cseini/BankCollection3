package domain;

public class MinusAccountBean extends AccountBean{
	public final static String ACCOUNT_TYPE = "마이너스통장";
	public int limit;
	public void setAccountType() {
		this.accountType=ACCOUNT_TYPE;
	}
	public void setLimit(int limit) {
		this.limit=limit;
	}
	public String getAccoutType() {
		return accountType;
	}
	public int getLimit() {
		return limit;
	}
	public String toString() {
		return String.format("%s \n%s \n계좌번호 %s \n이름 : %s \nid : %s\n pw:**** \n생성일 : %s \n잔액 : %d원\n 대출한도 : %s\n" ,BANK_NAME,accountType,accountNum,name,uid,createDate,money,limit);
	}
}
