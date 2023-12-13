import java.awt.Color;
import javax.swing.JPanel;

public class SquarePanel extends JPanel{
	private static final long serialVersionUID = 1L;

	public SquarePanel(Color backgroundColor){
		this.setBackground(backgroundColor);
	}
	
	public void ChangeColor(Color backgroundColor){
		this.setBackground(backgroundColor);
		this.repaint();
	}
	
}

