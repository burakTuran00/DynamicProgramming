import java.util.HashMap;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {

    }

    public static int countPaths(List<List<String>> grid)
    {
        return  countPaths(0,0,grid, new HashMap<>());
    }

    public static int countPaths(int r , int c,  List<List<String>> grid, HashMap<List<Integer>, Integer> memory)
    {
        if(r == grid.size() || c == grid.get(0).size())
        {
            return 0;
        }

        if(grid.get(r).get(c).equals("X"))
        {
            return 0;
        }

        if(r == grid.size() -1 && c == grid.get(0).size() - 1)
        {
            return 1;
        }

        List<Integer> pos = List.of(r, c);

        if(memory.containsKey(pos))
        {
            return memory.get(pos);
        }

        int result =  countPaths(r+1,c,grid, memory) + countPaths(r, c+1,grid, memory);
        memory.put(pos, result);
        return result;
    }
}