package search.impl.tour;

import search.Action;
import search.Printing;
import search.State;

public class TourPrinting extends Printing {

	@Override
	public void print(Action action) {
		if(!(action instanceof Road))
			throw new IllegalArgumentException();
		Road road = (Road) action;
		
		System.out.println("Travel down road:");
		System.out.println(road.sourceCity + "---> " + road.targetCity + "   (" + road.length + "km");
	}

	@Override
	public void print(State state) {
		if(!(state instanceof TourState))
			throw new IllegalArgumentException();
		TourState tourState = (TourState) state;
		System.out.println("Now at city:");
		System.out.println(tourState.getCurrentCity().name);
	}

}
