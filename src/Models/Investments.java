package Models;

import java.sql.Date;

public class Goal {
    private int idGoal;
    private String nameGoal;
    private Date dateGoal;
    private double balanceGoal;
}

public int getIdGoal() {
    return idGoal;
}

public void setIdGoal(int idGoal) {
    this.idGoal = idGoal;
}

public String getNameGoal() {
    return nameGoal;
}

public void setNameGoal(String nameGoal) {
    this.nameGoal = nameGoal;
}

public Date getDateGoal() {
    return dateGoal;
}

public void setDateGoal(Date dateGoal) {
    this.dateGoal = dateGoal;
}

public double getBalanceGoal() {
    return balanceGoal;
}

public void setBalanceGoal(double balanceGoal) {
    this.balanceGoal = balanceGoal;
}