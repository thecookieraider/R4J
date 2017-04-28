package no.stelar7.api.l4j8.pojo.match;

import no.stelar7.api.l4j8.basic.constants.types.TeamType;
import no.stelar7.api.l4j8.pojo.shared.*;

import java.util.*;

public class TeamStats
{
    private List<BannedChampion> bans;
    private Integer              baronKills;
    private Long                 dominionVictoryScore;
    private Integer              dragonKills;
    private Boolean              firstBaron;
    private Boolean              firstBlood;
    private Boolean              firstDragon;
    private Boolean              firstInhibitor;
    private Boolean              firstTower;
    private Integer              inhibitorKills;
    private TeamType             teamId;
    private Integer              towerKills;
    private Integer              vilemawKills;
    private String               win;
    private Boolean              firstRiftHerald;
    private Integer              riftHeraldKills;
    
    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (this.getClass() != obj.getClass())
        {
            return false;
        }
        final TeamStats other = (TeamStats) obj;
        if (this.bans == null)
        {
            if (other.bans != null)
            {
                return false;
            }
        } else if (!this.bans.equals(other.bans))
        {
            return false;
        }
        if (this.baronKills == null)
        {
            if (other.baronKills != null)
            {
                return false;
            }
        } else if (!this.baronKills.equals(other.baronKills))
        {
            return false;
        }
        if (this.dominionVictoryScore == null)
        {
            if (other.dominionVictoryScore != null)
            {
                return false;
            }
        } else if (!this.dominionVictoryScore.equals(other.dominionVictoryScore))
        {
            return false;
        }
        if (this.dragonKills == null)
        {
            if (other.dragonKills != null)
            {
                return false;
            }
        } else if (!this.dragonKills.equals(other.dragonKills))
        {
            return false;
        }
        if (this.firstBaron == null)
        {
            if (other.firstBaron != null)
            {
                return false;
            }
        } else if (!this.firstBaron.equals(other.firstBaron))
        {
            return false;
        }
        if (this.firstBlood == null)
        {
            if (other.firstBlood != null)
            {
                return false;
            }
        } else if (!this.firstBlood.equals(other.firstBlood))
        {
            return false;
        }
        if (this.firstDragon == null)
        {
            if (other.firstDragon != null)
            {
                return false;
            }
        } else if (!this.firstDragon.equals(other.firstDragon))
        {
            return false;
        }
        if (this.firstInhibitor == null)
        {
            if (other.firstInhibitor != null)
            {
                return false;
            }
        } else if (!this.firstInhibitor.equals(other.firstInhibitor))
        {
            return false;
        }
        if (this.firstRiftHerald == null)
        {
            if (other.firstRiftHerald != null)
            {
                return false;
            }
        } else if (!this.firstRiftHerald.equals(other.firstRiftHerald))
        {
            return false;
        }
        if (this.firstTower == null)
        {
            if (other.firstTower != null)
            {
                return false;
            }
        } else if (!this.firstTower.equals(other.firstTower))
        {
            return false;
        }
        if (this.inhibitorKills == null)
        {
            if (other.inhibitorKills != null)
            {
                return false;
            }
        } else if (!this.inhibitorKills.equals(other.inhibitorKills))
        {
            return false;
        }
        if (this.riftHeraldKills == null)
        {
            if (other.riftHeraldKills != null)
            {
                return false;
            }
        } else if (!this.riftHeraldKills.equals(other.riftHeraldKills))
        {
            return false;
        }
        if (this.teamId == null)
        {
            if (other.teamId != null)
            {
                return false;
            }
        } else if (!this.teamId.equals(other.teamId))
        {
            return false;
        }
        if (this.towerKills == null)
        {
            if (other.towerKills != null)
            {
                return false;
            }
        } else if (!this.towerKills.equals(other.towerKills))
        {
            return false;
        }
        if (this.vilemawKills == null)
        {
            if (other.vilemawKills != null)
            {
                return false;
            }
        } else if (!this.vilemawKills.equals(other.vilemawKills))
        {
            return false;
        }
        if (this.win == null)
        {
            if (other.win != null)
            {
                return false;
            }
        } else if (!this.win.equals(other.win))
        {
            return false;
        }
        return true;
    }
    
    /**
     * Gets the bans.
     *
     * @return the bans
     */
    public List<BannedChampion> getBans()
    {
        return this.bans;
    }
    
    /**
     * Gets the baron kills.
     *
     * @return the baron kills
     */
    public Integer getBaronKills()
    {
        return this.baronKills;
    }
    
    /**
     * Gets the dominion victory score.
     *
     * @return the dominion victory score
     */
    public Long getDominionVictoryScore()
    {
        return this.dominionVictoryScore;
    }
    
    /**
     * Gets the dragon kills.
     *
     * @return the dragon kills
     */
    public Integer getDragonKills()
    {
        return this.dragonKills;
    }
    
    /**
     * Gets the first baron.
     *
     * @return the first baron
     */
    public Boolean getFirstBaron()
    {
        return this.firstBaron;
    }
    
    /**
     * Gets the first blood.
     *
     * @return the first blood
     */
    public Boolean getFirstBlood()
    {
        return this.firstBlood;
    }
    
    /**
     * Gets the first dragon.
     *
     * @return the first dragon
     */
    public Boolean getFirstDragon()
    {
        return this.firstDragon;
    }
    
    /**
     * Gets the first inhibitor.
     *
     * @return the first inhibitor
     */
    public Boolean getFirstInhibitor()
    {
        return this.firstInhibitor;
    }
    
    /**
     * Flag indicating whether or not the team got the first rift herald kill.
     *
     * @return the first rift herald
     */
    public Boolean getFirstRiftHerald()
    {
        return this.firstRiftHerald;
    }
    
    /**
     * Gets the first tower.
     *
     * @return the first tower
     */
    public Boolean getFirstTower()
    {
        return this.firstTower;
    }
    
    /**
     * Gets the inhibitor kills.
     *
     * @return the inhibitor kills
     */
    public Integer getInhibitorKills()
    {
        return this.inhibitorKills;
    }
    
    /**
     * Number of times the team killed rift herald.
     *
     * @return the rift herald kills
     */
    public Integer getRiftHeraldKills()
    {
        return this.riftHeraldKills;
    }
    
    /**
     * Gets the team id.
     *
     * @return the team id
     */
    public TeamType getTeamType()
    {
        return this.teamId;
    }
    
    /**
     * Gets the tower kills.
     *
     * @return the tower kills
     */
    public Integer getTowerKills()
    {
        return this.towerKills;
    }
    
    /**
     * Gets the vilemaw kills.
     *
     * @return the vilemaw kills
     */
    public Integer getVilemawKills()
    {
        return this.vilemawKills;
    }
    
    /**
     * Gets the winner.
     *
     * @return the winner
     */
    public String getWin()
    {
        return this.win;
    }
    
    @Override
    public int hashCode()
    {
        final int prime  = 31;
        int       result = 1;
        result = (prime * result) + ((this.bans == null) ? 0 : this.bans.hashCode());
        result = (prime * result) + ((this.baronKills == null) ? 0 : this.baronKills.hashCode());
        result = (prime * result) + ((this.dominionVictoryScore == null) ? 0 : this.dominionVictoryScore.hashCode());
        result = (prime * result) + ((this.dragonKills == null) ? 0 : this.dragonKills.hashCode());
        result = (prime * result) + ((this.firstBaron == null) ? 0 : this.firstBaron.hashCode());
        result = (prime * result) + ((this.firstBlood == null) ? 0 : this.firstBlood.hashCode());
        result = (prime * result) + ((this.firstDragon == null) ? 0 : this.firstDragon.hashCode());
        result = (prime * result) + ((this.firstInhibitor == null) ? 0 : this.firstInhibitor.hashCode());
        result = (prime * result) + ((this.firstRiftHerald == null) ? 0 : this.firstRiftHerald.hashCode());
        result = (prime * result) + ((this.firstTower == null) ? 0 : this.firstTower.hashCode());
        result = (prime * result) + ((this.inhibitorKills == null) ? 0 : this.inhibitorKills.hashCode());
        result = (prime * result) + ((this.riftHeraldKills == null) ? 0 : this.riftHeraldKills.hashCode());
        result = (prime * result) + ((this.teamId == null) ? 0 : this.teamId.hashCode());
        result = (prime * result) + ((this.towerKills == null) ? 0 : this.towerKills.hashCode());
        result = (prime * result) + ((this.vilemawKills == null) ? 0 : this.vilemawKills.hashCode());
        result = (prime * result) + ((this.win == null) ? 0 : this.win.hashCode());
        return result;
    }
    
    /**
     * Checks if is first baron.
     *
     * @return the boolean
     */
    public Boolean isFirstBaron()
    {
        return this.firstBaron;
    }
    
    /**
     * Checks if is first blood.
     *
     * @return the boolean
     */
    public Boolean isFirstBlood()
    {
        return this.firstBlood;
    }
    
    /**
     * Checks if is first dragon.
     *
     * @return the boolean
     */
    public Boolean isFirstDragon()
    {
        return this.firstDragon;
    }
    
    /**
     * Checks if is first inhibitor.
     *
     * @return the boolean
     */
    public Boolean isFirstInhibitor()
    {
        return this.firstInhibitor;
    }
    
    /**
     * Checks if is first tower.
     *
     * @return the boolean
     */
    public Boolean isFirstTower()
    {
        return this.firstTower;
    }
    
    /**
     * Checks if is winner.
     *
     * @return the boolean
     */
    public Boolean isWinner()
    {
        return "Win".equalsIgnoreCase(this.win);
    }
    
    @Override
    public String toString()
    {
        return "TeamType{" +
               "bans=" + bans +
               ", baronKills=" + baronKills +
               ", dominionVictoryScore=" + dominionVictoryScore +
               ", dragonKills=" + dragonKills +
               ", firstBaron=" + firstBaron +
               ", firstBlood=" + firstBlood +
               ", firstDragon=" + firstDragon +
               ", firstInhibitor=" + firstInhibitor +
               ", firstTower=" + firstTower +
               ", inhibitorKills=" + inhibitorKills +
               ", teamId=" + teamId +
               ", towerKills=" + towerKills +
               ", vilemawKills=" + vilemawKills +
               ", winner=" + win +
               ", firstRiftHerald=" + firstRiftHerald +
               ", riftHeraldKills=" + riftHeraldKills +
               '}';
    }
}