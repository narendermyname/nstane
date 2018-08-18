package com.ns.yamlreader;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ns.yamlreader.config.YamlConfigurationPool;
import com.ns.yamlreader.reader.DevYamlReader;
import com.ns.yamlreader.reader.YamlReader;

public class Main {
	private static AnnotationConfigApplicationContext appContext;
	private static YamlConfigurationPool pool;

	static {
		appContext = new AnnotationConfigApplicationContext();
		pool = new YamlConfigurationPool(appContext);
	}

	public static void main(String[] args) {
		readProdYaml();
	}

	public static void readProdYaml() {
		YamlReader reader = createYamlReader(Environment.PROD);
		boolean isObjectAdded = pool.addYamlObjectToPool("prod", reader.readYaml(Environment.PROD.getEnvFileName()));
		if(isObjectAdded) {
			System.out.println(appContext.getBean("prod"));
		}
	}

	public static YamlReader createYamlReader(Environment env) {
		switch (env) {
		case DEV:
			return new DevYamlReader();
		case TEST:
			return new DevYamlReader();
		case INT:
			return new DevYamlReader();
		case PROD:
			return new DevYamlReader();
		default:
			return null;
		}
	}

}
