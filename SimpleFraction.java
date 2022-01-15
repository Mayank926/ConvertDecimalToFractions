
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SimpleFraction
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int numerator = Integer.parseInt(S[0]);
            int denominator = Integer.parseInt(S[1]);
            SolutionClass ob = new SolutionClass();
            String ans = ob.fractionToDecimal(numerator, denominator);
            System.out.println(ans);
        }
    }
}

class SolutionClass
{
    public String  fractionToDecimal(int numerator, int denominator)
    {
        if(numerator%denominator == 0){
            return ""+(numerator/denominator);
        }
        int quot = numerator/denominator;
        int rem = numerator%denominator;
        StringBuilder fractionPart = new StringBuilder();
        Map<Integer,Integer> remainders = new HashMap<>();
        int idxCount=0;
        remainders.put(rem,idxCount++);
        while(rem>0){
            rem*=10;
            int nextdigit=rem/denominator;
            fractionPart.append(nextdigit);
            rem%=denominator;
            if(remainders.containsKey(rem)){
                fractionPart.append(")");
                int remFirstIndex = remainders.get(rem);
                fractionPart.insert(remFirstIndex,"(");
                break;
            }
            remainders.put(rem,idxCount++);
        }
        return ""+quot+"."+fractionPart.toString();
    }
}
