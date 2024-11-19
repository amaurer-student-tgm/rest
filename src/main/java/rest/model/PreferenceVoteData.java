package rest.model;

public class PreferenceVoteData {
	private String listNumber;
	private String name;
	private String votes;

	public PreferenceVoteData(String listNumber, String name, String votes) {
		this.listNumber = listNumber;
		this.name = name;
		this.votes = votes;
	}

	public String getListNumber() { return listNumber; }
	public String getName() { return name; }
	public String getVotes() { return votes; }
}
