package gamemanager;

import game.chips.BoardChips;
import game.chips.GameChips;
import game.chips.MoveChips;
import game.fourinarow.BoardFourInARow;
import game.fourinarow.GameFourInARow;
import game.fourinarow.MoveFourInARow;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import tictactoe.BoardTicTacToe;
import tictactoe.GameTicTacToe;
import tictactoe.MoveTicTacToe;
import uploaded.chips.PlayerChipsBrandon;
import uploaded.chips.PlayerChipsCoty;
import uploaded.chips.PlayerChipsEasy;
import uploaded.chips.PlayerChipsHard;
import uploaded.chips.PlayerChipsLevi;
import uploaded.chips.PlayerChipsTommy;
import uploaded.fourinarow.PlayerFourInARowEasy;
import uploaded.fourinarow.PlayerFourInARowMedium;
import uploaded.tictactoe.PlayerTicTacToeEasy;
import uploaded.tictactoe.PlayerTicTacToeMedium;
import ai.game.Game;
import ai.player.Player;

public class AIWars {
	public static void main(String[] args) {
		getGames();
		getBots(GameChips.class);
		getBots(GameTicTacToe.class);
	}

	public static ArrayList<Game> getGames() {
		ArrayList<Game> games = new ArrayList<Game>();
		games.add(new GameChips());
		games.add(new GameFourInARow());
		games.add(new GameTicTacToe());
		return games;
	}

	public static ArrayList<Player> getBots(Class<?> gameClazz) {
		ArrayList<Player> playableBots = new ArrayList<Player>();
		if (gameClazz == GameChips.class) {
			playableBots.add(new PlayerChipsBrandon());
			playableBots.add(new PlayerChipsCoty());
			playableBots.add(new PlayerChipsEasy());
			playableBots.add(new PlayerChipsHard());
			playableBots.add(new PlayerChipsLevi());
			playableBots.add(new PlayerChipsTommy());
		} else if (gameClazz == GameFourInARow.class) {
			playableBots.add(new PlayerFourInARowEasy());
			playableBots.add(new PlayerFourInARowMedium());
		} else if (gameClazz == GameTicTacToe.class) {
			playableBots.add(new PlayerTicTacToeEasy());
			playableBots.add(new PlayerTicTacToeMedium());
			// playableBots.add(new PlayerTicTacToeHard());
		}
		// try {
		// File file = new File(new File("").getAbsolutePath() + "/AIUpload");
		// File[] files = file.listFiles();
		// // compile(files);
		// ArrayList<Class<?>> clazzes = new ClassPathHacker().getClasses(file);
		// for (Class<?> clazz : clazzes) {
		// if (canPlay(clazz, gameClazz)) {
		// Object player = clazz.newInstance();
		// System.out.println("Added: " + clazz + " for " + gameClazz);
		// playableBots.add((Player) player);
		// }
		// }
		// } catch (Throwable t) {
		// t.printStackTrace();
		// }
		return playableBots;
	}

	private static boolean canPlay(Class<?> player, Class<?> gameClazz) {
		if (gameClazz == GameChips.class) {
			return implementsGame(player, MoveChips.class, BoardChips.class);
		} else if (gameClazz == GameTicTacToe.class) {
			return implementsGame(player, MoveTicTacToe.class, BoardTicTacToe.class);
		} else if (gameClazz == GameFourInARow.class) {
			return implementsGame(player, MoveFourInARow.class, BoardFourInARow.class);
		}
		return false;
	}

	private static boolean implementsGame(Class<?> player, Class<?> returnType, Class<?> boardClazz) {
		for (Method method : player.getMethods()) {
			if (method.getReturnType() == returnType) {
				if (method.getParameterTypes().length == 1) {
					if (method.getParameterTypes()[0] == boardClazz) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static void compile(File[] files) {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		if (compiler == null) {
			System.setProperty("java.home", "C:\\Program Files\\Java\\jdk1.7.0_09");
			compiler = ToolProvider.getSystemJavaCompiler();
		}
		ByteArrayOutputStream errorStream = new ByteArrayOutputStream();

		for (File file : files) {
			String fileName = file.getName();
			if (fileName.endsWith(".java")) {
				String name = fileName.replaceAll(".java", "");
				if (compiler.run(null, null, errorStream, file.getPath()) == 0) {
					try {
						URLClassLoader clazzLoader = URLClassLoader.newInstance(new URL[] { file.getParentFile().toURI().toURL() });
						Class<?> cls = Class.forName(name, true, clazzLoader);
					} catch (Throwable e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
