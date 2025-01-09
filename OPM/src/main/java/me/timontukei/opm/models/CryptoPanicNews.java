package me.timontukei.opm.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class CryptoPanicNews {

    @JsonProperty("count")
    private int count;

    @JsonProperty("next")
    private String next;

    @JsonProperty("previous")
    private String previous;

    @JsonProperty("results")
    List<NewsItem> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<NewsItem> getResults() {
        return results;
    }

    public void setResults(List<NewsItem> results) {
        this.results = results;
    }

    public static class NewsItem {


        @JsonProperty("domain")
        private String domain;

        @JsonProperty("title")
        private String title;

        @JsonProperty("published_at")
        private Date publishedAt;

        @JsonProperty("url")
        private String url;

        @JsonProperty("source")
        private Source source;

        @JsonProperty("slug")
        private String slug;

        @JsonProperty("currencies")
        private List<Currency> currencies;

        @JsonProperty("id")
        private int id;

        @JsonProperty("kind")
        private String kind;

        @JsonProperty("created_at")
        private Date createdAt;

        @JsonIgnore
        private Vote[] votes;

        public Vote[] getVotes() {
            return votes;
        }

        public void setVotes(Vote[] votes) {
            this.votes = votes;
        }

        public Date getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }

        public String getSlug() {
            return slug;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public List<Currency> getCurrencies() {
            return currencies;
        }

        public void setCurrencies(List<Currency> currencies) {
            this.currencies = currencies;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Date getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(Date publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Source getSource() {
            return source;
        }

        public void setSource(Source source) {
            this.source = source;
        }
    }

    public static class Source {

        @JsonProperty("title")
        private String title;

        @JsonProperty("region")
        private String region;

        @JsonProperty("domain")
        private String domain;

        @JsonProperty("path")
        private String path;

        @JsonProperty("type")
        private String type;

        public String getTitle() {
            return title;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }
    }

    public static class Currency {

        @JsonProperty("code")
        private String code;

        @JsonProperty("title")
        private String title;

        @JsonProperty("slug")
        private String slug;

        @JsonProperty("url")
        private String url;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Vote {

        @JsonProperty("negative")
        private int negative;

        @JsonProperty("positive")
        private int positive;

        @JsonProperty("important")
        private int important;

        @JsonProperty("liked")
        private int liked;

        @JsonProperty("disliked")
        private int disliked;

        @JsonProperty("lol")
        private int lol;

        @JsonProperty("toxic")
        private int toxic;

        @JsonProperty("saved")
        private int saved;

        @JsonProperty("comments")
        private int comments;

        public int getNegative() {
            return negative;
        }

        public void setNegative(int negative) {
            this.negative = negative;
        }

        public int getPositive() {
            return positive;
        }

        public void setPositive(int positive) {
            this.positive = positive;
        }

        public int getImportant() {
            return important;
        }

        public void setImportant(int important) {
            this.important = important;
        }

        public int getLiked() {
            return liked;
        }

        public void setLiked(int liked) {
            this.liked = liked;
        }

        public int getDisliked() {
            return disliked;
        }

        public void setDisliked(int disliked) {
            this.disliked = disliked;
        }

        public int getLol() {
            return lol;
        }

        public void setLol(int lol) {
            this.lol = lol;
        }

        public int getToxic() {
            return toxic;
        }

        public void setToxic(int toxic) {
            this.toxic = toxic;
        }

        public int getSaved() {
            return saved;
        }

        public void setSaved(int saved) {
            this.saved = saved;
        }

        public int getComments() {
            return comments;
        }

        public void setComments(int comments) {
            this.comments = comments;
        }
    }
}