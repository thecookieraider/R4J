package no.stelar7.api.l4j8.basic.constants.types;

import java.util.*;
import java.util.stream.*;

public enum AscencionType
{
    CHAMPION_ASCENDED,
    CLEAR_ASCENDED,
    MINION_ASCENDED;
    
    /**
     * Returns an AscentionType from the provided value
     *
     * @return AscentionType
     */
    public static Optional<AscencionType> getFromCode(final String type)
    {
        return Stream.of(AscencionType.values()).filter(t -> t.name().equalsIgnoreCase(type)).findFirst();
    }
    
    /**
     * The value used to map strings to objects
     *
     * @return String
     */
    public String getCode()
    {
        return this.name();
    }
}