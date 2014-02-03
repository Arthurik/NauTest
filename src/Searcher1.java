/*
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Searcher1 implements ISearcher
{
    String[] res = new String[12];
    Map<String, Long> map = new TreeMap<String, Long>();
    Map<Long, String> newMap  = new HashMap<Long, String>(new Comparator<Long>(){
        @Override
        public int compare(String o1, String o2) {
            return (int) o1.compareTo(o2);
        }
    });






    public String[] guess(String start)
    {

        Set set = map.entrySet();
        Iterator i = set.iterator();

        while((i.hasNext())  ){
                if(newMap.size()<12){
            Map.Entry m = (Map.Entry) i.next();
            String key = (String) m.getKey();
            if(mapVal(key,start)){
                String newValue = (String) m.getKey();
                Long newKey = (Long) m.getValue();
                newMap.put(newKey, newValue);

            }
                } else { break;  }
        }


        int j=0;
       for(Map.Entry e : newMap.entrySet()){

          res[j] = (String) e.getValue();
              j++;
        }
     /*   Set st = newMap.entrySet();
        Iterator it = st.iterator();
        while (it.hasNext()){
            Map.Entry me = (Map.Entry) it.next();
            System.out.println(me.getValue());
            //res[j]= (String) me.getValue();

        }
 /       return res;
    }


   public Boolean mapVal(String st, String start){
        Pattern p = Pattern.compile("^"+start+".+");
        Matcher matcher = p.matcher(st);
        return matcher.matches();
    }
    @Override
    public void refresh(String[] classNames, long[] modificationDates)
    {

        for (int i=0;i<classNames.length;i++){
            map.put(classNames[i],modificationDates[i]);
        }
      //  Set st = map.entrySet();
      //  Iterator it = st.iterator();

       /* while(it.hasNext()){
            Map.Entry me = (Map.Entry) it.next();
            System.out.println(me.getKey()+" - "+me.getValue());
        }
/

    }



}

*/

