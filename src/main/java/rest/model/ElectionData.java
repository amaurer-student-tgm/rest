package rest.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ElectionData {
	private String
		regionID, regionName, regionAddress, regionPostalCode, federalState,
		timestamp;
	private CountingDataParty[] parties;
	private PreferenceVoteData[][] preferenceVoteData;

	public ElectionData(
		String regionID, String regionName, String regionAddress,
		String regionPostalCode, String federalState, CountingDataParty[] parties,
		PreferenceVoteData[][] preferenceVoteData)
	{
		this.regionID = regionID;
		this.regionName = regionName;
		this.regionAddress = regionAddress;
		this.regionPostalCode = regionPostalCode;
		this.federalState = federalState;
		this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
		this.parties = parties;
		this.preferenceVoteData = preferenceVoteData;
	}

	public String getRegionID() { return regionID; }
	public String getRegionName() { return regionName; }
	public String getRegionAddress() { return regionAddress; }
	public String getRegionPostalCode() { return regionPostalCode; }
	public String getFederalState() { return federalState; }
	public String getTimestamp() { return timestamp; }
	public CountingDataParty[] getParties() { return parties; }
	public PreferenceVoteData[][] getPreferenceVotes() { return preferenceVoteData; }
}
