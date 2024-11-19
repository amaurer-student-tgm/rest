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
