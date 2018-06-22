package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CreateTextField {
	JTextField idTxt;
	JPanel idPan;
	public void create() {
		idTxt=new JTextField();
		idPan = new JPanel();
		idPan.add(idTxt);
	}
}
