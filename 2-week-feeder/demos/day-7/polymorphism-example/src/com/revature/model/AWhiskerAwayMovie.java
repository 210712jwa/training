package com.revature.model;

public class AWhiskerAwayMovie extends Movie {

	@Override // Is really optional. But it is recommended because it allows our IDE / compiler / linter, whatever to tell us
	// whether we are actually overriding something or not. Because we might be misspelling our method names for example and
	// therefore not really overriding something in the parent class
	public String getMovieDescription() {
		return "A girl who transforms into a cat using a cat mask";
	}
	
}
