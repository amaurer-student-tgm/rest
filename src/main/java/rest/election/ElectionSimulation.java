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

	private int getRandom() {
		return (int)(Math.random() * 1000 + 1);
		//return (int)(Math.random() * (max-min) + 1 + min);
	}

	private int getRandom(int max) {
		return (int)(Math.random() * max + 1);
	}
}
