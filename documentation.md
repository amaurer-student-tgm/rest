# Rest - Andreas Maurer

**What is Rest?**

Representational State Transfer is a system of transfering data as a representable format like JSON or XML. In Java the springboot framework is commonly used to achieve this kind of connection.

**Implementation**

For the implementation we need our Application, which just runs the Spring Boot thread.

```java
package rest.election;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.model.*;

@RestController
public class ElectionController {
	@Autowired
	private ElectionService service;

	@RequestMapping("/")
	public String warehouseMain() {
		return
			"This is the warehouse application! (DEZSYS_WAREHOUSE_REST) <br/><br/>" +
			"<a href='http://localhost:8080/election/json'>Link to election/json</a><br/>" +
			"<a href='http://localhost:8080/election/xml'>Link to election/xml</a><br/>";
	}

	@RequestMapping(value="/election/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public ElectionData electionDataXml() {
		return service.getElectionData();
	}

	@RequestMapping(value="/election/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public ElectionData electionDataJson() {
		return service.getElectionData();
	}
}


```

Hier mapped man die Daten zu JSON or XML mit Spring boot vom Service.

**Service**

```java
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
```



**Simulation**

Here you set the ElectionData with meaningful data. In this case the elections were filled with random generated data.

```java
package rest.election;

import rest.model.*;

public class ElectionSimulation {
	public ElectionData getData() {
		int[] votes = new int[3];
		String[] parties = { "FPOE", "OEVP", "SPOE" };

		CountingDataParty[] countingDataParty = new CountingDataParty[3];
		for (int i = 0; i < countingDataParty.length; ++i)
			countingDataParty[i] = new CountingDataParty(parties[i], String.valueOf(votes[i] = getRandom()));

		PreferenceVoteData[][] preferenceVoteData = new PreferenceVoteData[3][5];
		int tmp;
		for (int i = 0; i < preferenceVoteData.length; ++i) {
			for (int j = 0; j < preferenceVoteData[i].length; ++j) {
				preferenceVoteData[i][j] =
					new PreferenceVoteData(
						String.valueOf(getRandom(9999)),
						parties[i] + "Person" + (j+1),
						String.valueOf(tmp = getRandom(votes[i]))
					);
					votes[i] = tmp;
			}
		}

		return
			new ElectionData(
				"33123",
				"Linz Bahnhof",
				"Bahnhofsstrasse 27/9",
				"Linz",
				"Austria",
				countingDataParty,
				preferenceVoteData
			);
    }
}
```


