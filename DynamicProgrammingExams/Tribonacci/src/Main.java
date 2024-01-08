import java.util.HashMap;

public class Main
{
    private static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args)
    {
        double start = System.currentTimeMillis();

        for(int i = 0; i < 10; i++)
        {
            System.out.print(tribonacci(i) + " ");
        }

        double end = System.currentTimeMillis();

        System.out.println("\n" + (end-start) + "ms");
    }
    public static int tribonacci(int n)
    {
        return tribonacci(n, hashMap);
    }

    public static int tribonacci(int n, HashMap<Integer, Integer> memory)
    {
        if(n == 0 || n == 1)
        {
            return 0;
        }

        if(n == 2)
        {
            return 1;
        }

        if(memory.containsKey(n))
        {
            return memory.get(n);
        }

        int result = tribonacci(n - 1, memory) +  tribonacci(n - 2, memory) + tribonacci(n - 3, memory);
        memory.put(n, result);

        return result;
    }
}