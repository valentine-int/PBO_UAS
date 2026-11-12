import java.time.LocalDate;

public abstract class Audio extends Media_Digital implements Dapat_Diputar {
    private int durasi;
    private int bitrate;
    private String channel;

    public Audio(String judul, String pembuat, float size, String format,
                 LocalDate dateUpload, float harga,
                 int durasi, int bitrate, String channel) {
        super(judul, pembuat, size, format, dateUpload, harga);
        this.durasi = durasi;
        this.bitrate = bitrate;
        this.channel = channel;
    }

    public int getDurasi() { return durasi; }
    public void setDurasi(int durasi) { this.durasi = durasi; }
    public int getBitrate() { return bitrate; }
    public void setBitrate(int bitrate) { this.bitrate = bitrate; }
    public String getChannel() { return channel; }
    public void setChannel(String channel) { this.channel = channel; }

    @Override
    public void putar() {
        System.out.println("Memutar audio \"" + getJudul() + "\" (" + durasi + " menit, " + bitrate + " kbps)");
    }

    @Override
    public void berhenti() {
        System.out.println("Audio \"" + getJudul() + "\" dihentikan.");
    }
}
