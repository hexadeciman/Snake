import java.awt.Color;
import javax.swing.JPanel;

public class SquarePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1785548725355874876L;

	public SquarePanel(Color d){
		//on rempli le fond du JPanel "Carre"
		this.setBackground(d);
	}
	
	//On change le fond de "Carre"
	public void ChangeColor(Color d){
		this.setBackground(d);
		this.repaint();
	}
	
}

