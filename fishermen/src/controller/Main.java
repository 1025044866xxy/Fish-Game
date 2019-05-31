package controller;

import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		//1.3.设置窗口对象的相关内容
		window.setSize(1300, 768);
		window.setLocationRelativeTo(null);
		window.setTitle("捕鱼达人-Version1.0");
		window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		window.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				int choice=JOptionPane.showConfirmDialog(null, "确认退出","退出",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
				if(choice==JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			}
		});
		//1.2.让窗口对象呈现出来
		Panel panel=new Panel();
		new Thread(panel).start();
		panel.addKeyListener((KeyListener) panel);
		window.add(panel);
		window.addMouseListener(panel);
		window.addMouseMotionListener(panel);
		window.addKeyListener((KeyListener) panel);
		window.setVisible(true);
	}

}
