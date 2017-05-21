package ArrayGroup;

/**
 * Created by Wei on 2017/5/22.
 */
public class IslandPerimeter {
    public int perimeter(int[][] grid){
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int islands = 0; int neighbours = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    islands++;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        neighbours++;
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1){
                        neighbours++;
                    }
                }
            }
        }
        return 4*islands - 2 * neighbours;
    }
}
