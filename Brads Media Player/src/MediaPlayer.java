import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension; //allows to store heights
import java.awt.Font;
import java.awt.Toolkit; //allows asking questions of the operating system
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File; //to select a file

import junit.framework.*; //for testing 

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*; //allows GUI for swing 
import javax.swing.filechooser.FileNameExtensionFilter; //allows for me to choose music files


public class MediaPlayer extends JPanel implements ActionListener
{
	JFrame window = new JFrame("Brad's Media Player");
	JLabel info = new JLabel("WAV media player");
	
	JButton addButton = new JButton("Select Music");
	JButton playButton = new JButton("Play");
	//JButton pauseButton = new JButton("Pause");
	JButton stopButton = new JButton("Stop");
	
	Font customFont = new Font("sans",Font.BOLD,16);
	
	JComboBox list = new JComboBox();
	JFileChooser browser = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("WAV Sound", "wav");
	
	int returnValue;
	int index = 0;
	
	File selectedFile;
	File sound;
	AudioInputStream ais;
	Clip clip;
	
	
	String[] music = new String[10]; //ten files can be selected and stored
	
	MediaPlayer()
	{
		this.setBackground(Color.DARK_GRAY);
		window.add(this);
		
		
		addButton.addActionListener(this);
		playButton.addActionListener(this);
		//pauseButton.addActionListener(this);
		stopButton.addActionListener(this);
		
		
		addButton.setFont(customFont);
		addButton.setBackground(Color.YELLOW);
		addButton.setForeground(Color.BLACK);
		addButton.setToolTipText("This is where you will add a WAV file go ahead you can add multiple");
		window.add(addButton,BorderLayout.LINE_START);
		
		playButton.setFont(customFont); 
		playButton.setBackground(Color.GREEN);
		playButton.setForeground(Color.BLACK);
		playButton.setToolTipText("Play your Clip!");
		window.add(playButton,BorderLayout.CENTER);
		

		
		stopButton.setFont(customFont);
		stopButton.setBackground(Color.RED);
		stopButton.setForeground(Color.DARK_GRAY);
		stopButton.setToolTipText("Stop your clip!");
		window.add(stopButton,BorderLayout.LINE_END);
		
		
		info.setFont(new Font("",Font.ITALIC,16)); 
		window.add(info,BorderLayout.PAGE_END);
		
		list.setBackground(Color.WHITE);
		list.setForeground(Color.BLUE);
		window.add(list,BorderLayout.PAGE_START);
		
		browser.setFileFilter(filter);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		Dimension dim = tk.getScreenSize();
		
		int xPos = (dim.width / 2) - (window.getWidth() / 2);
		int yPos = (dim.height / 2) - (window.getHeight() / 2);
		
		window.setSize(400, 150);
		window.setLocation(xPos, yPos);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(true);	
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addButton)
		{
			returnValue = browser.showOpenDialog(window);
			
			if(returnValue==browser.APPROVE_OPTION)
			{
				selectedFile = browser.getSelectedFile();
				music[index] = selectedFile.toString();
				list.addItem("Choice # "+index);
				index++;
			}
		}
		
		else if(e.getSource()==playButton)
		{
			try{
				if(list.getSelectedIndex()==0)
				{
					sound = new File(music[list.getSelectedIndex()]);
					ais = AudioSystem.getAudioInputStream(sound);
					clip = AudioSystem.getClip();
					clip.open(ais);
					clip.start();
				}
				
				else if(list.getSelectedIndex()==1)
				{
					sound = new File (music[list.getSelectedIndex()]);
					ais = AudioSystem.getAudioInputStream(sound);
					clip = AudioSystem.getClip();
					clip.open(ais);
					clip.start();
				}
				
				else if(list.getSelectedIndex()==2)
				{
					sound = new File (music[list.getSelectedIndex()]);
					ais = AudioSystem.getAudioInputStream(sound);
					clip = AudioSystem.getClip();
					clip.open(ais);
					clip.start();
				}
				
				else if(list.getSelectedIndex()==3)
				{
					sound = new File (music[list.getSelectedIndex()]);
					ais = AudioSystem.getAudioInputStream(sound);
					clip = AudioSystem.getClip();
					clip.open(ais);
					clip.start();
				}
				
			}catch(Exception be){JOptionPane.showMessageDialog(null, be);}
		}
		
		else if(e.getSource()==stopButton)
		{
			clip.stop();
		}
	}
	
}