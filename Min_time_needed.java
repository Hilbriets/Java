package Grid_method;
import java.util.*;
public class Min_time_needed {
	private static final int r_c=20;
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right, down, left, up
	
    private static class Drone 
    {
        int startX, startY, endX, endY, startTime;
        List<int[]> path;

        public Drone(int startX, int startY, int endX, int endY, int startTime) 
        {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
            this.startTime = startTime;
            this.path = new ArrayList<>();
            this.path.add(new int[]{startX, startY});
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int[] pos : path) {
                sb.append(Arrays.toString(pos)).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append("]");
            return sb.toString();
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

        List<Drone> drones = new ArrayList<>();
        drones.add(new Drone(0, 0, 1, 1, 0)); // example input
        drones.add(new Drone(3, 3, 1, 1, 5)); // example input

        int[][] grid = new int[r_c][r_c];
        for (Drone drone : drones) {
            grid[drone.startX][drone.startY] = drone.startTime + 1;
        }

        PriorityQueue<Drone> pq = new PriorityQueue<>(Comparator.comparingInt(d -> d.startTime));

        for (Drone drone : drones) {
            pq.offer(drone);
        }

        while (!pq.isEmpty()) {
            Drone curr = pq.poll();

            if (curr.startX == curr.endX && curr.startY == curr.endY) {
                continue; // drone has already reached its destination
            }

            int minDist = Integer.MAX_VALUE;
            int[] bestDir = null;

            for (int[] dir : DIRS) {
                int x = curr.startX + dir[0];
                int y = curr.startY + dir[1];
                int t = curr.startTime + 1;

                if (x < 0 || x >= r_c || y < 0 || y >= r_c) {
                    continue; // out of bounds
                }

                if (grid[x][y] != 0 && grid[x][y] <= t) {
                    continue; // collision with another drone or obstacle
                }

                int dist = Math.abs(x - curr.endX) + Math.abs(y - curr.endY);
                if (dist < minDist) {
                    minDist = dist;
                    bestDir = dir;
                }
            }

            if (bestDir != null) {
                int newX = curr.startX + bestDir[0];
                int newY = curr.startY + bestDir[1];
                int newT = curr.startTime + 1;
                curr.startX = newX;
                curr.startY = newY;
                curr.startTime = newT;
                System.out.println(newX+" "+newY);
                curr.path.add(new int[]{newX, newY});
                grid[newX][newY] = newT + 1;
                pq.offer(curr);
            }
        }

        for (Drone drone : drones) {
            System.out.println("Drone path: " + drone.path.toString());
        
	}
	}
}
