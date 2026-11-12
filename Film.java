import java.time.LocalDate;

public class Film extends Video implements Dapat_Diunduh {
    private String genre;
    private int tahunRilis;
    private float rating;

    public Film(String judul, String pembuat, float size, String format,
                LocalDate dateUpload, float harga,
                int durasi, String resolusi, String aspekRasio,
                String genre, int tahunRilis, float rating) {
        super(judul, pembuat, size, format, dateUpload, harga,
                durasi, resolusi, aspekRasio);
        this.genre = genre;
        this.tahunRilis = tahunRilis;
        this.rating = rating;
    }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public int getTahunRilis() { return tahunRilis; }
    public void setTahunRilis(int tahunRilis) { this.tahunRilis = tahunRilis; }
    public float getRating() { return rating; }
    public void setRating(float rating) { this.rating = rating; }

    @Override
    public float hitungHarga() {
        if (rating >= 4.5f) {
            return getHarga() * 1.2f;   // film rating tinggi: +20%
        }
        return getHarga();
    }

    @Override
    public void unduh() {
        System.out.println("Mengunduh film \"" + getJudul() + "\" (" + getSize() + " MB)... selesai!");
    }
}
