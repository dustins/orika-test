package testpackage;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

/**
 * Created by dustins on 7/23/17.
 */
public class MappingTest {
    private MapperFacade mapper;

    @Before
    public void setUp() throws Exception {
        MapperFactory factory = new DefaultMapperFactory.Builder()
                .dumpStateOnException(true)
                .build();

        factory.classMap(Seed.class, SeedDto.class)
                .field("id", "id")
                .field("name", "name")
                .register();

        factory.classMap(Apple.class, AppleDto.class)
                .field("id", "id")
                .field("name", "name")
                .field("seeds{id}", "seeds{key}")
                .field("seeds{}", "seeds{value}")
                .register();

        mapper = factory.getMapperFacade();
    }

    @Test
    public void testSeedMapping() throws Exception {
        Seed seed = new Seed("seed 1", 1L);
        SeedDto seedDto = mapper.map(seed, SeedDto.class);
        Assert.assertEquals(seed.getId(), seedDto.getId());
        Assert.assertEquals(seed.getName(), seedDto.getName());
        Seed seed2 = mapper.map(seedDto, Seed.class);
        Assert.assertEquals(seedDto.getId(), seed.getId());
        Assert.assertEquals(seedDto.getName(), seed.getName());
    }

    @Test
    public void testAppleMapping() throws Exception {
        Apple apple = new Apple("apple 1", new HashSet<>(), 1L);
        AppleDto appleDto = mapper.map(apple, AppleDto.class);
        Assert.assertEquals(apple.getId(), appleDto.getId());
        Assert.assertEquals(apple.getName(), appleDto.getName());
        Assert.assertEquals(apple.getSeeds().size(), appleDto.getSeeds().size());
        Apple apple2 = mapper.map(appleDto, Apple.class);
        Assert.assertEquals(appleDto.getId(), apple.getId());
        Assert.assertEquals(appleDto.getName(), apple.getName());
        Assert.assertEquals(appleDto.getSeeds().size(), apple.getSeeds().size());
    }

    @Test
    public void testSetToMapMapping() throws Exception {
        Apple apple = new Apple("apple 1", new HashSet<Seed>() {{
            add(new Seed("seed 1", 1L));
            add(new Seed("seed 2", 2L));
        }}, 1L);
        AppleDto appleDto = mapper.map(apple, AppleDto.class);
        Assert.assertEquals(apple.getId(), appleDto.getId());
        Assert.assertEquals(apple.getName(), appleDto.getName());
        Assert.assertEquals(apple.getSeeds().size(), appleDto.getSeeds().size());
    }
}
