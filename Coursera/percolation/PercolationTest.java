import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PercolationTest {
    private final String OPEN = "open";
    private final String BLOCKED = "blocked";
    private int VIRTUAL_BOTTOM;
    private int n;

    @Test
    public void test_shouldThrowExceptionOutSideRange() {
        n = 10;
        Percolation percolation = new Percolation(n);
        assertThrows(IllegalArgumentException.class, () -> percolation.isOpen(0, 1));
        assertThrows(IllegalArgumentException.class, () -> percolation.isOpen(0, 0));
        assertThrows(IllegalArgumentException.class, () -> percolation.isOpen(n + 2, n + 2));
        assertThrows(IllegalArgumentException.class, () -> percolation.isFull(n, 0));
        assertThrows(IllegalArgumentException.class, () -> percolation.open(n + 2, 1));
    }


    @Test
    public void test_OpenInvalidArgs() {
        Percolation percolation = new Percolation(10);
        assertThrows(IllegalArgumentException.class, () -> percolation.open(-1, 5));
        assertThrows(IllegalArgumentException.class, () -> {
            percolation.open(-1, 5);
            percolation.open(11, 5);
            percolation.open(0, 5);
            percolation.open(5, -1);
            percolation.open(5, 11);
            percolation.open(-2147483648, -2147483648);
            percolation.open(2147483647, 2147483647);

            percolation.isOpen(-1, 5);
            percolation.isOpen(11, 5);
            percolation.isOpen(0, 5);
            percolation.isOpen(5, -1);
            percolation.isOpen(5, 11);
            percolation.isOpen(-2147483648, -2147483648);
            percolation.isOpen(2147483647, 2147483647);
        });
    }

    @Test
    public void test_shouldSetAllToBlocked() {
        n = 10;
        Percolation percolation = new Percolation(n);
        boolean isThereAnyNotBlocked = false;
        for (int i = 1; i < percolation.matrix.length - 1; i++) {
            for (int j = 1; j < percolation.matrix.length - 1; j++) {
                String element = percolation.matrix[i][j];
                if (!element.equals(BLOCKED)) {
                    isThereAnyNotBlocked = true;
                }
            }
        }
        assertFalse(isThereAnyNotBlocked);
    }

    @Test
    public void testOpen() {
        n = 5;

        Percolation percolation = new Percolation(n);

        assertEquals(percolation.wqu.count(), 27);
        assertEquals(percolation.wqu.find(9), 9);
        {
            int row1 = 1;
            int col1 = 1;
            int row2 = 1;
            int col2 = 2;

            percolation.open(row1, col1);
            percolation.open(row2, col2);

            assertEquals(percolation.matrix[row1][col1], OPEN);
            assertEquals(percolation.matrix[row2][col2], OPEN);

            int first = percolation.wqu.find(link2DTo1D(row1, col1));
            int second = percolation.wqu.find(link2DTo1D(row2, col2));

            assertEquals(first, second);
        }
        {
            int row1 = 1;
            int col1 = 1;
            int row2 = 2;
            int col2 = 1;

            percolation.open(row1, col1);
            percolation.open(row2, col2);

            assertEquals(percolation.matrix[row1][col1], OPEN);
            assertEquals(percolation.matrix[row2][col2], OPEN);

            int first = percolation.wqu.find(link2DTo1D(row1, col1));
            int second = percolation.wqu.find(link2DTo1D(row2, col2));

            assertEquals(first, second);
        }
    }

    @Test
    public void test_OpenMoreCases() {
        n = 5;
        Percolation percolation = new Percolation(n);


        int row2 = 2;
        int col3 = 3;
        int row3 = 3;

        percolation.open(row2, col3);
        percolation.open(row3, col3);

        int first = percolation.wqu.find(link2DTo1D(row2, col3));
        int second = percolation.wqu.find(link2DTo1D(row3, col3));

        assertEquals(first, second);

        int col1 = 1;
        percolation.open(row3, col1);

        assertNotEquals(percolation.wqu.find(link2DTo1D(row3, col1)), percolation.wqu.find(link2DTo1D(3, 2)));

        percolation.open(row3, 2);

        assertEquals(percolation.wqu.find(link2DTo1D(row3, col1)), percolation.wqu.find(link2DTo1D(3, 2)));
        assertEquals(percolation.wqu.find(link2DTo1D(row3, col3)), percolation.wqu.find(link2DTo1D(3, 2)));
    }


    @Test
    public void test_openBackwash() {
        Percolation percolation = new Percolation(3);
        percolation.open(1, 1);
        percolation.open(1, 2);
        percolation.open(1, 3);
        percolation.open(3, 3);

        assertFalse(percolation.isFull(3, 3));

    }

    @Test
    public void test_OpenVirtual() {
        n = 5;
        Percolation percolation = new Percolation(n);
        VIRTUAL_BOTTOM = n * n + 1;

        percolation.open(1, 4);
        percolation.open(1, 5);

        int first = percolation.wqu.find(link2DTo1D(1, 4));
        int second = percolation.wqu.find(link2DTo1D(1, 4));

        assertEquals(first, 0);
        assertEquals(second, 0);

        // bottom
        percolation.open(5, 4);
        percolation.open(5, 5);

        first = percolation.wqu.find(link2DTo1D(5, 4));
        second = percolation.wqu.find(link2DTo1D(5, 4));

        assertEquals(first, VIRTUAL_BOTTOM);
        assertEquals(second, VIRTUAL_BOTTOM);

        percolation.open(5, 1);
        percolation.open(5, 2);

        first = percolation.wqu.find(link2DTo1D(5, 1));
        second = percolation.wqu.find(link2DTo1D(5, 2));

        assertEquals(first, percolation.wqu.find(percolation.wqu.count()));
        assertEquals(second, percolation.wqu.find(percolation.wqu.count()));

    }

    @Test
    public void test_isFull() {
        Percolation percolation = new Percolation(5);
        percolation.open(1, 1);

        assertFalse(percolation.isFull(1, 2));

        percolation.open(2, 1);

        assertTrue(percolation.isFull(2, 1));

        percolation.open(3, 2);

        assertFalse(percolation.isFull(3, 2));

        percolation.open(3, 1);

        assertTrue(percolation.isFull(3, 2));
    }

    @Test
    public void test_isFull_2() {
        Percolation percolation = new Percolation(5);
        percolation.open(3, 4);
        percolation.open(3, 5);
        percolation.open(2, 5);
        percolation.open(1, 5);

        assertTrue(percolation.isFull(3, 4));
    }

    @Test
    public void test_open_sites() {
        int N = 5;
        Percolation percolation = new Percolation(N);
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                percolation.open(i, j);
            }
        }
        assertEquals(25, percolation.numberOfOpenSites());
    }

    @Test
    public void test_ifSystemPercolates() {
        Percolation percolation = new Percolation(5);
        percolation.open(1, 2);
        percolation.open(2, 2);
        percolation.open(3, 2);
        percolation.open(4, 2);
        percolation.open(5, 2);

        assertTrue(percolation.percolates());

        percolation = new Percolation(5);
        percolation.open(1, 2);
        percolation.open(2, 2);
        percolation.open(3, 2);
        percolation.open(5, 2);

        assertFalse(percolation.percolates());

        percolation = new Percolation(5);
        percolation.open(1, 3);
        percolation.open(2, 3);
        percolation.open(3, 3);
        percolation.open(3, 4);
        percolation.open(4, 4);
        percolation.open(5, 4);

        assertTrue(percolation.percolates());

    }
    //repeat method
    private int link2DTo1D(int row, int col) {
        return (n * row) - (n - (col - 1));
    }
}