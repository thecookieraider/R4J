package no.stelar7.api.l4j8.tests.summoner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javafx.util.Pair;
import no.stelar7.api.l4j8.basic.Server;
import no.stelar7.api.l4j8.basic.URLEndpoint;
import no.stelar7.api.l4j8.basic.DataCall.ResponseType;
import no.stelar7.api.l4j8.pojo.summoner.runes.RunePage;
import no.stelar7.api.l4j8.pojo.summoner.runes.RuneSlot;
import no.stelar7.api.l4j8.tests.SecretFile;
import no.stelar7.api.l4j8.tests.TestBase;

public class SummonerRunesTest extends TestBase
{

    @Before
    public void init()
    {
        this.builder.withAPIKey(SecretFile.API_KEY);
        this.builder.withServer(Server.EUW);
        this.builder.withEndpoint(URLEndpoint.SUMMONER_RUNES_BY_ID);
    }
    
    @Test
    public void doTest()
    {
        // Generate list of summoner IDs
        List<String> keys = Arrays.asList("19613950", "22291359", "33540589");

        // Add them as a parameter to the URL
        keys.forEach((String k) -> this.builder.withURLData("{summonerId}", k));

        // Get the response
        final Pair<ResponseType, Object> dataCall = this.builder.build();

        // Map it to the correct return value
        Map<String, List<RunePage>> data = (Map<String, List<RunePage>>) dataCall.getValue();

        // Make sure all the data is returned as expected
        data.forEach(doAssertions);
    }

    private BiConsumer<String, List<RunePage>> doAssertions = (String key, List<RunePage> value) -> {

        value.forEach((RunePage page) -> {
            Assert.assertNotNull("Rune Page does not have an id", page.getId());
            Assert.assertNotNull("Rune Page does not have a name", page.getName());
            Assert.assertNotNull("Rune Page does not contain any slots", page.getSlots());
            Assert.assertNotNull("Unable to determine current Rune page", page.isCurrent());

            page.getSlots().forEach((RuneSlot slot) -> {
                Assert.assertNotNull("Rune slot does not have a slot id", slot.getRuneSlotId());
                Assert.assertNotNull("Rune slot does not have a rune id", slot.getRuneId());

                Assert.assertNotEquals("Rune slot does not have a valid id", slot.getRuneSlotId(), (Integer) 0);
                Assert.assertNotEquals("Rune slot does not have a valid rune id", slot.getRuneId(), (Integer) 0);
            });
        });

        Assert.assertTrue("There is not exactly ONE \"current\" page", value.stream().filter((RunePage page) -> page.isCurrent()).count() == 1);
    };
}
