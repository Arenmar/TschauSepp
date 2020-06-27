/**
 * TSApp
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 27-06-2020
 */

public class TSApp {

	public static void main(String[] args) {

		Spiel game = new Spiel();

		StartGUI sg = new StartGUI(game);
	}
}