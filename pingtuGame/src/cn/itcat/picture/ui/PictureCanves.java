package cn.itcat.picture.ui;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * ƴͼ����
 */
public class PictureCanves extends JPanel implements MouseListener {
	// ��Ա����
	private Cell[] cells;
	private boolean hasAddActilistener = false;// ������ǰ�����Ƿ�����˼���
	// ��̬����
	public static int pictureID = 1;// ͼƬ��id
	public static int stepNum = 0;// ͼƬ���ƶ�����
	private Rectangle nullCell;

	// ���췽��
	public PictureCanves() {
		// ����ƴͼ���Ĳ���
		this.setLayout(null);// ֡����
		// ����ʮ����С����ƴ�ӵ�ƴͼ��
		cells = new Cell[12];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 3; j++) {
				// ����ͼƬ
				// ImageIcon icon=new ImageIcon("Pictute\\1_01.gif");
				// int num=i*3+j;
				ImageIcon icon = new ImageIcon("Pictute\\" + pictureID + "_"
						+ (i * 3 + j + 1) + ".gif");
				// ����ͼƬС����
				cells[i * 3 + j] = new Cell(icon);
				// ָ��ͼƬС�����λ��
				cells[i * 3 + j].setLocation(j * 150 + 15, i * 150 + 15);
				// �ѵ�ǰ��С������ӵ�ƴͼ����
				this.add(cells[i * 3 + j]);
			}
		// ָ��һ���յ�С����
		this.remove(cells[11]);
		nullCell = new Rectangle(315, 465, 150, 150);

	}

	// ���¼���ͼƬ�������������ʾ
	public void ReloadPictureAddNum() {
		// ��ȡÿһ��С����
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 3; j++) {
				// ��ȡС����

				// ����С�����Ӧ��ͼƬ
				ImageIcon icon = new ImageIcon("Pictute\\" + pictureID + "_"
						+ (i * 3 + j + 1) + ".gif");
				cells[i * 3 + j].setIcon(icon);
				// ������ʾ��������ʾ
				cells[i * 3 + j].setText("�ڼ�" + (i * 3 + j + 1) + "��ͼƬ");
				cells[i * 3 + j].setVerticalTextPosition(this.getY() / 2);
				cells[i * 3 + j].setHorizontalTextPosition(this.getX() / 2);

			}

	}

	// ���¼���ͼƬ����ȥ��ʨ����ʾ
	public void ReloadClearNum() {
		// ��ȡÿһ��С����
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 3; j++) {
				// ��ȡС����

				// ����С�����Ӧ��ͼƬ
				ImageIcon icon = new ImageIcon("Pictute\\" + pictureID + "_"
						+ (i * 3 + j + 1) + ".gif");
				cells[i * 3 + j].setIcon(icon);
				// ������ʾ��������ʾ
				cells[i * 3 + j].setText("");

			}
	}

	public void start() {
		// �����С����û�м�������С������Ӽ���
		if (!hasAddActilistener) {
			// ��Ӽ���
			for (int i = 0; i < 11; i++) {
				cells[i].addMouseListener(this);
			}
			// ��������״̬
			hasAddActilistener = true;

		}

		// �����ǰ��һ��С����������ϽǽϽ�ʱ����ʱ�÷�����շ��񻥻�
		// �����һ��С���������Ͻ��ĸ������ڣ��Ͳ��ϵĽ��л���
		while (cells[0].getBounds().x <= 165 && cells[0].getBounds().y <= 165) {
			// ��ȡ�շ����λ��
			int nullx = nullCell.getBounds().x;
			int nully = nullCell.getBounds().y;
			// �������һ�����򣬽��пշ�����С����Ļ���
			// ����0-3���������Ӧ������ƶ�
			int direct = (int) (Math.random() * 4);// 0-3�������
			switch (direct) {
			case 0://�շ��������ƶ�����෽�������ƶ�
                nullx-=150;
                cellMove(nullx,nully,"Right");
				break;
			case 1:////�շ��������ƶ�����෽�������ƶ�
                nullx+=150;
                cellMove(nullx,nully,"Left");
				break;
			case 2:////�շ��������ƶ�����෽�������ƶ�
                nully-=150;
                cellMove(nullx,nully,"Down");
				break;
			case 3://�շ��������ƶ�����෽�������ƶ�
				 nully+=150;
	                cellMove(nullx,nully,"Up");
				break;

			}

		}

	}
    //������շ���Ļ���
	private void cellMove(int nullx, int nully, String direct) {
		// TODO Auto-generated method stub
		for(int i=0;i<11;i++)
		{
			if(cells[i].getBounds().x==nullx&&cells[i].getBounds().y==nully)
			{
				//��ǰ�շ�����ƶ�
				cells[i].move(direct);
				//�շ����ƶ�
				nullCell.setLocation(nullx,nully);
				//��ɽ���������ѭ��
				break;
				
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//��ȡ�������С����
		Cell buttonCell =(Cell)e.getSource();
		
		//��ȡ�������ĵ��룬x,yֵ
		int x=buttonCell.getBounds().x;
		int y=buttonCell.getBounds().y;
		//�жϿշ����Ƿ����㽻�����������շ�����룬x,y;
		int nullx=nullCell.getBounds().x;
		int nully=nullCell.getBounds().y;
		if(x==nullx&&y-nully==150)//�����Ϊ�շ�������ķ���
		{
		buttonCell.move("Up");
		}else if(x==nullx&&y-nully==-150)//�����Ϊ�շ�������ķ���
		{
			buttonCell.move("Down");
		}else if(y==nully&&x-nullx==150)//�����Ϊ�շ�������ķ���
		{
			buttonCell.move("Left");
		}else if(y==nully&&x-nullx==-150)//�����Ϊ�շ�������ķ���
		{
			buttonCell.move("Right");	
		}else {
			return;
		}
		//���¿շ����λ��
		nullCell.setLocation(x,y);
		//ƴͼ���������»���
		this.repaint();
		//���¸�����Ϸ״̬�������²���
		stepNum++;
		PictureMainFrame.step.setText("������"+stepNum);
		//�ж���Ϸ�Ƿ����
		if(isFish())
		{
			//����������ʾ
			JOptionPane.showMessageDialog(this,"��ϲ��������ǵ�ƴͼ��\n"+stepNum);
			//���������������
			for(int i=0;i<11;i++)
			{
				cells[i].removeMouseListener(this);
			}
			//���·����״̬
			hasAddActilistener=false;
			
		}
		
	}
	//���������ж��Ƿ�ƴͼ�ɹ�
	private boolean  isFish()
	{
		for(int i=0;i<11;i++)
		{
			//��ȡÿ�������λ��
			int x=cells[i].getBounds().x;
			int y=cells[i].getBounds().y;
			if((y-15)/150*3+(x-15)/150!=i)
			{
				return false;
			}
			
		}
		
		return true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
