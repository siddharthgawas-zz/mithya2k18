package org.pccegoa.mithya2k18.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Siddharth on 4/4/2018.
 */

public class EventFilter {

    public static List<Map<String,Object>> getEventsBetweenTime(Date t1, Date t2,
                                                             List<Map<String,Object>> events)
    {
        List<Map<String,Object>> temp  = new ArrayList<>();
        for (int i = 0 ; i < events.size();i++)
        {
            Map<String,Object> event = events.get(i);
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            try {
                Date date = format.parse((String) event.get("time"));
                if(date.after(t1) && date.before(t2))
                    temp.add(event);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        return temp;
    }
    public static List<Map<String,Object>> sort(List<Map<String,Object>> events)
    {
        List<Map<String,Object>> temp  = new ArrayList<>();
        for (int i = 0 ; i < events.size();i++)
        {
            Map<String,Object> event = events.get(i);
            if (i == 0)
            {
                temp.add(event);
                continue;
            }
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            try {
                Date date = format.parse((String) event.get("time"));
                boolean flagAdded = false;
                for(int j =0; j < temp.size();j++)
                {
                    Map<String,Object> event2 = temp.get(j);
                    Date date2 = format.parse((String)event2.get("time"));
                    if(date.before(date2))
                    {
                        temp.add(j,event);
                        flagAdded = true;
                        break;
                    }
                }
                if (!flagAdded)
                    temp.add(event);

            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        return temp;
    }
}
