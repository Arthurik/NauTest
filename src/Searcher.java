import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Searcher implements ISearcher {
        Set<Nau> set = new TreeSet<Nau>();


    @Override
    public void refresh(String[] classNames, long[] modificationDates) {

        for(int i=0; i<classNames.length;i++  ){
                set.add(new Nau(classNames[i], modificationDates[i]));
            }
    }

    @Override
    public String[] guess(String start) {
        String[] result = new String[12];

              Iterator s =  set.iterator();
                int i=0;
            while (s.hasNext()){


                if(i<12){
                    Nau n = (Nau) s.next();
                    String res = n.classNames;
                    if(compareClassName(res, start)){
                        result[i] = res;

                    i++;
                    }

                } else { break;  }
            }


        return result;
    }

    public Boolean compareClassName(String st, String start){
        Pattern p = Pattern.compile("^"+start+".+");
        Matcher matcher = p.matcher(st);
        return matcher.matches();
    }






    public class Nau implements Comparable {
        String classNames;
        Long modificationDates;

            public Nau (String classNames, Long modificationDates){
                this.classNames = classNames;
                this.modificationDates = modificationDates;
            }

        @Override
        public int compareTo(Object o) {
                Nau entry = (Nau) o;
            int res = (int) (entry.modificationDates - modificationDates);
            if(res != 0) {
                return (int) res / Math.abs( res );
            }

            res = classNames.compareTo(entry.classNames);
            if(res != 0) {
                return res;
            }
            return 0;
        }

    }
}