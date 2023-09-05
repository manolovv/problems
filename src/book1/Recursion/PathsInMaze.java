package book1.Recursion;

public class PathsInMaze {

    private static char[][] lab ={
            {' ',' ',' ','*',' ',' ',' '},
            {'*','*',' ','*',' ','*',' '},
            {' ',' ',' ',' ',' ',' ',' '},
            {' ','*','*','*','*','*',' '},
            {' ',' ',' ',' ',' ',' ','e'},
    };
    private static char[] path = new char[lab[0].length * lab.length];
    private static int position = 0;
    private static void findPath(int row, int col, char direction) {
        if ((col < 0 || row < 0) ||
                (col >= lab[0].length) || row >= lab.length) {
            return;
        }
        path[position] = direction;
        position++;

        if (lab[row][col] == 'e') {
            printPath(path, 1, position - 1);
            return;
        }
        if (lab[row][col] == ' ') {
            lab[row][col] = 's';

            findPath(row, col + 1, 'R');
            findPath(row, col - 1, 'L');
            findPath(row + 1, col, 'U');
            findPath(row - 1, col, 'D');

            lab[row][col] = ' ';
        }
        position--;
    }

    private static void printPath(char[] path, int startPos, int endPos) {
        System.out.print("Found the way: ");
        for (int pos = startPos; pos <= endPos; pos++) {
            System.out.print(path[pos]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        findPath(0,0, 'S');
    }
}
