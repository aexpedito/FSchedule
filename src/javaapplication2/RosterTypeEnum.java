/*
Duty Types legend
1 On Duty
2 Standby
3 Training
4 Proceeding
5 Admin
6 Vacation
7 Sick
8 Off
9 36h
10 On Duty-Unassigned
11 Standby-Unassigned
12 Ground
13 Ground-Unassigned
14 Travel
15 Travel-Unassigned
*/

package javaapplication2;


public enum RosterTypeEnum 
{
    CALL(0),
    ONDUTY(1),
    STANDBY(2),
    TRAINING(3),
    PROCEEDING(4),
    ADMIN(5),
    VACATION(6),
    SICK(7),
    OFF(8),
    A36H(9),
    ONDUTYU(10),
    STANDBYU(11),
    GROUND(12),
    GROUNDU(13),
    TRAVEL(14),
    TRAVELU(15); 
    
    private int value;
    
    private RosterTypeEnum(int value)
    {
        this.value=value;
    }
    
    public int getValue()
    {
        return this.value;
    }
    
    public String getLabel(int val)
    {
        switch (val)
        {
            case 1:
                return RosterTypeEnum.ONDUTY.toString();                
            case 2:
                return RosterTypeEnum.STANDBY.toString();
            case 3:
                return RosterTypeEnum.TRAINING.toString();
            case 4:
                return RosterTypeEnum.PROCEEDING.toString();
            case 5:
                return RosterTypeEnum.ADMIN.toString();
            case 6:
                return RosterTypeEnum.VACATION.toString();
            case 7:
                return RosterTypeEnum.SICK.toString();
            case 8:
                return RosterTypeEnum.OFF.toString();
            case 9:
                return RosterTypeEnum.A36H.toString();
            case 10:
                return RosterTypeEnum.ONDUTYU.toString();
            case 11:
                return RosterTypeEnum.STANDBYU.toString();
            case 12:
                return RosterTypeEnum.GROUND.toString();
            case 13:
                return RosterTypeEnum.GROUNDU.toString();
            case 14:
                return RosterTypeEnum.TRAVEL.toString();
            case 15:
                return RosterTypeEnum.TRAVELU.toString();
            default:
                return "Nothing";
        }
    }
};

