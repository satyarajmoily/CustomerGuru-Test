import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.SimpleDateFormat;  
import java.util.Date; 
import java.text.DateFormat;

class GenerateDate
{
    
    public static GenaratedDate generate(String from, String to) throws Exception{
        Date fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(from);
        Date toDay = new SimpleDateFormat("yyyy-MM-dd").parse(to);

        //Todays date
        java.util.Date todayDay= new Date();
        Calendar todayCal = Calendar.getInstance();
        todayCal.setTime(todayDay);
        int todayYear = todayCal.get(Calendar.YEAR);
        int todayMonth = todayCal.get(Calendar.MONTH)+1;
        int todayDate = todayCal.get(Calendar.DATE);

        //from date
        Calendar fromCal = Calendar.getInstance();
        fromCal.setTime(fromDate);
        int fromYear = fromCal.get(Calendar.YEAR);
        int fromMonth = fromCal.get(Calendar.MONTH)+1;
        
        //To date
        Calendar toCal = Calendar.getInstance();
        toCal.setTime(toDay);
        int toYear = toCal.get(Calendar.YEAR);
        int toMonth = toCal.get(Calendar.MONTH)+1;
        int toDate = toCal.get(Calendar.DATE);
        
        String finalFrom = fromYear+"-"+fromMonth+"-"+"01";
        String finalTo;
        if(toYear == todayYear)
        {
            if(toMonth >= todayMonth)
            {
                  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                   finalTo = dateFormat.format(todayDay);
            }else{
                finalTo = toYear+"-"+toMonth+"-"+toCal.getActualMaximum(Calendar.DATE);
                }
        }else if(toYear > todayYear){
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                   finalTo = dateFormat.format(todayDay);
        }
        else{
            finalTo = toYear+"-"+toMonth+"-"+toCal.getActualMaximum(Calendar.DATE);
           
        }
        
             return new GenaratedDate(finalFrom,finalTo);
    }
    static class GenaratedDate{
        String fromDate;
        String toDate;
           GenaratedDate(String fromDate, String toDate){
               this.fromDate = fromDate;
               this.toDate = toDate;
           }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		
		String from  = "2016-09-11";
		String to    = "2017-03-20";
		
	    GenaratedDate date = generate(from,to);
	    
	    System.out.println("fromdatereturns: "+date.fromDate);
	    System.out.println("todatereturns: "+date.toDate);
		
	}
}
