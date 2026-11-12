import java.time.LocalDate;

public class Animasi extends Video {
    private String studio;
    private String genre;
    private int jumlahEpisode;

    public Animasi(String judul, String pembuat, float size, String format,
                   LocalDate dateUpload, float harga,
                   int durasi, String resolusi, String aspekRasio,
                   String studio, String genre, int jumlahEpisode) {
        super(judul, pembuat, size, format, dateUpload, harga,
                durasi, resolusi, aspekRasio);
        this.studio = studio;
        this.genre = genre;
        this.jumlahEpisode = jumlahEpisode;
    }

    public String getStudio() { return studio; }
    public void setStudio(String studio) { this.studio = studio; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public int getJumlahEpisode() { return jumlahEpisode; }
    public void setJumlahEpisode(int jumlahEpisode) { this.jumlahEpisode = jumlahEpisode; }

    @Override
    public float hitungHarga() {
        float total = getHarga() * jumlahEpisode;   // harga per episode
        if (jumlahEpisode > 10) {
            total = total * 0.8f;                   // diskon 20%
        }
        return total;
    }
}