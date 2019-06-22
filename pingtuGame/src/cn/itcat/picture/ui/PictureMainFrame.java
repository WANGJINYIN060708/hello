package cn.itcat.picture.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/*
 * ������
 * 
 */
public class PictureMainFrame extends JFrame {
	private String[] items = { "СŮ��", "Ů����" };
	private JRadioButton addNumInfo;// ������ʾ
	private JRadioButton clearNummInfo;// ���������ʾ
	private PictureCanves canves;// ƴͼ��
	private PicturePreView pView;// Ԥ����
	private JComboBox<String> box;// ������
	private JTextField name;// ͼƬ����
	public static JTextField step;// �ƶ�����,���������е��ö����������� 
	private JButton startButton;

	// �ղ������췽��
	public PictureMainFrame() {
		// super();
		init();// ��ʼ������
		// ������
		addComponent();

		addPreViewImage();// ���Ԥ��ͼƬ��ƴͼͼƬ

		addActionListener();// Ϊ������ʱ�����
		addActionListener1();

	}

	// �����ʾ
	private void addActionListener1() {
		// TODO Auto-generated method stub
		clearNummInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canves.ReloadClearNum();

			}
		});
		// ������
		box.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// ��ȡѡȡͼƬ��id
				int num = box.getSelectedIndex();// Ĭ�ϴ��㿪ʼ
				// ����Ԥ����
				PictureCanves.pictureID = num + 1;
				// ����ͼƬ��
				pView.repaint();// ���»���
				canves.ReloadClearNum();
				// ���°�ť��
				// ����ͼƬname
				name.setText("ͼƬ���ƣ� " + box.getSelectedItem());
				// ���ò���
				int stepNum = PictureCanves.stepNum = 0;
				step.setText("������" + stepNum);
				// �Ѱ�ť�������״̬
				clearNummInfo.setSelected(true);
			}
		});
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ��������
				PictureCanves.stepNum = 0;
				// ����״̬���Ĳ���gengxing
				step.setText("������ " + PictureCanves.stepNum);
				// ��С�������˳��
				canves.start();

			}
		});
	}

	private void addActionListener() {
		// Ϊ��ǰ��������ʾ
		addNumInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canves.ReloadPictureAddNum();

			}
		});

	}

	private void addPreViewImage() {
		// ����һ����壬����ƴͼ����Ԥ����
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));// �������Ϊ��񲼾�
		canves = new PictureCanves();
		canves.setBorder(new TitledBorder("ƴͼ��"));
		pView = new PicturePreView();
		pView.setBorder(new TitledBorder("Ԥ����"));
		// ���ƴͼ����Ԥ�������м�������
		panel.add(canves, BorderLayout.EAST);
		panel.add(pView, BorderLayout.WEST);
		// �������ʾ����������
		this.add(panel, BorderLayout.CENTER);// ������ʾ

	}

	/**
	 * ����������
	 */
	private void addComponent() {
		// ����һ����壬�ڵ�ǰ����������ť����״̬��
		JPanel panel = new JPanel();
		// panel.setBackground(Color.PINK);// ��ָ��ǰ���ı���ɫΪ��ɫ
		panel.setLayout(new GridLayout(1, 2));// �������Ϊһ�����еĵ�Ԫ�񲼾�

		// ����һ����ť�����
		JPanel leftPanel = new JPanel();
		panel.add(leftPanel, BorderLayout.WEST);// ���
		leftPanel.setBorder(new TitledBorder("��ť��"));// ���ñ߿�
		leftPanel.setBackground(Color.PINK);// ���ñ���ɫ

		addNumInfo = new JRadioButton("������ʾ", false);
		clearNummInfo = new JRadioButton("�����ʾ", true);
		// ��ӵ�ѡ��ť��
		ButtonGroup addNumGroup = new ButtonGroup();
		box = new JComboBox<String>(items);
		startButton = new JButton("Start");
		// �������������
		addNumGroup.add(addNumInfo);
		addNumGroup.add(clearNummInfo);
		// ���ñ���ɫ
		addNumInfo.setBackground(Color.PINK);
		clearNummInfo.setBackground(Color.PINK);
		startButton.setBackground(Color.PINK);

		// ��ӵ�ѡ��ť����ť����
		leftPanel.add(addNumInfo);
		leftPanel.add(clearNummInfo);
		leftPanel.add(new JLabel("      ѡ��ͼƬ"));
		leftPanel.add(box);
		leftPanel.add(startButton);

		// ����һ��״̬�����
		JPanel rightPanel = new JPanel();
		panel.add(rightPanel, BorderLayout.EAST);// �ұ�
		rightPanel.setBorder(new TitledBorder("��Ϸ״̬"));// ����ұ߱߿�
		rightPanel.setBackground(Color.PINK);
		rightPanel.setLayout(new GridLayout(1, 2));
		name = new JTextField("ͼƬ����:СŮ��");
		step = new JTextField("��ǰ������0");
		// �����ı����ܱ༭
		name.setEditable(false);
		step.setEditable(false);
		rightPanel.add(name, BorderLayout.WEST);
		rightPanel.add(step, BorderLayout.EAST);
		// ���õ�ǰ������ڴ��ڵ��Ϸ�λ����ʾ
		this.add(panel, BorderLayout.NORTH);

	}

	/*
	 * �����ʼ������
	 */

	private void init() {
		// TODO Auto-generated method stub
		// ���ô������
		this.setTitle("ƴͼ��Ϸ");
		// ���ô����С
		this.setSize(1000, 720);
		// ���ô���λ��
		this.setLocation(150, 10);
		// ���ô����СΪ�̶���С
		this.setResizable(false);
		// ���ô����Ĭ�Ϲر�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
