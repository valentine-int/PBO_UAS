import java.time.LocalDate;

public class Musik extends Audio implements Dapat_Diunduh {
    private String artis;
    private String genre;
    private int tahunRilis;

    public Musik(String judul, String pembuat, float size, String format,
                 LocalDate dateUpload, float harga,
                 int durasi, int bitrate, String channel,
                 String artis, String genre, int tahunRilis) {
        super(judul, pembuat, size, format, dateUpload, harga,
                durasi, bitrate, channel);
        this.artis = artis;
        this.genre = genre;
        this.tahunRilis = tahunRilis;
    }

    public String getArtis() { return artis; }
    public void setArtis(String artis) { this.artis = artis; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public int getTahunRilis() { return tahunRilis; }
    public void setTahunRilis(int tahunRilis) { this.tahunRilis = tahunRilis; }

    @Override
    public float hitungHarga() {
        return getHarga() * 1.1f;   // + 10% royalti artis
    }

    @Override
    public void unduh() {
        System.out.println("Mengunduh lagu \"" + getJudul() + "\" (" + getSize() + " MB)... selesai!");
    }
}
