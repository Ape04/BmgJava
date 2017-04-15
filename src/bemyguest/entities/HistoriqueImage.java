
package bemyguest.entities;

/**
 *
 * @author Daly
 */
public class HistoriqueImage {
    private int id;
    private String url;
    private Propriete propriete;

    public HistoriqueImage() {
    }

    public HistoriqueImage(int id, String url, Propriete propriete) {
        this.id = id;
        this.url = url;
        this.propriete = propriete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Propriete getPropriete() {
        return propriete;
    }

    public void setPropriete(Propriete propriete) {
        this.propriete = propriete;
    }

    @Override
    public String toString() {
        return "HistoriqueImage{" + "id=" + id + ", url=" + url + ", propriete=" + propriete + '}';
    }
}