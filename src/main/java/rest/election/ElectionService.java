package rest.election;

import org.springframework.stereotype.Service;
import rest.model.*;

@Service
public class ElectionService {
	public ElectionData getElectionData() {
		return new ElectionSimulation().getData();
	}

	public String getGreetings(String text) {
		return "Greetings from " + text;
	}
}
