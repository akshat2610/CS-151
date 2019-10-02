import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;

public class MyIconTester{
	public static void main(String[] args){
		JFrame frame = new JFrame("My Icon Tester");
		MyIcon icon = new MyIcon(50);
		JLabel iconLabel = new JLabel(icon);
		frame.setLayout(new FlowLayout());

		JButton greenBtn = new JButton("Repaint green");
		JButton redBtn = new JButton("Repaint red");
		JButton blueBtn = new JButton("Repaint blue");

		frame.add(greenBtn);
		frame.add(redBtn);
		frame.add(blueBtn);
		frame.add(iconLabel);

		greenBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				icon.setColor(Color.GREEN);
				iconLabel.repaint();
			}
		});
		redBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				icon.setColor(Color.RED);
				iconLabel.repaint();
			}
		});
		blueBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				icon.setColor(Color.BLUE);
				iconLabel.repaint();
			}
		});


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	frame.pack();
      	frame.setVisible(true);
	}
}