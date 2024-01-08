import java.util.HashMap;

public class Main
{
    private static HashMap<Integer, Integer> hashMap = new HashMap<>();
    private static final int NUMBER = 8;

    public static void main(String[] args)
    {
        for(int i = 0 ; i < NUMBER; i++)
        {
            System.out.print(fib(i) + " ");
        }
    }
    public static int fib(int n)
    {
        return fib(n, hashMap);
    }
    public static int fib(int n, HashMap<Integer, Integer> memory)
    {
        if(n == 0 || n == 1)
        {
            return n;
        }
        if(memory.containsKey(n))
        {
            return memory.get(n);
        }

        int result =  fib(n - 1, memory) + fib(n - 2, memory);
        memory.put(n, result);

        return result;
    }
}
// Time complexity: O(n)
// Space complexity: O(m)