package p04_recharge;

import p04_recharge.contracts.Rechargeable;
import p04_recharge.models.MyRobot;
import p04_recharge.models.RechargeStation;

public class Main {
    public static void main(String[] args) {

        Rechargeable myRobot = new MyRobot("3", 10);

        RechargeStation rechargeStation = new RechargeStation();
        
        rechargeStation.recharge(myRobot);

    }
}
