import java.util.List;

public class TeamClass {
    private String teamName;
    private List<String> membersList;
    private String creatorName;

    public TeamClass(String teamName, List<String> membersList, String creatorName) {
        this.teamName = teamName;
        this.membersList = membersList;
        this.creatorName = creatorName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<String> getMembersList() {
        return membersList;
    }

    public void setMembersList(List<String> membersList) {
        this.membersList = membersList;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }


}
