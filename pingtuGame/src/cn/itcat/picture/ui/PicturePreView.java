package cn.itcat.picture.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
/*
 * ͼƬԤ��
 */
public class PicturePreView extends JPanel{
	//��д���Ƹ���
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		//ָ����ǰͼƬ��·��
		 //String filename="Pictute\\1.jpg";
		String filename="Pictute\\"+PictureCanves.pictureID+".jpg";
		 //��ȡ��ӦͼƬ��ͼ��
		 ImageIcon icon=new ImageIcon(filename);
		 //��ȡͼƬ��ͼ��
		Image image= icon.getImage();
		//��ͼ����ʾ��ͼƬԤ����
		g.drawImage(image,15,15,450,600,this);
	}
	 

}
