import java.awt.*;

import javax.swing.*;

/**
 * This program implements an animation that moves a car shape.
 * @author Akshat Bansal
 */
public class AnimationTester {
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		final MoveableShape shape1 = new CarShape(0, 0, CAR_WIDTH);
		final MoveableShape shape2 = new CarShape(0, 25, CAR_WIDTH);
		final MoveableShape shape3 = new CarShape(0, 50, CAR_WIDTH);

		ShapeIcon icon1 = new ShapeIcon(shape1, ICON_WIDTH, ICON_HEIGHT);
		ShapeIcon icon2 = new ShapeIcon(shape2, ICON_WIDTH, ICON_HEIGHT);
		ShapeIcon icon3 = new ShapeIcon(shape3, ICON_WIDTH, ICON_HEIGHT);

		final JLabel label1 = new JLabel(icon1);
		final JLabel label2 = new JLabel(icon2);
		final JLabel label3 = new JLabel(icon3);

		frame.setLayout(new GridLayout(3, 1));
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					shape1.move();
					frame.repaint();
					try {
						Thread.sleep(75);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					shape2.move();
					frame.repaint();
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					shape3.move();
					frame.repaint();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		t1.start();
		t2.start();
		t3.start();
	}

	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 100;
	private static final int CAR_WIDTH = 100;
}