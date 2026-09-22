 import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> counts = new HashMap<>();

        // Membaca input baris demi baris
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            
            // Lewati baris kosong
            if (line.isEmpty()) {
                continue;
            }
            
            // Berhenti jika menemukan tanda ---
            if (line.equals("---")) {
                break;
            }

            // Parsing angka
            try {
                int val = Integer.parseInt(line);
                counts.put(val, counts.getOrDefault(val, 0) + 1);
            } catch (NumberFormatException e) {
                // Mengabaikan input yang bukan angka jika ada
            }
        }

        // Jika tidak ada data angka yang masuk, program langsung selesai
        if (counts.isEmpty()) {
            scanner.close();
            return;
        }

        List<Integer> keys = new ArrayList<>(counts.keySet());

        // 1. Nilai Tertinggi dan Terendah
        int tertinggi = Collections.max(keys);
        int terendah = Collections.min(keys);

        // Inisialisasi variabel statistik
        int terbanyak = keys.get(0);
        int tersedikit = keys.get(0);
        int jumlahTertinggi = keys.get(0);
        int jumlahTerendah = keys.get(0);

        for (int k : keys) {
            int freqK = counts.get(k);
            long prodK = (long) k * freqK;

            // 2. Terbanyak (Frekuensi terbesar; jika seri, pilih nilai lebih besar)
            int freqTerbanyak = counts.get(terbanyak);
            if (freqK > freqTerbanyak || (freqK == freqTerbanyak && k > terbanyak)) {
                terbanyak = k;
            }

            // 3. Tersedikit (Frekuensi terkecil; jika seri, pilih nilai lebih kecil)
            int freqTersedikit = counts.get(tersedikit);
            if (freqK < freqTersedikit || (freqK == freqTersedikit && k < tersedikit)) {
                tersedikit = k;
            }

            // 4. Jumlah Tertinggi (nilai * frekuensi terbesar; jika seri, pilih nilai lebih besar)
            long prodJumlahTertinggi = (long) jumlahTertinggi * counts.get(jumlahTertinggi);
            if (prodK > prodJumlahTertinggi || (prodK == prodJumlahTertinggi && k > jumlahTertinggi)) {
                jumlahTertinggi = k;
            }

            // 5. Jumlah Terendah (nilai * frekuensi terkecil; jika seri, pilih nilai lebih kecil)
            long prodJumlahTerendah = (long) jumlahTerendah * counts.get(jumlahTerendah);
            if (prodK < prodJumlahTerendah || (prodK == prodJumlahTerendah && k < jumlahTerendah)) {
                jumlahTerendah = k;
            }
        }

        // Menampilkan Output
        System.out.println("Tertinggi: " + tertinggi);
        System.out.println("Terendah: " + terendah);
        System.out.println("Terbanyak: " + terbanyak + " (" + counts.get(terbanyak) + "x)");
        System.out.println("Tersedikit: " + tersedikit + " (" + counts.get(tersedikit) + "x)");
        System.out.println("Jumlah Tertinggi: " + jumlahTertinggi + " * " + counts.get(jumlahTertinggi) + " = " + ((long) jumlahTertinggi * counts.get(jumlahTertinggi)));
        System.out.println("Jumlah Terendah: " + jumlahTerendah + " * " + counts.get(jumlahTerendah) + " = " + ((long) jumlahTerendah * counts.get(jumlahTerendah)));

        scanner.close();
    }
}