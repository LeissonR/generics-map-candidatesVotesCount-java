package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Map<Candidate, Integer> total = new HashMap<>();

		System.out.print("Enter file full path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();

			while (line != null) {
				String[] fields = line.split(",");
				String candidateName = fields[0];
				Integer votesAmount = Integer.parseInt(fields[1]);

				Candidate candidate = new Candidate(candidateName, votesAmount);
				Integer totalVotes = candidate.sumVotes(candidate, total);
				
				total.put(candidate, totalVotes);
				line = br.readLine();
			}

			for (Candidate key : total.keySet()) {
				System.out.println(key.getCandidateName() + ": " + total.get(key));
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}

}
