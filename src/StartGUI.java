import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * gui.StartGUI
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 27-06-2020
 */

public class StartGUI extends JFrame {

	private Spiel spiel;
	private Spieler spieler;
	private Vector<Spieler> spielerVector = new Vector<Spieler>();

	private JLabel alleSpieler;

	private JTextField name;

	private JButton spielerHinzufuegen;

	private JPanel mainPanel, spielerHinzufuegenPanel, alleSpielerPanel;

	private static int cntr;

	public StartGUI(Spiel spiel) {

		super("Tschau Sepp");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		cntr = 0;

		mainPanel = new JPanel();
		spielerHinzufuegenPanel = new JPanel();
		alleSpielerPanel = new JPanel();

		alleSpieler = new JLabel();

		name = new JTextField();

		spielerHinzufuegen = new JButton("+");
		spielerHinzufuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onSpielerHinzufuegen(e);
			}
		});

		init();
		pack();
		setSize(500, 500);
		setVisible(true);
	}

	public void init() {
		getContentPane().add(mainPanel);
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(alleSpielerPanel, BorderLayout.CENTER);
		mainPanel.add(spielerHinzufuegenPanel, BorderLayout.NORTH);

		alleSpielerPanel.setLayout(new GridLayout(4,1));

		spielerHinzufuegenPanel.setLayout(new BorderLayout());
		spielerHinzufuegenPanel.add(spielerHinzufuegen, BorderLayout.CENTER);
		spielerHinzufuegenPanel.add(name, BorderLayout.NORTH);
	}

	public void onSpielerHinzufuegen(ActionEvent e) {
		if (name.equals(null)) {
			name.setText("Bitte Name eingeben");
		} else {
			spielerVector.add(new Spieler(name.getText()));
			alleSpielerPanel.add(new JLabel(name.getText()));
			name.setText(null);
			alleSpielerPanel.revalidate();
		}
	}
}
