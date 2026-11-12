import java.time.LocalDate;

public class Podcast extends Audio {
    private String host;
    private String topik;
    private int episode;

    public Podcast(String judul, String pembuat, float size, String format,
                   LocalDate dateUpload, float harga,
                   int durasi, int bitrate, String channel,
                   String host, String topik, int episode) {
        super(judul, pembuat, size, format, dateUpload, harga,
                durasi, bitrate, channel);
        this.host = host;
        this.topik = topik;
        this.episode = episode;
    }

    public String getHost() { return host; }
    public void setHost(String host) { this.host = host; }
    public String getTopik() { return topik; }
    public void setTopik(String topik) { this.topik = topik; }
    public int getEpisode() { return episode; }
    public void setEpisode(int episode) { this.episode = episode; }

    @Override
    public float hitungHarga() {
        return getHarga() * 0.8f;   // diskon 20%
    }
}