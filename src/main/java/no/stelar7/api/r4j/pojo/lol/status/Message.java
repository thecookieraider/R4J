package no.stelar7.api.r4j.pojo.lol.status;

import java.io.Serializable;
import java.util.List;

public class Message implements Serializable
{
    private static final long serialVersionUID = -7432141392779902242L;
    
    private String            author;
    private String            content;
    private String            created_at;
    private String            id;
    private String            severity;
    private String            updated_at;
    private List<Translation> translations;
    
    
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
        final Message other = (Message) obj;
        if (this.author == null)
        {
            if (other.author != null)
            {
                return false;
            }
        } else if (!this.author.equals(other.author))
        {
            return false;
        }
        if (this.content == null)
        {
            if (other.content != null)
            {
                return false;
            }
        } else if (!this.content.equals(other.content))
        {
            return false;
        }
        if (this.created_at == null)
        {
            if (other.created_at != null)
            {
                return false;
            }
        } else if (!this.created_at.equals(other.created_at))
        {
            return false;
        }
        if (this.id == null)
        {
            if (other.id != null)
            {
                return false;
            }
        } else if (!this.id.equals(other.id))
        {
            return false;
        }
        if (this.severity == null)
        {
            if (other.severity != null)
            {
                return false;
            }
        } else if (!this.severity.equals(other.severity))
        {
            return false;
        }
        if (this.translations == null)
        {
            if (other.translations != null)
            {
                return false;
            }
        } else if (!this.translations.equals(other.translations))
        {
            return false;
        }
        if (this.updated_at == null)
        {
            return other.updated_at == null;
        } else
        {
            return this.updated_at.equals(other.updated_at);
        }
    }
    
    /**
     * Gets the author.
     *
     * @return the author
     */
    public String getAuthor()
    {
        return this.author;
    }
    
    /**
     * Gets the content.
     *
     * @return the content
     */
    public String getContent()
    {
        return this.content;
    }
    
    /**
     * Gets the created_at.
     *
     * @return the created_at
     */
    public String getCreatedAt()
    {
        return this.created_at;
    }
    
    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId()
    {
        return this.id;
    }
    
    /**
     * Gets the severity. Legal values: Info, Alert, Error
     *
     * @return the severity
     */
    public String getSeverity()
    {
        return this.severity;
    }
    
    /**
     * Gets the translations.
     *
     * @return the translations
     */
    public List<Translation> getTranslations()
    {
        return this.translations;
    }
    
    /**
     * Gets the updated_at.
     *
     * @return the updated_at
     */
    public String getUpdatedAt()
    {
        return this.updated_at;
    }
    
    @Override
    public int hashCode()
    {
        final int prime  = 31;
        int       result = 1;
        result = (prime * result) + ((this.author == null) ? 0 : this.author.hashCode());
        result = (prime * result) + ((this.content == null) ? 0 : this.content.hashCode());
        result = (prime * result) + ((this.created_at == null) ? 0 : this.created_at.hashCode());
        result = (prime * result) + ((this.id == null) ? 0 : this.id.hashCode());
        result = (prime * result) + ((this.severity == null) ? 0 : this.severity.hashCode());
        result = (prime * result) + ((this.translations == null) ? 0 : this.translations.hashCode());
        result = (prime * result) + ((this.updated_at == null) ? 0 : this.updated_at.hashCode());
        return result;
    }
    
    @Override
    public String toString()
    {
        return "Message{" +
               "author='" + author + '\'' +
               ", content='" + content + '\'' +
               ", created_at='" + created_at + '\'' +
               ", id='" + id + '\'' +
               ", severity='" + severity + '\'' +
               ", updated_at='" + updated_at + '\'' +
               ", translations=" + translations +
               '}';
    }
}
