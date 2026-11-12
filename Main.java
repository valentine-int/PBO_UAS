import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
/*
 * Program Toko Media Digital - contoh INTERFACE vs ABSTRACT CLASS
 *
 * ABSTRACT CLASS : Media_Digital, Video, Audio
 *   -> punya atribut + method biasa + method abstract (hitungHarga)
 * INTERFACE      : Dapat_Diputar, Dapat_Diunduh
 *   -> hanya kontrak method, bisa dipakai banyak class sekaligus
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Variabel untuk menyimpan data
        Film film = new Film("Laskar Pelangi", "Riri Riza", 1800.5f, "MP4",
                LocalDate.of(2026, 3, 10), 35000f,
                125, "1080p", "16:9",
                "Drama", 2008, 4.6f);

        Musik musik = new Musik("Hati-Hati di Jalan", "Tulus", 8.2f, "MP3",
                LocalDate.of(2026, 4, 2), 12000f,
                4, 320, "Stereo",
                "Tulus", "Pop", 2022);

        Animasi anime = new Animasi("Petualangan Nusantara", "Studio Garuda", 9000f, "MKV",
                LocalDate.of(2026, 2, 15), 5000f,
                24, "1080p", "16:9",
                "Studio Garuda", "Aksi", 20);

        Podcast podcast = new Podcast("Ngobrol Santai", "Budi Santoso", 45.5f, "MP3",
                LocalDate.of(2026, 1, 20), 10000f,
                60, 128, "Stereo",
                "Budi Santoso", "Hiburan", 15);

        Media_Digital[] daftar = {film, musik, anime, podcast};
        ArrayList<Transaksi> riwayat = new ArrayList<>();
        Map<String, Media_Digital> katalog = new HashMap<>();

        for (Media_Digital media : daftar) {
            katalog.put(media.getJudul(), media);
        }

        int pilihan;
        do {
            System.out.println("\n===== TOKO MEDIA DIGITAL =====");
            System.out.println("1. Lihat daftar media");
            System.out.println("2. Putar media      (interface Dapat_Diputar)");
            System.out.println("3. Unduh media      (interface Dapat_Diunduh)");
            System.out.println("4. Beli media");
            System.out.println("5. Lihat riwayat transaksi");
            System.out.println("6. Perbedaan Abstract Class vs Interface");
            System.out.println("7. Cari media"); // menu baru hash map
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = bacaAngka(input);

            if (pilihan == 1) {
                tampilDaftar(daftar);

            } else if (pilihan == 2) {
                int no = pilihMedia(input, daftar);
                if (no != -1) {
                    Media_Digital m = daftar[no];
                    // Cek apakah media ini mengimplementasikan interface Dapat_Diputar
                    if (m instanceof Dapat_Diputar) {
                        Dapat_Diputar p = (Dapat_Diputar) m;
                        p.putar();
                        p.berhenti();
                    } else {
                        System.out.println("Media ini tidak bisa diputar.");
                    }
                }

            } else if (pilihan == 3) {
                int no = pilihMedia(input, daftar);
                if (no != -1) {
                    Media_Digital m = daftar[no];
                    // Tidak semua media mengimplementasikan Dapat_Diunduh
                    if (m instanceof Dapat_Diunduh) {
                        ((Dapat_Diunduh) m).unduh();
                    } else {
                        System.out.println("\"" + m.getJudul() + "\" hanya bisa di-streaming, tidak bisa diunduh.");
                    }
                }

            } else if (pilihan == 4) {
                int no = pilihMedia(input, daftar);
                if (no != -1) {
                    System.out.print("Metode pembayaran (kosongkan = Tunai): ");
                    String metode = input.nextLine().trim();
                    String id = "TRX-" + String.format("%03d", Transaksi.getJumlahTransaksi() + 1);

                    Transaksi t;
                    if (metode.isEmpty()) {
                        t = new Transaksi(id, LocalDate.now(), daftar[no]);
                    } else {
                        t = new Transaksi(id, LocalDate.now(), daftar[no], metode);
                    }
                    riwayat.add(t);
                    System.out.println("\nTransaksi berhasil!");
                    t.tampilkanInfo();
                }

            } else if (pilihan == 5) {
                if (riwayat.isEmpty()) {
                    System.out.println("Belum ada transaksi.");
                } else {
                    double totalSemua = 0;
                    for (Transaksi t : riwayat) {
                        System.out.println();
                        t.tampilkanInfo();
                        totalSemua += t.getTotal();
                    }
                    System.out.println("\nJumlah transaksi : " + riwayat.size());
                    System.out.println("Total pendapatan : Rp" + String.format("%,.0f", totalSemua));
                }

            } else if (pilihan == 6) {
                tampilPerbedaan();
            
            } else if (pilihan == 7) {
                System.out.print("Masukkan judul media: ");
                String judul = input.nextLine();

                Media_Digital hasil = katalog.get(judul);

                if (hasil != null) {
                    System.out.println("\nMedia ditemukan!");
                    hasil.tampilkanInfo();
                } else {
                    System.out.println("Media tidak ditemukan.");
                }

            } else if (pilihan != 0) {
                System.out.println("Menu tidak tersedia.");
            }

        } while (pilihan != 0);

        System.out.println("Terima kasih!");
        input.close();
    }

    // Membaca angka dari pengguna (ulang sampai benar-benar angka)
    static int bacaAngka(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.print("Masukkan angka: ");
            input.next();
        }
        int angka = input.nextInt();
        input.nextLine();
        return angka;
    }

    // Menampilkan daftar media beserta kemampuannya
    static void tampilDaftar(Media_Digital[] daftar) {
        System.out.println("\n--- Daftar Media ---");
        for (int i = 0; i < daftar.length; i++) {
            Media_Digital m = daftar[i];
            String fitur = "";
            if (m instanceof Dapat_Diputar) fitur += "[Putar] ";
            if (m instanceof Dapat_Diunduh) fitur += "[Unduh]";
            System.out.println((i + 1) + ". " + m.getJudul() + " " + fitur);
            m.tampilkanInfo();   // method biasa dari abstract class
            System.out.println();
        }
    }

    // Meminta pengguna memilih media, mengembalikan index (-1 jika tidak valid)
    static int pilihMedia(Scanner input, Media_Digital[] daftar) {
        for (int i = 0; i < daftar.length; i++) {
            System.out.println((i + 1) + ". " + daftar[i].getJudul());
        }
        System.out.print("Pilih nomor media: ");
        int no = bacaAngka(input);
        if (no < 1 || no > daftar.length) {
            System.out.println("Nomor media tidak valid.");
            return -1;
        }
        return no - 1;
    }

    static void tampilPerbedaan() {
        System.out.println("\n--- Abstract Class vs Interface ---");
        System.out.println("Abstract Class (Media_Digital, Video, Audio):");
        System.out.println("  - Boleh punya atribut, constructor, dan method biasa");
        System.out.println("  - Boleh punya method abstract (hitungHarga)");
        System.out.println("  - Subclass hanya bisa extends SATU abstract class");
        System.out.println("  - Cocok untuk hubungan 'is-a' (Film adalah Video)");
        System.out.println("Interface (Dapat_Diputar, Dapat_Diunduh):");
        System.out.println("  - Hanya berisi kontrak method (tanpa atribut data)");
        System.out.println("  - Class bisa implements BANYAK interface (Film: putar + unduh)");
        System.out.println("  - Cocok untuk kemampuan 'bisa melakukan' (can-do)");
    }
}
