package com.mcnavish.toobsoc.handlers;

import static spark.Spark.get;
import static spark.Spark.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.servlet.SparkApplication;


public class AttHandler implements SparkApplication {
	
	private Logger logger = LoggerFactory.getLogger(AttHandler.class);

	@Override
	public void init() {
		
		get(new Route("/att/provision/:name") {
			
			@Override
			public Object handle(Request request, Response response) {
				logger.debug("in /att/provision/name: " + request.params(":name"));
				return "At&t Provisioning " + request.params(":name");
			}
			
		});
		
		post(new Route("/att/provision"){
			
			@Override
			public Object handle(Request request, Response response){
				String body = request.body();
				logger.debug("body: " + body);
				
				//TODO: do stuff with body
				
				response.status(201); //created
				return "post provision response goes here";
			}
		});
		
		get(new Route("/att/provision") {
			
			@Override
			public Object handle(Request request, Response response) {
				logger.debug("in /att/provision GET");
				return "At&t Provision request accepted";
			}
			
		});
		
		get(new Route("/att/*"){
			
			@Override
			public Object handle(Request request, Response response) {
				halt(404, "<h1>404</h1> Your lost, turn around and try again.");
				
				return "";
			}
		});
				
	}

}
