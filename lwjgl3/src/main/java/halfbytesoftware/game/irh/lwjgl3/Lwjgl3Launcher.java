package halfbytesoftware.game.irh.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import halfbytesoftware.game.irh.IPlatformServices;
import halfbytesoftware.game.irh.IRHGame;

public class Lwjgl3Launcher implements IPlatformServices {
	public static void main(String[] args) {
		Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
		configuration.setTitle("Idle Rogue Heroes");
		configuration.setWindowedMode(1280, 720);
		configuration.setResizable(false);
		configuration.setWindowPosition(200, 200);
		configuration.useVsync(true);
		configuration.setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png");

		IRHGame game = new IRHGame(new Lwjgl3Launcher());

		new Lwjgl3Application(game, configuration);
	}
}