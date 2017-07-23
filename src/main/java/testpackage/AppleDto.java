package testpackage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dustins on 7/23/17.
 */
public class AppleDto {
    private Long id;

    private String name;

    private Map<Long, SeedDto> seeds = new HashMap<Long, SeedDto>();

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

    public Map<Long, SeedDto> getSeeds() {
        return seeds;
    }

    public void setSeeds(Map<Long, SeedDto> seeds) {
        this.seeds = seeds;
    }
}
