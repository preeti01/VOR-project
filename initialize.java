
package vor;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;

public class App
{
	public static final String APP_NAME = "VOR";
        private JFrame frame;
	private Display display;

	public App()
	{
		display = new Display();

		initializeFrame();
	}

	private void initializeFrame()
	{
		frame = new JFrame(APP_NAME);
		frame.add(display);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e) 
			{
				handleQuit();
			}
		});
		frame.pack();
		frame.setVisible(true);
	}



	Action exitAction = new AbstractAction("Exit")
	{
		public void actionPerformed(ActionEvent e)
		{
			handleQuit();
		}
	};



	public void handleQuit()
	{
		
		Runtime.getRuntime().exit(0);
	}

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new App();
			}
		});
	}
}
