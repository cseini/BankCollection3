package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.AccountController;
import controller.AdminController;
import controller.MemberController;
import domain.*;

public class OpenAccount extends JFrame{
	private static final long serialVersionUID = 1L;
	JLabel topLab, idLab,passLab, nameLab, limitLab;
	JTextField idTxt, passTxt, nameTxt, limitTxt;
	JButton addBtn;
	JPanel bottomPan, centerPan, idPan, passPan, namePan, limitPan;
	JComboBox<?> combo;
	String[] menu = {"일반계좌","대출계좌"};
	public OpenAccount() {
		makeGui(); //화면구성
		this.setSize(400, 300);
		this.setVisible(true);
	}
	public void makeGui() {
		topLab = new JLabel("계좌개설", JLabel.CENTER);
		
		combo = new JComboBox<>(menu);
		idLab = new JLabel("I D : ", JLabel.CENTER);
		idTxt = new JTextField(15);
		idPan = new JPanel();
		idPan.add(idLab);
		idPan.add(idTxt);
		
		passLab = new JLabel("비밀번호 : ");
		passTxt = new JTextField(15);
		passPan = new JPanel();
		passPan.add(passLab);
		passPan.add(passTxt);
	
		nameLab = new JLabel("이 름 : ");
		nameTxt = new JTextField(15);
		namePan = new JPanel();
		namePan.add(nameLab);
		namePan.add(nameTxt);
		
		limitLab = new JLabel("대출한도 : ");
		limitTxt = new JTextField(15);
		limitPan = new JPanel();
		limitPan.add(limitLab);
		limitPan.add(limitTxt);

		centerPan = new JPanel();
		centerPan.setLayout(new GridLayout(8, 1));
		centerPan.add(combo);
		centerPan.add(idPan);
		centerPan.add(passPan);
		centerPan.add(namePan);
		centerPan.add(limitPan);

		
		addBtn = new JButton("개설신청");
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AccountBean account=new MinusAccountBean();
				account.setName(nameTxt.getText());
				account.setUid(idTxt.getText());
				account.setPass(passTxt.getText());
				
				if(((String) combo.getSelectedItem()).equals(menu[0])) {
					AdminController.getInstance().createAccount(account);
				}else {
					((MinusAccountBean) account).setLimit(Integer.parseInt(limitTxt.getText()));	
					AdminController.getInstance().createMinusAccount(account);
				}
			}
		});
		
	
		bottomPan = new JPanel();
		bottomPan.add(addBtn);
		
		add(topLab, "North");
		add(centerPan, "Center");
		add(bottomPan, "South");
	}
}
