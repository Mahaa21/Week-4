import java.util.*;

public class VotingSystem {

    private Map<String, Integer> voteMap;
    private Map<String, Integer> linkedVoteMap;
    private Map<String, Integer> sortedVoteMap;

    public VotingSystem() {
        this.voteMap = new HashMap<>();
        this.linkedVoteMap = new LinkedHashMap<>();
        this.sortedVoteMap = new TreeMap<>();
    }

    public void castVote(String candidate) {

        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);

        linkedVoteMap.put(candidate, voteMap.get(candidate));

        sortedVoteMap.put(candidate, voteMap.get(candidate));
    }

    public void displayVotesInOrderOfCasting() {
        System.out.println("Votes in order of casting (LinkedHashMap): ");
        for (Map.Entry<String, Integer> entry : linkedVoteMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public void displaySortedVotes() {
        System.out.println("\nVotes in sorted order (TreeMap): ");
        for (Map.Entry<String, Integer> entry : sortedVoteMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public void displayTotalVotes() {
        System.out.println("\nTotal votes (HashMap): ");
        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public static void main(String[] args) {

        VotingSystem votingSystem = new VotingSystem();

        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");

        votingSystem.displayVotesInOrderOfCasting();
        votingSystem.displaySortedVotes();
        votingSystem.displayTotalVotes();
    }
}
