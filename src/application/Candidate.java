package application;

import java.util.Map;
import java.util.Objects;

public class Candidate {

	private String candidateName;
	private Integer votesAmount;

	public Candidate(String candidateName, Integer votesAmount) {
		this.candidateName = candidateName;
		this.votesAmount = votesAmount;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public Integer getVotesAmount() {
		return votesAmount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(candidateName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidate other = (Candidate) obj;
		return Objects.equals(candidateName, other.candidateName);
	}

	public Integer sumVotes(Candidate candidate, Map<Candidate, Integer> total) {
		Integer sum = getVotesAmount();
		if (total.containsKey(candidate)) {
			sum += total.get(candidate);
		}
		return sum;
	}
	
	
	
	/*
	public Integer sumVotes(String candidateName, Integer votesAmount) {
		Integer sum = 0;
		Candidate other = new Candidate(candidateName, votesAmount);
		if (candidateName.compareTo(other.getCandidateName()) == 0) {
			sum += votesAmount;
		}
		return sum;
	}
	*/
}
