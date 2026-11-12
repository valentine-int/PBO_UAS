import java.time.LocalDate;

// ABSTRACT CLASS: boleh punya atribut, constructor, dan method biasa,
// serta method abstract yang WAJIB di-override oleh subclass.
public abstract class Media_Digital {
    private String judul;
    private String pembuat;
    private float size;
    private String format;
    private LocalDate dateUpload;
    private float harga;

    public Media_Digital(String judul, String pembuat, float size, String format,
                         LocalDate dateUpload, float harga) {
        this.judul = judul;
        this.pembuat = pembuat;
        this.size = size;
        this.format = format;
        this.dateUpload = dateUpload;
        setHarga(harga);
    }

    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }
    public String getPembuat() { return pembuat; }
    public void setPembuat(String pembuat) { this.pembuat = pembuat; }
    public float getSize() { return size; }
    public void setSize(float size) { this.size = size; }
    public String getFormat() { return format; }
    public void setFormat(String format) { this.format = format; }
    public LocalDate getDateUpload() { return dateUpload; }
    public void setDateUpload(LocalDate dateUpload) { this.dateUpload = dateUpload; }
    public float getHarga() { return harga; }

    public void setHarga(float harga) {
        if (harga < 0) {
            System.out.println("Harga tidak boleh negatif");
        } else {
            this.harga = harga;
        }
    }

    // Method ABSTRACT: tidak ada isi, setiap jenis media punya cara hitung sendiri
    public abstract float hitungHarga();

    // Method BIASA: sudah ada isi, langsung diwariskan ke semua subclass
    public void tampilkanInfo() {
        System.out.println("Judul   : " + judul + " (" + pembuat + ")");
        System.out.println("Format  : " + format + " | Ukuran: " + size + " MB");
        System.out.println("Harga   : Rp" + String.format("%,.0f", hitungHarga()));
    }
}