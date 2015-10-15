package ShortestPath;

	class Point 
	{
		int x;
		int y;

		Point(int x, int y) 
		{
			this.x = x;
			this.y = y;	
		}
		//Prints path 
		public String toString() {
			return "[" + x + ", " + y + "]";
		}
	}
	public class ShortestPath
	{
		static int[][] Maze = {{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
					           {-1, 0,-1, 0, 0, 0, 0, 0, 0,-1},
					           {-1, 0,-1,-1, 0,-1,-1,-1,-1,-1},
					           {-1, 0,-1, 0, 0, 0, 0,-1, 0,-1},
					           {-1, 0, 0, 0,-1,-1, 0,-1, 0,-1},
					           {-1, 0,-1, 0,-1, 0, 0, 0, 0,-1},
					           {-1,-1,-1, 0,-1, 0,-1, 0,-1,-1},
					           {-1, 0,-1,-1,-1, 0,-1, 0, 0,-1},
				               {-1, 0, 0, 0, 0, 0,-1,-1, 0,-1},
					           {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}};

		public static void main(String[] args) 
		{
			Goal();
		}

		static void Goal() 
		{
			Queue<Point> Q = new Queue<Point>();
			//set current to the DistanceFromStart of the maze
			Point current = new Point(1,1); //keeps track of current position
			//add DistanceFromStart of maze to queue
			Q.enqueue(current);
			while (!Q.isEmpty()) 
			{	
				current = Q.dequeue();
				//keeps track of distance from the start of the maze
				int DistanceFromStart = Maze[current.y][current.x];
				//prints distance
				
				if (current.x == 8 && current.y == 8) 
				{
					// if goal found, resent maze to see if there is a shorter path
	                Maze[1][1] = 0;
					System.out.printf("Dist from Start %d\n", DistanceFromStart);
	                return;
				}
				//checks for valid moves, enqueues if it is tried to find goal through that path
				//go up
				if (Maze[current.y - 1][current.x] == 0) 
				{
					Maze[current.y - 1][current.x] = DistanceFromStart + 1;
					Q.enqueue(new Point(current.x, current.y - 1));
				}
				//go down
				if (Maze[current.y + 1][current.x] == 0) 
				{
					Maze[current.y + 1][current.x] = DistanceFromStart + 1;
					Q.enqueue(new Point(current.x, current.y + 1));
				}
				//go left
				if (Maze[current.y][current.x - 1] == 0) 
				{
					Maze[current.y][current.x - 1] = DistanceFromStart + 1;
					Q.enqueue(new Point(current.x - 1, current.y));
				}
				//go right
				if (Maze[current.y][current.x + 1] == 0) 
				{
					Maze[current.y][current.x + 1] = DistanceFromStart + 1;
					Q.enqueue(new Point(current.x + 1, current.y));
				}
			}
		}
	}

