package views;


import javax.swing.JFrame;

public class SnakeView {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public SnakeView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setFrame();
		setComponents();
		setListeners();
	}

	
	public void setFrame() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setComponents() {
		
	}
	
	public void setListeners() {
		
	}
}
