import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        Set<Integer> col = new HashSet<>();
        Set<Integer> pDiag = new HashSet<>();
        Set<Integer> nDiag = new HashSet<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(0, n, board, col, pDiag, nDiag, res);
        return res;
    }

    private void backtrack(int r, int n, char[][] board, Set<Integer> col, Set<Integer> pDiag, Set<Integer> nDiag, List<List<String>> res) {
        if (r == n) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(new String(board[i]));
            }
            res.add(solution);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col.contains(c) || pDiag.contains(r + c) || nDiag.contains(r - c)) {
                continue;
            }

            col.add(c);
            pDiag.add(r + c);
            nDiag.add(r - c);
            board[r][c] = 'Q';

            backtrack(r + 1, n, board, col, pDiag, nDiag, res);

            col.remove(c);
            pDiag.remove(r + c);
            nDiag.remove(r - c);
            board[r][c] = '.';
        }
    }

    public static void main(String[] args) {
        Leetcode51 solution = new Leetcode51();
        List<List<String>> result = solution.solveNQueens(4);

        for (List<String> board : result) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
