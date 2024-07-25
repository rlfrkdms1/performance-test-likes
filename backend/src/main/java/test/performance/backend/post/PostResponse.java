package test.performance.backend.post;

import lombok.Builder;

public class PostResponse {

    private Long id;
    private String title;
    private String contents;
    private long likes;

    public static PostResponse from(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .contents(post.getContent())
                .likes(post.getLikes())
                .build();
    }

    public static PostResponse of(Post post, long likes) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .contents(post.getContent())
                .likes(likes)
                .build();
    }

    @Builder
    public PostResponse(Long id, String title, String contents, long likes) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.likes = likes;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public long getLikes() {
        return likes;
    }
}
