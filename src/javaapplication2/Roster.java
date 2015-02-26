
package javaapplication2;

import java.util.Date;


public class Roster 
{
    private String code;
    private Date date;
    private int duty;

    public Roster(String code, String date, int duty) 
    {
        this.code = code;
        this.date = date; //TODO transform string here string format:  2015-02-19T00:00:00Z
        this.duty = duty;
    }   
    
    private String strToDate(String date)
    {
        String str = date.trim();
        
    }
    
    public String getCode() 
    {
        return code;
    }

    public void setCode(String code) 
    {
        this.code = code;
    }

    public Date getDate() 
    {
        return date;
    }

    public void setDate(Date date) 
    {
        this.date = date;
    }

    public int getDuty() 
    {
        return duty;
    }

    public void setDuty(int duty) 
    {
        this.duty = duty;
    }
        
}
