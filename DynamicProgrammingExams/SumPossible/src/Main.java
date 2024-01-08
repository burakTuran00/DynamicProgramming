import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(2);
        list.add(5);

        System.out.println("\n" + sumPossible(9, list));
    }
    public static boolean sumPossible(int amount , List<Integer> numbers)
    {
        return sumPossible(amount,numbers, new HashMap<>());
    }
    public static boolean sumPossible(int amount , List<Integer> numbers, HashMap<Integer, Boolean> memory)
    {
        if(amount == 0) {
            return true;
        }

        if(amount < 0){
            return false;
        }

        if(memory.containsKey(amount)){
            return memory.get(amount);
        }

        for(int num : numbers)
        {
            int subAmount = amount - num;

            if(sumPossible(subAmount, numbers, memory))
            {
                System.out.print(num + " ");
                memory.put(amount, true);
                return true;
            }
        }
        memory.put(amount, false);
        return false;
    }
}