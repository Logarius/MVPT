package git.osc.roland.main;

import javax.swing.*;

public class Boot {
	
	public void run() {
        // 创建及设置窗口
        JFrame frame = new JFrame("MVPT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 添加 "Hello World" 标签
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        // 显示窗口
        frame.pack();
        frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new Boot().run();
            }
        });
	}

}
