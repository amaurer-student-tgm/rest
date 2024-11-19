package rest.model;

public class CountingDataParty {
	private String partyID, amountVotes;

	public CountingDataParty(String partyID, String amountVotes) {
		this.partyID = partyID;
		this.amountVotes = amountVotes;
	}

	public String getPartyID() { return partyID; }
	public String getAmountVotes() { return amountVotes; }
}
