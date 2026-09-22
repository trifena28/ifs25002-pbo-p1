import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membaca ukuran matriks
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Membaca elemen-elemen matriks
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // 1. Kasus Khusus 1x1
        if (n == 1) {
            int nilai = matrix[0][0];
            System.out.println("Nilai L: Tidak Ada");
            System.out.println("Nilai Kebalikan L: Tidak Ada");
            System.out.println("Nilai Tengah: " + nilai);
            System.out.println("Perbedaan: Tidak Ada");
            System.out.println("Dominan: " + nilai);
            return;
        }

        // 2. Kasus Khusus 2x2
        if (n == 2) {
            int total = matrix[0][0] + matrix[0][1] + matrix[1][0] + matrix[1][1];
            System.out.println("Nilai L: Tidak Ada");
            System.out.println("Nilai Kebalikan L: Tidak Ada");
            System.out.println("Nilai Tengah: " + total);
            System.out.println("Perbedaan: Tidak Ada");
            System.out.println("Dominan: " + total);
            return;
        }

        // 3. Kasus Matriks >= 3x3

        // --- Menghitung Nilai L ---
        // Seluruh kolom pertama (j = 0) + baris terakhir kecuali sel kanan bawah (i = N-1, j dari 1 s/d N-2)
        int nilaiL = 0;
        for (int i = 0; i < n; i++) {
            nilaiL += matrix[i][0];
        }
        for (int j = 1; j < n - 1; j++) {
            nilaiL += matrix[n - 1][j];
        }

        // --- Menghitung Nilai Kebalikan L ---
        // Seluruh kolom terakhir (j = N-1) + baris pertama kecuali sel kiri atas (i = 0, j dari 1 s/d N-2)
        int nilaiKebalikanL = 0;
        for (int i = 0; i < n; i++) {
            nilaiKebalikanL += matrix[i][n - 1];
        }
        for (int j = 1; j < n - 1; j++) {
            nilaiKebalikanL += matrix[0][j];
        }

        // --- Menghitung Nilai Tengah ---
        int nilaiTengah = 0;
        if (n % 2 != 0) {
            // Ukuran Ganjil (3x3, 5x5, dst)
            nilaiTengah = matrix[n / 2][n / 2];
        } else {
            // Ukuran Genap (4x4, 6x6, dst): Blok 2x2 di pusat
            int mid1 = (n / 2) - 1;
            int mid2 = n / 2;
            nilaiTengah = matrix[mid1][mid1] + matrix[mid1][mid2]
                        + matrix[mid2][mid1] + matrix[mid2][mid2];
        }

        // --- Menghitung Perbedaan ---
        int perbedaan = Math.abs(nilaiL - nilaiKebalikanL);

        // --- Menentukan Nilai Dominan ---
        int dominan;
        if (perbedaan == 0) {
            dominan = nilaiTengah;
        } else {
            dominan = Math.max(nilaiL, nilaiKebalikanL);
        }

        // --- Menampilkan Output ---
        System.out.println("Nilai L: " + nilaiL);
        System.out.println("Nilai Kebalikan L: " + nilaiKebalikanL);
        System.out.println("Nilai Tengah: " + nilaiTengah);
        System.out.println("Perbedaan: " + perbedaan);
        System.out.println("Dominan: " + dominan);

        scanner.close();
    }
}