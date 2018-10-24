package p07_foodShortage.models.contracts;

public interface Citizen extends Buyer, People {

    String getId();

    String getBirthdate();
}
