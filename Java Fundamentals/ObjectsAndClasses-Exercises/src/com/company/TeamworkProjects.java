package com.company;
//with TreeMap, working 100%. in Judge 87/100 with one "clock"
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TeamworkProjects {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, TreeMap<String, List<String>>> teamCreatorMembers = new TreeMap<>();
        TreeMap<String, Integer> teamMembersCount = new TreeMap<>();

        int numberOfTeams = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfTeams; i++) {
            String[] newTeamArr = reader.readLine().split("[-]");
            AddNewTeam(newTeamArr, teamCreatorMembers);
        }

        String joiner = reader.readLine();
        while (!joiner.equals("end of assignment")) {
            String[] joiners = joiner.trim().split("->");
            UpdateAddNewMembers(teamCreatorMembers, joiners, teamMembersCount);

            joiner = reader.readLine();
        }

        List<String> disbanTeams = new ArrayList<>();
        CheckForEmptyTeams(teamCreatorMembers, disbanTeams);

        Print(teamCreatorMembers, disbanTeams, teamMembersCount);
    }

    private static void Print(TreeMap<String, TreeMap<String, List<String>>> teamCreatorMembers, List<String> disbanTeams, TreeMap<String, Integer> teamMembersCount)
    {
        ArrayList<String> teamsSort = new ArrayList<>();
        teamMembersCount.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> teamsSort.add(k.getKey()));

        for (int i = 0; i < teamsSort.size(); i++) {
            System.out.println(teamsSort.get(i));
            for (String creator : teamCreatorMembers.get(teamsSort.get(i)).keySet()) {
                System.out.println(String.format("- %s", creator));
                for (int j = 0; j < teamCreatorMembers.get(teamsSort.get(i)).get(creator).size(); j++) {
                    System.out.println(String.format("-- %s", teamCreatorMembers.get(teamsSort.get(i)).get(creator).get(j)));
                }
            }
        }

        System.out.println("Teams to disband:");
        for (int i = 0; i < disbanTeams.size(); i++) {
            System.out.println(disbanTeams.get(i));
        }
    }

    private static void CheckForEmptyTeams(TreeMap<String, TreeMap<String, List<String>>> teamCreatorMembers, List<String> disbanTeams)
    {
        //Checking for empty teams and if have add them to disbanTeams
        for (String team : teamCreatorMembers.keySet()) {
            for (String creator : teamCreatorMembers.get(team).keySet()) {
                if (teamCreatorMembers.get(team).get(creator).size() == 0) {
                    disbanTeams.add(team);
                }
            }
        }
        //Erase all disbanTeams from teamCreatorMembers Map
        for (String disbanTeam : disbanTeams) {
            teamCreatorMembers.remove(disbanTeam);
        }
    }

    private static void UpdateAddNewMembers(TreeMap<String, TreeMap<String, List<String>>> teamCreatorMembers, String[] joiners, TreeMap<String, Integer> teamMembersCount)
    {
        String joinName = joiners[0];
        String teamChoice = joiners[1];

        if (!teamCreatorMembers.containsKey(teamChoice)) {
            System.out.println(String.format("Team %s does not exist!", teamChoice));
        }
        else if (CheckForThisMember(teamCreatorMembers, joinName)) {
            System.out.println(String.format("Member %s cannot join team %s!", joinName, teamChoice));
        }
        else {
            for (String creator : teamCreatorMembers.get(teamChoice).keySet()) {
                teamCreatorMembers.get(teamChoice).get(creator).add(joinName);
                Collections.sort(teamCreatorMembers.get(teamChoice).get(creator));
            }

            if (!teamMembersCount.containsKey(teamChoice)) {
                int count = 1;
                teamMembersCount.put(teamChoice, count);
            } else {
                int count = teamMembersCount.get(teamChoice) + 1;
                teamMembersCount.replace(teamChoice, count);
            }
        }
    }

    private static boolean CheckForThisMember(TreeMap<String, TreeMap<String, List<String>>> teamCreatorMembers, String joinName)
    {
        boolean isAlreadyMember = false;

        for (String team : teamCreatorMembers.keySet()) {
            if (teamCreatorMembers.get(team).containsKey(joinName)) {
                isAlreadyMember = true;
                break;
            }
            for (String creator : teamCreatorMembers.get(team).keySet()) {
                if (teamCreatorMembers.get(team).get(creator).contains(joinName)) {
                    isAlreadyMember = true;
                    break;
                }
            }
        }

        return isAlreadyMember;
    }

    private static void AddNewTeam(String[] newTeamArr, TreeMap<String, TreeMap<String, List<String>>> teamCreatorMembers)
    {
        String creatorName = newTeamArr[0];
        String teamName = newTeamArr[1];
        if (teamCreatorMembers.containsKey(newTeamArr[1])) {
            System.out.println(String.format("Team %s was already created!", teamName));
        }
        else if (CheckIsOldCreator(teamCreatorMembers, newTeamArr[0])) {
            System.out.println(String.format("%s cannot create another team!", creatorName));
        }
        else {
            teamCreatorMembers.put(teamName, new TreeMap<>());
            teamCreatorMembers.get(teamName).put(creatorName, new ArrayList<>());
            System.out.println(String.format("Team %s has been created by %s!", teamName, creatorName));
        }
    }

    private static boolean CheckIsOldCreator(TreeMap<String, TreeMap<String, List<String>>> teamCreatorMembers, String creatorName)
    {
        boolean isOldCreator = false;

        for (String team : teamCreatorMembers.keySet()) {
            for (String creator : teamCreatorMembers.get(team).keySet()) {
                if (creator.equals(creatorName)) {
                    isOldCreator = true;
                }

                for (int i = 0; i < teamCreatorMembers.get(team).get(creator).size(); i++) {
                    if (teamCreatorMembers.get(team).get(creator).get(i).equals(creatorName)) {
                        isOldCreator = true;
                    }
                }

            }
        }

        return isOldCreator;
    }

}


//*********** TESTs ***********

//2
//Didi-PowerPuffsCoders
//Toni-Toni is the best
//Petq->PowerPuffsCoders
//Toni->Toni is the best
//end of assignment

//7
//Did-PowerCoders
//Tonii-Tonii is the best
//Didi-PowerPuffsCoders
//Toni-Toni is the best
//Tatyana-CloneClub
//Helena-CloneClub
//Trifon-AiNaBira
//Pesho->aiNaBira
//Pesho->AiNaBira
//Tatyana->Leda
//PeshO->AiNaBira
//Cossima->CloneClub
//P3sho->AiNaBira
//Tatyan4eto->Leda
//PeeshO->AiNaaBira
//Cosima->CloneClub
//end of assignment

//****************************