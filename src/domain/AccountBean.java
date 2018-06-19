package domain;

public class AccountBean {
	public final static String BANK_NAME = "비트뱅크";
	public final static String ACCOUNT_TYPE = "기본통장";
	public final static String WITHDRAW_SUCCESS = "출금성공";
	public final static String WITHDRAW_FAIL = "잔액부족";
	public final static String DEPOSIT_SUCCESS = "입금성공";
	public final static String DEPOSIT_FAIL = "적합한 입력값이 아님";
	protected int money;
	protected String name, uid, pass, accountType, accountNum, createDate;
	public void setName(String name) {
		this.name = name;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public void setAccountType() {
		this.accountType = ACCOUNT_TYPE;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getName() {
		return name;
	}

	public String getUid() {
		return uid;
	}

	public String getPass() {
		return pass;
	}

	public int getMoney() {
		return money;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public String getCreateDate() {
		return createDate;
	}
	public String toString() {
		return String.format("%s \n%s \n계좌번호 %s \n이름 : %s \nid : %s\npw:**** \n생성일 : %s \n잔액 : %d원\n" ,BANK_NAME,accountType,accountNum,name,uid,createDate,money);
	}
}
