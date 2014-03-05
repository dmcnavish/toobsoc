package com.mcnavish.toobsoc.handlers;

import static spark.Spark.get;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.servlet.SparkApplication;

public class SprintHandler implements SparkApplication {

	private Logger logger = LoggerFactory.getLogger(SprintHandler.class);
	
	@Override
	public void init() {
		get(new Route("/sprint/provision") {
			
			@Override
			public Object handle(Request request, Response response) {
				logger.debug("in /sprint/provision");
				return "Sprint Provision request accepted";
			}
			
		});
		
		get(new Route("/sprint/*"){
			
			@Override
			public Object handle(Request request, Response response) {
				halt(404, "<h1>404</h1> Your lost, turn around and try again.");
				
				return "";
			}
		});
		
	}

}
