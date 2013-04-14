package gamemanager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class ClassPathHacker {
	private ArrayList<Class<?>> classes;

	public static void main(String[] args) {
	}

	public ArrayList<Class<?>> getClasses(File file) {
		classes = new ArrayList<Class<?>>();
		try {
			addDirectory(file);
			addFiles(file);
		} catch (Throwable t) {
			t.printStackTrace();

		}
		return classes;
	}

	private void addFiles(File parent) {
		for (File file : parent.listFiles()) {
			try {
				if (file.isDirectory()) {
					addDirectory(file);
					addFiles(file);
				}
			} catch (Throwable throwable) {
				throwable.printStackTrace();
			}
		}
	}

	private void addDirectory(File file) throws Throwable {
		addURL(file.toURI().toURL());
		searchFiles(file);
	}

	private void searchFiles(File parent) throws Throwable {
		URLClassLoader clazzLoader = URLClassLoader.newInstance(new URL[] { parent.toURI().toURL() });
		for (File file : parent.listFiles()) {
			if (file.getName().endsWith(".class")) {
				Class<?> clazz = clazzLoader.loadClass(file.getName().replaceAll(".class", "").replaceAll("/", "."));
				classes.add(clazz);
			}
		}
	}

	private void addURL(URL u) throws IOException {
		URLClassLoader sysloader = (URLClassLoader) ClassLoader.getSystemClassLoader();
		Class<?> sysclass = URLClassLoader.class;
		try {
			Method method = sysclass.getDeclaredMethod("addURL", new Class[] { URL.class });
			method.setAccessible(true);
			method.invoke(sysloader, new Object[] { u });
		} catch (Throwable t) {
			t.printStackTrace();
			throw new IOException("Error, could not add URL to system classloader");
		}
	}
}