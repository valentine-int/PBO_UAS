import java.time.LocalDate;

public abstract class Video extends Media_Digital implements Dapat_Diputar {
    private int durasi;
    private String resolusi;
    private String aspekRasio;

    public Video(String judul, String pembuat, float size, String format,
                 LocalDate dateUpload, float harga,
                 int durasi, String resolusi, String aspekRasio) {
        super(judul, pembuat, size, format, dateUpload, harga);
        this.durasi = durasi;
        this.resolusi = resolusi;
        this.aspekRasio = aspekRasio;
    }

    public int getDurasi() { return durasi; }
    public void setDurasi(int durasi) { this.durasi = durasi; }
    public String getResolusi() { return resolusi; }
    public void setResolusi(String resolusi) { this.resolusi = resolusi; }
    public String getAspekRasio() { return aspekRasio; }
    public void setAspekRasio(String aspekRasio) { this.aspekRasio = aspekRasio; }

    @Override
    public void putar() {
        System.out.println("Memutar video \"" + getJudul() + "\" (" + durasi + " menit, " + resolusi + ")");
    }

    @Override
    public void berhenti() {
        System.out.println("Video \"" + getJudul() + "\" dihentikan.");
    }
}
