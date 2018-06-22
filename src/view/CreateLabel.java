package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreateLabel {
	JLabel idLab;
	JPanel idPan;
	public void create() {
		idLab=new JLabel("ID", JLabel.CENTER);
		idPan = new JPanel();
		idPan.add(idLab);
	}
}
