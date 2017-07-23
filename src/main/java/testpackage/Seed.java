package testpackage;

/**
 * Created by dustins on 7/23/17.
 */
public class Seed {
    private Long id;

    private String name;

    public Seed(String name, Long id) {
        this.id = id;
        this.name = name;
    }

    public Seed(String name) {
        this(name, 0L);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
