package users.system.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pictures")
public class Picture {

    private Long id;
    private String title;
    private String caption;
    private String path;
    private Set<Album> album;

    public Picture() {
        this.album = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Column(length = 1000, nullable = false)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @ManyToMany(mappedBy = "pictures", targetEntity = Album.class)
    public Set<Album> getAlbum() {
        return album;
    }

    public void setAlbum(Set<Album> album) {
        this.album = album;
    }
}
