import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("\n" + minChange(7, list));
    }

    private static int minChange(int amount, List<Integer> coins)
    {
        return minChange(amount, coins, new HashMap<>());
    }

    private static int minChange(int amount, List<Integer> coins, HashMap<Integer, Integer> memory)
    {
        if(amount == 0) {
            return 0;
        }

        if(amount < 0)
        {
            return -1;
        }

        if(memory.containsKey(amount))
        {
            return memory.get(amount);
        }

        int minCoins = -1;

        for(int coin : coins)
        {
            int subAmount = amount - coin;
            int subCoins = minChange(subAmount, coins, memory);

            if(subCoins != -1)
            {
                int numCoins = subCoins + 1;

                if(numCoins < minCoins || minCoins == -1)
                {
                    minCoins = numCoins;

                }
            }
        }

        memory.put(amount, minCoins);
        return minCoins;
    }
}