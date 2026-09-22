import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Jika tidak ada input sama sekali
        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }

        String inputJam = scanner.nextLine().trim();

        // Validasi Format Jam Awal
        String[] parts = inputJam.split(":");
        if (parts.length != 2) {
            System.out.println("Jam tidak valid");
            scanner.close();
            return;
        }

        int jam, menit;
        try {
            jam = Integer.parseInt(parts[0].trim());
            menit = Integer.parseInt(parts[1].trim());
        } catch (NumberFormatException e) {
            System.out.println("Jam tidak valid");
            scanner.close();
            return;
        }

        if (jam < 0 || jam > 23 || menit < 0 || menit > 59) {
            System.out.println("Jam tidak valid");
            scanner.close();
            return;
        }

        // Variabel Perhitungan
        int totalMenitAwal = jam * 60 + menit;
        int currentMenit = totalMenitAwal;
        int totalMenitGeser = 0;
        int pergantianHari = 0;

        // Membaca Perintah Geser
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            if (line.equals("---")) {
                break;
            }

            // Validasi Perintah +N / -N
            if (!line.startsWith("+") && !line.startsWith("-")) {
                System.out.println("Perintah tidak valid");
                continue;
            }

            int n;
            try {
                n = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Perintah tidak valid");
                continue;
            }

            // Tambahkan nilai geser ke akumulator
            totalMenitGeser += n;

            // Pergeseran Menit Demi Menit untuk Menghitung Pergantian Hari
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    currentMenit++;
                    if (currentMenit == 1440) {
                        currentMenit = 0;
                        pergantianHari++;
                    }
                }
            } else if (n < 0) {
                for (int i = 0; i < Math.abs(n); i++) {
                    currentMenit--;
                    if (currentMenit < 0) {
                        currentMenit = 1439;
                        pergantianHari++;
                    }
                }
            }
        }

        // Konversi Menit Akhir ke Jam & Menit Output
        int jamAkhir = currentMenit / 60;
        int menitAkhir = currentMenit % 60;

        // Formatting Tanda Total Menit
        String strTotalMenit;
        if (totalMenitGeser > 0) {
            strTotalMenit = "+" + totalMenitGeser;
        } else {
            strTotalMenit = String.valueOf(totalMenitGeser);
        }

        // Cetak Hasil
        System.out.printf("Jam Awal: %02d:%02d%n", jam, menit);
        System.out.printf("Jam Akhir: %02d:%02d%n", jamAkhir, menitAkhir);
        System.out.println("Total Menit: " + strTotalMenit);
        System.out.println("Pergantian Hari: " + pergantianHari);

        scanner.close();
    }
}