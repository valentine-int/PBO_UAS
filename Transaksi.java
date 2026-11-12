import java.time.LocalDate;

public class Transaksi {
    private String idTransaksi;
    private LocalDate tanggal;
    private String metodePembayaran;
    private double total;
    private Media_Digital media;
    private static int jumlahTransaksi = 0;

    // Constructor 1: lengkap dengan metodePembayaran
    public Transaksi(String idTransaksi, LocalDate tanggal,
                     Media_Digital media, String metodePembayaran) {
        this.idTransaksi = idTransaksi;
        this.tanggal = tanggal;
        this.media = media;
        this.metodePembayaran = metodePembayaran;
        setTotal(media.hitungHarga());   // pakai harga hasil override
        jumlahTransaksi++;
    }

    // Constructor 2: tanpa metodePembayaran, default "Tunai"
    public Transaksi(String idTransaksi, LocalDate tanggal, Media_Digital media) {
        this(idTransaksi, tanggal, media, "Tunai");
    }

    public String getIdTransaksi() { return idTransaksi; }
    public LocalDate getTanggal() { return tanggal; }
    public String getMetodePembayaran() { return metodePembayaran; }
    public double getTotal() { return total; }
    public Media_Digital getMedia() { return media; }
    public static int getJumlahTransaksi() { return jumlahTransaksi; }

    public void setTotal(double total) {
        if (total < 0) {
            System.out.println("Total tidak boleh negatif");
        } else {
            this.total = total;
        }
    }

    // Setter
    public void setIdTransaksi(String idTransaksi) { this.idTransaksi = idTransaksi; }
    public void setTanggal(LocalDate tanggal) { this.tanggal = tanggal; }
    public void setMetodePembayaran(String metodePembayaran) { this.metodePembayaran = metodePembayaran; }

    public void setMedia(Media_Digital media) {
        this.media = media;
        setTotal(media.hitungHarga());   // total ikut dihitung ulang
    }

    public void tampilkanInfo() {
        System.out.println("ID Transaksi      : " + idTransaksi);
        System.out.println("Tanggal           : " + tanggal);
        System.out.println("Media             : " + media.getJudul() + " (" + media.getPembuat() + ")");
        System.out.println("Metode Pembayaran : " + metodePembayaran);
        System.out.println("Total             : Rp" + String.format("%,.0f", total));
    }
}