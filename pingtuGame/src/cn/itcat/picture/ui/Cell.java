package cn.itcat.picture.ui;

import javax.swing.Icon;
import javax.swing.JButton;

/*
 * ͼƬС����
 */
public class Cell extends JButton {
	// ����ͼƬ��С����
	public Cell(Icon icon) {
		super(icon);
		// ����С�����С
		this.setSize(150, 150);

	}

	// ����ͼƬ����������
	public Cell(String text, Icon icon) {
		super(text, icon);
		this.setSize(150, 150);
		this.setHorizontalTextPosition(CENTER);// ����ˮƽ������ʾ
		this.setVerticalTextPosition(CENTER);// ���ִ�ֱ������ʾ

	}

	public void move(String direct) {
		// TODO Auto-generated method stub
		switch (direct) {
		case "Right":
			 this.setLocation(this.getBounds().x+150,this.getBounds().y);
			break;
		case "Left":
			 this.setLocation(this.getBounds().x-150,this.getBounds().y);
			break;
		case "Down":
			 this.setLocation(this.getBounds().x,this.getBounds().y+150);
			break;
		case "Up":
			 this.setLocation(this.getBounds().x,this.getBounds().y-150);
			break;
	
		}
	}

}
