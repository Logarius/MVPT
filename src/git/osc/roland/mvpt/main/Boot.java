package git.osc.roland.mvpt.main;

import git.osc.roland.mvpt.common.utils.XmlParseUtils;

import javax.swing.*;


public class Boot {
	
	public void run() {
        JFrame frame = new JFrame("MVPT");
        frame.setSize(600, 480);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);
        try {
            JTextArea commentTextArea = new JTextArea(XmlParseUtils.getUsers().toString());
            JScrollPane scrollPane = new JScrollPane(commentTextArea);
            JPanel controlPanel = new JPanel();
            controlPanel.add(scrollPane);
            frame.getContentPane().add(controlPanel);

        }catch (Exception e){
            e.printStackTrace();
        }

        frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run()  {
            	new Boot().run();
            }
        });
	}

}
