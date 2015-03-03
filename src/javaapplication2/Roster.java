
package javaapplication2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Roster implements Comparable<Roster>
{
    private String code;
    private Date date;
    private int duty;

    public Roster(String code, String date, int duty) 
    {
        this.code = code;
        this.date = strToDate(date); //TODO transform string here string format:  2015-02-19T00:00:00Z
        if (this.date==null)
            this.date = new Date();
        this.duty = duty;
    }   
    
    private Date strToDate(String date)
    {
        try{
        String str = date.trim().substring(0, 10);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
        Date dateObj= format.parse(str);
        //System.out.println("Contrutor:"+dateObj);
        return dateObj;
        }catch(ParseException ex)
        {
            System.out.println(ex.getMessage());
        }
        return null;
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

    @Override
    public int compareTo(Roster o) 
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return getDate().compareTo(o.getDate());
    }
        
}
