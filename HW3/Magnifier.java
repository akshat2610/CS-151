import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Magnifier extends JFrame{
	public Magnifier(){
		setSize(1000, 500);
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(3,1));

		zoomInBtn = new JButton("Zoom in");
		zoomOutBtn  = new JButton("Zoom out");
		CarIcon carIcon = new CarIcon(300);
		carIconLabel = new JLabel(carIcon);

		zoomInBtn.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               carIcon.zoomIn();
               carIconLabel.repaint();
            }
         });
		zoomOutBtn.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               carIcon.zoomOut();
               carIconLabel.repaint();
            }
         });

		cp.add(carIconLabel);
		cp.add(zoomInBtn);
		cp.add(zoomOutBtn);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] agrs){
		new Magnifier();
	}

	private JButton zoomInBtn;
	private JButton zoomOutBtn;
	private JLabel carIconLabel;
}