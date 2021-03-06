package no.stelar7.api.r4j.pojo.lol.staticdata.item;

import java.io.Serializable;
import java.util.List;

public class ItemTree implements Serializable
{
    private static final long serialVersionUID = 1596861484491451508L;
    
    private String       header;
    private List<String> tags;
    
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
        final ItemTree other = (ItemTree) obj;
        if (this.header == null)
        {
            if (other.header != null)
            {
                return false;
            }
        } else if (!this.header.equals(other.header))
        {
            return false;
        }
        if (this.tags == null)
        {
            return other.tags == null;
        } else
        {
            return this.tags.equals(other.tags);
        }
    }
    
    /**
     * Gets the header.
     *
     * @return the header
     */
    public String getHeader()
    {
        return this.header;
    }
    
    /**
     * Gets the tags.
     *
     * @return the tags
     */
    public List<String> getTags()
    {
        return this.tags;
    }
    
    @Override
    public int hashCode()
    {
        final int prime  = 31;
        int       result = 1;
        result = (prime * result) + ((this.header == null) ? 0 : this.header.hashCode());
        result = (prime * result) + ((this.tags == null) ? 0 : this.tags.hashCode());
        return result;
    }
    
    @Override
    public String toString()
    {
        return "ItemTree{" +
               "header='" + header + '\'' +
               ", tags=" + tags +
               '}';
    }
}
