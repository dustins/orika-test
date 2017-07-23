package testpackage;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dustins on 7/23/17.
 */
public class Apple {
    private Long id;

    private String name;

    private Set<Seed> seeds;

    public Apple(String name, Set<Seed> seeds, Long id) {
        this.id = id;
        this.name = name;
        this.seeds = seeds;
    }

    public Apple(String name, Set<Seed> seeds) {
        this(name, seeds, 0L);
    }

    public Apple(String name) {
        this(name, new HashSet<>());
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

    public Set<Seed> getSeeds() {
        return seeds;
    }

    public void setSeeds(Set<Seed> seeds) {
        this.seeds = seeds;
    }
}
