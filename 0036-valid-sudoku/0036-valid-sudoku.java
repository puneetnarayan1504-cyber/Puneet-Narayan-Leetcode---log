class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') {
                    continue;
                }

                int digitIndex = ch - '1';
                int boxIndex = (r / 3) * 3 + (c / 3);

                if (rows[r][digitIndex] || cols[c][digitIndex] || boxes[boxIndex][digitIndex]) {
                    return false;
                }

                rows[r][digitIndex] = true;
                cols[c][digitIndex] = true;
                boxes[boxIndex][digitIndex] = true;
            }
        }

        return true;
    }
}