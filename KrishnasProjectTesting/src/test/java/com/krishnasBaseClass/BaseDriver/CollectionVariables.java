package com.krishnasBaseClass.BaseDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class CollectionVariables {
	
	public static Gson environmentConfiguration;
	public static ConfigurationEnv configurationEnv = new ConfigurationEnv();
	public static final Logger LOGGER = LoggerFactory.getLogger(CollectionVariables.class);

	public CollectionVariables() {
		// TODO Auto-generated constructor stub
	}

}
