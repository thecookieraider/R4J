package no.stelar7.api.l4j8.impl.builders.match;

import no.stelar7.api.l4j8.basic.calling.*;
import no.stelar7.api.l4j8.basic.constants.api.*;
import no.stelar7.api.l4j8.basic.constants.types.*;
import no.stelar7.api.l4j8.basic.utils.LazyList;
import no.stelar7.api.l4j8.pojo.match.*;

import java.util.*;

public class MatchListBuilder
{
    
    private final Platform           platform;
    private final Long               id;
    private final Long               beginTime;
    private final Long               endTime;
    private final Long               beginIndex;
    private final Long               endIndex;
    private final Set<GameQueueType> queues;
    private final Set<SeasonType>    seasons;
    private final Set<Integer>       champions;
    
    public MatchListBuilder()
    {
        this.platform = Platform.UNKNOWN;
        this.id = null;
        this.beginTime = null;
        this.endTime = null;
        this.beginIndex = null;
        this.endIndex = null;
        this.queues = EnumSet.noneOf(GameQueueType.class);
        this.seasons = EnumSet.noneOf(SeasonType.class);
        this.champions = new HashSet<>();
    }
    
    private MatchListBuilder(Platform platform, Long id, Long beginTime, Long endTime, Long beginIndex, Long endIndex, Set<GameQueueType> queues, Set<SeasonType> seasons, Set<Integer> champions)
    {
        this.platform = platform;
        this.id = id;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
        this.queues = queues;
        this.seasons = seasons;
        this.champions = champions;
    }
    
    public MatchListBuilder withPlatform(Platform platform)
    {
        return new MatchListBuilder(platform, this.id, this.beginTime, this.endTime, this.beginIndex, this.endIndex, this.queues, this.seasons, this.champions);
    }
    
    public MatchListBuilder withAccountId(Long accountId)
    {
        return new MatchListBuilder(this.platform, accountId, this.beginTime, this.endTime, this.beginIndex, this.endIndex, this.queues, this.seasons, this.champions);
    }
    
    public MatchListBuilder withBeginTime(Long time)
    {
        return new MatchListBuilder(this.platform, this.id, time, this.endTime, this.beginIndex, this.endIndex, this.queues, this.seasons, this.champions);
    }
    
    public MatchListBuilder withEndTime(Long time)
    {
        return new MatchListBuilder(this.platform, this.id, this.beginTime, time, this.beginIndex, this.endIndex, this.queues, this.seasons, this.champions);
    }
    
    public MatchListBuilder withBeginIndex(Long index)
    {
        return new MatchListBuilder(this.platform, this.id, this.beginTime, this.endTime, index, this.endIndex, this.queues, this.seasons, this.champions);
    }
    
    public MatchListBuilder withEndIndex(Long index)
    {
        return new MatchListBuilder(this.platform, this.id, this.beginTime, this.endTime, this.beginIndex, index, this.queues, this.seasons, this.champions);
    }
    
    public MatchListBuilder withQueues(Set<GameQueueType> queues)
    {
        return new MatchListBuilder(this.platform, this.id, this.beginTime, this.endTime, this.beginIndex, this.endIndex, queues, this.seasons, this.champions);
    }
    
    public MatchListBuilder addQueue(GameQueueType queue)
    {
        Set<GameQueueType> local = EnumSet.copyOf(this.queues);
        local.add(queue);
        
        return new MatchListBuilder(this.platform, this.id, this.beginTime, this.endTime, this.beginIndex, this.endIndex, local, this.seasons, this.champions);
    }
    
    
    public MatchListBuilder withSeasons(Set<SeasonType> seasons)
    {
        return new MatchListBuilder(this.platform, this.id, this.beginTime, this.endTime, this.beginIndex, this.endIndex, this.queues, seasons, this.champions);
    }
    
    public MatchListBuilder addSeason(SeasonType season)
    {
        Set<SeasonType> local = EnumSet.copyOf(this.seasons);
        local.add(season);
        
        return new MatchListBuilder(this.platform, this.id, this.beginTime, this.endTime, this.beginIndex, this.endIndex, this.queues, local, this.champions);
    }
    
    public MatchListBuilder withChampions(Set<Integer> champions)
    {
        return new MatchListBuilder(this.platform, this.id, this.beginTime, this.endTime, this.beginIndex, this.endIndex, this.queues, this.seasons, champions);
    }
    
    public MatchListBuilder addChampion(Integer champ)
    {
        Set<Integer> local = new HashSet(this.champions);
        local.add(champ);
        
        return new MatchListBuilder(this.platform, this.id, this.beginTime, this.endTime, this.beginIndex, this.endIndex, this.queues, this.seasons, local);
    }
    
    /**
     * Returns a list of the accounts games
     * <p>
     * A number of optional parameters are provided for filtering.
     * It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned.
     * If beginIndex is specified, but not endIndex, then endIndex defaults to beginIndex+50.
     * If endIndex is specified, but not beginIndex, then beginIndex defaults to 0.
     * If both are specified, then endIndex must be greater than beginIndex.
     * The maximum range allowed is 50, otherwise a 400 error code is returned.
     * If beginTime is specified, but not endTime, then these parameters are ignored.
     * If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history.
     * If both are specified, then endTime should be greater than beginTime.
     * The maximum time range allowed is one week, otherwise a 400 error code is returned.
     *
     * @return MatchList
     */
    public List<MatchReference> get()
    {
        if (this.id < 0 || this.platform == Platform.UNKNOWN)
        {
            return Collections.emptyList();
        }
        
        DataCallBuilder builder = new DataCallBuilder().withURLParameter(Constants.ACCOUNT_ID_PLACEHOLDER, String.valueOf(this.id))
                                                       .withEndpoint(URLEndpoint.V3_MATCHLIST)
                                                       .withPlatform(this.platform);
        
        
        if (this.beginIndex != null)
        {
            builder.withURLData(Constants.BEGININDEX_PLACEHOLDER_DATA, String.valueOf(this.beginIndex));
        }
        if (this.endIndex != null)
        {
            if ((this.beginIndex != null ? this.beginIndex : 0) + 50 - this.endIndex < 0)
            {
                throw new IllegalArgumentException("begin-endindex out of range! (difference between beginIndex and endIndex is more than 50)");
            }
            
            builder.withURLData(Constants.ENDINDEX_PLACEHOLDER_DATA, String.valueOf(this.endIndex));
        }
        
        if (this.beginTime != null)
        {
            builder.withURLData(Constants.BEGINTIME_PLACEHOLDER_DATA, String.valueOf(this.beginTime));
        }
        if (this.endTime != null)
        {
            
            if ((this.beginTime != null ? this.beginTime : 0) + 604800000 - this.endTime < 0)
            {
                throw new IllegalArgumentException("begin-endtime out of range! (difference between beginTime and endTime is more than one week)");
            }
            
            builder.withURLData(Constants.ENDTIME_PLACEHOLDER_DATA, String.valueOf(this.endTime));
        }
        if (this.queues != null)
        {
            this.queues.forEach(queue -> builder.withURLDataAsSet(Constants.QUEUE_PLACEHOLDER_DATA, String.valueOf(queue.getValues()[0])));
        }
        if (this.seasons != null)
        {
            this.seasons.forEach(sea -> builder.withURLDataAsSet(Constants.SEASON_PLACEHOLDER_DATA, String.valueOf(sea.getValue())));
        }
        if (this.champions != null)
        {
            this.champions.forEach(champ -> builder.withURLDataAsSet(Constants.CHAMPION_PLACEHOLDER_DATA, String.valueOf(champ)));
        }
        
        
        Optional chl = DataCall.getCacheProvider().get(URLEndpoint.V3_MATCHLIST, this.id, this.platform, this.beginTime, this.endTime, this.beginIndex, this.endIndex, this.queues, this.seasons, this.champions);
        if (chl.isPresent())
        {
            return (List<MatchReference>) chl.get();
        }
        
        try
        {
            MatchList list = (MatchList) builder.build();
            DataCall.getCacheProvider().store(URLEndpoint.V3_MATCHLIST, list.getMatches(), this.id, this.platform, this.beginTime, this.endTime, this.beginIndex, this.endIndex, this.queues, this.seasons, this.champions);
            return list.getMatches();
        } catch (ClassCastException e)
        {
            
            return Collections.emptyList();
        }
    }
    
    /**
     * Returns a list of all games avaliable in the api
     * This list is updated lazily!
     * To get all the items, either iterate the list once, or get(Integer.MAX_VALUE)
     *
     * @return {@code List<MatchReference>}
     */
    public LazyList<MatchReference> getLazy()
    {
        int increment = 50;
        return new LazyList<>(increment, prevValue -> {
            Long begin = (this.beginIndex != null ? this.beginIndex : 0) + prevValue;
            Long end   = (this.endIndex != null ? this.endIndex : 0) + increment + prevValue;
            
            MatchListBuilder local = new MatchListBuilder(this.platform, this.id, this.beginTime, this.endTime, begin, end, this.queues, this.seasons, this.champions);
            return local.get();
        });
        
    }
    
}