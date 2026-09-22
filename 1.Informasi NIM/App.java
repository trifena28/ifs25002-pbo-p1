 import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membaca NIM
        String nim = scanner.nextLine().trim();

        // Mengecek panjang NIM
        if (nim.length() != 8) {
            System.out.println("NIM harus 8 karakter");
            return;
        }

        // Mengambil 3 karakter pertama sebagai prefix
        String prefix = nim.substring(0, 3);

        String programStudi;

        // Menentukan program studi berdasarkan prefix
        switch (prefix) {
            case "11S":
                programStudi = "Sarjana Informatika";
                break;

            case "12S":
                programStudi = "Sarjana Sistem Informasi";
                break;

            case "13S":
                programStudi = "Sarjana Teknik Elektro";
                break;

            case "21S":
                programStudi = "Sarjana Manajemen Rekayasa";
                break;

            case "22S":
                programStudi = "Sarjana Teknik Metalurgi";
                break;

            case "31S":
                programStudi = "Sarjana Teknik Bioproses";
                break;

            case "32S":
                programStudi = "Sarjana Bioteknologi";
                break;

            case "114":
                programStudi = "Diploma 4 Teknologi Rekayasa Perangkat Lunak";
                break;

            case "113":
                programStudi = "Diploma 3 Teknologi Informasi";
                break;

            case "133":
                programStudi = "Diploma 3 Teknologi Komputer";
                break;

            default:
                System.out.println("Kode tidak tersedia");
                return;
        }

        // Mengambil karakter indeks 3-4 sebagai kode angkatan
        String kodeAngkatan = nim.substring(3, 5);

        // Menambahkan 20 di depan kode angkatan
        int angkatan = Integer.parseInt("20" + kodeAngkatan);

        // Mengambil 3 karakter terakhir sebagai nomor urut
        int urutan = Integer.parseInt(nim.substring(5, 8));

        // Menampilkan hasil
        System.out.println("Informasi NIM " + nim + ": ");
        System.out.println(">> Program Studi: " + programStudi);
        System.out.println(">> Angkatan: " + angkatan);
        System.out.println(">> Urutan: " + urutan);
    }
}